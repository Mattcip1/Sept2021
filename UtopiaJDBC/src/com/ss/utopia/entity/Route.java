package com.ss.utopia.entity;

import java.util.List;

public class Route {

	private Integer routeId;
	private Airport originAirport;
	private Airport destinationAirport;
	private List<Flight> flights;
	
	public Integer getRouteId() {
		return routeId;
	}
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	public Airport getOriginAirport() {
		return originAirport;
	}
	public void setOriginAirport(Airport originAirport) {
		this.originAirport = originAirport;
	}
	public Airport getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	public List<Flight> getFlights() {
		return flights;
	}
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destinationAirport == null) ? 0 : destinationAirport.hashCode());
		result = prime * result + ((flights == null) ? 0 : flights.hashCode());
		result = prime * result + ((originAirport == null) ? 0 : originAirport.hashCode());
		result = prime * result + ((routeId == null) ? 0 : routeId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Route other = (Route) obj;
		if (destinationAirport == null) {
			if (other.destinationAirport != null)
				return false;
		} else if (!destinationAirport.equals(other.destinationAirport))
			return false;
		if (flights == null) {
			if (other.flights != null)
				return false;
		} else if (!flights.equals(other.flights))
			return false;
		if (originAirport == null) {
			if (other.originAirport != null)
				return false;
		} else if (!originAirport.equals(other.originAirport))
			return false;
		if (routeId == null) {
			if (other.routeId != null)
				return false;
		} else if (!routeId.equals(other.routeId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", originAirport=" + originAirport + ", destinationAirport="
				+ destinationAirport + ", flights=" + flights + "]";
	}
}
