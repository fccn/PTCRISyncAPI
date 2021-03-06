/*
 * PTCRISync webservice
 * This is an interface for PTCRISync library.
 *
 * OpenAPI spec version: 0.0.1-alpha
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.SourceClientId;
import io.swagger.model.SourceName;
import io.swagger.model.SourceOrcid;
import javax.validation.constraints.*;

/**
 * Source
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-03T10:28:37.821Z")
public class Source   {
  @JsonProperty("source-orcid")
  private SourceOrcid sourceOrcid = null;

  @JsonProperty("source-client-id")
  private SourceClientId sourceClientId = null;

  @JsonProperty("source-name")
  private SourceName sourceName = null;

  public Source sourceOrcid(SourceOrcid sourceOrcid) {
    this.sourceOrcid = sourceOrcid;
    return this;
  }

   /**
   * Get sourceOrcid
   * @return sourceOrcid
  **/
  @JsonProperty("source-orcid")
  @ApiModelProperty(value = "")
  public SourceOrcid getSourceOrcid() {
    return sourceOrcid;
  }

  public void setSourceOrcid(SourceOrcid sourceOrcid) {
    this.sourceOrcid = sourceOrcid;
  }

  public Source sourceClientId(SourceClientId sourceClientId) {
    this.sourceClientId = sourceClientId;
    return this;
  }

   /**
   * Get sourceClientId
   * @return sourceClientId
  **/
  @JsonProperty("source-client-id")
  @ApiModelProperty(value = "")
  public SourceClientId getSourceClientId() {
    return sourceClientId;
  }

  public void setSourceClientId(SourceClientId sourceClientId) {
    this.sourceClientId = sourceClientId;
  }

  public Source sourceName(SourceName sourceName) {
    this.sourceName = sourceName;
    return this;
  }

   /**
   * Get sourceName
   * @return sourceName
  **/
  @JsonProperty("source-name")
  @ApiModelProperty(value = "")
  public SourceName getSourceName() {
    return sourceName;
  }

  public void setSourceName(SourceName sourceName) {
    this.sourceName = sourceName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Source source = (Source) o;
    return Objects.equals(this.sourceOrcid, source.sourceOrcid) &&
        Objects.equals(this.sourceClientId, source.sourceClientId) &&
        Objects.equals(this.sourceName, source.sourceName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sourceOrcid, sourceClientId, sourceName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Source {\n");
    
    sb.append("    sourceOrcid: ").append(toIndentedString(sourceOrcid)).append("\n");
    sb.append("    sourceClientId: ").append(toIndentedString(sourceClientId)).append("\n");
    sb.append("    sourceName: ").append(toIndentedString(sourceName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

