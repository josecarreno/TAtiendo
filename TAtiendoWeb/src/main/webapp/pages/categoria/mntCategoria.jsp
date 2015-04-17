<%@page import="pe.com.tatiendo.util.SystemUtil"%>
<%@page import="pe.com.tatiendo.dao.entity.Categoria"%>
<%@page import="pe.com.tatiendo.web.util.WebUtil"%>
<%@page import="pe.com.tatiendo.service.CategoriaService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    CategoriaService categoriaService = 
            (CategoriaService)WebUtil.obtenerService("CATEGORIA");
    List<Categoria> listaCategorias = null;
    String mensaje = SystemUtil.validaNulo(request.getParameter("mensaje"));
    try{
        listaCategorias = categoriaService.listar();
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
        <title>Mantenimiento Categoria</title>
    </head>
    <body onload="noBack();" 
          onpageshow="if(event.persisted) noBack();" 
          onunload="" >
        <%@include file="../../resources/template/cabecera.jsp" %>
        <%@include file="../../resources/template/menu.jsp" %>
        <div id="divPrincipal">
            <h3><%= mensaje %></h3>
            <table border="1">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Operación</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        if(listaCategorias!=null){
                            for(Categoria c : listaCategorias){
                    %>
                    <tr>
                        <td><%= c.getIdCategoria() %></td>
                        <td><%= c.getNombre() %></td>
                        <td>
                            <%
                                String rAct = 
                                   request.getContextPath() + "/pages/categoria/actCategoria.jsp";
                                rAct+="?id=" + c.getIdCategoria();
                                
                                String rEli = 
                                    request.getContextPath() + "/CategoriaController";
                                rEli+="?id=" + c.getIdCategoria() + "&txtAction=ELIMINAR";
                            %>
                            <a href="<%= rAct %>">Actualizar</a> |
                            <a href="<%= rEli %>">Eliminar</a>
                        </td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>

        </div>
        <%@include file="../../resources/template/pie.jsp" %>
    </body>
</html>
