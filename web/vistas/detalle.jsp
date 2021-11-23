<%@page import="pe.gob.mincetur.webdestinosturisticos.Beans.DestinoDetalle"%>
<%@page import="java.util.List"%>
<%@page import="pe.gob.mincetur.webdestinosturisticos.Beans.DestinoFoto"%>
<%@page import="pe.gob.mincetur.webdestinosturisticos.Beans.Detalle"%>
<%@ page import="pe.gob.mincetur.webdestinosturisticos.Beans.Destino" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <style>
            /* Make the image fully responsive */
            .carousel-inner img {
                width: 100%;
                height: 100%;
            }
        </style>
        <link rel="icon" href="static/images/favicon-portal.ico">
        <title>Destinos Tur&iacute;sticos</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <img src="static/images/logo.png" alt="logo" class="logo">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}">Inicio</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}/destino">Destinos <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/search">B&uacute;squeda</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/hello">Hello</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="container" style="margin-top: 30px">
            <%
                if (request.getAttribute("detalle") != null) {
                    Detalle d = (Detalle) request.getAttribute("detalle");
            %>
            <div class="row">
                <div class="col-md">
                    <div id="demo" class="carousel slide" data-ride="carousel">

                        <!-- Indicators -->
                        <ul class="carousel-indicators">
                            <%
                                List<DestinoFoto> imagenes = d.getImagenes();
                                for (int i = 0; i < imagenes.size(); i++) {
                            %>
                            <li data-target="#demo" data-slide-to="<%=i%>" <%if (i == 0) {%>class="active"<%}%>></li>
                                <%
                                    }
                                %>
                        </ul>

                        <!-- The slideshow -->
                        <div class="carousel-inner">
                            <%
                                for (int i = 0; i < imagenes.size(); i++) {
                            %>
                            <div class="carousel-item <%if (i == 0) {%>active<%}%>">
                                <img src="<%=imagenes.get(i).getRutaImagen()%>" alt="<%=d.getNombre()%>">
                            </div>
                            <%
                                }
                            %>
                        </div>

                        <!-- Left and right controls -->
                        <a class="carousel-control-prev" href="#demo" data-slide="prev">
                            <span class="carousel-control-prev-icon"></span>
                        </a>
                        <a class="carousel-control-next" href="#demo" data-slide="next">
                            <span class="carousel-control-next-icon"></span>
                        </a>

                    </div>

                </div>
                <div class="col-md">
                    <div>
                        <h5 class="card-title"><%=d.getNombre()%></h5>
                        <p class="card-text"><%=d.getDescripcion()%></p>
                        <button type="button" class="btn btn-success">Compartir por correo</button>
                        <button type="button" class="btn btn-info">Descargar PDF</button>
                    </div>
                    <div>
                        <hr>
                        <h6 class="card-title">Servicios</h6>
                        <%
                            List<DestinoDetalle> servicios = d.getServicios();
                            for (int i = 0; i < servicios.size(); i++) {
                        %>
                        <div>
                            <h6><%=servicios.get(i).getNombre()%></h6>
                            <p><%=servicios.get(i).getDescripcion()%></p>
                        </div>
                        <%
                            }
                        %>
                    </div>
                </div>
            </div>
            <%
                }
            %>
        </div>
        <footer class="text-center text-lg-start bg-light text-muted">
            <!-- Section: Social media -->
            <section
                class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom"
                >
                <!-- Left -->
                <div class="me-5 d-none d-lg-block">
                    <span>Con&eacute;ctate a nuestras redes sociales:</span>
                </div>
                <!-- Left -->

                <!-- Right -->
                <div>
                    <a href="" class="me-4 text-reset">
                        <i class="fab fa-facebook-f"></i>
                    </a>
                    <a href="" class="me-4 text-reset">
                        <i class="fab fa-twitter"></i>
                    </a>
                    <a href="" class="me-4 text-reset">
                        <i class="fab fa-google"></i>
                    </a>
                    <a href="" class="me-4 text-reset">
                        <i class="fab fa-instagram"></i>
                    </a>
                    <a href="" class="me-4 text-reset">
                        <i class="fab fa-linkedin"></i>
                    </a>
                    <a href="" class="me-4 text-reset">
                        <i class="fab fa-github"></i>
                    </a>
                </div>
                <!-- Right -->
            </section>
            <!-- Section: Social media -->

            <!-- Section: Links  -->
            <section class="">
                <div class="container text-center text-md-start mt-5">
                    <!-- Grid row -->
                    <div class="row mt-3">
                        <!-- Grid column -->
                        <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                            <!-- Content -->
                            <img src="static/images/logo2.png" alt="logo2" class="logo2">
                            <p>
                                ¡A recorrer el Per&uacute;! Descubre todo lo que puedes
                                conocer en cada una de las regiones.
                            </p>
                        </div>
                        <!-- Grid column -->

                        <!-- Grid column -->
                        <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                            <!-- Links -->
                            <h6 class="text-uppercase fw-bold mb-4">
                                Destinos
                            </h6>
                            <p>
                                <a href="#!" class="text-reset">Macchupicchu</a>
                            </p>
                            <p>
                                <a href="#!" class="text-reset">Mancora</a>
                            </p>
                            <p>
                                <a href="#!" class="text-reset">Huascar&aacute;n</a>
                            </p>
                            <p>
                                <a href="#!" class="text-reset">Lago Titicaca</a>
                            </p>
                        </div>
                        <!-- Grid column -->

                        <!-- Grid column -->
                        <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                            <!-- Links -->
                            <h6 class="text-uppercase fw-bold mb-4">
                                Departamentos
                            </h6>
                            <p>
                                <a href="#!" class="text-reset">Cusco</a>
                            </p>
                            <p>
                                <a href="#!" class="text-reset">Piura</a>
                            </p>
                            <p>
                                <a href="#!" class="text-reset">Huaraz</a>
                            </p>
                            <p>
                                <a href="#!" class="text-reset">Puno</a>
                            </p>
                        </div>
                        <!-- Grid column -->

                        <!-- Grid column -->
                        <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                            <!-- Links -->
                            <h6 class="text-uppercase fw-bold mb-4">
                                Cont&aacute;ctenos
                            </h6>
                            <p><i class="fas fa-home me-3"></i> Lima, San Isidro, Per&uacute;</p>
                            <p>
                                <i class="fas fa-envelope me-3"></i>
                                info@mincetur.gob.pe
                            </p>
                            <p><i class="fas fa-phone me-3"></i> + 01 513 6100</p>
                        </div>
                        <!-- Grid column -->
                    </div>
                    <!-- Grid row -->
                </div>
            </section>
            <!-- Section: Links  -->

            <!-- Copyright -->
            <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
                © 2021 Copyright:
                <a class="text-reset fw-bold" target="_blank" href="https://www.mincetur.gob.pe/">mincetur.gob.pe</a>
            </div>
            <!-- Copyright -->
        </footer>

    </body>
</html>