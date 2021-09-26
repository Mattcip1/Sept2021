package com.ss.utopia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.dao.AirplaneDAO;
import com.ss.utopia.dao.AirplaneTypeDAO;
import com.ss.utopia.dao.AirportDAO;
import com.ss.utopia.dao.BookingAgentDAO;
import com.ss.utopia.dao.BookingUserDAO;
import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.dao.PassengerDAO;
import com.ss.utopia.dao.RouteDAO;
import com.ss.utopia.dao.UserDAO;
import com.ss.utopia.entity.Airplane;
import com.ss.utopia.entity.AirplaneType;
import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.BookingAgent;
import com.ss.utopia.entity.BookingUser;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.Passenger;
import com.ss.utopia.entity.Route;
import com.ss.utopia.entity.User;

public class AdminService {

	ConnectionUtil connUtil = new ConnectionUtil();

	public String addFlight(Route route, Airport airport, Airplane airplane, AirplaneType type, String departuretime,
			Integer seats, Float price) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			RouteDAO rdao = new RouteDAO(conn);
			AirportDAO adao = new AirportDAO(conn);
			AirplaneDAO aidao = new AirplaneDAO(conn);
			AirplaneTypeDAO atdao = new AirplaneTypeDAO(conn);
			FlightDAO fdao = new FlightDAO(conn);
			adao.addAirport(airport);
			rdao.addRoute(route);
			atdao.addAirplaneType(type);
			aidao.addAirplane(airplane);
			Flight flight = new Flight();
			flight.setRouteId(route);
			flight.setPlaneId(airplane);
			flight.setDepartureTime(departuretime);
			flight.setResvSeats(seats);
			flight.setSeatPrice(price);
			fdao.addFlight(flight);
			conn.commit();
			return "Flight added successfully";
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			return "Flight not added successfully";
		} finally {
			if (conn != null)
				conn.close();
		}
	}
	
	public void deleteFlight(Flight flight) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			fdao.deleteflight(flight);
			conn.commit();
			System.out.println("Flight deleted successfully");
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Flight deletion Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
	}
	
	public List<Flight> readFlight() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			List<Flight> flights = new ArrayList<Flight>();
			return flights = fdao.readFlight();
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Flight Read Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
		return null;
	}
	
	public List<Flight> readSeats() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			List<Flight> flights = new ArrayList<Flight>();
			return flights = fdao.readFlight();
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Seats Read Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
		return null;
	}
	
	public List<Passenger> readPassengers() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PassengerDAO pdao = new PassengerDAO(conn);
			List<Passenger> passengers = new ArrayList<Passenger>();
			return passengers = pdao.readPassenger();
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Passengers Read Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
		return null;
	}
	
	public List<User> readBUsers() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO udao = new UserDAO(conn);
			List<User> users = new ArrayList<User>();
			return users = udao.readUserByRole(3);
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Travelers Read Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
		return null;
	}
	
	public List<User> readAgents() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO udao = new UserDAO(conn);
			List<User> agents = new ArrayList<User>();
			return agents = udao.readUserByRole(2);
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Employees Read Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
		return null;
	}
	
	///////////
	public void readRoutes() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			RouteDAO rdao = new RouteDAO(conn);
			List<Route> routes = new ArrayList<Route>();
			routes = rdao.readRoute();
			for(Route r: routes)
				System.out.println(r.toString());
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Routes Read Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
	}
	
	public List<Airport> readAirports() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirportDAO aidao = new AirportDAO(conn);
			List<Airport> airports = new ArrayList<Airport>();
			return airports = aidao.readAirport();
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Airports Read Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
		return null;
	}
}
