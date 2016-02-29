package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.UserDao;
import alb.util.log.Log;

public class ModificarDatosAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String resultado="EXITO";
		
		String nuevoNombre=request.getParameter("nombre");
		String nuevoApellido=request.getParameter("apellidos");
		String nuevoEmail=request.getParameter("email");
		
		HttpSession session=request.getSession();
		User usuario=((User)session.getAttribute("user"));
		
		
		//Modificación de los datos personales del usuario.
		if(nuevoNombre != null)
			usuario.setName(nuevoNombre);
		
		if(nuevoApellido != null)
			usuario.setSurname(nuevoApellido);
		
		if(nuevoEmail != null)
			usuario.setEmail(nuevoEmail);
		
		//Moficiación de la contraseña del usuario
		String contrasenaActual=request.getParameter("contrasenaActual");
		String contrasenaNueva=request.getParameter("contrasenaNueva");
		String contrasenaRepeNueva=request.getParameter("contrasenaRepeNueva");
		
		if(contrasenaActual.isEmpty() || contrasenaNueva.isEmpty() ||contrasenaRepeNueva.isEmpty()){
			Log.info("Se han de cubrir los tres campos para poder proceder a modificar la contraseña.");
			resultado="FRACASO";
		}
		else if(!usuario.getPassword().equals(contrasenaActual)){
			Log.info("La contraseña actual introducida es incorrecta.");
			resultado="FRACASO";
		}
		else if(!contrasenaNueva.equals(contrasenaRepeNueva)){
			Log.info("Las contraseñas introducidas no coinciden. Por favor, inténtalo de nuevo.");
			resultado="FRACASO";
		}
		else
			usuario.setPassword(contrasenaNueva);
		
		
		try {
			
			if(resultado=="EXITO"){
				UserDao dao = PersistenceFactory.newUserDao();
				dao.update(usuario);
			
				if(nuevoNombre != null)
					Log.debug("Modificado campo Nombre de [%s] con el valor [%s]", usuario.getLogin(), nuevoNombre);
				if(nuevoApellido != null)
					Log.debug("Modificado campo Apellidos de [%s] con el valor [%s]", usuario.getLogin(), nuevoApellido);
				if(nuevoEmail != null)
					Log.debug("Modificado campo Email de [%s] con el valor [%s]", usuario.getLogin(), nuevoEmail);
				if(contrasenaActual != null && contrasenaNueva != null && contrasenaRepeNueva != null)
					Log.debug("Modificado campo contraseña de [%s] con el valor [%s]", usuario.getLogin(), contrasenaNueva);
			}
		}
		catch (Exception e) {
			Log.error("Algo ha ocurrido actualizando el nombre de [%s]", usuario.getLogin());
			Log.error("Algo ha ocurrido actualizando los apellidos de [%s]", usuario.getLogin());
			Log.error("Algo ha ocurrido actualizando el email de [%s]", usuario.getLogin());
			Log.error("Algo ha ocurrido actualizando la contraseña de [%s]", usuario.getLogin());
		}
		
		return resultado;
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}
	
}
