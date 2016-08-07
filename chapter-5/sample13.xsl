<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" encoding="UTF-8"/>

	<xsl:template match="/">
		<html>
			<xsl:apply-templates select="cars"/>
		</html>
	</xsl:template>

	<xsl:template match="cars">
		<body>
			<table border="3">
				<xsl:apply-templates select="car[price &gt;= 200]"/>
			</table>
		</body>
	</xsl:template>

	<xsl:template match="car">
		<tr>
			<xsl:apply-templates select="name"/>
			<xsl:apply-templates select="price"/>
			<xsl:apply-templates select="description"/>
		</tr>
	</xsl:template>

	<xsl:template match="name">
		<td>
			<xsl:value-of select="."/>
		</td>
	</xsl:template>

	<xsl:template match="price">
		<td>
			<xsl:value-of select="."/>万円
		</td>
	</xsl:template>

	<xsl:template match="description">
		<td>
			<xsl:value-of select="."/>
		</td>
	</xsl:template>

</xsl:stylesheet>
