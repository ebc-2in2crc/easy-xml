<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" encoding="UTF-8"/>

	<xsl:template match="/">
		<root>
			<xsl:apply-templates select="cars/car">
				<xsl:sort select="price" order="ascending"/>
			</xsl:apply-templates>
		</root>
	</xsl:template>

	<xsl:template match="car">
		<car>
			<num>
				<xsl:number value="position()"/>
			</num>
			<xsl:apply-templates select="name"/>
			<xsl:apply-templates select="price"/>
		</car>
	</xsl:template>

	<xsl:template match="name">
		<xsl:copy-of select="."/>
	</xsl:template>

	<xsl:template match="price">
		<xsl:copy-of select="."/>
	</xsl:template>

</xsl:stylesheet>
