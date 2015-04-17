<%@page import="pe.com.tatiendo.util.SystemUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String mensaje = SystemUtil.validaNulo(request.getParameter("mensaje"));
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../../resources/template/metaData.jsp" %>
        <title>Registrar Categoria</title>
    </head>
    <body onload="noBack();" 
          onpageshow="if(event.persisted) noBack();" 
          onunload="" >
        <%@include file="../../resources/template/cabecera.jsp" %>
        <%@include file="../../resources/template/menu.jsp" %>
        <div id="divPrincipal">
            <h3><%= mensaje %></h3>
            <form id="frmPrincipal" method="post" 
                  action="<%= request.getContextPath() %>/CategoriaController">
                <table border="0">
                    <tr>
                        <td>Nombre: </td>
                        <td><input type="text" name="txtNombre" value="" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Registrar" name="btnRegistrar" /></td>
                    </tr>
                </table>
                <input type="hidden" name="txtAction" value="REGISTRAR" />
            </form>
        </div>
        <%@include file="../../resources/template/pie.jsp" %>
    </body>
</html>
