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
import org.joda.time.DateTime;

import java.net.URI;
import java.util.Objects;

/**
 * CloudEvent type
 */
@ApiModel(description = "CloudEvent type")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-08-30T14:34:32.048Z[Etc/UTC]")
public class V1beta1ConnectorComponentStatusCloudEvent {
    public static final String SERIALIZED_NAME_DATA = "data";
    public static final String SERIALIZED_NAME_DATA_SCHEMA = "dataSchema";
    public static final String SERIALIZED_NAME_DATACONTENTTYPE = "datacontenttype";
    public static final String SERIALIZED_NAME_ID = "id";
    public static final String SERIALIZED_NAME_SOURCE = "source";
    public static final String SERIALIZED_NAME_SPECVERSION = "specversion";
    public static final String SERIALIZED_NAME_SUBJECT = "subject";
    public static final String SERIALIZED_NAME_TIME = "time";
    public static final String SERIALIZED_NAME_TYPE = "type";
    @SerializedName(SERIALIZED_NAME_DATA)
    private String data;
    @SerializedName(SERIALIZED_NAME_DATA_SCHEMA)
    private URI dataSchema;
    @SerializedName(SERIALIZED_NAME_DATACONTENTTYPE)
    private String datacontenttype;
    @SerializedName(SERIALIZED_NAME_ID)
    private String id;
    @SerializedName(SERIALIZED_NAME_SOURCE)
    private String source;
    @SerializedName(SERIALIZED_NAME_SPECVERSION)
    private String specversion;
    @SerializedName(SERIALIZED_NAME_SUBJECT)
    private String subject;
    @SerializedName(SERIALIZED_NAME_TIME)
    private DateTime time;
    @SerializedName(SERIALIZED_NAME_TYPE)
    private String type;


    public V1beta1ConnectorComponentStatusCloudEvent data(String data) {

        this.data = data;
        return this;
    }

    /**
     * Get data
     *
     * @return data
     **/
    @ApiModelProperty(required = true, value = "")

    public String getData() {
        return data;
    }


    public void setData(String data) {
        this.data = data;
    }


    public V1beta1ConnectorComponentStatusCloudEvent dataSchema(URI dataSchema) {

        this.dataSchema = dataSchema;
        return this;
    }

    /**
     * Get dataSchema
     *
     * @return dataSchema
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")

    public URI getDataSchema() {
        return dataSchema;
    }


    public void setDataSchema(URI dataSchema) {
        this.dataSchema = dataSchema;
    }


    public V1beta1ConnectorComponentStatusCloudEvent datacontenttype(String datacontenttype) {

        this.datacontenttype = datacontenttype;
        return this;
    }

    /**
     * Get datacontenttype
     *
     * @return datacontenttype
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")

    public String getDatacontenttype() {
        return datacontenttype;
    }


    public void setDatacontenttype(String datacontenttype) {
        this.datacontenttype = datacontenttype;
    }


    public V1beta1ConnectorComponentStatusCloudEvent id(String id) {

        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @ApiModelProperty(required = true, value = "")

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public V1beta1ConnectorComponentStatusCloudEvent source(String source) {

        this.source = source;
        return this;
    }

    /**
     * Get source
     *
     * @return source
     **/
    @ApiModelProperty(required = true, value = "")

    public String getSource() {
        return source;
    }


    public void setSource(String source) {
        this.source = source;
    }


    public V1beta1ConnectorComponentStatusCloudEvent specversion(String specversion) {

        this.specversion = specversion;
        return this;
    }

    /**
     * Get specversion
     *
     * @return specversion
     **/
    @ApiModelProperty(required = true, value = "")

    public String getSpecversion() {
        return specversion;
    }


    public void setSpecversion(String specversion) {
        this.specversion = specversion;
    }


    public V1beta1ConnectorComponentStatusCloudEvent subject(String subject) {

        this.subject = subject;
        return this;
    }

    /**
     * Get subject
     *
     * @return subject
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")

    public String getSubject() {
        return subject;
    }


    public void setSubject(String subject) {
        this.subject = subject;
    }


    public V1beta1ConnectorComponentStatusCloudEvent time(DateTime time) {

        this.time = time;
        return this;
    }

    /**
     * Get time
     *
     * @return time
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")

    public DateTime getTime() {
        return time;
    }


    public void setTime(DateTime time) {
        this.time = time;
    }


    public V1beta1ConnectorComponentStatusCloudEvent type(String type) {

        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    @ApiModelProperty(required = true, value = "")

    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        V1beta1ConnectorComponentStatusCloudEvent v1beta1ConnectorComponentStatusCloudEvent = (V1beta1ConnectorComponentStatusCloudEvent) o;
        return Objects.equals(this.data, v1beta1ConnectorComponentStatusCloudEvent.data) &&
                Objects.equals(this.dataSchema, v1beta1ConnectorComponentStatusCloudEvent.dataSchema) &&
                Objects.equals(this.datacontenttype, v1beta1ConnectorComponentStatusCloudEvent.datacontenttype) &&
                Objects.equals(this.id, v1beta1ConnectorComponentStatusCloudEvent.id) &&
                Objects.equals(this.source, v1beta1ConnectorComponentStatusCloudEvent.source) &&
                Objects.equals(this.specversion, v1beta1ConnectorComponentStatusCloudEvent.specversion) &&
                Objects.equals(this.subject, v1beta1ConnectorComponentStatusCloudEvent.subject) &&
                Objects.equals(this.time, v1beta1ConnectorComponentStatusCloudEvent.time) &&
                Objects.equals(this.type, v1beta1ConnectorComponentStatusCloudEvent.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, dataSchema, datacontenttype, id, source, specversion, subject, time, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class V1beta1ConnectorComponentStatusCloudEvent {\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    dataSchema: ").append(toIndentedString(dataSchema)).append("\n");
        sb.append("    datacontenttype: ").append(toIndentedString(datacontenttype)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    source: ").append(toIndentedString(source)).append("\n");
        sb.append("    specversion: ").append(toIndentedString(specversion)).append("\n");
        sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
        sb.append("    time: ").append(toIndentedString(time)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

