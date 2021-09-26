package com.ss.utopia.entity;

import java.util.List;

public class Airplane {

	private Integer airplaneId;
	private AirplaneType typeId;
	private List<Flight> flights;

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public Integer getAirplaneId() {
		return airplaneId;
	}

	public void setAirplaneId(Integer airplaneId) {
		this.airplaneId = airplaneId;
	}

	public AirplaneType getTypeId() {
		return typeId;
	}

	public void setTypeId(AirplaneType typeId) {
		this.typeId = typeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airplaneId == null) ? 0 : airplaneId.hashCode());
		result = prime * result + ((flights == null) ? 0 : flights.hashCode());
		result = prime * result + ((typeId == null) ? 0 : typeId.hashCode());
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
		Airplane other = (Airplane) obj;
		if (airplaneId == null) {
			if (other.airplaneId != null)
				return false;
		} else if (!airplaneId.equals(other.airplaneId))
			return false;
		if (flights == null) {
			if (other.flights != null)
				return false;
		} else if (!flights.equals(other.flights))
			return false;
		if (typeId == null) {
			if (other.typeId != null)
				return false;
		} else if (!typeId.equals(other.typeId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Airplane [airplaneId=" + airplaneId + ", typeId=" + typeId + ", flights=" + flights + "]";
	}
	
	
}
