<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html><head> <title>ShareMyTrip - Inicie sesión</title>
<body>
  <form action="validarse" method="post">

 	<center><h1>Inicia sesión</h1></center>
 	<hr><br>
 	<table align="center">
    	<tr> 
    		<td align="right">Identificador de usuario</td>
	    	<td><input type="text" name="nombreUsuario" align="left" size="15"></td>
      	</tr>
      	<tr>
	    	<td align="right">Contraseña</td>
	    	<td><input type="password" name="passUsuario" align="left" size="15"></td>
      	</tr>
      	<tr>
    	    <td><input type="submit" value="Enviar"/></td>
      	</tr>
      </table>
   </form>
   <a id="listarViajes" href="listarViajes">Lista de viajes</a>
   
   <br>
   <form action="registrarse" method="post">

 	<center><h2>¡Regístrate ahora!</h2></center>
 	<hr><br>
 	<center><h4>¿Eres nuevo y te interesa alguno de los viajes? Rellena el siguiente
 	formulario y pasa a ser miembro de nuestra comunidad.</h4></center>
 	<br>
 	<table align="center">
    	<tr> 
    		<td align="right">Identificador de usuario</td>
	    	<td><input type="text" name="identificadorUsuario" align="left" size="15"></td>
      	</tr>
      	<tr> 
    		<td align="right">Nombre</td>
	    	<td><input type="text" name="nombreRegUsuario" align="left" size="15"></td>
      	</tr>
      	<tr> 
    		<td align="right">Apellidos</td>
	    	<td><input type="text" name="apellidosUsuario" align="left" size="15"></td>
      	</tr>
      	<tr> 
    		<td align="right">Email</td>
	    	<td><input type="text" name="emailUsuario" align="left" size="15"></td>
      	</tr>
      	<tr> 
    		<td align="right">Contraseña</td>
	    	<td><input type="password" name="contrasenaUsuario" align="left" size="15"></td>
      	</tr>
      	<tr> 
    		<td align="right">Repite la contraseña</td>
	    	<td><input type="password" name="contrasenaRepeUsuario" align="left" size="15"></td>
      	</tr>
      	
      	<tr>
    	    <td><input type="submit" value="Enviar"/></td>
      	</tr>
      </table>
   </form>
</body>
</html>