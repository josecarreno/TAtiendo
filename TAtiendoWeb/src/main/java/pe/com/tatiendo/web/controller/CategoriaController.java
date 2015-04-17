/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.tatiendo.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.com.tatiendo.dao.entity.Categoria;
import pe.com.tatiendo.service.CategoriaService;
import pe.com.tatiendo.web.util.WebUtil;

/**
 *
 * @author proyecto
 */
@WebServlet(name = "CategoriaController", urlPatterns = {"/CategoriaController"})
public class CategoriaController extends HttpServlet {

    private CategoriaService categoriaService = 
            (CategoriaService) WebUtil.obtenerService("CATEGORIA");
    //Permite registrar una categoria
    protected void registrar(HttpServletRequest request, 
            HttpServletResponse response) throws Exception{
        Categoria categoria = new Categoria();
        categoria.setNombre(request.getParameter("txtNombre"));
        categoriaService.insertar(categoria);
    }
    //Permite actualizar una categoria
    protected void actualizar(HttpServletRequest request, 
            HttpServletResponse response) throws Exception{
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(
                Integer.parseInt(request.getParameter("txtCodigo")));
        categoria.setNombre(request.getParameter("txtNombre"));
        categoriaService.actualizar(categoria);
    }
    //Permite eliminar una categoria
    protected void eliminar(HttpServletRequest request, 
            HttpServletResponse response) throws Exception{
        categoriaService.eliminar(
                Integer.parseInt(request.getParameter("id")));
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("txtAction");
        String mensaje = "";
        String pagina = "";
        try {
            if(accion.equalsIgnoreCase("REGISTRAR")){
                registrar(request, response);
                mensaje ="Se registro correctamente la categoria";
                pagina = "/pages/categoria/mntCategoria.jsp?mensaje=";
            }else if(accion.equalsIgnoreCase("ACTUALIZAR")){
                actualizar(request, response);
                mensaje ="Se actualizo correctamente la categoria";
                pagina = "/pages/categoria/mntCategoria.jsp?mensaje=";
            }else if(accion.equalsIgnoreCase("ELIMINAR")){
                eliminar(request, response);
                mensaje ="Se elimino correctamente la categoria";
                pagina = "/pages/categoria/mntCategoria.jsp?mensaje=";
            }
        } catch (Exception e) {
            e.printStackTrace();
            mensaje = WebUtil.controlarError(e);
            pagina = "/error.jsp?mensaje=";
        }
        response.sendRedirect(request.getContextPath() + pagina + mensaje);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
