<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" encoding="UTF-8"/>

	<xsl:template match="/">
		<root>
			<xsl:apply-templates select="cars/car[2]"/>
		</root>
	</xsl:template>

	<xsl:template match="car">
		<xsl:copy>
			<xsl:apply-templates select="name"/>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="name">
		<xsl:copy-of select="."/>
	</xsl:template>

</xsl:stylesheet>
