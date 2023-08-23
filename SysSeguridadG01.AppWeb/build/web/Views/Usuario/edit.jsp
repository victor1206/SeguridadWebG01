<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sysseguridadg01.entidadesdenegocio.Usuario" %>
<% Usuario usuario = (Usuario) request.getAttribute("usuario");%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Editar Usuario</title>
    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />
        <main class="container">
            <h5>Editar Usuario</h5>
            <form action="Usuario" method="post" onsubmit="return validarFormulario()">
                <input type="hidden" name="accion" 
                       value="<%=request.getAttribute("accion")%>" id="txtHidden">
                <input type="hidden" name="id" value="<%=usuario.getId()%>">
                <div class="row">
                    <div class="input-field col 14 s12">
                        <input type="text" id="txtNombre" name ="nombre" required 
                               class="validate" maxlength="30"
                               value="<%=usuario.getNombre()%>">
                        <label for="txtNombre">Nombre</label>
                    </div>
                    <div class="input-field col 14 s12">
                        <input type="text" id="txtApellido" name ="apellido" required 
                               class="validate" maxlength="30"
                               value="<%=usuario.getApellido()%>">
                        <label for="txtApellido">Apellido</label>
                    </div>
                    <div class="input-field col 14 s12">
                        <input type="text" id="txtLogin" name ="login" required 
                               class="validate" maxlength="25"
                               value="<%=usuario.getLogin()%>">
                        <label for="txtLogin">Login</label>
                    </div>
                    <div class="input-field col 14 s12">
                       <select id="slEstado" name="estatus" class="validate">
                           <option value="0" <%=usuario.getEstatus() == 0 ? "selected":""%>>Seleccionar</option>
                           <option value="1" <%=usuario.getEstatus() == 1 ? "selected":""%>>ACTIVO</option>
                           <option value="2" <%=usuario.getEstatus() == 2 ? "selected":""%>>INACTIVO</option>
                       </select>
                       <label for="slEstado">Estatus</label>
                       <span id="slEstado_error" 
                              style="color:red;font-weight: bold" class="helper-text">
                        </span>
                   </div>
                   <div class="input-field col 14 s12">
                       <jsp:include page="/Views/Rol/select.jsp">
                           <jsp:param name="id" value="<%=usuario.getIdRol()%>"/>
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
        <script>
            function validarFormulario()
            {
                var result = true;
                var slestatus = $("#slEstado").val();
                var slRol = $("#slRol").val();
                
                if(parseInt(slestatus) == 0)
                {
                    $("#slEstado_error")
                            .empty();
                   $("#slEstado_error")
                    .append("El estatus es obligatorio");
                    result = false;
                }
                else
                {
                    $("#slEstado_error")
                            .empty();
                }
                
                if(parseInt(slRol) == 0)
                {
                    $("#slRol_error")
                            .empty();
                   $("#slRol_error")
                    .append("El Rol es obligatorio");
                    result = false;
                }
                else
                {
                    $("#slRol_error")
                            .empty();
                }
                return result;
            }   
            
            <%--function validarFormulario() {
                var result = true;
                var txtPassword = document.getElementById("txtPassword");
                var txtConfirm_password = document.getElementById("txtConfirmPassword_aux");
                var txtConfirm_password_error = document.getElementById("txtConfirmPassword_aux_error");
                var slEstatus = document.getElementById("slEstatus");
                var slEstatus_error = document.getElementById("slEstatus_error");
                var slRol = document.getElementById("slRol");
                var slRol_error = document.getElementById("slRol_error");
                if (txtPassword.value != txtConfirm_password.value) {
                    txtConfirm_password_error.innerHTML = "El password y confirmar password debe ser iguales";
                    result = false;
                } else {
                    txtConfirm_password_error.innerHTML = "";
                }
                if (slEstatus.value == 0) {
                    slEstatus_error.innerHTML = "El estatus es obligatorio";
                    result = false;
                } else {
                    slEstatus_error.innerHTML = "";
                }
                if (slRol.value == 0) {
                    slRol_error.innerHTML = "El Rol es obligatorio";
                    result = false;
                } else {
                    slRol_error.innerHTML = "";
                }

                return result;
            }--%>
        </script>
    </body>
</html>
