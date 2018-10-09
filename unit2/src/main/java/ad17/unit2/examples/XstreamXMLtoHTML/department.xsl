<?xml version="1.0" encoding='ISO-8859-1'?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:template match='/'>
   <html><xsl:apply-templates /></html>
 </xsl:template>
 <xsl:template match='DepartmentList'>
    <head><title>LIST OF DEPARTMENTS</title></head>
    <body> 
    <h1>LIST OF DEPARTMENTS</h1>
    <table border='1'>
    <tr><th>Name Department</th><th>Town</th><th>Num.Department</th></tr>
      <xsl:apply-templates select='DepartmentInfo' />
    </table>
    </body>
 </xsl:template>
 <xsl:template match='DepartmentInfo'>
   <tr><xsl:apply-templates /></tr>
 </xsl:template>
 <xsl:template match='name|loc|nrDep'>
   <td><xsl:apply-templates /></td>
 </xsl:template>
</xsl:stylesheet>
