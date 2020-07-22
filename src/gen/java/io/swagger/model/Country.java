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
 * Country
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-03T10:28:37.821Z")
public class Country   {
  /**
   * Gets or Sets value
   */
  public enum ValueEnum {
    AF("AF"),
    
    AX("AX"),
    
    AL("AL"),
    
    DZ("DZ"),
    
    AS("AS"),
    
    AD("AD"),
    
    AO("AO"),
    
    AI("AI"),
    
    AQ("AQ"),
    
    AG("AG"),
    
    AR("AR"),
    
    AM("AM"),
    
    AW("AW"),
    
    AU("AU"),
    
    AT("AT"),
    
    AZ("AZ"),
    
    BS("BS"),
    
    BH("BH"),
    
    BD("BD"),
    
    BB("BB"),
    
    BY("BY"),
    
    BE("BE"),
    
    BZ("BZ"),
    
    BJ("BJ"),
    
    BM("BM"),
    
    BT("BT"),
    
    BO("BO"),
    
    BQ("BQ"),
    
    BA("BA"),
    
    BW("BW"),
    
    BV("BV"),
    
    BR("BR"),
    
    IO("IO"),
    
    BN("BN"),
    
    BG("BG"),
    
    BF("BF"),
    
    BI("BI"),
    
    KH("KH"),
    
    CM("CM"),
    
    CA("CA"),
    
    CV("CV"),
    
    KY("KY"),
    
    CF("CF"),
    
    TD("TD"),
    
    CL("CL"),
    
    CN("CN"),
    
    CX("CX"),
    
    CC("CC"),
    
    CO("CO"),
    
    KM("KM"),
    
    CG("CG"),
    
    CD("CD"),
    
    CK("CK"),
    
    CR("CR"),
    
    CI("CI"),
    
    HR("HR"),
    
    CU("CU"),
    
    CW("CW"),
    
    CY("CY"),
    
    CZ("CZ"),
    
    DK("DK"),
    
    DJ("DJ"),
    
    DM("DM"),
    
    DO("DO"),
    
    EC("EC"),
    
    EG("EG"),
    
    SV("SV"),
    
    GQ("GQ"),
    
    ER("ER"),
    
    EE("EE"),
    
    ET("ET"),
    
    FK("FK"),
    
    FO("FO"),
    
    FJ("FJ"),
    
    FI("FI"),
    
    FR("FR"),
    
    GF("GF"),
    
    PF("PF"),
    
    TF("TF"),
    
    GA("GA"),
    
    GM("GM"),
    
    GE("GE"),
    
    DE("DE"),
    
    GH("GH"),
    
    GI("GI"),
    
    GR("GR"),
    
    GL("GL"),
    
    GD("GD"),
    
    GP("GP"),
    
    GU("GU"),
    
    GT("GT"),
    
    GG("GG"),
    
    GN("GN"),
    
    GW("GW"),
    
    GY("GY"),
    
    HT("HT"),
    
    HM("HM"),
    
    VA("VA"),
    
    HN("HN"),
    
    HK("HK"),
    
    HU("HU"),
    
    IS("IS"),
    
    IN("IN"),
    
    ID("ID"),
    
    IR("IR"),
    
    IQ("IQ"),
    
    IE("IE"),
    
    IM("IM"),
    
    IL("IL"),
    
    IT("IT"),
    
    JM("JM"),
    
    JP("JP"),
    
    JE("JE"),
    
    JO("JO"),
    
    KZ("KZ"),
    
    KE("KE"),
    
    KI("KI"),
    
    KP("KP"),
    
    KR("KR"),
    
    KW("KW"),
    
    KG("KG"),
    
    LA("LA"),
    
    LV("LV"),
    
    LB("LB"),
    
    LS("LS"),
    
    LR("LR"),
    
    LY("LY"),
    
    LI("LI"),
    
    LT("LT"),
    
    LU("LU"),
    
    MO("MO"),
    
    MK("MK"),
    
    MG("MG"),
    
    MW("MW"),
    
    MY("MY"),
    
    MV("MV"),
    
    ML("ML"),
    
    MT("MT"),
    
    MH("MH"),
    
    MQ("MQ"),
    
    MR("MR"),
    
    MU("MU"),
    
    YT("YT"),
    
    MX("MX"),
    
    FM("FM"),
    
    MD("MD"),
    
    MC("MC"),
    
    MN("MN"),
    
    ME("ME"),
    
    MS("MS"),
    
    MA("MA"),
    
    MZ("MZ"),
    
    MM("MM"),
    
    NA("NA"),
    
    NR("NR"),
    
    NP("NP"),
    
    NL("NL"),
    
    NC("NC"),
    
    NZ("NZ"),
    
    NI("NI"),
    
    NE("NE"),
    
    NG("NG"),
    
    NU("NU"),
    
    NF("NF"),
    
    MP("MP"),
    
    NO("NO"),
    
    OM("OM"),
    
    PK("PK"),
    
    PW("PW"),
    
    PS("PS"),
    
    PA("PA"),
    
    PG("PG"),
    
    PY("PY"),
    
    PE("PE"),
    
    PH("PH"),
    
    PN("PN"),
    
    PL("PL"),
    
    PT("PT"),
    
    PR("PR"),
    
    QA("QA"),
    
    RE("RE"),
    
    RO("RO"),
    
    RU("RU"),
    
    RW("RW"),
    
    BL("BL"),
    
    SH("SH"),
    
    KN("KN"),
    
    LC("LC"),
    
    MF("MF"),
    
    PM("PM"),
    
    VC("VC"),
    
    WS("WS"),
    
    SM("SM"),
    
    ST("ST"),
    
    SA("SA"),
    
    SN("SN"),
    
    RS("RS"),
    
    SC("SC"),
    
    SL("SL"),
    
    SG("SG"),
    
    SX("SX"),
    
    SK("SK"),
    
    SI("SI"),
    
    SB("SB"),
    
    SO("SO"),
    
    ZA("ZA"),
    
    GS("GS"),
    
    SS("SS"),
    
    ES("ES"),
    
    LK("LK"),
    
    SD("SD"),
    
    SR("SR"),
    
    SJ("SJ"),
    
    SZ("SZ"),
    
    SE("SE"),
    
    CH("CH"),
    
    SY("SY"),
    
    TJ("TJ"),
    
    TZ("TZ"),
    
    TH("TH"),
    
    TL("TL"),
    
    TG("TG"),
    
    TK("TK"),
    
    TO("TO"),
    
    TT("TT"),
    
    TN("TN"),
    
    TR("TR"),
    
    TM("TM"),
    
    TC("TC"),
    
    TV("TV"),
    
    UG("UG"),
    
    UA("UA"),
    
    AE("AE"),
    
    GB("GB"),
    
    US("US"),
    
    UM("UM"),
    
    UY("UY"),
    
    UZ("UZ"),
    
    VU("VU"),
    
    VE("VE"),
    
    VN("VN"),
    
    VG("VG"),
    
    VI("VI"),
    
    WF("WF"),
    
    EH("EH"),
    
    YE("YE"),
    
    ZM("ZM"),
    
    ZW("ZW"),
    
    TW("TW"),
    
    XK("XK");

    private String value;

    ValueEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ValueEnum fromValue(String text) {
      for (ValueEnum b : ValueEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("value")
  private ValueEnum value = null;

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

  public Country value(ValueEnum value) {
    this.value = value;
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @JsonProperty("value")
  @ApiModelProperty(value = "")
  public ValueEnum getValue() {
    return value;
  }

  public void setValue(ValueEnum value) {
    this.value = value;
  }

  public Country visibility(VisibilityEnum visibility) {
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
    Country country = (Country) o;
    return Objects.equals(this.value, country.value) &&
        Objects.equals(this.visibility, country.visibility);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, visibility);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Country {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

