<!DOCTYPE html>
<html>
<head>
	<title>Registro</title>
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
<div>
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-4">
			<div class="panel panel-danger">
				<div class="panel panel-heading">Registro de usuario</div>
				<div class="panel panel-body">
					<form id="frmRegistro">
                        <div class="row">
                            <div class="col-md-6 mb-3">
						        <label>Nombre</label>
					            <input type="text" class="form-control input-sm" id="nombre" name="">
                            </div>

                            <div class="col-md-6 mb-3">
                                <label>Apellido</label>
                                <input type="text" class="form-control input-sm" id="apellido" name="">
                            </div>
                        <div>

					<label>Usuario</label>
					<input type="text" class="form-control input-sm" id="usuario" name="">
                    <label>DNI</label>
					<input type="int" class="form-control input-sm" id="dni" name="">
                    <label>Direccion</label>
					<input type="text" class="form-control input-sm" id="direccion" name="">
					<label>Password</label>
					<input type="text" class="form-control input-sm" id="password" name="">
					<p></p>
					<span class="btn btn-primary" id="registrarNuevo">Registrar</span>
					</form>
					<div style="text-align: right;">
						<a href="index.php" class="btn btn-default">Login</a>
					</div>
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
		$('#registrarNuevo').click(function(){

			if($('#nombre').val()==""){
				alertify.alert("Debes agregar el nombre");
				return false;
			}else if($('#apellido').val()==""){
				alertify.alert("Debes agregar el apellido");
				return false;
			}else if($('#usuario').val()==""){
				alertify.alert("Debes agregar el usuario");
				return false;
			}else if($('#dni').val()==""){
				alertify.alert("Debes agregar el dni");
				return false;
			}else if($('#direccion').val()==""){
				alertify.alert("Debes agregar la direccion");
				return false;
			}else if($('#password').val()==""){
				alertify.alert("Debes agregar la password");
				return false;
			}

			cadena="nombre=" + $('#nombre').val() +
					"&apellido=" + $('#apellido').val() +
					"&usuario=" + $('#usuario').val() + 
					"&dni=" + $('#dni').val()+
                    "&direccion=" + $('#direccion').val()+
                    "&password=" + $('#password').val();

					$.ajax({
						type:"POST",
						url:"php/registro.php",
						data:cadena,
						success:function(r){

							if(r==2){
								alertify.alert("Este usuario ya existe, prueba con otro :)");
							}
							else if(r==1){
								$('#frmRegistro')[0].reset();
								alertify.success("Agregado con exito");
							}else{
								alertify.error("Fallo al agregar");
							}
						}
					});
		});
	});
</script>

