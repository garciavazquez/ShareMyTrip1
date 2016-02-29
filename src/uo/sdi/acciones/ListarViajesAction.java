package uo.sdi.acciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.model.Trip;
import uo.sdi.persistence.PersistenceFactory;
import alb.util.log.Log;

public class ListarViajesAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		List<Trip> viajes;

		try {
			
			viajes = PersistenceFactory.newTripDao().findAll();
			List<Trip> viajesFiltrados = new ArrayList<>();
			
			// Cogemos la fecha actual
			Date fechaActual = new Date();

			// Añadiremos a la lista los viajes que...
			for (Trip trip : viajes) {
				//no se hayan realizado aún.
				if(!trip.getDepartureDate().before(fechaActual))
					viajesFiltrados.add(trip);
				
				//no hayan cerrado el plazo de inscripción.
				if (!trip.getClosingDate().before(fechaActual))
					viajesFiltrados.add(trip);
				
				// tengan plazas libres.
				if(trip.getAvailablePax() != 0)
					viajesFiltrados.add(trip);				
			}

			request.setAttribute("listaViajes", viajesFiltrados);
			Log.debug("Obtenida lista de viajes conteniendo [%d] viajes",
					viajesFiltrados.size());
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
