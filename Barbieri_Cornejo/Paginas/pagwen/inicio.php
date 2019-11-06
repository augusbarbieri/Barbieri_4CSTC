<?php 
	session_start();

	if(isset($_SESSION['user'])){
 ?>

 <!DOCTYPE html>
<html>
<head>
	<title>Inicio</title>
	<?php require_once "scripts.php"; ?>
</head>
<body>
<br><br><br>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				
					<h2>Entraste con exito</h2>
				<a href="php/salir.php" class="btn btn-info">Salir del sistema</a>
				<a href="html/index.html" class="btn btn-info">Ir a la pagina principal</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

<?php
} else {
	header("location:index.php");
	}
 ?>
