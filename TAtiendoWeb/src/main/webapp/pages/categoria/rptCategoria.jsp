<%@page import="org.jfree.chart.ChartUtilities"%>
<%@page import="net.sf.jasperreports.charts.util.ChartUtil"%>
<%@page import="org.jfree.chart.plot.PlotOrientation"%>
<%@page import="org.jfree.chart.ChartFactory"%>
<%@page import="org.jfree.chart.JFreeChart"%>
<%@page import="org.jfree.data.category.DefaultCategoryDataset"%>
<%@page import="java.io.File"%>
<%@page import="pe.com.tatiendo.dao.entity.Categoria"%>
<%@page import="pe.com.tatiendo.web.util.WebUtil"%>
<%@page import="pe.com.tatiendo.service.CategoriaService"%>
<%@page import="pe.com.tatiendo.util.SystemUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String mensaje = 
            SystemUtil.validaNulo(request.getParameter("mensaje"));
    CategoriaService categoriaService = 
            (CategoriaService)WebUtil.obtenerService("CATEGORIA");
    String nombreImagen = "rptCategoria" + 
                SystemUtil.convertirDate(
                        new java.util.Date(), "ddMMyyyyhhmmss") +
                    ".jpg";
    String ruta = request.getServletContext().getRealPath("/")
            + nombreImagen;
    try{
        List<Categoria> lista = categoriaService.listar();
        File imagen = new File(ruta);
        //Establecer la data del reporte
        DefaultCategoryDataset defaultCategoryDataset = 
                new DefaultCategoryDataset();
        for(Categoria c : lista){
            defaultCategoryDataset.setValue(c.getIdCategoria(), 
                    "Categoria", 
                    c.getNombre());
        }
        JFreeChart freeChart = ChartFactory.createBarChart(
                "Top Categorias", 
                "Categorias",
                "Cantidad", 
                defaultCategoryDataset, PlotOrientation.VERTICAL, 
                true,true,true);
        ChartUtilities.saveChartAsJPEG(imagen, freeChart, 400, 400);
    }catch(Exception e){
        e.printStackTrace();
    }
    
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../../resources/template/metaData.jsp" %>
        <title>Reporte Categoria</title>
    </head>
    <body onload="noBack();" 
          onpageshow="if(event.persisted) noBack();" 
          onunload="" >
        <%@include file="../../resources/template/cabecera.jsp" %>
        <%@include file="../../resources/template/menu.jsp" %>
        <div id="divPrincipal">
            <h3><%= mensaje%></h3>
            <img src="<%= request.getContextPath()+"/"+nombreImagen %>"
                 width="400" height="400" alt="top" />
        </div>
        <%@include file="../../resources/template/pie.jsp" %>
    </body>
</html>
