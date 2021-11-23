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
                        <th style="text-align:left">Fizetés</th>
                        <th style="text-align:left">Fokozat</th>
                    </tr>
                    <xsl:for-each select="class/student">
                        <tr>
                            <td><xsl:value-of select="@id"/></td>
                            <td><xsl:value-of select="vezetéknév"/></td>
                            <td><xsl:value-of select="keresztnév"/></td>
                            <td><xsl:value-of select="becenév"/></td>
                            <td><xsl:value-of select="fizetes"/></td>
                            <xsl:choose>
                                <xsl:when test="fizetes >= 500000">
                                    <td>
                                        High
                                    </td>
                                </xsl:when>
                                <xsl:when test="fizetes >= 400000">
                                    <td>Medium</td>
                                </xsl:when>
                                <xsl:otherwise>
                                    <td>Low</td>
                                </xsl:otherwise>
                            </xsl:choose>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>