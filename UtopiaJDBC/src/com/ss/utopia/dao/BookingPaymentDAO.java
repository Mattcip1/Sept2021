package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.BookingPayment;

public class BookingPaymentDAO extends BaseDAO<BookingPayment> {

	public BookingPaymentDAO(Connection conn) {
		super(conn);
	}

	public void addBookingPayment(BookingPayment payment) throws ClassNotFoundException, SQLException {
		save("INSERT INTO booking_payment (booking_id, stripe_id, refunded) VALUES (?, ?, ?)", new Object[] {
				payment.getPaymentId().getId(), payment.getStripeId(), payment.getRefunded() });
	}

	public void updateBookingPayment(BookingPayment payment) throws ClassNotFoundException, SQLException {
		save("UPDATE booking_payment set stripe_id = ?, refunded = ? WHERE booking_id = ?",
				new Object[] {payment.getStripeId(), payment.getRefunded(), payment.getPaymentId().getId()});
	}
	
	public void tripOverride(Integer id) throws ClassNotFoundException, SQLException {
		save("UPDATE booking_payment set refunded = 0 WHERE booking_id = ?",
				new Object[] {id});
	}

	public void deleteBookingPayment(BookingPayment payment) throws ClassNotFoundException, SQLException {
		save("Delete booking_payment where booking_id = ?", new Object[] { payment.getPaymentId().getId() });
	}

	public List<BookingPayment> readBookingPayment() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM booking_payment", null);
	}
	
	public List<BookingPayment> readBookingPayment(Integer id) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM booking_payment where booking_id = ?", new Object[] {id});
	}

	@Override
	protected List<BookingPayment> extractData(ResultSet rs) throws SQLException {
		List<BookingPayment> payments = new ArrayList<>();

		while (rs.next()) {
			BookingPayment payment = new BookingPayment();
			payment.setPaymentId(new Booking());
			payment.getPaymentId().setId(rs.getInt("booking_id"));
			payment.setStripeId(rs.getString("stripe_id"));
			payment.setRefunded(rs.getInt("refunded"));
			payments.add(payment);
		}
		return payments;
	}
}
