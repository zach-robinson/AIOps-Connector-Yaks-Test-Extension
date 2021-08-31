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
import org.apache.commons.lang.StringEscapeUtils;
import org.citrusframework.yaks.kubernetes.KubernetesSettings;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ConnectorComponentSteps {
    private final String namespace = KubernetesSettings.getNamespace();
    private Integer waitSeconds = 5;
    private Integer stopAfterAttempts = 6;

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
        Polling.waitPeriodly(waitSeconds, TimeUnit.SECONDS).stopAfterAttempt(stopAfterAttempts).run(() -> {
            try {
                final V1beta1ConnectorComponent connectorComponent = getConnectorComponent(name);
                final String actualPhase = Objects.requireNonNull(connectorComponent.getStatus()).getPhase().toString();
                if (!actualPhase.equals(expectedPhase)) {
                    throw new CitrusRuntimeException("Expected phase of ConnectorComponent " + name + " to be " +
                            expectedPhase + ", but was " + actualPhase);
                }
                return AttemptResults.justFinish();
            } catch (Exception e) {
                return AttemptResults.justContinue();
            }
        });
    }

    @Then("^The requeueAfter of ConnectorComponent ([^\\s]+) should be (\\d+)$")
    public void testRqAfter(String name, Long expectedRqAfter) {
        Polling.waitPeriodly(waitSeconds, TimeUnit.SECONDS).stopAfterAttempt(stopAfterAttempts).run(() -> {
            try {
                final V1beta1ConnectorComponent connectorComponent = getConnectorComponent(name);
                final Long actualRqAfter = Objects.requireNonNull(connectorComponent.getStatus()).getRequeueAfter();
                if (!Objects.equals(actualRqAfter, expectedRqAfter)) {
                    throw new CitrusRuntimeException("Expected requeueAfter of ConnectorComponent "
                            + name + " to be " + expectedRqAfter + ", but was " + actualRqAfter);
                }
                return AttemptResults.justFinish();
            } catch (Exception e) {
                return AttemptResults.justContinue();
            }
        });
    }

    public void testMessageHelper(String name, String expectedKey, String expectedData) {
        Polling.waitPeriodly(waitSeconds, TimeUnit.SECONDS).stopAfterAttempt(stopAfterAttempts).run(() -> {
            try {
                final V1beta1ConnectorComponent connectorComponent = getConnectorComponent(name);
                if (!Objects.requireNonNull(Objects.requireNonNull(connectorComponent.getStatus()).getMessages())
                        .containsKey(expectedKey)) {
                    throw new CitrusRuntimeException("status.messages of ConnectorComponent " + name +
                            " did not contain key: " + expectedKey);
                }
                if (expectedData != null) {
                    final String actualData = Objects.requireNonNull(connectorComponent.getStatus().getMessages())
                            .get(expectedKey).toString();
                    if (!actualData.equals(expectedData)) {
                        throw new CitrusRuntimeException("Expected status.messages." + expectedKey +
                                " of ConnectorComponent " + name + " to have value of '" +
                                StringEscapeUtils.escapeJava(expectedData) + "', but was '" +
                                StringEscapeUtils.escapeJava(actualData) + "'");
                    }
                }
                return AttemptResults.justFinish();
            } catch (Exception e) {
                return AttemptResults.justContinue();
            }
        });
    }

    @Then("^The status.messages of ConnectorComponent ([^\\s]+) should contain the key ([^\\s]+)$")
    public void testMessageKey(String name, String expectedKey) {
        testMessageHelper(name, expectedKey, null);
    }

    @Then("^The status.messages of ConnectorComponent ([^\\s]+) should contain the key ([^\\s]+) which should have data matching ([^\\s]+)$")
    public void testMessageBody(String name, String expectedKey, String expectedData) {
        testMessageHelper(name, expectedKey, expectedData);
    }
}
