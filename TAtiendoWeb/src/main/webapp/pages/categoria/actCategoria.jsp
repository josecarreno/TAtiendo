<%@page import="pe.com.tatiendo.dao.entity.Categoria"%>
<%@page import="pe.com.tatiendo.web.util.WebUtil"%>
<%@page import="pe.com.tatiendo.service.CategoriaService"%>
<%@page import="pe.com.tatiendo.util.SystemUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String mensaje = SystemUtil.validaNulo(request.getParameter("mensaje"));
    CategoriaService categoriaService = 
            (CategoriaService)WebUtil.obtenerService("CATEGORIA");
    Categoria c = null;
    try{
        c = categoriaService.obtener(
                Integer.parseInt(request.getParameter("id")));
    }catch(Exception e){
        mensaje = WebUtil.controlarError(e);
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../../resources/template/metaData.jsp" %>
        <title>Actualizar Categoria</title>
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
                        <td>Código: </td>
                        <td><input type="text" name="txtCodigo" 
                                   value="<%= c.getIdCategoria() %>"
                                   readonly="true"/></td>
                    </tr>
                    <tr>
                        <td>Nombre: </td>
                        <td><input type="text" name="txtNombre" 
                                   value="<%= c.getNombre() %>" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Actualizar" name="btnActualizar" /></td>
                    </tr>
                </table>
                <input type="hidden" name="txtAction" value="ACTUALIZAR" />
            </form>
        </div>
        <%@include file="../../resources/template/pie.jsp" %>
    </body>
</html>
