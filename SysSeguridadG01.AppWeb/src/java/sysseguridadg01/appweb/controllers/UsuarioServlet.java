/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sysseguridadg01.appweb.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import sysseguridadg01.accesoadatos.UsuarioDAL;
import sysseguridadg01.accesoadatos.RolDAL;
import sysseguridadg01.appweb.utils.*;
import sysseguridadg01.entidadesdenegocio.Rol;
import sysseguridadg01.entidadesdenegocio.Usuario;

/**
 *
 * @author victo
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/Usuario"})
public class UsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private Usuario obtenerUsuario(HttpServletRequest request)
    {
        String accion = Utilidad.getParameter(request, "accion", 
                "index");
        Usuario usuario = new Usuario();
        //Llenar objeto usuario desde vista (Nombre)
        usuario.setNombre(Utilidad.getParameter(request, "nombre", 
                ""));
        //Llenar objeto usuario desde vista (Apellido)
        usuario.setApellido(Utilidad.getParameter(request, 
                "apellido", ""));
        //Llenar objeto usuario desde vista (login)
        usuario.setLogin(Utilidad.getParameter(request, 
                "login", ""));
        //Llenar objeto usuario desde vista (idRol)
        usuario.setIdRol(Integer.parseInt(Utilidad.getParameter(request, 
                "idRol", "0")));
        //Llenar objeto usuario desde vista (idRol)
        usuario.setEstatus(Byte.parseByte(Utilidad.getParameter(
                request, "estatus", "0")));
        if(accion.equals("create") || accion.equals("login")
           || accion.equals("cambiarpass"))
        {
            usuario.setPassword(Utilidad.getParameter(request, 
                    "password",""));
            usuario.setConfirmPassword_aux(Utilidad.getParameter(request, 
                    "confirmPassword_aux",""));
            if(accion.equals("cambiarpass"))
            {
                usuario.setId(Integer.parseInt(Utilidad.getParameter(request, 
                "id", "0")));
            }
        }
        else
        if(accion.equals("index"))
        {
            usuario.setTop_aux(Integer.parseInt(
                    Utilidad.getParameter(request,"top_aux", "10")));
            usuario.setTop_aux(usuario.getTop_aux() == 0 ? Integer.MAX_VALUE: 
                    usuario.getTop_aux());
        }
        else
        {
            usuario.setId(Integer.parseInt(Utilidad.getParameter(request, 
                "id", "0")));
        }
        return usuario;
    }
    
    protected void doGetRequestIndex(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Views/Rol/create.jsp").forward(request, response);
    }
    
    protected void doGetRequestLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.getRequestDispatcher("Views/Usuario/login.jsp")
                    .forward(request, response);
    }
    
    protected void doPostRequestLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            Usuario usuario = obtenerUsuario(request);
            Usuario usuario_auth = new Usuario();//Provisional
            if(usuario_auth.getId() != 0 && 
               usuario_auth.getLogin().equals(usuario.getLogin()))
            {
                Rol rol = new Rol();
                rol.setId(usuario_auth.getIdRol());
                usuario_auth.setRol(RolDAL.obtenerPorId(rol));
                SessionUser.autenticarUser(request, usuario_auth);
                response.sendRedirect("Home");
            }
            else
            {
                request.setAttribute("error", "Credenciales incorrectas");
                request.setAttribute("accion", "login");
                doGetRequestLogin(request, response);
            }

        }
        catch(Exception ex)
        {
            request.setAttribute("error", ex.getMessage());
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
        String accion = Utilidad.getParameter(request, "accion", 
                "index");
        if(accion.equals("login"))
        {
            request.setAttribute("accion", accion);
            doGetRequestLogin(request, response);
        }
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
        String accion = Utilidad.getParameter(request, "accion", 
                "index");
        if(accion.equals("login"))
        {
            request.setAttribute("accion", accion);
            doPostRequestLogin(request, response);
        }
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
