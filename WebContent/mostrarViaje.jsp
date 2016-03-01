<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comprobarNavegacion.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Detalles del viaje</title>
</head>
<body>
	<table border="1" align="center">
			<tr>
				<th>ID viaje</th>
				<td>${viaje.id}</td>
			</tr>
			
			<tr>
				<th>País salida</th>
				<td>${viaje.departure.country}</td>
			</tr>
			<tr>
				<th>Estado salida</th>
				<td>${viaje.departure.state}</td>
			</tr>	
			<tr>
				<th>Ciudad salida</th>
				<td>${viaje.departure.city}</td>
			</tr>
			<tr>
				<th>Dirección salida</th>
				<td>${viaje.departure.address}</td>
			</tr>
			<tr>
				<th>ZipCode salida</th>
				<td>${viaje.departure.zipCode}</td>
			</tr>
			<tr>
				<th>Coordenadas salida</th>
				<td>${viaje.departure.waypoint}</td>
			</tr>	
			<tr>
				<th>Fecha salida</th>
				<td>${viaje.departureDate}</td>
			</tr>
			
			<tr>
				<th>País destino</th>
				<td>${viaje.destination.country}</td>
			</tr>
			<tr>
				<th>Estado destino</th>
				<td>${viaje.destination.state}</td>
			</tr>	
			<tr>
				<th>Ciudad destino</th>
				<td>${viaje.destination.city}</td>
			</tr>
			<tr>
				<th>Dirección destino</th>
				<td>${viaje.destination.address}</td>
			</tr>
			<tr>
				<th>ZipCode destino</th>
				<td>${viaje.destination.zipCode}</td>
			</tr>
			<tr>
				<th>Coordenadas destino</th>
				<td>${viaje.destination.waypoint}</td>
			</tr>				
			<tr>
				<th>Fecha llegada</th>
				<td>${viaje.arrivalDate}</td>
			</tr>
			<tr>
				<th>Plazas disponibles</th>
				<td>${viaje.availablePax}</td>
			</tr>
			<tr>
				<th>Fecha de cierre</th>
				<td>${viaje.closingDate}</td>
			</tr>
			<tr>
				<th>Comentarios</th>
				<td>${viaje.comments}</td>
			</tr>
			<tr>
				<th>Coste estimado</th>
				<td>${viaje.estimatedCost}</td>
			</tr>	
			<tr>
				<th>Pasajeros máximos</th>
				<td>${viaje.estimatedCost}</td>
			</tr>	
			
				
			
	</table>
</body>
</html>