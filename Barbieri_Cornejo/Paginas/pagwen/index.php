<!DOCTYPE html>
<html>
<head>
  <title>Login</title>

  <?php require_once "scripts.php"; ?>
</head>

<body style="background-color: white">


<nav class="navbar navbar-inverse">
          <div class="container-fluid">
            <div class="navbar-header">
              <a class="navbar-brand" href="html/practica_para_html.html">Meta Gaming</a>
            </div>
            <ul class="nav navbar-nav navbar-right hidden-xs">
              <li class=""><a href="home.html">Home</a></li>
              <li><a href="productos.html">Productos</a></li>
              <li><a href="armar.html">Armar</a></li>
              <li><a href="contacto.html">Contacto</a></li>
              <li><a href="registro.php"><span class="glyphicon glyphicon-user"></span> Registrarse</a></li>
              <li><a href="inicio.php"><span class="glyphicon glyphicon-log-in"></span> Ingresar</a></li>
              <li><a href="inicio.php"><span class=""></span> Cerrar Sesion</a></li>
              <li>
                <a href=""></a>
             </li>
            </ul>
          </div>
        </nav>

<br>

<br>
<div>
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-4">
			<div class="panel panel-danger">
				<div class="panel panel-heading">Inicio de sesion</div>
				<div class="panel panel-body">
					<form id="frmRegistro">
                        <div class="row">
                            

</div>
          <p></p>
          <label>Usuario</label>
          <input type="text" id="usuario" class="form-control input-sm" name="">
          <label>Password</label>
          <input type="password" id="password" class="form-control input-sm" name="">
          <p></p>
          <span class="btn btn-primary" id="entrarSistema">Entrar</span>
          <a href="registro.php" class="btn btn-danger">Registro</a>
        </div>
      </div>
    </div>
    <div class="col-sm-4"></div>
  </div>
</div>
</body>
</html>

<script type="text/javascript">
  $(document).ready(function(){
    $('#entrarSistema').click(function(){
      if($('#usuario').val()==""){
        alertify.alert("Debes agregar el usuario");
        return false;
      }else if($('#password').val()==""){
        alertify.alert("Debes agregar el password");
        return false;
      }

      cadena="usuario=" + $('#usuario').val() + 
          "&password=" + $('#password').val();

          $.ajax({
            type:"POST",
            url:"php/login.php",
            data:cadena,
            success:function(r){
              if(r==1){
                window.location="inicio.php";
              }else{
                alertify.alert("Fallo al entrar :(");
              }
            }
          });
    }); 
  });
</script>