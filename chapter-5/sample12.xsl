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
			<xsl:apply-templates select="car"/>
		</body>
	</xsl:template>

	<xsl:template match="car">
		<div>
			<xsl:apply-templates select="name"/>
			<xsl:apply-templates select="description"/>
		</div>
	</xsl:template>

	<xsl:template match="name">
		<h1>
			<xsl:value-of select="."/>
		</h1>
	</xsl:template>

	<xsl:template match="description">
		<p>
			<xsl:value-of select="."/>
		</p>
	</xsl:template>

</xsl:stylesheet>
