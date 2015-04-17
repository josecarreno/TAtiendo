/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.tatiendo.web.filter;

import java.io.IOException;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.com.tatiendo.dao.entity.Menu;
import pe.com.tatiendo.dao.entity.Usuario;

@WebFilter(filterName = "ServletFilter", urlPatterns = {"/*"})
public class ServletFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(":::INICIO DEL FILTRO:::");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(":::doFilter:::");
        boolean accesoPermitido = true;
        if(request instanceof HttpServletRequest && 
                response instanceof HttpServletResponse){
            HttpServletRequest requestTemp = (HttpServletRequest)request;
            HttpServletResponse responseTemp = (HttpServletResponse)response;
            HttpSession session = requestTemp.getSession(false);
            String paginaVisitada = requestTemp.getRequestURI();
            if(paginaVisitada.contains(".jsp")){
                if(paginaVisitada.contains("error.jsp") ||
                        paginaVisitada.contains("index.jsp")){
                    accesoPermitido = true;
                    if(session!=null && 
                            session.getAttribute("usuarioInicio")!=null){
                        session.removeAttribute("usuarioInicio");
                        session.invalidate();
                    }
                }else{
                      if(session!=null && 
                          session.getAttribute("usuarioInicio")!=null){
                          //Yo inicie sesión
                          accesoPermitido = false;
                          Usuario usuario = 
                                  (Usuario)session.getAttribute("usuarioInicio");
                          //Las paginas que tengo acceso
                          List<Menu> menuOpciones = 
                                  usuario.getIdRol().getMenus();
                          for(Menu m : menuOpciones){
                              if(paginaVisitada.contains(m.getUrl())){
                                  accesoPermitido = true;
                                  break;
                              }
                          }
                      }else{
                          //No inice sesión
                          accesoPermitido = false;
                      }
                }
            }
            if(accesoPermitido == false){
                responseTemp.sendRedirect(
                        requestTemp.getContextPath() + 
                        "/error.jsp?mensaje=No tiene acceso a la pagina");
            }
        }
        if(accesoPermitido == true){
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("SE ELIMINO EL FILTRO");
    }
    
    
    
}
