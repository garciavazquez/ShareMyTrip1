package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.UserDao;
import alb.util.log.Log;

public class ValidarseAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String resultado="EXITO";
		String nombreUsuario=request.getParameter("nombreUsuario");
		String passUsuario=request.getParameter("passUsuario");
		HttpSession session=request.getSession();
		if (session.getAttribute("user")==null) {
			UserDao dao = PersistenceFactory.newUserDao();
			User userByLogin = dao.findByLoginAndPass(nombreUsuario, passUsuario);
			if (userByLogin!=null) {
				session.setAttribute("user", userByLogin);
				int contador=Integer.parseInt((String)request.getServletContext().getAttribute("contador"));
				request.getServletContext().setAttribute("contador", String.valueOf(contador+1));
				Log.info("El usuario [%s] ha iniciado sesión",nombreUsuario);
			}
			else {
				session.invalidate();
				Log.info("El usuario [%s] no está registrado o la contraseña no es correcta",nombreUsuario);
				resultado="FRACASO";
			}
		}
		else
			if (!nombreUsuario.equals(session.getAttribute("user"))) {
				Log.info("Se ha intentado iniciar sesión como [%s] teniendo la sesión iniciada como [%s]",nombreUsuario,((User)session.getAttribute("user")).getLogin());
				session.invalidate();
				resultado="FRACASO";
			}
		return resultado;
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}
	
}
