<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="AutServlet">Cerrar Siesión</a>
        
        <div class="container">
            <div class="row">
                <div class="col-sm-8"> 
                    <div class="col-sm-2">
                        Nombre:                        
                    </div>
                    <div class="col-sm-2">
                        ${nombre}
                    </div>
                    <div class="col-sm-2">
                        Email:                        
                    </div>
                    <div class="col-sm-2">
                        ${email}
                    </div>
                </div>
            </div>
        </div>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

    </body>
</html>