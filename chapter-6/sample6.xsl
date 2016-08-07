<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" encoding="UTF-8"/>

	<xsl:template match="/">
		<root>
			<xsl:apply-templates select="//title"/>
		</root>
	</xsl:template>

	<xsl:template match="title">
		<title>
			<xsl:number level="multiple" count="chapter|section|subsection"/>
			<xsl:text>_</xsl:text>
			<xsl:value-of select="."/>
		</title>
	</xsl:template>

</xsl:stylesheet>
