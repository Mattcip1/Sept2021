package com.ss.utopia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.dao.AirplaneDAO;
import com.ss.utopia.dao.AirplaneTypeDAO;
import com.ss.utopia.dao.AirportDAO;
import com.ss.utopia.dao.BookingAgentDAO;
import com.ss.utopia.dao.BookingDAO;
import com.ss.utopia.dao.BookingPaymentDAO;
import com.ss.utopia.dao.BookingUserDAO;
import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.dao.PassengerDAO;
import com.ss.utopia.dao.RouteDAO;
import com.ss.utopia.dao.UserDAO;
import com.ss.utopia.dao.UserRoleDAO;
import com.ss.utopia.entity.Airplane;
import com.ss.utopia.entity.AirplaneType;
import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.BookingAgent;
import com.ss.utopia.entity.BookingPayment;
import com.ss.utopia.entity.BookingUser;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.Passenger;
import com.ss.utopia.entity.Route;
import com.ss.utopia.entity.User;
import com.ss.utopia.entity.UserRole;

public class AdminService {

	ConnectionUtil connUtil = new ConnectionUtil();

	public void addFlight(Flight flight) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			fdao.addFlight(flight);
			conn.commit();
			System.out.println("Flight added successfully");
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Flight addition Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
	}
	
	public void updateFlight(Flight flight) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			fdao.updateflight(flight);
			conn.commit();
			System.out.println("Flight updated successfully");
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Flight update Unsuccessful");
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

	public void createSeats(Flight flight, Integer seats) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			flight.setResvSeats(flight.getResvSeats() - seats);
			fdao.updateflight(flight);
			conn.commit();
			System.out.println("Seats added successfully");
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Seats addition Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
	}
	
	public void updateSeats(Flight flight, Integer seats) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			flight.setResvSeats(seats);
			fdao.updateflight(flight);
			conn.commit();
			System.out.println("Seats updated successfully");
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Seats update Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
	}
	
	public void deleteSeats(Flight flight) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			flight.setResvSeats(0);
			fdao.updateflight(flight);
			conn.commit();
			System.out.println("Seats deleted successfully");
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Seats deleted Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
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
	
	public void addPassenger(Passenger passenger) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PassengerDAO pdao = new PassengerDAO(conn);
			pdao.addPassenger(passenger);
			conn.commit();
			System.out.println("Passenger added successfully");
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Passenger addition Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
	}
	
	public void updatePassenger(Passenger passenger) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PassengerDAO pdao = new PassengerDAO(conn);
			pdao.updatePassenger(passenger);
			conn.commit();
			System.out.println("Passenger updated successfully");
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Passenger update Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
	}
	
	public void deletePassenger(Passenger passenger) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PassengerDAO pdao = new PassengerDAO(conn);
			pdao.deletePassenger(passenger);
			conn.commit();
			System.out.println("Passenger deleted successfully");
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Passenger deleted Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
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

	public void addBUser(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO udao = new UserDAO(conn);
			udao.addUser(user);
			conn.commit();
			System.out.println("Traveler added successfully");
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Traveler addition Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
	}
	
	public void updateBUser(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO udao = new UserDAO(conn);
			udao.updateUser(user);
			conn.commit();
			System.out.println("Traveler updated successfully");
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Traveler update Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
	}
	
	public void deleteBUser(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO udao = new UserDAO(conn);
			udao.deleteUser(user);
			conn.commit();
			System.out.println("Traveler deleted successfully");
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Traveler deleted Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
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
	
	public void addAgent(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO udao = new UserDAO(conn);
			udao.addUser(user);
			conn.commit();
			System.out.println("Employee added successfully");
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Employee addition Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
	}
	
	public void updateAgent(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO udao = new UserDAO(conn);
			udao.updateUser(user);
			conn.commit();
			System.out.println("Employee updated successfully");
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Employee update Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
	}
	
	public void deleteAgent(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO udao = new UserDAO(conn);
			udao.deleteUser(user);
			conn.commit();
			System.out.println("Employee deleted successfully");
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Employee deleted Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
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
	
	public Route addRoute(Route route) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			RouteDAO rdao = new RouteDAO(conn);
			Integer id = 0;
			id = rdao.addRoute(route);
			List<Route> route1 = new ArrayList<Route>();
			route1 = rdao.readRouteById(id);
			conn.commit();
			System.out.println("Route added successfully");
			System.out.println(route1.get(0));
			return route1.get(0);
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Route addition Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
		return null;
	}
	
	public List<Route> readRoutes() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			RouteDAO rdao = new RouteDAO(conn);
			List<Route> routes = new ArrayList<Route>();
			return routes = rdao.readRoute();
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
		} finally {
			if (conn != null)
				conn.close();
		}
		return null;
	}
	
	public void addAirport(Airport airport) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirportDAO aidao = new AirportDAO(conn);
			aidao.addAirport(airport);
			conn.commit();
			System.out.println("Airport added successfully");
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Airport addition Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
	}
	
	public void updateAirport(Airport airport) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirportDAO aidao = new AirportDAO(conn);
			aidao.updateAirport(airport);
			conn.commit();
			System.out.println("Airport updated successfully");
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Airport update Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
	}
	
	public void deleteAirport(Airport airport) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirportDAO aidao = new AirportDAO(conn);
			aidao.deleteAirport(airport);
			conn.commit();
			System.out.println("Airport deleted successfully");
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Airport deleted Unsuccessful");
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
	
	public List<Airplane> readAirplanes() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneDAO apdao = new AirplaneDAO(conn);
			List<Airplane> airplanes = new ArrayList<Airplane>();
			return airplanes = apdao.readAirplane();
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Airplanes Read Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
		return null;
	}
	
	public List<AirplaneType> readAirplaneTypes() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneTypeDAO aptdao = new AirplaneTypeDAO(conn);
			List<AirplaneType> planetypes = new ArrayList<AirplaneType>();
			return planetypes = aptdao.readAirplaneType();
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Airplane Types Read Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
		return null;
	}
	
	public List<Booking> readBooking() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingDAO bdao = new BookingDAO(conn);
			List<Booking> bookings = new ArrayList<Booking>();
			return bookings = bdao.readBooking();
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
		} finally {
			if (conn != null)
				conn.close();
		}
		return null;
	}
	
	public List<Booking> readBookingOveride() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingDAO bdao = new BookingDAO(conn);
			List<Booking> bookings = new ArrayList<Booking>();
			return bookings = bdao.readBookingOveride();
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
		} finally {
			if (conn != null)
				conn.close();
		}
		return null;
	}

	public Booking addBooking(Booking booking) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingDAO bdao = new BookingDAO(conn);
			Integer id = 0;
			id = bdao.addBooking(booking);
			List<Booking> booking1 = new ArrayList<Booking>();
			booking1 = bdao.readBookingById(id);
			conn.commit();
			System.out.println("Booking added successfully");
			System.out.println(booking1.get(0));
			return booking1.get(0);
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Booking addition Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
		return null;
	}
	
	public UserRole getUserRole(Integer in) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserRoleDAO urdao = new UserRoleDAO(conn);
			List<UserRole> roles = new ArrayList<UserRole>();
			if(in == 3) {
				roles = urdao.getUserRole();
			} else {
				roles = urdao.getAgentRole();
			}
			return roles.get(0);
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
	
	public Airport addODAirport(Airport airport) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirportDAO aidao = new AirportDAO(conn);
			Integer id = 0;
			id = aidao.addAirportWithPk(airport);
			String iata = airport.getAirportCode();
			List<Airport> airport1 = new ArrayList<Airport>();
			airport1 = aidao.readAirportById(iata);
			conn.commit();
			System.out.println("Airport added successfully");
			System.out.println(airport1.get(0));
			return airport1.get(0);
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Airport addition Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
		return null;
	}
	
	public Airplane addAirplane(Airplane airplane) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneDAO apdao = new AirplaneDAO(conn);
			Integer id = 0;
			id = apdao.addAirplane(airplane);
			List<Airplane> airplane1 = new ArrayList<Airplane>();
			airplane1 = apdao.readAirplaneById(id);
			conn.commit();
			System.out.println("Airplane added successfully");
			System.out.println(airplane1.get(0));
			return airplane1.get(0);
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Airplane addition Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
		return null;
	}
	
	public void tripOveride(Booking booking) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingDAO bdao = new BookingDAO(conn);
			Integer id = 0;
			id = booking.getId();
			bdao.tripOveride(booking);
			BookingPaymentDAO payment = new BookingPaymentDAO(conn);
			payment.tripOverride(id);
			conn.commit();
			System.out.println("Trip Overrided");
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("Trip Override Unsuccessful");
		} finally {
			if (conn != null)
				conn.close();
		}
	}
}
