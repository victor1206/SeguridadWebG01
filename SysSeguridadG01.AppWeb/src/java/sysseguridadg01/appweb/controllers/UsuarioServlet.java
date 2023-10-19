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
        try
        {
            Usuario usuario = new Usuario();
            usuario.setTop_aux(10);
            ArrayList<Usuario> usuarios = UsuarioDAL.buscarIncluirRol(
                                    usuario);
            request.setAttribute("usuarios", usuarios);
            request.setAttribute("top_aux", usuario.getTop_aux());
            request.getRequestDispatcher("Views/Usuario/index.jsp").forward(request, response);
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
            Usuario usuario = new Usuario();
            usuario.setTop_aux(10);
            ArrayList<Usuario> usuarios = UsuarioDAL.buscarIncluirRol(
                                    usuario);
            request.setAttribute("usuarios", usuarios);
            request.setAttribute("top_aux", usuario.getTop_aux());
            request.getRequestDispatcher("Views/Usuario/index.jsp").forward(request, response);
        }
        catch(Exception ex)
        {
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
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
            Usuario usuario_auth = UsuarioDAL.login(usuario);//Provisional
            if(usuario_auth.getId() != 0 && 
               usuario_auth.getLogin().equals(usuario.getLogin()))
            {
                Rol rol = new Rol();
                rol.setId(usuario_auth.getIdRol());
                usuario_auth.setRol(RolDAL.obtenerPorId(rol));
                SessionUser.autenticarUser(request, usuario_auth);
                String userLogs = SessionUser.getUser(request);
                request.setAttribute("userlog", userLogs);
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
    
    protected void doGetRequestCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.getRequestDispatcher("Views/Usuario/create.jsp")
                    .forward(request, response);
    }
    
    protected void doPostRequestCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            Usuario usuario = obtenerUsuario(request);
            int result = UsuarioDAL.crear(usuario);
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
    
    protected void requestObtenerPorId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            Usuario usuario = obtenerUsuario(request);
            Usuario usuario_result = UsuarioDAL.obtenerPorId(usuario);
            if(usuario_result.getId() > 0)
            {
                Rol rol = new Rol();
                rol.setId(usuario_result.getIdRol());
                usuario_result.setRol(RolDAL.obtenerPorId(rol));
                request.setAttribute("usuario", usuario_result);
            }
            else
            {
                Utilidad.enviarError("El Id: " + usuario_result.getId() 
                + " no existe en la base de datos", request, response);
            }
        }
        catch(Exception ex)
        {
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }
    
    protected void doGetRequestEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            requestObtenerPorId(request,response);
            request.getRequestDispatcher("Views/Usuario/edit.jsp")
                    .forward(request, response);
    }
    
    protected void doPostRequestEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            Usuario usuario = obtenerUsuario(request);
            int result = UsuarioDAL.modificar(usuario);
            if(result != 0)
            {
                request.setAttribute("accion", "index");
                doGetRequestIndex(request, response);
            }
            else
            {
                Utilidad.enviarError("Error al Actualizar el Regisgtro", request, response);
            }

        }
        catch(Exception ex)
        {
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }
    
    protected void doGetRequestDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            requestObtenerPorId(request,response);
            request.getRequestDispatcher("Views/Usuario/details.jsp")
                    .forward(request, response);
    }
    
    protected void doGetRequestDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            requestObtenerPorId(request,response);
            request.getRequestDispatcher("Views/Usuario/delete.jsp")
                    .forward(request, response);
    }
    
    protected void doPostRequestDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            Usuario usuario = obtenerUsuario(request);
            int result = UsuarioDAL.eliminar(usuario);
            if(result != 0)
            {
                request.setAttribute("accion", "index");
                doGetRequestIndex(request, response);
            }
            else
            {
                Utilidad.enviarError("Error al Eliminar el Regisgtro", request, response);
            }

        }
        catch(Exception ex)
        {
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }
    
    protected void doGetRequestCambiarPassword(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            Usuario usuario = new Usuario();
            //Buscar el usuario que esta logeado y obtiene el login de la 
            //variable de session ViDuran
            usuario.setLogin(SessionUser.getUser(request));
            Usuario usuario_result = UsuarioDAL.buscar(usuario)
                    .get(0);
            if(usuario_result.getId() > 0)
            {
                request.setAttribute("usuario", usuario_result);
                request.getRequestDispatcher(
                        "Views/Usuario/cambiarPassword.jsp")
                    .forward(request, response);
            }
            else
            {
                Utilidad.enviarError("El login: " + usuario_result.getLogin() +
                        "no existe en la Base de Datos", request, response);
            }
        }
        catch(Exception ex)
        {
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }
    
    protected void doPostCambiarPassword(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            Usuario usuario = obtenerUsuario(request);
            String passActual = Utilidad.getParameter(request,
                    "passwordActual", "");
            int result = UsuarioDAL.cambiarPassword(usuario, 
                    passActual);
            if(result != 0)
            {
                response.sendRedirect("Usuario?accion=login");
            }
            else
            {
                Utilidad.enviarError("Error al cambiar el Password", request, response);
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
        String accion = Utilidad.getParameter(request, "accion", 
                "index");
        if(accion.equals("login"))
        {
            request.setAttribute("accion", accion);
            doGetRequestLogin(request, response);
        }
        else
        {
            SessionUser.authorize(request, response, () -> {
                switch(accion)
                {
                    case "index":
                        request.setAttribute("accion", accion);
                        doGetRequestIndex(request,response);
                        break;
                    case "create":
                        request.setAttribute("accion", accion);
                        doGetRequestCreate(request,response);
                        break;
                    case "edit":
                        request.setAttribute("accion", accion);
                        doGetRequestEdit(request,response);
                        break;
                    case "details":
                        request.setAttribute("accion", accion);
                        doGetRequestDetails(request,response);
                        break;
                    case "delete":
                        request.setAttribute("accion", accion);
                        doGetRequestDelete(request,response);
                        break;
                    case "cambiarpass":
                        request.setAttribute("accion", accion);
                        doGetRequestCambiarPassword(request,response);
                        break;
                }
            });
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
        else
        {
            SessionUser.authorize(request, response, () -> {
                switch(accion)
                {
                    case "index":
                        request.setAttribute("accion", accion);
                        doPostRequestIndex(request,response);
                        break;
                    case "create":
                        request.setAttribute("accion", accion);
                        doPostRequestCreate(request,response);
                        break;
                    case "edit":
                        request.setAttribute("accion", accion);
                        doPostRequestEdit(request,response);
                        break;
                    case "delete":
                        request.setAttribute("accion", accion);
                        doPostRequestDelete(request,response);
                        break;
                    case "cambiarpass":
                        request.setAttribute("accion", accion);
                        doPostCambiarPassword(request,response);
                        break;
                }
            });
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
