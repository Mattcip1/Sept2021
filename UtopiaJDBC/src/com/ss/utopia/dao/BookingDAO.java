package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Booking;

public class BookingDAO extends BaseDAO<Booking> {
	
	
	public BookingDAO(Connection conn) {
		super(conn);
	}

	public void addBooking(Booking booking) throws ClassNotFoundException, SQLException {
		save("INSERT INTO booking (is_active, confirmation_code) VALUES (?, ?)", new Object[] {
				booking.getIsActive(), booking.getConfirmationCode()});
	}

	public void updateBooking(Booking booking) throws ClassNotFoundException, SQLException {
		save("UPDATE booking set is_active = ?, confirmation_code = ? WHERE id = ?",
				new Object[] {booking.getIsActive(), booking.getConfirmationCode(), booking.getId()});
	}

	public void deleteBooking(Booking booking) throws ClassNotFoundException, SQLException {
		save("Delete booking where id = ?", new Object[] { booking.getId() });
	}

	public List<Booking> readAirport() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM airport", null);
	}

	@Override
	protected List<Booking> extractData(ResultSet rs) throws SQLException {
		List<Booking> bookings = new ArrayList<>();

		while (rs.next()) {
			Booking booking = new Booking();
			booking.setId(rs.getInt("id"));
			booking.setIsActive(rs.getInt("is_active"));
			booking.setConfirmationCode(rs.getInt("confirmation_code"));
			bookings.add(booking);
		}
		return bookings;
	}
}
