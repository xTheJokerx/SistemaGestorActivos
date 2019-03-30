<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="SistemaGestorActivos.Logic.Funcionario"%>
<%@page import="SistemaGestorActivos.Logic.Model"%>
<%@page import="SistemaGestorActivos.Logic.Usuario"%>
<% Usuario logged = (Usuario) session.getAttribute("logged");%>
<!DOCTYPE html>

<head>
    <title>Encabezado</title>
    <base href="http://localhost:8080/SistemaGestorActivos/">
    <link href="css/Estilos.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
        <img id="engranaje" src="images/engranajes.jpg" alt="engranajes"> &nbsp;&nbsp;&nbsp;&nbsp;
        <p class="navbar-brand">Activos</p>
        <div class="container">
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">

                    <% if (logged != null) { %>

                    <% if (session.getAttribute("rolActual").equals("Admin") || session.getAttribute("rolActual").equals("SOCCB")
                                || session.getAttribute("rolActual").equals("JOCCB") || session.getAttribute("rolActual").equals("Registrador")
                                || session.getAttribute("rolActual").equals("JefeRH")) { %>         
                    <li class="nav-item"><a class="nav-link" href="presentation/users/Lobby">Principal</a> </li>
                    <% }%> 

                    <% if (session.getAttribute("rolActual").equals("Admin")) { %>        
                    <li class="nav-item dropdown"> 
                        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Administrador
                        </a>  
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="presentation/users/Admin/Lista">Mostrar Solicitudes</a>
                            <a class="dropdown-item" href="presentation/users/Admin/nuevaSolicitud">Realizar Solicitud</a>
                        </div>
                    </li>

                    <% }%>         

                    <li class="nav-item dropdown"> 
                        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <%=session.getAttribute("funcActual")%>
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="presentation/logout">Cerrar sesión</a>
                        </div>           
                    </li>
                    <% }%> 

                    <% if (logged == null) { %>
                    <li class="nav-item">
                        <a class="nav-link" href="presentation/index.jsp">Acerca de</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="presentation/prepareLogin">Iniciar Sesion</a>
                    </li>
                    <% }%>    

                </ul>

            </div>
        </div>
    </nav>
</body>
</html>
