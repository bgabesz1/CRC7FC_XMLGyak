<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
    <body>
        <h2>Halgatói adatok</h2>
        <table border="1">
            <tr bgcolor="#9acd32">
                <th style="text-align:left">id</th>
                <th style="text-align:left">vezeteknev</th>
                <th style="text-align:left">keresztnev</th>
                <th style="text-align:left">becenev</th>
                <th style="text-align:left">kor</th>
            </tr>
            <xsl:for-each select="class/student">
                <tr>
                    <td><xsl:value-of select="@id"/></td>
                    <td><xsl:value-of select="vezetéknév"/></td>
                    <td><xsl:value-of select="keresztnév"/></td>
                    <td><xsl:value-of select="becenév"/></td>
                    <td><xsl:value-of select="kor"/></td>
                </tr>
            </xsl:for-each>
        </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>