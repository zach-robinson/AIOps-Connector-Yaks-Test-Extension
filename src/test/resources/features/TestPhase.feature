Feature: TestPhase of ConnectorComponent

  Scenario: Create a ConnectorComponent and poll until its phase is "Running"
    Given load Kubernetes custom resource github-connection.yaml in connectorcomponents.connectors.aiops.ibm.com
    Given Polling with interval 5 seconds that stops after 12 attempts
    Then The phase of ConnectorComponent github-sample should be running