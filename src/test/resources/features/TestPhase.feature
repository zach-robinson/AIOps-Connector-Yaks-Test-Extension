Feature: TestPhase of ConnectorComponent

  Scenario: Create a ConnectorComponent and poll until its phase is "Running"
    Given load Kubernetes custom resource github-connection.yaml in connectorconfigurations.connectors.aiops.ibm.com
    Then The phase of ConnectorComponent github-sample should be running