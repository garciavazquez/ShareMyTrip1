<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="comprobarNavegacion.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Página principal del usuario</title>
</head>
<body>
	<jsp:useBean id="user" class="uo.sdi.model.User" scope="session" />
	<center><h1>Perfil de <jsp:getProperty property="name" name="user" /></h1></center>
	<hr>
	
	<table align="center">
		<tr>
			<td>Login:</td><td id="login"><jsp:getProperty property="login" name="user" /></td>
		</tr>
		<tr>
			<td>Nombre:</td>
			<td id="nombre"><form action="modificarDatos" method="POST">
					<input type="text" name="nombre" size="15"
						value="<jsp:getProperty property="name" name="user"/>"> 
					<input type="submit" value="Modificar">
				</form>
			</td>
		</tr>
		<tr>
			<td>Apellidos:</td>
			<td id="apellidos"><form action="modificarDatos" method="POST">
					<input type="text" name="apellidos" size="15"
						value="<jsp:getProperty property="surname" name="user"/>"> 
					<input type="submit" value="Modificar">
				</form>
			</td>
		</tr>
		<tr>
			<td>Email:</td>
			<td id="email"><form action="modificarDatos" method="POST">
					<input type="text" name="email" size="15"
						value="<jsp:getProperty property="email" name="user"/>"> 
					<input type="submit" value="Modificar">
				</form>
			</td>
		</tr>
	</table>
	<br>
	<center>
	<h4>¿Quieres cambiar la contraseña de tu cuenta?</h4>
	<form action="modificarDatos" method="post">
 	Introduce primero la contraseña actual y a continuación introduce la nueva dos veces.
 	<br><br><br>
 	<table align="center">
    	<tr> 
    		<td align="right">Contraseña actual del usuario:</td>
	    	<td><input type="password" name="contrasenaActual" align="left" size="15"></td>
      	</tr>
      	<tr> 
    		<td align="right">Contraseña nueva:</td>
	    	<td><input type="password" name="contrasenaNueva" align="left" size="15"></td>
      	</tr>
      	<tr> 
    		<td align="right">Repite la contraseña nueva:</td>
	    	<td><input type="password" name="contrasenaRepeNueva" align="left" size="15"></td>
      	</tr>
      </table>
      
      <input type="submit" value="Modificar contraseña"/>
   </form>
   <br/>
   <center><h3>Mis viajes</h3></center>
	<hr>
	Haz clic en Lista de viajes para ver un listado de los viajes disponibles y sus datos más característicos.
	<br/>
	Haz clic en Registrar viaje para poder promocionar un viaje y permitir a otros usuarios apuntarse al mismo.
	<br/><br/>
   <a id="listarViajesUserRegistrado" href="listarViajesUserRegistrado">Lista de viajes</a>
   <br/><br/>  
   <form action="registrarViaje" method="post">
   		<input type="submit" value="Registrar viaje"/>
   </form>
	</center>
	<br/><br/><br/><br/>
	Es Vd el usuario número: ${contador}
</body>
</html>
