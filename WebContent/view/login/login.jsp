<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>e-Library | Login</title>
</head>
<body>

	<link rel="stylesheet" href="css/bootstrap.css">
	<script src="js/bootstrap.min.js"></script>

	<div class="container">
		<h2>Usuarios___</h2>
		<form action="login" method="get" id="loginForm"
			role="form">
			<input type="hidden" id="buscarAction" name="buscarAction"
				value="buscarPorNombre">
			<div class="form-group col-xs-5">
				<output>Usuario</output>
				<input type="text" name="usuarioTXT" id="usuarioTXT"
					class="form-control" required="true"
					placeholder="Escriba su usuario" />
			</div>
			<div class="form-group col-xs-5">
				<output>Contrase&ntilde;a</output>
				<input type="password" name="passwordTXT" id="passwordTXT"
					class="form-control" required="true"
					placeholder="Escriba su contrase&ntilde;a" />
			</div>
			<div class="form-group col-xs-5">
				<br>
				<button type="submit" class="btn btn-info">
					<span class="glyphicon glyphicon-search"></span> Autenticarse
				</button>
			</div>
			
		</form>
	</div>

</body>
</html>
