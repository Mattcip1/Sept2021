package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.BookingAgent;
import com.ss.utopia.entity.BookingUser;
import com.ss.utopia.entity.User;

public class BookingUserDAO extends BaseDAO<BookingUser> {

	public BookingUserDAO(Connection conn) {
		super(conn);
	}

	public void addBookingUser(BookingUser user) throws ClassNotFoundException, SQLException {
		save("INSERT INTO booking_user (booking_id, user_id) VALUES (?, ?)", new Object[] {
				user.getBookingId().getId(), user.getUserId().getUserId() });
	}

	public void updateBookingUser(BookingUser user) throws ClassNotFoundException, SQLException {
		save("UPDATE booking_user set booking_id = ? WHERE user_id = ?",
				new Object[] {user.getBookingId().getId(), user.getUserId().getUserId()});
	}

	public void deleteBookingUser(BookingUser user) throws ClassNotFoundException, SQLException {
		save("Delete booking_user where user_id = ?", new Object[] { user.getUserId().getUserId() });
	}

	public List<BookingUser> readBookingUser() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM booking_user", null);
	}

	@Override
	protected List<BookingUser> extractData(ResultSet rs) throws SQLException {
		List<BookingUser> users = new ArrayList<>();

		while (rs.next()) {
			BookingUser user = new BookingUser();
			user.setBookingId(new Booking());
			user.getBookingId().setId(rs.getInt("booking_id"));
			user.setUserId(new User());
			user.getUserId().setUserId(rs.getInt("user_id"));
			users.add(user);
		}
		return users;
	}
}
