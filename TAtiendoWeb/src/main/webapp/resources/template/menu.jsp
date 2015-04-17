<%@page import="java.util.List"%>
<%@page import="pe.com.tatiendo.dao.entity.Menu"%>
<%@page import="pe.com.tatiendo.dao.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario usuario = (Usuario)session.getAttribute("usuarioInicio");
    if(usuario!=null){
        List<Menu> menuOpciones = usuario.getIdRol().getMenus();
%>
<br />
<div>
    <%
        for(Menu m : menuOpciones){
            if(m.getDescripcion()!=null){
                String url = request.getContextPath() + m.getUrl();
    %>
    
                | <a href="<%= url%>"><%= m.getDescripcion() %></a>
    
    <%
            }
        }
    %>
</div>
<%
    }
%>