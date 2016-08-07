<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" encoding="UTF-8"/>

	<xsl:template match="/">
		<root>
			<xsl:apply-templates select="cars"/>
		</root>
	</xsl:template>

	<xsl:template match="cars">
		<xsl:copy>
			<xsl:apply-templates select="car"/>
			<sum>
				<xsl:value-of select="sum(car/price)"/>
			</sum>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="car">
		<xsl:copy>
			<xsl:apply-templates select="name"/>
			<xsl:apply-templates select="price"/>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="name">
		<xsl:copy-of select="."/>
	</xsl:template>

	<xsl:template match="price">
		<xsl:copy-of select="."/>
	</xsl:template>

</xsl:stylesheet>
