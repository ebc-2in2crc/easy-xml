<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" encoding="UTF-8"/>

	<xsl:template match="/">
		<文書>
			<xsl:apply-templates select="cars"/>
		</文書>
	</xsl:template>

	<xsl:template match="cars">
		<車リスト>
			<xsl:apply-templates select="car"/>
		</車リスト>
	</xsl:template>

	<xsl:template match="car">
		<車>
			<xsl:apply-templates select="name"/>
			<xsl:apply-templates select="price"/>
		</車>
	</xsl:template>

	<xsl:template match="name">
		<品名>
			<xsl:value-of select="."/>
		</品名>
	</xsl:template>

	<xsl:template match="price">
		<価格>
			<xsl:value-of select="."/>
		</価格>
	</xsl:template>

</xsl:stylesheet>
