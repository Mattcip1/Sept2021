package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.BookingAgent;
import com.ss.utopia.entity.BookingGuest;

public class BookingGuestDAO extends BaseDAO<BookingGuest> {

	public BookingGuestDAO(Connection conn) {
		super(conn);
	}

	public void addBookingGuest(BookingGuest guest) throws ClassNotFoundException, SQLException {
		save("INSERT INTO booking_guest (booking_id, contact_email, contact_phone) VALUES (?, ?, ?)", new Object[] {
				guest.getBookingId().getId(), guest.getEmail(), guest.getPhoneNumber() });
	}

	public void updateBookingGuest(BookingGuest guest) throws ClassNotFoundException, SQLException {
		save("UPDATE booking_guest set contact_email = ?, contact_phone = ? WHERE booking_id = ?",
				new Object[] {guest.getEmail(), guest.getPhoneNumber(), guest.getBookingId().getId()});
	}

	public void deleteBookingGuest(BookingGuest guest) throws ClassNotFoundException, SQLException {
		save("Delete booking_guest where booking_id = ?", new Object[] { guest.getBookingId().getId() });
	}

	public List<BookingGuest> readAirport() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM booking_guest", null);
	}

	@Override
	protected List<BookingGuest> extractData(ResultSet rs) throws SQLException {
		List<BookingGuest> guests = new ArrayList<>();

		while (rs.next()) {
			BookingGuest guest = new BookingGuest();
			guest.getBookingId().setId(rs.getInt("booking_id"));
			guest.setEmail(rs.getString("contact_email"));
			guest.setPhoneNumber(rs.getString("contact_phone"));
			guests.add(guest);
		}
		return guests;
	}
}
