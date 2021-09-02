package com.ibm.aiops.connectors.steps;

import com.consol.citrus.exceptions.CitrusRuntimeException;
import com.dyngr.Polling;
import com.dyngr.core.AttemptResults;
import com.ibm.aiops.connectors.models.V1beta1ConnectorComponent;
import com.ibm.aiops.connectors.models.V1beta1ConnectorComponentList;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.kubernetes.client.extended.kubectl.Kubectl;
import io.kubernetes.client.extended.kubectl.exception.KubectlException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.util.Config;
import io.kubernetes.client.util.ModelMapper;
import org.citrusframework.yaks.kubernetes.KubernetesSettings;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ConnectorComponentSteps {
    private final String namespace = KubernetesSettings.getNamespace();
    private Integer waitSeconds = 5;
    private Integer stopAfterAttempts = 6;

    private static void throwExceptionsAsCitrus(VoidRunner c) throws CitrusRuntimeException {
        try {
            c.run();
        } catch (Exception e) {
            throw new CitrusRuntimeException(e);
        }
    }

    private void poll(VoidRunner c) {
        throwExceptionsAsCitrus(() ->
                Polling.waitPeriodly(waitSeconds, TimeUnit.SECONDS).stopAfterAttempt(stopAfterAttempts)
                        .stopIfException(false).run(() -> {
                            try {
                                c.run();
                                return AttemptResults.justFinish();
                            } catch (Exception e) {
                                return AttemptResults.continueFor(e);
                            }
                        }));
    }

    @Before
    public void before(@SuppressWarnings("unused") Scenario scenario) throws IOException {
        Configuration.setDefaultApiClient(Config.fromCluster());
        ModelMapper.addModelMap("connectors.aiops.ibm.com", "v1beta1", "ConnectorComponent",
                "connectorcomponents", true,
                V1beta1ConnectorComponent.class, V1beta1ConnectorComponentList.class);
    }

    @Given("^Polling with interval (\\d+) seconds that stops after (\\d+) attempts$")
    public void setPollingSettings(int waitSeconds, int stopAfterAttempts) {
        this.waitSeconds = waitSeconds;
        this.stopAfterAttempts = stopAfterAttempts;
    }

    private V1beta1ConnectorComponent getConnectorComponent(String name) throws KubectlException {
        return Kubectl.get(V1beta1ConnectorComponent.class).name(name).namespace(namespace).execute();
    }

    @Then("^The phase of ConnectorComponent ([^\\s]+) should be ([^\\s]+)$")
    public void testPhase(String name, String expectedPhase) {
        poll(() -> {
            final V1beta1ConnectorComponent connectorComponent = getConnectorComponent(name);
            final String actualPhase = Objects.requireNonNull(connectorComponent.getStatus()).getPhase().toString();
            if (!actualPhase.equals(expectedPhase)) {
                throw new CitrusRuntimeException("Expected phase of ConnectorComponent " + name + " to be " +
                        expectedPhase + ", but was " + actualPhase);
            }
        });
    }

    @Then("^The requeueAfter of ConnectorComponent ([^\\s]+) should be (\\d+)$")
    public void testRqAfter(String name, Long expectedRqAfter) {
        poll(() -> {
            final V1beta1ConnectorComponent connectorComponent = getConnectorComponent(name);
            final Long actualRqAfter = Objects.requireNonNull(connectorComponent.getStatus()).getRequeueAfter();
            if (!Objects.equals(actualRqAfter, expectedRqAfter)) {
                throw new CitrusRuntimeException("Expected requeueAfter of ConnectorComponent "
                        + name + " to be " + expectedRqAfter + ", but was " + actualRqAfter);
            }
        });
    }
}
