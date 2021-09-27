package com.ss.utopia.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.Passenger;
import com.ss.utopia.entity.User;

class AdminTest {

	private static AdminService serv = new AdminService();
	
	@Test
	void flightTest() throws SQLException {
		//assertThrows(SQLException.class, () -> serv.addFlight(new Flight()));
		//assertThrows(SQLException.class, () -> serv.updateFlight(new Flight()));
		//assertThrows(SQLException.class, () -> serv.deleteFlight(new Flight()));
		assertNotNull(serv.readFlight());
	}
	
	@Test
	void seatsTest() throws SQLException {
		//assertThrows(SQLException.class, () -> serv.createSeats(new Flight(), null));
		//assertThrows(SQLException.class, () -> serv.updateSeats(new Flight(), null));
		//assertThrows(SQLException.class, () -> serv.deleteSeats(new Flight()));
		assertNotNull(serv.readSeats());
	}
	
	@Test
	void passengerTest() throws SQLException {
		//assertThrows(SQLException.class, () -> serv.addPassenger(new Passenger()));
		//assertThrows(SQLException.class, () -> serv.updatePassenger(new Passenger()));
		//assertThrows(SQLException.class, () -> serv.deletePassenger(new Passenger()));
		assertNotNull(serv.readPassengers());
	}
	
	@Test
	void airportTest() throws SQLException {
		//assertThrows(SQLException.class, () -> serv.addAirport(new Airport()));
		//assertThrows(SQLException.class, () -> serv.updateAirport(new Airport()));
		//assertThrows(SQLException.class, () -> serv.deleteAirport(new Airport()));
		assertNotNull(serv.readAirports());
	}
	
	@Test
	void travelerTest() throws SQLException {
		//assertThrows(SQLException.class, () -> serv.addBUser(new User()));
		//assertThrows(SQLException.class, () -> serv.updateBUser(new User()));
		//assertThrows(SQLException.class, () -> serv.deleteBUser(new User()));
		assertNotNull(serv.readBUsers());
	}
	
	@Test
	void agentTest() throws SQLException {
		//assertThrows(SQLException.class, () -> serv.addAgent(new User()));
		//assertThrows(SQLException.class, () -> serv.updateAgent(new User()));
		//assertThrows(SQLException.class, () -> serv.deleteAgent(new User()));
		assertNotNull(serv.readAgents());
	}
}
