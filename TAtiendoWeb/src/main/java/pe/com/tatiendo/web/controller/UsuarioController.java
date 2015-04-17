package pe.com.tatiendo.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.com.tatiendo.dao.entity.Usuario;
import pe.com.tatiendo.service.UsuarioService;
import pe.com.tatiendo.util.SystemException;
import pe.com.tatiendo.web.util.WebUtil;

@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    private UsuarioService usuarioService= (UsuarioService)WebUtil.obtenerService("USUARIO");

    protected void iniciarSesion(HttpServletRequest request, 
                                 HttpServletResponse response)
            throws Exception {
        String usuario = request.getParameter("txtUsuario");
        String clave = request.getParameter("txtClave");
        String pagina = "";
        Usuario usuarioInicio = usuarioService.validarUsuario(usuario, clave);
        if(usuarioInicio!=null){
            //La clave es correcta
            HttpSession session = request.getSession(true);
            session.setAttribute("usuarioInicio", usuarioInicio);
            if(usuarioInicio.getIdRol().getIdRol()==1){
                //Es el encargado de la tabla Producto
                pagina = "/pages/producto/mntProducto.jsp";
            }else{
                //Es el encargado de la tabla Categoria
                pagina = "/pages/categoria/mntCategoria.jsp";
            }
        }else{
            pagina = "/error.jsp?mensaje=Clave o usuario incorrecto";
        }
        response.sendRedirect(request.getContextPath() + pagina);
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("txtAction");
        try{
            if(accion.equalsIgnoreCase("iniciarSesion")){
                iniciarSesion(request, response);
            }
        }catch(Exception e){
            e.printStackTrace();
            response.sendRedirect("error.jsp?mensaje=" + 
                    WebUtil.controlarError(e));
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
