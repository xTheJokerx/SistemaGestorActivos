<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Administracion de Categorias</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <base href="http://localhost:8080/SistemaGestorActivos/">
        <script src="presentation/js/ajaxCategoria.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@ include file="/presentation/header.jsp" %>
        <br>

        <!-- Modal Ingreso Categoria -->
        <div class="modal" id="ModalInsCat">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">

                    <!-- Header del Modal -->
                    <div class="modal-header">
                        <h4 class="modal-title">Ingresar Categoria</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <!-- Cuerpo del Modal -->
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div class="form-group form-group-sm">
                                <label class="col-sm-2 control-label" for="sm">Codigo</label>
                                <div class="col-sm-8"><input id ="addCodigo" class="form-control" type="text"></div>                     
                                <label class="col-sm-2 control-label" for="sm">Descripcion</label>
                                <div class="col-sm-8"><input id ="addDescripcion" class="form-control" type="text"></div>                     
                            </div>
                        </form>
                    </div>
                    <!-- Footer del Modal -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-success" data-dismiss="modal" onclick="add()">Agregar</button>
                        <button type="button" class="btn btn-warning" data-dismiss="modal">Cancelar</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal Update Categoria  -->
        <div class="modal" id="ModalUpdCat">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Header del Modal -->
                    <div class="modal-header">
                        <h4 class="modal-title">Modificacion de Categoria</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Cuerpo del Modal -->
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div class="form-group form-group-sm">
                                <label class="col-sm-2 control-label" for="sm">Id</label>
                                <div class="col-sm-8"><input id ="updId" class="form-control" type="text" disabled=""></div>   
                                <label class="col-sm-2 control-label" for="sm">Codigo</label>
                                <div class="col-sm-8"><input id ="updCodigo" class="form-control" type="text"></div>                     
                                <label class="col-sm-2 control-label" for="sm">Descripcion</label>
                                <div class="col-sm-8"><input id ="updDescripcion" class="form-control" type="text"></div>
                                <label class="col-sm-2 control-label" for="sm">Consecutivo</label>
                                <div class="col-sm-8"><input id ="updConsecutivo" class="form-control" type="text" disabled=""></div>   
                            </div>
                        </form>
                    </div>

                    <!-- Footer del Modal -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-success" data-dismiss="modal" onclick="update()">Guardar</button>
                        <button type="button" class="btn btn-warning" data-dismiss="modal">Cancelar</button>
                    </div>

                </div>
            </div>
        </div>

        <div class="container">
            <h1 style="text-align: center">Listado de Categorias</h1>
            <br>
            <div class="row justify-content-center">
                <div class="col-12 col-md-10 col-lg-8">
                    <div class="card card-sm">
                        <div class="card-body row no-gutters align-items-center">
                            <div class="col">
                                <input id ="filtrado" name="filtrado" class="form-control form-control-lg form-control-borderless" type="search" placeholder="Descripcion">
                            </div>
                            <!--end of col-->
                            &nbsp;&nbsp;&nbsp;
                            <div class="col-auto">
                                <button type="button" class="btn btn-info" onclick="buscar()">Buscar</button>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#ModalInsCat">Agregar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="ventanaSolicitud">
            <br>
            <table class="table table-bordered table-striped mb-0">
                <thead>
                    <tr> <th>Id</th>
                        <th>Codigo</th>
                        <th>Descripcion</th>
                        <th>Consecutivo</th>
                        <th>Modificar</th>
                        <th>Eliminar</th>
                    </tr>
                </thead>
                <tbody id="listadoCategorias"></tbody>
            </table>
            <br>
        </div>
        <%@ include file="/presentation/footer.jsp" %>

        <script>
            function loaded(event) {
                //Posibles eventos en botones
                //document.getElementById("agregar").addEventListener("click", add);
                //document.getElementById("buscar").addEventListener("click", buscar);

                // se envia  al servidor
                //ajax({type: "GET", url: "api/categorias?descripcion=" + ""})
                //.then(function (personas) {
                //list(personas);
                //},
                //function (status) {
                //alert(errorMessage(status));
                //});
            }

            function focus(event) {
                event.target.classList.add("focus");
            }
            function blur(event) {
                event.target.classList.remove("focus");
            }

            function list(categorias) {
                var listado = document.getElementById("listadoCategorias");
                listado.innerHTML = "";
                categorias.forEach((c) => {row(listado, c); });
            }

            function row(listado, categoria) {
                var tr = document.createElement("tr");
                tr.innerHTML = "<td>" + categoria.id + "</td>" +
                        "<td>" + categoria.codigo + "</td>" +
                        "<td>" + categoria.descripcion + "</td>" +
                        "<td>" + categoria.consecutivo + "</td>" +
                        "<td><button type=button class=\"btn btn-success\" data-toggle=modal data-target=#ModalUpdCat onclick='edit(\"" + categoria.id + "\");'>Modificar</button></td>" +
                        "<td><button type=button class=\"btn btn-danger\" onclick='del(\"" + categoria.id + "\");'>Eliminar</button></td>";
                listado.appendChild(tr);
            }

            function buscar() {
                var descrip = document.getElementById("filtrado").value;
                ajax({type: "GET", url: "api/categorias?descripcion=" + descrip})
                        .then(function (personas) {
                            list(personas);
                        },
                                function (status) {
                                    alert(errorMessage(status));
                                });
            }
            function buscarTodos() {
                var descrip = "";
                ajax({type: "GET", url: "api/categorias?descripcion=" + descrip})
                    .then(function (personas) {list(personas);},
                          function (status) {alert(errorMessage(status));});
            }
            function cleanAdd(){
                document.getElementById("addCodigo").value="";
                document.getElementById("addDescripcion").value="";
            }
            function add() {
                cat = { codigo: document.getElementById("addCodigo").value,
                        descripcion: document.getElementById("addDescripcion").value
                      };
                    // se envia  al servidor
                    ajax({type: "POST", url: "api/categorias", data: JSON.stringify(cat), contentType: "application/json"})
                    .then(function () {
                        var descrip = "";
                        ajax({type: "GET", url: "api/categorias?descripcion=" + descrip})
                            .then(function (personas) {list(personas);},
                                  function (status) {alert(errorMessage(status));})})
                    .then(cleanAdd());
            }
            function edit(id) {
            // lo trae del servidor
            ajax({type: "GET",url: "api/categorias/" + id})
                    .then(function (categoria) {show(categoria);},
                          function (status) { alert(errorMessage(status));
                         });
            }
            function show(cat) {
                document.getElementById("updId").value = cat.id;
                document.getElementById("updCodigo").value = cat.codigo;
                document.getElementById("updDescripcion").value = cat.descripcion;
                document.getElementById("updConsecutivo").value = cat.consecutivo;
            }
            function update(){
                cat = { id:             document.getElementById("updId").value,
                        codigo:         document.getElementById("updCodigo").value,
                        descripcion:    document.getElementById("updDescripcion").value,
                        consecutivo:    document.getElementById("updConsecutivo").value
                      };
                       // se envia  al servidor
                ajax({type: "PUT", url: "api/categorias", data: JSON.stringify(cat), contentType: "application/json"})
                .then(function () {
                    var descrip = "";
                    ajax({type: "GET", url: "api/categorias?descripcion=" + descrip})
                    .then(function (personas) {list(personas);},
                          function (status) {alert(errorMessage(status));});
                    });
            }
            function del(id) {
                ajax({type: "DELETE",url: "api/categorias/" + id})
                    .then(function () {
                        var descrip = "";
                        ajax({type: "GET", url: "api/categorias?descripcion=" + descrip})
                            .then(function (personas) {list(personas);},
                                  function (status) {alert(errorMessage(status));})},
                              function (status) {alert(errorMessage(status));});
            }
            document.addEventListener("DOMContentLoaded", loaded);
        </script>
    </body>
</html>