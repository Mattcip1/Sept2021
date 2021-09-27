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

	public Integer addBooking(Booking booking) throws ClassNotFoundException, SQLException {
		return saveWithPK("INSERT INTO booking (is_active, confirmation_code) VALUES (?, ?)", new Object[] {
				booking.getIsActive(), booking.getConfirmationCode()});
	}

	public void updateBooking(Booking booking) throws ClassNotFoundException, SQLException {
		save("UPDATE booking set is_active = ?, confirmation_code = ? WHERE id = ?",
				new Object[] {booking.getIsActive(), booking.getConfirmationCode(), booking.getId()});
	}
	
	public Integer tripOveride(Booking booking) throws ClassNotFoundException, SQLException {
		return saveWithPK("update booking set is_active = 1 where id = ?",
				new Object[] {booking.getId()});
	}

	public void deleteBooking(Booking booking) throws ClassNotFoundException, SQLException {
		save("Delete booking where id = ?", new Object[] { booking.getId() });
	}

	public List<Booking> readBooking() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM booking", null);
	}
	
	public List<Booking> readBookingById(Integer in) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM booking WHERE id = ?", new Object[] {in});
	}
	
	public List<Booking> readBookingOveride() throws ClassNotFoundException, SQLException {
		return read("Select * from booking Inner Join booking_payment ON booking_payment.booking_id = booking.id AND booking.is_active = 0 AND booking_payment.refunded = 1;", null);
	}

	@Override
	protected List<Booking> extractData(ResultSet rs) throws SQLException {
		List<Booking> bookings = new ArrayList<>();

		while (rs.next()) {
			Booking booking = new Booking();
			booking.setId(rs.getInt("id"));
			booking.setIsActive(rs.getInt("is_active"));
			booking.setConfirmationCode(rs.getString("confirmation_code"));
			bookings.add(booking);
		}
		return bookings;
	}
}
