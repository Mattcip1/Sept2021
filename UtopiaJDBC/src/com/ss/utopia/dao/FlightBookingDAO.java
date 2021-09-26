package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.FlightBooking;

public class FlightBookingDAO extends BaseDAO<FlightBooking> {

	public FlightBookingDAO(Connection conn) {
		super(conn);
	}

	public void addFlightBooking(FlightBooking booking) throws ClassNotFoundException, SQLException {
		save("INSERT INTO flight_booking (flight_id, booking_id) VALUES (?, ?)", new Object[] {
				booking.getFlightId().getFlightId(), booking.getBookingId().getId()});
	}

	public void updateFlightBooking(FlightBooking booking) throws ClassNotFoundException, SQLException {
		save("UPDATE flight_booking set flight_id = ? WHERE booking_id = ?",
				new Object[] {booking.getFlightId().getFlightId(), booking.getBookingId().getId()});
	}

	public void deleteFlightBooking(FlightBooking booking) throws ClassNotFoundException, SQLException {
		save("Delete flight_booking where booking_id = ?", new Object[] { booking.getBookingId().getId()});
	}

	public List<FlightBooking> readAirport() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM flight_booking", null);
	}

	@Override
	protected List<FlightBooking> extractData(ResultSet rs) throws SQLException {
		List<FlightBooking> bookings = new ArrayList<>();

		while (rs.next()) {
			FlightBooking booking = new FlightBooking();
			booking.getFlightId().setFlightId((rs.getInt("flight_id")));
			booking.getBookingId().setId(rs.getInt("booking_id"));
			bookings.add(booking);
		}
		return bookings;
	}
}
