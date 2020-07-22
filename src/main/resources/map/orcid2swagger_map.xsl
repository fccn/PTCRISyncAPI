<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">

	<xsl:template match="/ | @* | node()">
		<xsl:copy>
			<xsl:apply-templates 
		select="@* | node()"/> 
		</xsl:copy>
	</xsl:template>
	
	<xsl:template match="createdDate">
		<created-date>
			<xsl:apply-templates select="@* | node()"/>
		</created-date>		
	</xsl:template>	

	<xsl:template match="lastModifiedDate">
		<last-modified-date>
			<xsl:apply-templates select="@* | node()"/>
		</last-modified-date>		
	</xsl:template>
	
	<xsl:template match="publicationDate">
		<publication-date>
			<xsl:apply-templates select="@* | node()"/>
		</publication-date>		
	</xsl:template>
	

	<xsl:template match="uriPath">
		<uri-path>
			<xsl:apply-templates select="@* | node()"/>
		</uri-path>		
	</xsl:template>

	<xsl:template match="citationType">
		<citation-type>
			<xsl:apply-templates select="@* | node()"/>
		</citation-type>		
	</xsl:template>
	
	<xsl:template match="sourceOrcid">
		<source-orcid>
			<xsl:apply-templates select="@* | node()"/>
		</source-orcid>		
	</xsl:template>
	
	

<xsl:template match="putCode">
		<put-code>
			<xsl:apply-templates select="@* | node()"/>
		</put-code>		
	</xsl:template>
	
 	<xsl:template match="@putCode">
        <xsl:attribute name="put-code">
            <xsl:value-of select="."/>
        </xsl:attribute>
    </xsl:template>	

<xsl:template match="sourceClientId">
		<source-client-id>
			<xsl:apply-templates select="@* | node()"/>
		</source-client-id>		
	</xsl:template>


<xsl:template match="sourceName">
		<source-name>
			<xsl:apply-templates select="@* | node()"/>
		</source-name>		
	</xsl:template>


<xsl:template match="displayIndex">
		<display-index>
			<xsl:apply-templates select="@* | node()"/>
		</display-index>		
	</xsl:template>

<xsl:template match="shortDescription">
		<short-description>
			<xsl:apply-templates select="@* | node()"/>
		</short-description>		
	</xsl:template>

	<xsl:template match="translatedTitle">
		<translated-title>
			<xsl:apply-templates select="@* | node()"/>
		</translated-title>		
	</xsl:template>
		
	<xsl:template match="journalTitle">
		<journal-title>
			<xsl:apply-templates select="@* | node()"/>
		</journal-title>		
	</xsl:template>
	
	<xsl:template match="languageCode">
		<language-code>
			<xsl:apply-templates select="@* | node()"/>
		</language-code>		
	</xsl:template>
 
  	<xsl:template match="externalIds">
		<external-ids>
			<xsl:apply-templates select="@* | node()"/>
		</external-ids>		
	</xsl:template>
	
  	<xsl:template match="externalId">
		<external-id>
			<xsl:apply-templates select="@* | node()"/>
		</external-id>		
	</xsl:template>	
 
 	<xsl:template match="externalIdType">
		<external-id-type>
			<xsl:apply-templates select="@* | node()"/>
		</external-id-type>		
	</xsl:template>
	
	<xsl:template match="externalIdValue">
		<external-id-value>
			<xsl:apply-templates select="@* | node()"/>
		</external-id-value>		
	</xsl:template>
	
	<xsl:template match="externalIdRelationship">
		<external-id-relationship>
			<xsl:apply-templates select="@* | node()"/>
		</external-id-relationship>		
	</xsl:template>
 
 	<xsl:template match="externalIdUrl">
		<external-id-url>
			<xsl:apply-templates select="@* | node()"/>
		</external-id-url>		
	</xsl:template>
 
 
 	<xsl:template match="@languageCode">
        <xsl:attribute name="language-code">
            <xsl:value-of select="."/>
        </xsl:attribute>
    </xsl:template>

</xsl:stylesheet>