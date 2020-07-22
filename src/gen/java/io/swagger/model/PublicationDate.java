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
import io.swagger.model.Day;
import io.swagger.model.Month;
import io.swagger.model.Year;
import javax.validation.constraints.*;

/**
 * PublicationDate
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-03T10:28:37.821Z")
public class PublicationDate   {
  @JsonProperty("year")
  private Year year = null;

  @JsonProperty("month")
  private Month month = null;

  @JsonProperty("day")
  private Day day = null;

  /**
   * Gets or Sets mediaType
   */
  public enum MediaTypeEnum {
    PRINT("PRINT"),
    
    ONLINE("ONLINE"),
    
    OTHER("OTHER");

    private String value;

    MediaTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MediaTypeEnum fromValue(String text) {
      for (MediaTypeEnum b : MediaTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("media-type")
  private MediaTypeEnum mediaType = null;

  public PublicationDate year(Year year) {
    this.year = year;
    return this;
  }

   /**
   * Get year
   * @return year
  **/
  @JsonProperty("year")
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public Year getYear() {
    return year;
  }

  public void setYear(Year year) {
    this.year = year;
  }

  public PublicationDate month(Month month) {
    this.month = month;
    return this;
  }

   /**
   * Get month
   * @return month
  **/
  @JsonProperty("month")
  @ApiModelProperty(value = "")
  public Month getMonth() {
    return month;
  }

  public void setMonth(Month month) {
    this.month = month;
  }

  public PublicationDate day(Day day) {
    this.day = day;
    return this;
  }

   /**
   * Get day
   * @return day
  **/
  @JsonProperty("day")
  @ApiModelProperty(value = "")
  public Day getDay() {
    return day;
  }

  public void setDay(Day day) {
    this.day = day;
  }

  public PublicationDate mediaType(MediaTypeEnum mediaType) {
    this.mediaType = mediaType;
    return this;
  }

   /**
   * Get mediaType
   * @return mediaType
  **/
  @JsonProperty("media-type")
  @ApiModelProperty(value = "")
  public MediaTypeEnum getMediaType() {
    return mediaType;
  }

  public void setMediaType(MediaTypeEnum mediaType) {
    this.mediaType = mediaType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PublicationDate publicationDate = (PublicationDate) o;
    return Objects.equals(this.year, publicationDate.year) &&
        Objects.equals(this.month, publicationDate.month) &&
        Objects.equals(this.day, publicationDate.day) &&
        Objects.equals(this.mediaType, publicationDate.mediaType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(year, month, day, mediaType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PublicationDate {\n");
    
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    month: ").append(toIndentedString(month)).append("\n");
    sb.append("    day: ").append(toIndentedString(day)).append("\n");
    sb.append("    mediaType: ").append(toIndentedString(mediaType)).append("\n");
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
