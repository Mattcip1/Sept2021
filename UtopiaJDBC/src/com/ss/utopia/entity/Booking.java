package com.ss.utopia.entity;

import java.util.List;

public class Booking {

	private Integer Id;
	private Integer isActive;
	private String confirmationCode;
	private List<Passenger> passengers;
	private List<FlightBooking> bookings;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public String getConfirmationCode() {
		return confirmationCode;
	}
	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
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
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((bookings == null) ? 0 : bookings.hashCode());
		result = prime * result + ((confirmationCode == null) ? 0 : confirmationCode.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((passengers == null) ? 0 : passengers.hashCode());
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
		Booking other = (Booking) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (bookings == null) {
			if (other.bookings != null)
				return false;
		} else if (!bookings.equals(other.bookings))
			return false;
		if (confirmationCode == null) {
			if (other.confirmationCode != null)
				return false;
		} else if (!confirmationCode.equals(other.confirmationCode))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (passengers == null) {
			if (other.passengers != null)
				return false;
		} else if (!passengers.equals(other.passengers))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Booking [Id=" + Id + ", isActive=" + isActive + ", confirmationCode=" + confirmationCode
				+ ", passengers=" + passengers + ", bookings=" + bookings + "]";
	}
}
