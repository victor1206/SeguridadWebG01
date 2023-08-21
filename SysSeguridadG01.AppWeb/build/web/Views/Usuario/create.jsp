<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sysseguridadg01.entidadesdenegocio.Usuario" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Crear Usuario</title>
    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />
        <main>
            <h5>Crear Usuario</h5>
            <form action="Usuario" method="post">
                <input type="hidden" name="accion" 
                       value="<%=request.getAttribute("accion")%>" id="txtHidden">
                <div class="row">
                    <div class="input-field col 14 s12">
                        <input type="text" id="txtNombre" name ="nombre" required 
                               class="validate" maxlength="30">
                        <label for="txtNombre">Nombre</label>
                    </div>
                    <div class="input-field col 14 s12">
                        <input type="text" id="txtApellido" name ="apellido" required 
                               class="validate" maxlength="30">
                        <label for="txtApellido">Apellido</label>
                    </div>
                    <div class="input-field col 14 s12">
                        <input type="text" id="txtLogin" name ="login" required 
                               class="validate" maxlength="25">
                        <label for="txtLogin">Login</label>
                    </div>
                    <div class="input-field col 14 s12">
                        <input type="password" id="txtPassword" name ="password" required 
                               class="validate" minlength="5" maxlength="32">
                        <label for="txtPassword">Password</label>
                    </div>
                    <div class="input-field col 14 s12">
                        <input type="password" id="txtConfirmPassword_aux" 
                               name ="confirmPassword_aux" required class="validate" 
                               minlength="5" maxlength="32">
                        <label for="txtConfirmPassword_aux">Password</label>
                        <span id="txtConfirmPassword_aux_error" 
                              style="color:red;font-weight: bold" class="helper-text">
                        </span>
                    </div>
                    <div class="input-field col 14 s12">
                       <select id="slEstado" name="estatus" class="validate">
                           <option value="0">Seleccionar</option>
                           <option value="1">ACTIVO</option>
                           <option value="2">INACTIVO</option>
                       </select>
                       <label for="slEstado">Estatus</label>
                       <span id="slEstado_error" 
                              style="color:red;font-weight: bold" class="helper-text">
                        </span>
                   </div>
                   <div class="input-field col 14 s12">
                       <jsp:include page="/Views/Rol/select.jsp">
                           <jsp:param name="id" value="0"/>
                       </jsp:include>
                       <span id="slRol_error" 
                              style="color:red;font-weight: bold" class="helper-text">
                        </span>
                   </div>
                </div>
                <div class="row">
                    <div class="col 112 s12">
                        <button type="submit" class="waves-effect waves-light btn blue">
                            <i class="material-icons right">save</i>Guardar
                        </button>
                        <a href="Rol" class="waves-effect waves-light btn blue">
                            <i class="material-icons right">list</i>Cancelar
                        </a>
                    </div>
                </div>
            </form>
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />
    </body>
</html>
