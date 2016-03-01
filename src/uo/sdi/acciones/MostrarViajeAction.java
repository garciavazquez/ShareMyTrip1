package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.model.Trip;
import uo.sdi.persistence.PersistenceFactory;
import alb.util.log.Log;

public class MostrarViajeAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		Trip viaje;
		
		Long idViaje = Long.parseLong(request.getParameter("id"));
		request.getServletContext().setAttribute("idViaje",idViaje);
		
		try {
			viaje=PersistenceFactory.newTripDao().findById(idViaje);
			request.setAttribute("viaje", viaje);
			Log.debug("Obtenido viaje para mostrar sus detalles");
		}
		catch (Exception e) {
			Log.error("Algo ha ocurrido obteniendo los detalles del viaje");
		}
		return "EXITO";
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}
	
}
