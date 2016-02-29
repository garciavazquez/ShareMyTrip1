package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.model.User;
import uo.sdi.model.UserStatus;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.UserDao;
import alb.util.log.Log;

public class RegistroAction implements Accion{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String resultado="EXITO";
		
		//Recuperación de datos introducidos en el formulario y comprobaciones pertinentes.
		String identificadorUsuario=request.getParameter("identificadorUsuario");
		User busquedaUsuarioIdent = PersistenceFactory.newUserDao().findByLogin(identificadorUsuario);
		
		if(identificadorUsuario.isEmpty()){
			Log.info("El campo correspondiente al identificador de usuario está vacío. Por favor, introduce tu identificador personal.");
			resultado="FRACASO";
		}
		else if(busquedaUsuarioIdent != null){
			Log.info("El identificador " + identificadorUsuario + " ya existe.");
			resultado="FRACASO";
		}
		
		String nombreRegUsuario=request.getParameter("nombreRegUsuario");
		String apellidosUsuario=request.getParameter("apellidosUsuario");
		if (nombreRegUsuario.isEmpty() || apellidosUsuario.isEmpty()){
			Log.info("Se necesita el nombre completo. Por favor cubre los campos con tu nombre y tus apellidos.");
			resultado="FRACASO";
		}
		
		String emailUsuario=request.getParameter("emailUsuario");
		if (emailUsuario.isEmpty()){
			Log.info("El campo correspondiente al email está vacío. Por favor, introduce tu email.");
			resultado="FRACASO";
		}
		
		String contrasenaUsuario=request.getParameter("contrasenaUsuario");
		String contrasenaRepeUsuario=request.getParameter("contrasenaRepeUsuario");
		
		if(!contrasenaUsuario.equals(contrasenaRepeUsuario)){
			Log.info("Las contraseñas introducidas no coinciden. Por favor, inténtalo de nuevo.");
			resultado="FRACASO";
		}
		else if(contrasenaUsuario.isEmpty() || contrasenaRepeUsuario.isEmpty()){
			Log.info("El campo correspondiente a la contraseña está vacío. Por favor, introduce la contraseña de tu cuenta.");
			resultado="FRACASO";
		}
		
		//Si no hay ningún error en la fase de introducción de datos se procede a registrar al usuario.
		if(resultado=="EXITO"){
			User nuevoUsuario = new User();
			
			nuevoUsuario.setLogin(identificadorUsuario);
			nuevoUsuario.setName(nombreRegUsuario);
			nuevoUsuario.setSurname(apellidosUsuario);
			nuevoUsuario.setEmail(emailUsuario);
			nuevoUsuario.setPassword(contrasenaUsuario);
			nuevoUsuario.setStatus(UserStatus.ACTIVE);
			
			UserDao udao = PersistenceFactory.newUserDao();
			udao.save(nuevoUsuario);
		}
		else{
			Log.debug("Ha ocurrido algún error durante la fase de registro de usuario.");
		}
		
		return resultado;
	}
	
}
