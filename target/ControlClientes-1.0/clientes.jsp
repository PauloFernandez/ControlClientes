<!DOCTYPE html>
<html>
    <head>
        <!-- Inicio linck para Bootstrap -->
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- FIN lincks para Bootstrap CSS -->

        <!-- Inicio links para iconos de Font Awesome -->
        <!-- estos links hacen referencia a los archivos descargados en nuesto proyectos para poder acceder a los inconos de Font Awesome -->
        <!-- Cualquier duda o consulta ver el siguiente video: https://www.youtube.com/watch?v=vH2eTesQ57c&list=PL3b9xmg86NTLHvul_VxsDda31xH6u8OdI&index=18 -->
        <script type="text/javascript" src="recursos/jquery.min.js"></script>
        <script type="text/javascript" src="recursos/icons.js"></script>
        <!-- FIN links para iconos de Font Awesome -->

        <title>Control de Clientes</title>
    </head>
    <body>
        <!-- CABECERO -->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp" />

        <!-- Botones de navegador -->
        <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacion.jsp" />

        <!-- Listado Clientes -->
        <jsp:include page="/WEB-INF/paginas/cliente/listadoClientes.jsp" />
        
        <!-- Pie de Pagina -->
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp" />
        
        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

        <!-- Option 2: Separate Popper and Bootstrap JS -->
        <!--
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
        -->
    </body>
</html>
