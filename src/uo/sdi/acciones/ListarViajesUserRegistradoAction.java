package uo.sdi.acciones;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uo.sdi.model.Application;
import uo.sdi.model.Trip;
import uo.sdi.model.User;
import uo.sdi.persistence.ApplicationDao;
import uo.sdi.persistence.PersistenceFactory;
import alb.util.log.Log;

public class ListarViajesUserRegistradoAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		List<Trip> viajes = new ArrayList<>();
		List<Application> aplications = new ArrayList<>();
		
		HttpSession session = request.getSession();
		
		try {
			
			viajes = PersistenceFactory.newTripDao().findAll();
			
			List<Trip> viajesFiltrados = new ArrayList<>();
			
			//Sacar con session el usuario y luego el atributo id
			User usuario = (User) session.getAttribute("user");
			Long idUsuarioActual = usuario.getId();	
			
			aplications = PersistenceFactory.newApplicationDao().findAll();
			
			List<Application> aplicationsFiltrados = new ArrayList<>();
			
			//Se añadirán a la lista los viajes...
			
			for (Trip trip : viajes) {
				//si el ID del promotor es igual del usuario actual.
				if(trip.getPromoterId() == idUsuarioActual)
					viajesFiltrados.add(trip);
			}
				
//			Long idViaje;
//			for (Application app : aplications){
//				//si el usuario actual ha solicitado plaza. (Tabla Seats)
//				if(app.getUserId() == idUsuarioActual){
//					idViaje = app.getTripId();
//					Trip viaje = PersistenceFactory.newTripDao().findById(idViaje);
//					viajesFiltrados.add(viaje);
//				}
//			}
			
			//si el usuario actual ha recibido confirmación o denegación de la plaza. (Tabla Seats)

			request.setAttribute("listaViajes", viajes);
			Log.debug("Obtenida lista de viajes conteniendo [%d] viajes",
					viajes.size());
		} catch (Exception e) {
			Log.error("Algo ha ocurrido obteniendo lista de viajes");
		}
		return "EXITO";
	}

	@Override
	public String toString() {
		return getClass().getName();
	}

}
