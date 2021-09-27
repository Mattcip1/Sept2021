package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.Passenger;

public class PassengerDAO extends BaseDAO<Passenger> {

	public PassengerDAO(Connection conn) {
		super(conn);
	}

	public void addPassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("INSERT INTO passenger (booking_id, given_name, family_name, dob, gender, address) VALUES (?, ?, ?, ?, ?, ?)", new Object[] {
				passenger.getBookingId().getId(), passenger.getFirstName(), passenger.getLastName(), passenger.getDateOfBirth(),
				passenger.getGender(), passenger.getAddress()});
	}

	public void updatePassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("UPDATE passenger set given_name = ?, family_name = ?, dob = ?, gender = ?, address = ? WHERE id = ?",
				new Object[] {passenger.getFirstName(), passenger.getLastName(), passenger.getDateOfBirth(),
						passenger.getGender(), passenger.getAddress(), passenger.getPassId()});
	}

	public void deletePassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("Delete from passenger where id = ?", new Object[] { passenger.getPassId()});
	}

	public List<Passenger> readPassenger() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM passenger", null);
	}

	@Override
	protected List<Passenger> extractData(ResultSet rs) throws SQLException {
		List<Passenger> passengers = new ArrayList<>();

		while (rs.next()) {
			Passenger passenger = new Passenger();
			passenger.setPassId(rs.getInt("id"));
			passenger.setBookingId(new Booking());
			passenger.getBookingId().setId(rs.getInt("booking_id"));
			passenger.setFirstName(rs.getString("given_name"));
			passenger.setLastName(rs.getString("family_name"));
			passenger.setDateOfBirth(rs.getString("dob"));
			passenger.setGender(rs.getString("gender"));
			passenger.setAddress(rs.getString("address"));
			passengers.add(passenger);
		}
		return passengers;
	}
}
