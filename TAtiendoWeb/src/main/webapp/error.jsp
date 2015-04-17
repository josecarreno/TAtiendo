<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
session.removeAttribute("usuarioInicio");
session.invalidate();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="resources/template/metaData.jsp" %>
        <title>Error</title>
    </head>
    <body onload="noBack();" 
          onpageshow="if(event.persisted) noBack();" 
          onunload="" >
        <%@include file="resources/template/cabecera.jsp" %>
        <div id="divPrincipal">
            <h4>ERROR</h4>
            <h3><%= request.getParameter("mensaje") %></h3>
            <a href="<%= request.getContextPath() %>">Volver al Inicio</a>
        </div>
        <%@include file="resources/template/pie.jsp" %>
    </body>
</html>
