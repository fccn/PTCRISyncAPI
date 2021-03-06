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
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;

/**
 * WorkExportResultPTCRISyncResult
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-03T10:28:37.821Z")
public class WorkExportResultPTCRISyncResult   {
  @JsonProperty("code")
  private Integer code = null;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    ADDOK("ADDOK"),
    
    UPDATEOK("UPDATEOK"),
    
    UPTODATE("UPTODATE"),
    
    INVALID("INVALID"),
    
    CLIENTERROR("CLIENTERROR");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("type")
  private TypeEnum type = null;

  @JsonProperty("exception")
  private String exception = null;

  public WorkExportResultPTCRISyncResult code(Integer code) {
    this.code = code;
    return this;
  }

   /**
   * Get code
   * @return code
  **/
  @JsonProperty("code")
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public WorkExportResultPTCRISyncResult type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @JsonProperty("type")
  @ApiModelProperty(value = "")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public WorkExportResultPTCRISyncResult exception(String exception) {
    this.exception = exception;
    return this;
  }

   /**
   * Get exception
   * @return exception
  **/
  @JsonProperty("exception")
  @ApiModelProperty(value = "")
  public String getException() {
    return exception;
  }

  public void setException(String exception) {
    this.exception = exception;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkExportResultPTCRISyncResult workExportResultPTCRISyncResult = (WorkExportResultPTCRISyncResult) o;
    return Objects.equals(this.code, workExportResultPTCRISyncResult.code) &&
        Objects.equals(this.type, workExportResultPTCRISyncResult.type) &&
        Objects.equals(this.exception, workExportResultPTCRISyncResult.exception);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, type, exception);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkExportResultPTCRISyncResult {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    exception: ").append(toIndentedString(exception)).append("\n");
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

