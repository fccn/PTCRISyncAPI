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
import io.swagger.model.ContributorAttributes;
import io.swagger.model.ContributorEmail;
import io.swagger.model.ContributorOrcid;
import io.swagger.model.CreditName;
import javax.validation.constraints.*;

/**
 * Contributor
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-03T10:28:37.821Z")
public class Contributor   {
  @JsonProperty("contributor-orcid")
  private ContributorOrcid contributorOrcid = null;

  @JsonProperty("credit-name")
  private CreditName creditName = null;

  @JsonProperty("contributor-email")
  private ContributorEmail contributorEmail = null;

  @JsonProperty("contributor-attributes")
  private ContributorAttributes contributorAttributes = null;

  public Contributor contributorOrcid(ContributorOrcid contributorOrcid) {
    this.contributorOrcid = contributorOrcid;
    return this;
  }

   /**
   * Get contributorOrcid
   * @return contributorOrcid
  **/
  @JsonProperty("contributor-orcid")
  @ApiModelProperty(value = "")
  public ContributorOrcid getContributorOrcid() {
    return contributorOrcid;
  }

  public void setContributorOrcid(ContributorOrcid contributorOrcid) {
    this.contributorOrcid = contributorOrcid;
  }

  public Contributor creditName(CreditName creditName) {
    this.creditName = creditName;
    return this;
  }

   /**
   * Get creditName
   * @return creditName
  **/
  @JsonProperty("credit-name")
  @ApiModelProperty(value = "")
  public CreditName getCreditName() {
    return creditName;
  }

  public void setCreditName(CreditName creditName) {
    this.creditName = creditName;
  }

  public Contributor contributorEmail(ContributorEmail contributorEmail) {
    this.contributorEmail = contributorEmail;
    return this;
  }

   /**
   * Get contributorEmail
   * @return contributorEmail
  **/
  @JsonProperty("contributor-email")
  @ApiModelProperty(value = "")
  public ContributorEmail getContributorEmail() {
    return contributorEmail;
  }

  public void setContributorEmail(ContributorEmail contributorEmail) {
    this.contributorEmail = contributorEmail;
  }

  public Contributor contributorAttributes(ContributorAttributes contributorAttributes) {
    this.contributorAttributes = contributorAttributes;
    return this;
  }

   /**
   * Get contributorAttributes
   * @return contributorAttributes
  **/
  @JsonProperty("contributor-attributes")
  @ApiModelProperty(value = "")
  public ContributorAttributes getContributorAttributes() {
    return contributorAttributes;
  }

  public void setContributorAttributes(ContributorAttributes contributorAttributes) {
    this.contributorAttributes = contributorAttributes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Contributor contributor = (Contributor) o;
    return Objects.equals(this.contributorOrcid, contributor.contributorOrcid) &&
        Objects.equals(this.creditName, contributor.creditName) &&
        Objects.equals(this.contributorEmail, contributor.contributorEmail) &&
        Objects.equals(this.contributorAttributes, contributor.contributorAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contributorOrcid, creditName, contributorEmail, contributorAttributes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Contributor {\n");
    
    sb.append("    contributorOrcid: ").append(toIndentedString(contributorOrcid)).append("\n");
    sb.append("    creditName: ").append(toIndentedString(creditName)).append("\n");
    sb.append("    contributorEmail: ").append(toIndentedString(contributorEmail)).append("\n");
    sb.append("    contributorAttributes: ").append(toIndentedString(contributorAttributes)).append("\n");
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
