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
        <title>Iniciar Sesión</title>
    </head>
    <body onload="noBack();" 
          onpageshow="if(event.persisted) noBack();" 
          onunload="" >
        <%@include file="resources/template/cabecera.jsp" %>
        
        <form action="UsuarioController">
            <input type="hidden" name="txtAction" value="iniciarSesion" />
            
            
            <table border ="0">
                <tr>
                    <td>Usuario:</td>
                    <td><input type="text" name="txtUsuario" value="" /></td>
                </tr>
                <tr>
                    <td>Clave:</td>
                    <td><input type="password" name="txtClave" value="" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Iniciar Sesion" name="btnIniciar" /></td>
                </tr>
            </table>
        </form>
        <%@include file="resources/template/pie.jsp" %>
    </body>
</html>
