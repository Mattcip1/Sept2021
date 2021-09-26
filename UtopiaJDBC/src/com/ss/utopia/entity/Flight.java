package com.ss.utopia.entity;

import java.util.List;

public class Flight {

	private Integer flightId;
	private Route routeId;
	private Airplane planeId;
	private String departureTime;
	private Integer resvSeats;
	private Float seatPrice;
	private List<FlightBooking> bookings;
	
	public Integer getFlightId() {
		return flightId;
	}
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}
	public Route getRouteId() {
		return routeId;
	}
	public void setRouteId(Route routeId) {
		this.routeId = routeId;
	}
	public Airplane getPlaneId() {
		return planeId;
	}
	public void setPlaneId(Airplane planeId) {
		this.planeId = planeId;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public Integer getResvSeats() {
		return resvSeats;
	}
	public void setResvSeats(Integer resvSeats) {
		this.resvSeats = resvSeats;
	}
	public Float getSeatPrice() {
		return seatPrice;
	}
	public void setSeatPrice(Float seatPrice) {
		this.seatPrice = seatPrice;
	}
	public List<FlightBooking> getBookings() {
		return bookings;
	}
	public void setBookings(List<FlightBooking> bookings) {
		this.bookings = bookings;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookings == null) ? 0 : bookings.hashCode());
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + ((flightId == null) ? 0 : flightId.hashCode());
		result = prime * result + ((planeId == null) ? 0 : planeId.hashCode());
		result = prime * result + ((resvSeats == null) ? 0 : resvSeats.hashCode());
		result = prime * result + ((routeId == null) ? 0 : routeId.hashCode());
		result = prime * result + ((seatPrice == null) ? 0 : seatPrice.hashCode());
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
		Flight other = (Flight) obj;
		if (bookings == null) {
			if (other.bookings != null)
				return false;
		} else if (!bookings.equals(other.bookings))
			return false;
		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
			return false;
		if (flightId == null) {
			if (other.flightId != null)
				return false;
		} else if (!flightId.equals(other.flightId))
			return false;
		if (planeId == null) {
			if (other.planeId != null)
				return false;
		} else if (!planeId.equals(other.planeId))
			return false;
		if (resvSeats == null) {
			if (other.resvSeats != null)
				return false;
		} else if (!resvSeats.equals(other.resvSeats))
			return false;
		if (routeId == null) {
			if (other.routeId != null)
				return false;
		} else if (!routeId.equals(other.routeId))
			return false;
		if (seatPrice == null) {
			if (other.seatPrice != null)
				return false;
		} else if (!seatPrice.equals(other.seatPrice))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", routeId=" + routeId + ", planeId=" + planeId + ", departureTime="
				+ departureTime + ", resvSeats=" + resvSeats + ", seatPrice=" + seatPrice + ", bookings=" + bookings
				+ "]";
	}
}
