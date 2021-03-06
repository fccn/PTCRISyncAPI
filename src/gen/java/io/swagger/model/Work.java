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
import io.swagger.model.Citation;
import io.swagger.model.Country;
import io.swagger.model.CreatedDate;
import io.swagger.model.ExternalIDs;
import io.swagger.model.LastModifiedDate;
import io.swagger.model.PublicationDate;
import io.swagger.model.Source;
import io.swagger.model.Title;
import io.swagger.model.Url;
import io.swagger.model.WorkContributors;
import io.swagger.model.WorkTitle;
import javax.validation.constraints.*;

/**
 * Work
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-03T10:28:37.821Z")
public class Work   {
  @JsonProperty("created-date")
  private CreatedDate createdDate = null;

  @JsonProperty("last-modified-date")
  private LastModifiedDate lastModifiedDate = null;

  @JsonProperty("source")
  private Source source = null;

  @JsonProperty("path")
  private String path = null;

  @JsonProperty("title")
  private WorkTitle title = null;

  @JsonProperty("journal-title")
  private Title journalTitle = null;

  @JsonProperty("short-description")
  private String shortDescription = null;

  @JsonProperty("citation")
  private Citation citation = null;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    ARTISTIC_PERFORMANCE("ARTISTIC_PERFORMANCE"),
    
    BOOK_CHAPTER("BOOK_CHAPTER"),
    
    BOOK_REVIEW("BOOK_REVIEW"),
    
    BOOK("BOOK"),
    
    CONFERENCE_ABSTRACT("CONFERENCE_ABSTRACT"),
    
    CONFERENCE_PAPER("CONFERENCE_PAPER"),
    
    CONFERENCE_POSTER("CONFERENCE_POSTER"),
    
    DATA_SET("DATA_SET"),
    
    DICTIONARY_ENTRY("DICTIONARY_ENTRY"),
    
    DISCLOSURE("DISCLOSURE"),
    
    DISSERTATION("DISSERTATION"),
    
    EDITED_BOOK("EDITED_BOOK"),
    
    ENCYCLOPEDIA_ENTRY("ENCYCLOPEDIA_ENTRY"),
    
    INVENTION("INVENTION"),
    
    JOURNAL_ARTICLE("JOURNAL_ARTICLE"),
    
    JOURNAL_ISSUE("JOURNAL_ISSUE"),
    
    LECTURE_SPEECH("LECTURE_SPEECH"),
    
    LICENSE("LICENSE"),
    
    MAGAZINE_ARTICLE("MAGAZINE_ARTICLE"),
    
    MANUAL("MANUAL"),
    
    NEWSLETTER_ARTICLE("NEWSLETTER_ARTICLE"),
    
    NEWSPAPER_ARTICLE("NEWSPAPER_ARTICLE"),
    
    ONLINE_RESOURCE("ONLINE_RESOURCE"),
    
    OTHER("OTHER"),
    
    PATENT("PATENT"),
    
    REGISTERED_COPYRIGHT("REGISTERED_COPYRIGHT"),
    
    REPORT("REPORT"),
    
    RESEARCH_TECHNIQUE("RESEARCH_TECHNIQUE"),
    
    RESEARCH_TOOL("RESEARCH_TOOL"),
    
    SPIN_OFF_COMPANY("SPIN_OFF_COMPANY"),
    
    STANDARDS_AND_POLICY("STANDARDS_AND_POLICY"),
    
    SUPERVISED_STUDENT_PUBLICATION("SUPERVISED_STUDENT_PUBLICATION"),
    
    TECHNICAL_STANDARD("TECHNICAL_STANDARD"),
    
    TEST("TEST"),
    
    TRADEMARK("TRADEMARK"),
    
    TRANSLATION("TRANSLATION"),
    
    WEBSITE("WEBSITE"),
    
    WORKING_PAPER("WORKING_PAPER"),
    
    UNDEFINED("UNDEFINED");

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

  @JsonProperty("publication-date")
  private PublicationDate publicationDate = null;

  @JsonProperty("external-ids")
  private ExternalIDs externalIds = null;

  @JsonProperty("url")
  private Url url = null;

  @JsonProperty("contributors")
  private WorkContributors contributors = null;

  @JsonProperty("language-code")
  private String languageCode = null;

  @JsonProperty("country")
  private Country country = null;

  /**
   * Gets or Sets visibility
   */
  public enum VisibilityEnum {
    LIMITED("LIMITED"),
    
    REGISTERED_ONLY("REGISTERED_ONLY"),
    
    PUBLIC("PUBLIC");

    private String value;

    VisibilityEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static VisibilityEnum fromValue(String text) {
      for (VisibilityEnum b : VisibilityEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("visibility")
  private VisibilityEnum visibility = null;

  public Work createdDate(CreatedDate createdDate) {
    this.createdDate = createdDate;
    return this;
  }

   /**
   * Get createdDate
   * @return createdDate
  **/
  @JsonProperty("created-date")
  @ApiModelProperty(value = "")
  public CreatedDate getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(CreatedDate createdDate) {
    this.createdDate = createdDate;
  }

  public Work lastModifiedDate(LastModifiedDate lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
    return this;
  }

   /**
   * Get lastModifiedDate
   * @return lastModifiedDate
  **/
  @JsonProperty("last-modified-date")
  @ApiModelProperty(value = "")
  public LastModifiedDate getLastModifiedDate() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(LastModifiedDate lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

  public Work source(Source source) {
    this.source = source;
    return this;
  }

   /**
   * Get source
   * @return source
  **/
  @JsonProperty("source")
  @ApiModelProperty(value = "")
  public Source getSource() {
    return source;
  }

  public void setSource(Source source) {
    this.source = source;
  }

  public Work path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @JsonProperty("path")
  @ApiModelProperty(value = "")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public Work title(WorkTitle title) {
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @JsonProperty("title")
  @ApiModelProperty(value = "")
  public WorkTitle getTitle() {
    return title;
  }

  public void setTitle(WorkTitle title) {
    this.title = title;
  }

  public Work journalTitle(Title journalTitle) {
    this.journalTitle = journalTitle;
    return this;
  }

   /**
   * Get journalTitle
   * @return journalTitle
  **/
  @JsonProperty("journal-title")
  @ApiModelProperty(value = "")
  public Title getJournalTitle() {
    return journalTitle;
  }

  public void setJournalTitle(Title journalTitle) {
    this.journalTitle = journalTitle;
  }

  public Work shortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
    return this;
  }

   /**
   * Get shortDescription
   * @return shortDescription
  **/
  @JsonProperty("short-description")
  @ApiModelProperty(value = "")
  public String getShortDescription() {
    return shortDescription;
  }

  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public Work citation(Citation citation) {
    this.citation = citation;
    return this;
  }

   /**
   * Get citation
   * @return citation
  **/
  @JsonProperty("citation")
  @ApiModelProperty(value = "")
  public Citation getCitation() {
    return citation;
  }

  public void setCitation(Citation citation) {
    this.citation = citation;
  }

  public Work type(TypeEnum type) {
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

  public Work publicationDate(PublicationDate publicationDate) {
    this.publicationDate = publicationDate;
    return this;
  }

   /**
   * Get publicationDate
   * @return publicationDate
  **/
  @JsonProperty("publication-date")
  @ApiModelProperty(value = "")
  public PublicationDate getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(PublicationDate publicationDate) {
    this.publicationDate = publicationDate;
  }

  public Work externalIds(ExternalIDs externalIds) {
    this.externalIds = externalIds;
    return this;
  }

   /**
   * Get externalIds
   * @return externalIds
  **/
  @JsonProperty("external-ids")
  @ApiModelProperty(value = "")
  public ExternalIDs getExternalIds() {
    return externalIds;
  }

  public void setExternalIds(ExternalIDs externalIds) {
    this.externalIds = externalIds;
  }

  public Work url(Url url) {
    this.url = url;
    return this;
  }

   /**
   * Get url
   * @return url
  **/
  @JsonProperty("url")
  @ApiModelProperty(value = "")
  public Url getUrl() {
    return url;
  }

  public void setUrl(Url url) {
    this.url = url;
  }

  public Work contributors(WorkContributors contributors) {
    this.contributors = contributors;
    return this;
  }

   /**
   * Get contributors
   * @return contributors
  **/
  @JsonProperty("contributors")
  @ApiModelProperty(value = "")
  public WorkContributors getContributors() {
    return contributors;
  }

  public void setContributors(WorkContributors contributors) {
    this.contributors = contributors;
  }

  public Work languageCode(String languageCode) {
    this.languageCode = languageCode;
    return this;
  }

   /**
   * Get languageCode
   * @return languageCode
  **/
  @JsonProperty("language-code")
  @ApiModelProperty(value = "")
  public String getLanguageCode() {
    return languageCode;
  }

  public void setLanguageCode(String languageCode) {
    this.languageCode = languageCode;
  }

  public Work country(Country country) {
    this.country = country;
    return this;
  }

   /**
   * Get country
   * @return country
  **/
  @JsonProperty("country")
  @ApiModelProperty(value = "")
  public Country getCountry() {
    return country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }

  public Work visibility(VisibilityEnum visibility) {
    this.visibility = visibility;
    return this;
  }

   /**
   * Get visibility
   * @return visibility
  **/
  @JsonProperty("visibility")
  @ApiModelProperty(value = "")
  public VisibilityEnum getVisibility() {
    return visibility;
  }

  public void setVisibility(VisibilityEnum visibility) {
    this.visibility = visibility;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Work work = (Work) o;
    return Objects.equals(this.createdDate, work.createdDate) &&
        Objects.equals(this.lastModifiedDate, work.lastModifiedDate) &&
        Objects.equals(this.source, work.source) &&
        Objects.equals(this.path, work.path) &&
        Objects.equals(this.title, work.title) &&
        Objects.equals(this.journalTitle, work.journalTitle) &&
        Objects.equals(this.shortDescription, work.shortDescription) &&
        Objects.equals(this.citation, work.citation) &&
        Objects.equals(this.type, work.type) &&
        Objects.equals(this.publicationDate, work.publicationDate) &&
        Objects.equals(this.externalIds, work.externalIds) &&
        Objects.equals(this.url, work.url) &&
        Objects.equals(this.contributors, work.contributors) &&
        Objects.equals(this.languageCode, work.languageCode) &&
        Objects.equals(this.country, work.country) &&
        Objects.equals(this.visibility, work.visibility);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdDate, lastModifiedDate, source, path, title, journalTitle, shortDescription, citation, type, publicationDate, externalIds, url, contributors, languageCode, country, visibility);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Work {\n");
    
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    lastModifiedDate: ").append(toIndentedString(lastModifiedDate)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    journalTitle: ").append(toIndentedString(journalTitle)).append("\n");
    sb.append("    shortDescription: ").append(toIndentedString(shortDescription)).append("\n");
    sb.append("    citation: ").append(toIndentedString(citation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    publicationDate: ").append(toIndentedString(publicationDate)).append("\n");
    sb.append("    externalIds: ").append(toIndentedString(externalIds)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    contributors: ").append(toIndentedString(contributors)).append("\n");
    sb.append("    languageCode: ").append(toIndentedString(languageCode)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    visibility: ").append(toIndentedString(visibility)).append("\n");
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

