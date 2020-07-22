<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns="http://www.orcid.org/ns/address" xmlns:ns2="http://www.orcid.org/ns/researcher-url"
	xmlns:ns3="http://www.orcid.org/ns/education" xmlns:ns4="http://www.orcid.org/ns/funding"
	xmlns:ns5="http://www.orcid.org/ns/peer-review" xmlns:ns6="http://www.orcid.org/ns/keyword"
	xmlns:ns7="http://www.orcid.org/ns/external-identifier" xmlns:ns8="http://www.orcid.org/ns/common"
	xmlns:ns9="http://www.orcid.org/ns/employment" xmlns:ns10="http://www.orcid.org/ns/work"
	xmlns:ns11="http://www.orcid.org/ns/email" xmlns:ns12="http://www.orcid.org/ns/other-name"
	version="1.0">
	<!-- xsl:template match="/ | @* | node()"> <xsl:copy> <xsl:apply-templates 
		select="@* | node()"/> </xsl:copy> </xsl:template put-code="" visibility="" 
		path="" -->

<xsl:variable name="lcletters">abcdefghijklmnopqrstuvwxyz-</xsl:variable>
<xsl:variable name="ucletters">ABCDEFGHIJKLMNOPQRSTUVWXYZ_</xsl:variable>

	<xsl:template match="Work">
		<ns10:work>
			<xsl:if test="visibility/value">
			<xsl:attribute name="visibility">
        		<xsl:value-of select="translate(visibility/value,$ucletters,$lcletters)" />
      		</xsl:attribute>
      		</xsl:if>
      		<xsl:if test="put-code">
      		<xsl:attribute name="put-code">
        		<xsl:value-of select="put-code" />
      		</xsl:attribute>      		
      		</xsl:if>
			<xsl:attribute name="path">
        		<xsl:value-of select="path" />
      		</xsl:attribute>
      		<xsl:attribute name="display-index">
        		<xsl:value-of select="display-index" />
      		</xsl:attribute>		
			<ns10:title>
				<xsl:apply-templates select="title" />
			</ns10:title>
			
			<ns10:journal-title>
				<xsl:apply-templates select="journal-title/value" />
			</ns10:journal-title>
			
			<ns10:short-description>
				<xsl:apply-templates select="short-description" />
			</ns10:short-description>
			<!--xsl:copy-of select="node()" / -->
			<xsl:if test="(citation/citation-value) and (citation/citation-value != '')">			
			<ns10:citation>
				<ns10:citation-type>
					<xsl:value-of select="translate(citation/citation-type,$ucletters,$lcletters)" />
				</ns10:citation-type>
				<ns10:citation-value>
					<xsl:value-of select="citation/citation-value" />
				</ns10:citation-value>
			</ns10:citation>
			</xsl:if>
			<ns10:type>
				<xsl:value-of select="translate(type,$ucletters,$lcletters)"/>
			</ns10:type>
			<xsl:apply-templates select="publication-date" />
			<xsl:apply-templates select="external-ids" />
			<ns10:url>
				<xsl:value-of select="url/value" />
			</ns10:url>
			<xsl:apply-templates select="contributors" />
			
			<xsl:if test="language-code/value">
			<ns8:language-code>
				<xsl:value-of select="translate(language-code/value,$ucletters,$lcletters)" />
			</ns8:language-code>
			</xsl:if>
			
			<xsl:if test="country/value">
			<ns8:country>				
				<xsl:if test="country/visibility">
					<xsl:attribute name="visibility">
	          			<xsl:value-of select="translate(country/visibility,$ucletters,$lcletters)" />         
	        		</xsl:attribute>
	        	</xsl:if>
				<xsl:value-of select="country/value" />				
			</ns8:country>			
			</xsl:if>
		</ns10:work>
	</xsl:template>

	<xsl:template match="title">
		<ns8:title>
			<xsl:value-of select="title/value" />
		</ns8:title>
		<ns8:subtitle>
			<xsl:value-of select="subtitle/value" />
		</ns8:subtitle>
		<xsl:if test="translated-title/value">
		<ns8:translated-title>
			<xsl:if test="translated-title/language-code">
				<xsl:attribute name="language-code">
	        		<xsl:value-of select="translate(translated-title/language-code,$ucletters,$lcletters)" />
	      		</xsl:attribute>
      		</xsl:if>
			<xsl:value-of select="translated-title/value" />
		</ns8:translated-title>
		</xsl:if>
	</xsl:template>

	<xsl:template match="external-ids">
		<ns8:external-ids>
			<xsl:for-each select="external-id/external-id">
				<ns8:external-id>
					<ns8:external-id-type>
						<xsl:value-of select="translate(external-id-type,$ucletters,$lcletters)" />
					</ns8:external-id-type>
					<ns8:external-id-value>
						<xsl:value-of select="external-id-value" />
					</ns8:external-id-value>
					<ns8:external-id-url>
						<xsl:value-of select="external-id-url/value" />
					</ns8:external-id-url>
					<ns8:external-id-relationship>
						<xsl:value-of select="translate(external-id-relationship,$ucletters,$lcletters)" />
					</ns8:external-id-relationship>
				</ns8:external-id>
			</xsl:for-each>
		</ns8:external-ids>
	</xsl:template>

	<xsl:template match="publication-date">
		<ns8:publication-date>
			<xsl:if test="year/value">
				<ns8:year>
					<xsl:value-of select="year/value" />
				</ns8:year>
			</xsl:if>
			<xsl:if test="month/value">
				<ns8:month>
					<xsl:value-of select="month/value" />
				</ns8:month>
			</xsl:if>
			<xsl:if test="day/value">
				<ns8:day>
					<xsl:value-of select="day/value" />
				</ns8:day>
			</xsl:if>
		</ns8:publication-date>
	</xsl:template>

	<xsl:template match="contributors">
		<ns10:contributors>			
			<xsl:for-each select="contributor">
				<ns10:contributor>
					<ns10:contributor-orcid>
						<ns8:uri />
						<ns8:path />
						<ns8:host />
					</ns10:contributor-orcid>
					<ns10:credit-name>
						<xsl:if test="contributor/credit-name/visibility"> 
							<xsl:attribute name="visibility">
	              				<xsl:value-of select="contributor/credit-name/visibility" />
	            			</xsl:attribute>
            			</xsl:if>
						<xsl:value-of select="contributor/credit-name/value" />
					</ns10:credit-name>
					<ns10:contributor-email>
						<xsl:value-of select="contributor/contributor-email/value" />
					</ns10:contributor-email>
					<ns10:contributor-attributes>
						<ns10:contributor-sequence />
						<ns10:contributor-role />
					</ns10:contributor-attributes>
				</ns10:contributor>
			</xsl:for-each>
		</ns10:contributors>
	</xsl:template>
	
 

</xsl:stylesheet>