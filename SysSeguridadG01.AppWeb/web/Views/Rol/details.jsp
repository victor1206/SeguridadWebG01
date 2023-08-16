<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sysseguridadg01.entidadesdenegocio.Rol" %>
<% Rol rol = (Rol) request.getAttribute("rol");%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Detalle Rol</title>
    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />
        <main>
            <h5>Datelle Rol</h5>
            <form action="Rol" method="post">
                <input type="hidden" name="accion" 
                       value="<%=request.getAttribute("accion")%>" id="txtHidden">
                <input type="hidden" name="id" value="<%=rol.getId()%>" />
                <div class="row">
                    <div class="input-field col 14 s12">
                        <input type="text" disabled id="txtNombre" name ="nombre" required 
                               class="validate" maxlength="30" 
                               value="<%=rol.getNombre()%>">
                        <label for="txtNombre">Nombre</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col 112 s12">
                        <a href="Rol?accion=edit&id=<%=rol.getId()%>" class="waves-effect waves-light btn blue">
                            <i class="material-icons right">edit</i>Ir a Editar
                        </a>
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
