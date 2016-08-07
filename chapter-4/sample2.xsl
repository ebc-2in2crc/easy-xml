<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" encoding="UTF-8"/>

	<xsl:template match="/">
		<root>
			<xsl:apply-templates select="cars"/>
		</root>
	</xsl:template>

	<xsl:template match="cars">
		<cars>車リストを処理しました</cars>
	</xsl:template>

</xsl:stylesheet>
