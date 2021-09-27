package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Airplane;
import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.Route;

public class FlightDAO extends BaseDAO<Flight> {
	
	public FlightDAO(Connection conn) {
		super(conn);
	}

	public void addFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("INSERT INTO flight (id, route_id, airplane_id, departure_time, reserved_seats, seat_price) VALUES (?, ?, ?, ?, ?, ?)", new Object[] {
				flight.getFlightId(), flight.getRouteId().getRouteId(), flight.getPlaneId().getAirplaneId(), flight.getDepartureTime(), flight.getResvSeats(), flight.getSeatPrice() });
	}

	public void updateflight(Flight flight) throws ClassNotFoundException, SQLException {
		save("UPDATE flight SET route_id = ?, airplane_id = ?, departure_time = ?, reserved_seats = ?, seat_price = ? where id = ?",
				new Object[] {flight.getRouteId().getRouteId(), flight.getPlaneId().getAirplaneId(), flight.getDepartureTime(), flight.getResvSeats(), flight.getSeatPrice(), flight.getFlightId()});
	}

	public void deleteflight(Flight flight) throws ClassNotFoundException, SQLException {
		save("Delete from flight where id = ?", new Object[] { flight.getFlightId() });
	}

	public List<Flight> readFlight() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM flight", null);
	}

	@Override
	protected List<Flight> extractData(ResultSet rs) throws SQLException {
		List<Flight> flights = new ArrayList<>();

		while (rs.next()) {
			Flight flight = new Flight();
			flight.setFlightId(rs.getInt("id"));
			flight.setRouteId(new Route());
			flight.getRouteId().setRouteId(rs.getInt("route_id"));
			flight.setPlaneId(new Airplane());
			flight.getPlaneId().setAirplaneId(rs.getInt("airplane_id"));
			flight.setDepartureTime(rs.getString("departure_time"));
			flight.setResvSeats(rs.getInt("reserved_seats"));
			flight.setSeatPrice(rs.getFloat("seat_price"));
			flights.add(flight);
		}
		return flights;
	}
}
