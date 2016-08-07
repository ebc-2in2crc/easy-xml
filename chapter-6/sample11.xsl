<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" encoding="UTF-8"/>

	<xsl:template match="/">
		<html><body>
			<xsl:apply-templates select="rss"/>
		</body></html>
	</xsl:template>

	<xsl:template match="rss">
		<xsl:apply-templates select="channel"/>
	</xsl:template>

	<xsl:template match="channel">
		<xsl:apply-templates select="/rss/channel/title"/>
		<xsl:apply-templates select="/rss/channel/description"/>
		<xsl:apply-templates select="item"/>
	</xsl:template>

	<xsl:template match="/rss/channel/title">
		<center>
			<h1>
				<xsl:value-of select="."/>
			</h1>
		</center>
	</xsl:template>

	<xsl:template match="/rss/channel/description">
		<center>
			<xsl:value-of select="."/>
			<br/>
			<hr/>
		</center>
	</xsl:template>

	<xsl:template match="item">
		<h3><a>
			<xsl:attribute name="href">
				<xsl:value-of select="link"/>
			</xsl:attribute>
			<xsl:value-of select="title"/>
		</a></h3>
		<xsl:value-of select="description"/>
	</xsl:template>

</xsl:stylesheet>
