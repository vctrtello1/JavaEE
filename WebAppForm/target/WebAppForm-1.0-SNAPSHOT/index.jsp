<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@page import="java.util.Map" %>
        <% Map<String, String> errores = (Map<String, String>)request.getAttribute("errores"); %>
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <title>Formulario de usuarios</title>
                    <!-- CSS only -->
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
                        integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
                </head>

                <body>
                    <h3>Formulario de usuarios</h3>

                    <% if(errores !=null && errores.size()>0){
                        %>
                        <ul class="alert alert-danger">
                            <% for(String error: errores.values()){%>
                                <li>
                                    <%=error%>
                                </li>
                                <%}%>
                        </ul>
                        <%}%>

                            <form action="/WebAppForm/registro" method="post">

                                <div class="row mb-3">
                                    <label for="username" class="col-form-label col-sm-2">Usuario</label>
                                    <div class="col-sm-4"><input type="text" name="username" id="username" class="form-control"></div>
                                    <% if(errores !=null && errores.containsKey("username")){ out.print("<small class='alert alert-danger' style='color:red'>" + errores.get("username") + "</small>"); } %>
                                </div>
                                <div class="row mb-3">
                                    <label for="password" class="col-form-label col-sm-2">Password</label>
                                    <div class="col-sm-4"><input type="password" name="password" id="password" class="form-control"></div>
                                    <% if(errores !=null && errores.containsKey("password")){ out.print("<small class='alert alert-danger' style='color:red'>" + errores.get("password") + "</small>"); } %>
                                </div>
                                <div class="row mb-3">
                                    <label for="email" class="col-form-label col-sm-2">Email</label>
                                    <div class="col-sm-4"><input type="text" name="email" id="email" class="form-control"></div>
                                    <% if(errores !=null && errores.containsKey("email")){ out.print("<small class='alert alert-danger' style='color:red'>" + errores.get("email") + "</small>"); } %>
                                </div>
                                <div class="row mb-3">
                                    <label for="pais" class="col-form-label col-sm-2">País</label>
                                    <div class="col-sm-4">
                                        <select name="pais" id="pais">
                                            <option value="">-- seleccionar --</option>
                                            <option value="ES">España</option>
                                            <option value="MX">México</option>
                                            <option value="CL" selected>Chile</option>
                                            <option value="AR">Argentina</option>
                                            <option value="PE">Perú</option>
                                            <option value="CO">Colombia</option>
                                            <option value="VE">Venezuela</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="row mb-3">
                                    <label for="lenguajes" class="form-control">Lenguajes de programación</label>
                                    <div class="col-sm-4">
                                        <select name="lenguajes" id="lenguajes" multiple class="form-select">
                                            <option value="java" selected>Java SE</option>
                                            <option value="jakartaee" selected>Jakarta EE9</option>
                                            <option value="spring">Spring Boot</option>
                                            <option value="js">JavaScript</option>
                                            <option value="angular" selected>Angular</option>
                                            <option value="react">React</option>
                                        </select>
                                    </div>
                                </div>

                                <div>
                                    <label class="form-control">Roles</label>
                                    <div>
                                        <input type="checkbox" name="roles" value="ROLE_ADMIN" class="form-check-input">
                                        <label class="form-check-label">Administrador</label>
                                    </div>
                                    <div>
                                        <input type="checkbox" name="roles" value="ROLE_USER" checked class="form-check-input">
                                        <label class="form-check-label">Usuario</label>
                                    </div>
                                    <div>
                                        <input type="checkbox" name="roles" value="ROLE_MODERATOR" class="form-check-input">
                                        <label class="form-check-label">Moderador</label>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label class="form-control">Idiomas</label>
                                    <div class="form-check">
                                        <input type="radio" name="idioma" value="es" checked class="form-check-input">
                                        <label class="form-check-label">Español</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="radio" name="idioma" value="en" class="form-check-input">
                                        <label class="form-check-label">Inglés</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="radio" name="idioma" value="fr" class="form-check-input">
                                        <label class="form-check-label">Frances</label>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="habilitar" class="col-form-label col-sm-2">Habilitar</label>
                                    <div class="form-check">
                                        <input type="checkbox" name="habilitar" id="habilitar" checked class="form-check-input">
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div>
                                        <input type="submit" value="Enviar" class="btn btn-primary">
                                    </div>
                                </div>
                                <input type="hidden" name="secreto" value="12345">
                            </form>
                </body>

                </html>