<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-lg-3">

            <#-- Side bar-->
            <#include "shared/sidebar.ftl">

        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">
            <div class="row">
                <div class="container">
                    <div id="carouselExampleIndicators" class="carousel slide span12" data-ride="carousel">
                        <div class="row">
                            <ol class="carousel-indicators">
                                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active" ></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                            </ol>
                        </div>
                        <div class="row">
                            <div class="carousel-inner" role="listbox">
                                <div class="carousel-item active">
                                    <a href="${context}/show/6/product">
                                        <img class="d-block img-fluid" src="${context}/assets/images/Pizza Hawaiian.jpg" alt="First slide">
                                    </a>
                                </div>

                                <div class="carousel-item">
                                    <a href="${context}/show/12/product">
                                        <img class="d-block img-fluid" src="${context}/assets/images/Pizza Carbonara.jpg" alt="Second slide">
                                    </a>
                                </div>
                                <div class="carousel-item">
                                    <a href="${context}/show/8/product">
                                        <img class="d-block img-fluid" src="${context}/assets/images/Pizza Margherita.jpg" alt="Third slide">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>

        </div>
        <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

</div>