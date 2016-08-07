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
				<xsl:apply-templates select="car">
					<xsl:sort select="price" data-type="number" order="ascending"/>
				</xsl:apply-templates>
			</table>
		</body>
	</xsl:template>

	<xsl:template match="car">
		<tr>
			<xsl:apply-templates select="name"/>
			<xsl:apply-templates select="price"/>
			<xsl:apply-templates select="description"/>
			<td>
				<xsl:if test="price &lt;= 200">
					<b>SALE!</b>
				</xsl:if>
			</td>
		</tr>
	</xsl:template>

	<xsl:template match="name">
		<td>
			<xsl:value-of select="."/>
		</td>
	</xsl:template>

	<xsl:template match="price">
		<td>
			<xsl:value-of select="."/>
		</td>
	</xsl:template>

	<xsl:template match="description">
		<td>
			<xsl:value-of select="."/>
		</td>
	</xsl:template>

</xsl:stylesheet>
