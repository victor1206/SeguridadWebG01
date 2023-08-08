package sysseguridadg01.appweb.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import sysseguridadg01.accesoadatos.RolDAL;
import sysseguridadg01.entidadesdenegocio.Rol;
import sysseguridadg01.appweb.utils.*;

/**
 *
 * @author victo
 */
@WebServlet(name = "RolServlet", urlPatterns = {"/Rol"})
public class RolServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Rol obtenerRol(HttpServletRequest request)
    {
        String accion = Utilidad.getParameter(request, "accion", "index");
        Rol rol = new Rol();
        if(accion.equals("create") == false)
        {
            //Obtiene el parametro de Id del request y asigna el valor a la propiedad 
            //Id de la instancia
            rol.setId(Integer.parseInt(Utilidad.getParameter(request, "id",
                    "0")));
        }
        rol.setNombre(Utilidad.getParameter(request, "nombre", ""));
        if(accion.equals("index"))
        {
            rol.setTop_aux(Integer.parseInt(Utilidad.getParameter(request, 
                    "top_aux", "10")));
            rol.setTop_aux(rol.getTop_aux() == 0 ? Integer.MAX_VALUE: rol.getTop_aux());
        }
        return rol;
    }
    
    protected void doGetRequestIndex(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            Rol rol = new Rol();
            rol.setTop_aux(10);
            ArrayList<Rol> roles = RolDAL.buscar(rol);
            request.setAttribute("roles", roles);
            request.setAttribute("top_aux", rol.getTop_aux());
            request.getRequestDispatcher("Views/Rol/index.jsp")
                    .forward(request, response);
        }
        catch(Exception ex)
        {
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }
    
    protected void doPostRequestIndex(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            Rol rol = obtenerRol(request);
            ArrayList<Rol> roles = RolDAL.buscar(rol);
            request.setAttribute("roles", roles);
            request.setAttribute("top_aux", rol.getTop_aux());
            request.getRequestDispatcher("Views/Rol/index.jsp")
                    .forward(request, response);
        }
        catch(Exception ex)
        {
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }
    
    protected void doGetRequestCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.getRequestDispatcher("Views/Rol/create.jsp")
                    .forward(request, response);
    }
    
    protected void doPostRequestCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            Rol rol = obtenerRol(request);
            int result = RolDAL.crear(rol);
            if(result != 0)
            {
                request.setAttribute("accion", "index");
                doGetRequestIndex(request, response);
            }
            else
            {
                Utilidad.enviarError("Error al Guardar el Regisgtro", request, response);
            }

        }
        catch(Exception ex)
        {
            Utilidad.enviarError(ex.getMessage(), request, response);
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
        //processRequest(request, response);
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
        //processRequest(request, response);
    }
}
