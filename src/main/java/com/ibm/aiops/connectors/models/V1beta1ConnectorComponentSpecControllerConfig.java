/*
 * Kubernetes
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v1.18.2
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.ibm.aiops.connectors.models;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * ExtensionHeader definition
 */
@ApiModel(description = "ExtensionHeader definition")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-09-02T16:30:48.596Z[Etc/UTC]")
public class V1beta1ConnectorComponentSpecControllerConfig {
  public static final String SERIALIZED_NAME_NAME = "name";
  public static final String SERIALIZED_NAME_VALUE = "value";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;
  @SerializedName(SERIALIZED_NAME_VALUE)
  private String value;


  public V1beta1ConnectorComponentSpecControllerConfig name(String name) {

    this.name = name;
    return this;
  }

  /**
   * ExtensionHeaderKey key for the Cloud Event
   *
   * @return name
   **/
  @ApiModelProperty(required = true, value = "ExtensionHeaderKey key for the Cloud Event")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public V1beta1ConnectorComponentSpecControllerConfig value(String value) {

    this.value = value;
    return this;
  }

  /**
   * Get value
   *
   * @return value
   **/
  @ApiModelProperty(required = true, value = "")

  public String getValue() {
    return value;
  }


  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1beta1ConnectorComponentSpecControllerConfig v1beta1ConnectorComponentSpecControllerConfig = (V1beta1ConnectorComponentSpecControllerConfig) o;
    return Objects.equals(this.name, v1beta1ConnectorComponentSpecControllerConfig.name) &&
            Objects.equals(this.value, v1beta1ConnectorComponentSpecControllerConfig.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, value);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1beta1ConnectorComponentSpecControllerConfig {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

