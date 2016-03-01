package uo.sdi.acciones;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uo.sdi.model.Application;
import uo.sdi.model.Trip;
import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import alb.util.log.Log;

public class SolicitarPlazaAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		Long idViaje;
		User user;
		ServletContext servletContext= request.getServletContext();
		synchronized(servletContext) {
			idViaje = (Long) (servletContext.getAttribute("idViaje"));
		}		
		
		HttpSession session = request.getSession();
		
		user = (User) session.getAttribute("user");
		
		try {
			PersistenceFactory.newApplicationDao().save(new Application(user.getId(), idViaje));
			Log.debug("Solicitada plaza en el viaje");
		}
		catch (Exception e) {
			Log.error("Algo ha ocurrido solicitando plaza en el viaje");
		}
		return "EXITO";
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}
	
}
