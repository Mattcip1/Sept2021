/**
 * 
 */
package com.ss.utopia.menus;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.ss.utopia.dao.RouteDAO;
import com.ss.utopia.entity.Airplane;
import com.ss.utopia.entity.AirplaneType;
import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.Passenger;
import com.ss.utopia.entity.Route;
import com.ss.utopia.entity.User;
import com.ss.utopia.service.AdminService;
import com.ss.utopia.service.ConnectionUtil;

/**
 * @author mattb
 *
 */
public class Driver {

	/**
	 * @param args
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Utopia Airlines Management System. Which category of a user are you");
		System.out.println("Admin - Enter 1");
		System.out.println("Employee/Agent - Enter 2");
		System.out.println("Traveler - Enter 3");
		String in = scan.nextLine();
		switch (in) {
		case "1":
			Driver.adminConsole();
			break;
		case "2":
			System.out.println("Hello Agent");
			break;
		case "3":
			System.out.println("Hello Traveler");
			break;
		}

	}

	public static void adminConsole() throws SQLException, ClassNotFoundException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Add/Update/Delete/Read Flights - Enter 1");
		System.out.println("Add/Update/Delete/Read Seats - Enter 2");
		System.out.println("Add/Update/Delete/Read Tickets and Passengers - Enter 3");
		System.out.println("Add/Update/Delete/Read Airports - Enter 4");
		System.out.println("Add/Update/Delete/Read Travelers - Enter 5");
		System.out.println("Add/Update/Delete/Read Employess - Enter 6");
		System.out.println("Over-ride Trip Cancellation for a ticket - Enter 7");
		String in = scan.nextLine();
		switch (in) {
		case "1":
			Driver.adminFlightConsole();
			break;
		case "2":
			Driver.adminSeatsConsole();
			break;
		case "3":
			Driver.adminPassengerConsole();
			break;
		case "4":
			Driver.adminAirportConsole();
			break;
		case "5":
			Driver.adminBUsersConsole();
			break;
		case "6":
			Driver.adminAgentsConsole();
			break;
		case "7":
			Driver.adminTripOverideConsole();
			break;
		}
	}

	public static void adminFlightConsole() throws SQLException, ClassNotFoundException {
		Scanner scan = new Scanner(System.in);
		AdminService serv = new AdminService();
		System.out.println("What operation would you like to perform on flights?");
		String in = scan.nextLine();
		switch (in) {
		case "Add":
			List<Route> routes = new ArrayList<Route>();
			routes = serv.readRoutes();
			int ct1 = 0;
			for (Route r : routes) {
				System.out.println(ct1 + "--" + r.toString());
				ct1++;
			}
			System.out.println("Select a route by index or say NEW to create new:");
			String input1 = scan.nextLine();
			Route route = new Route();
			if (input1.contentEquals("NEW")) {
				List<Airport> airports = new ArrayList<Airport>();
				airports = serv.readAirports();
				int ct11 = 0;
				for (Airport a : airports) {
					System.out.println(ct11 + "--" + a.toString());
					ct11++;
				}
				System.out.println("Select an origin airport by index or say NEW to create new:");
				String input11 = scan.nextLine();
				Airport oairport = new Airport();
				if (input11.contentEquals("NEW")) {
					Airport noairport = new Airport();
					System.out.println("What is the new Airport Code?");
					noairport.setAirportCode(scan.nextLine());
					System.out.println("What is the new Airport City Location?");
					noairport.setCityName(scan.nextLine());
					oairport = serv.addODAirport(noairport);
				} else {
					Integer index11 = Integer.parseInt(input11);
					oairport = airports.get(index11);
				}
				System.out.println("Select destination airport by index or say NEW to create new:");
				String input12 = scan.nextLine();
				Airport dairport = new Airport();
				if (input12.contentEquals("NEW")) {
					Airport ndairport = new Airport();
					System.out.println("What is the new Airport Code?");
					ndairport.setAirportCode(scan.nextLine());
					System.out.println("What is the new Airport City Location?");
					ndairport.setCityName(scan.nextLine());
					dairport = serv.addODAirport(ndairport);
				} else {
					Integer index12 = Integer.parseInt(input12);
					dairport = airports.get(index12);
				}
				Route nroute = new Route();
				nroute.setOriginAirport(oairport);
				nroute.setDestinationAirport(dairport);
				route = serv.addRoute(nroute);
			}
			else {
				Integer index1 = Integer.parseInt(input1);
				route = routes.get(index1);
			}
				
				List<Airplane> airplanes = new ArrayList<Airplane>();
				airplanes = serv.readAirplanes();
				int ct13 = 0;
				for (Airplane a : airplanes) {
					System.out.println(ct13 + "--" + a.toString());
					ct13++;
				}
				System.out.println("Select an airplane by index or say NEW to create new:");
				String input13 = scan.nextLine();
				Airplane airplane = new Airplane();
				if (input13.contentEquals("NEW")) {
					AirplaneType planetype = new AirplaneType();
					List<AirplaneType> planetypes = new ArrayList<AirplaneType>();
					planetypes = serv.readAirplaneTypes();
					int ct14 = 0;
					for (AirplaneType at : planetypes) {
						System.out.println(ct14 + "--" + at.toString());
						ct14++;
					}
					System.out.println("Select index of Airplane Type:");
					String type = scan.nextLine();
					int type2 = Integer.parseInt(type);
					airplane.setTypeId(planetypes.get(type2));
					airplane = serv.addAirplane(airplane);
				} else {
					Integer index13 = Integer.parseInt(input13);
					airplane = airplanes.get(index13);
				}
				Flight flight = new Flight();
				System.out.println("Enter the flight ID: ");
				String s1 = scan.nextLine();
				int i1 = Integer.parseInt(s1);
				flight.setFlightId(i1);
				flight.setRouteId(route);
				flight.setPlaneId(airplane);
				System.out.println("Enter the departure time (0000-00-00 00:00:00): ");
				flight.setDepartureTime(scan.nextLine());
				System.out.println("Enter the number of reserved seats: ");
				String s2 = scan.nextLine();
				int i2 = Integer.parseInt(s2);
				flight.setResvSeats(i2);
				System.out.println("Enter the seat price: ");
				String s3 = scan.nextLine();
				float f1 = Float.parseFloat(s3);
				flight.setSeatPrice(f1);
				serv.addFlight(flight);
			break;
		case "Update":
			List<Flight> flights2 = new ArrayList<Flight>();
			flights2 = serv.readFlight();
			int ct3 = 0;
			for (Flight f : flights2) {
				System.out.println(ct3 + "--" + f.toString());
				ct3++;
			}
			System.out.println("Select a flight by index to update:");
			String input3 = scan.nextLine();
			Integer index3 = Integer.parseInt(input3);
			Flight uflight = new Flight();
			uflight.setFlightId(flights2.get(index3).getFlightId());
			uflight.setRouteId(flights2.get(index3).getRouteId());
			uflight.setPlaneId(flights2.get(index3).getPlaneId());
			System.out.println("Enter the departure time (0000-00-00 00:00:00): ");
			uflight.setDepartureTime(scan.nextLine());
			System.out.println("Enter the number of reserved seats: ");
			String s31 = scan.nextLine();
			int i31 = Integer.parseInt(s31);
			uflight.setResvSeats(i31);
			System.out.println("Enter the seat price: ");
			String s32 = scan.nextLine();
			float f32 = Float.parseFloat(s32);
			uflight.setSeatPrice(f32);
			serv.updateFlight(uflight);
			break;
		case "Delete":
			List<Flight> flights3 = new ArrayList<Flight>();
			flights3 = serv.readFlight();
			int ct = 0;
			for (Flight f : flights3) {
				System.out.println(ct + "--" + f.toString());
				ct++;
			}
			System.out.println("Select a flight by index to delete:");
			String input = scan.nextLine();
			Integer index = Integer.parseInt(input);
			serv.deleteFlight(flights3.get(index));
			break;
		case "Read":
			List<Flight> flights4 = new ArrayList<Flight>();
			flights4 = serv.readFlight();
			for (Flight f : flights4)
				System.out.println(f.toString());
			break;
		}

	}

	public static void adminSeatsConsole() throws SQLException {
		Scanner scan = new Scanner(System.in);
		AdminService serv = new AdminService();
		System.out.println("What operation would you like to perform on Seats?");
		String in = scan.nextLine();
		switch (in) {
		case "Add":
			List<Flight> flights1 = new ArrayList<Flight>();
			flights1 = serv.readFlight();
			int ct1 = 0;
			for (Flight f : flights1) {
				System.out.println(ct1 + "--" + f.toString());
				ct1++;
			}
			System.out.println("Select a flight by index to add available seats:");
			String input1 = scan.nextLine();
			System.out.println("How many seats would you like to add?");
			String input12 = scan.nextLine();
			Integer index = Integer.parseInt(input1);
			Integer seats = Integer.parseInt(input12);
			serv.createSeats(flights1.get(index), seats);
			break;
		case "Update":
			List<Flight> flights2 = new ArrayList<Flight>();
			flights2 = serv.readFlight();
			int ct2 = 0;
			for (Flight f : flights2) {
				System.out.println(ct2 + "--" + f.toString());
				ct2++;
			}
			System.out.println("Select a flight by index to add available seats:");
			String input2 = scan.nextLine();
			System.out.println("What do you want the new number of reserved seats to be?");
			String input22 = scan.nextLine();
			Integer index2 = Integer.parseInt(input2);
			Integer seats2 = Integer.parseInt(input22);
			serv.updateSeats(flights2.get(index2), seats2);
			break;
		case "Delete":
			List<Flight> flights3 = new ArrayList<Flight>();
			flights3 = serv.readFlight();
			int ct3 = 0;
			for (Flight f : flights3) {
				System.out.println(ct3 + "--" + f.toString());
				ct3++;
			}
			System.out.println("Select a flight by index to delete seats:");
			String input3 = scan.nextLine();
			Integer index3 = Integer.parseInt(input3);
			serv.deleteSeats(flights3.get(index3));
			break;
		case "Read":
			List<Flight> flights4 = new ArrayList<Flight>();
			flights4 = serv.readSeats();
			for (Flight f : flights4)
				System.out.println("Flight #: " + f.getFlightId() + " Reserved Seats: " + f.getResvSeats());
			break;
		}
	}

	public static void adminPassengerConsole() throws SQLException {
		Scanner scan = new Scanner(System.in);
		AdminService serv = new AdminService();
		System.out.println("What operation would you like to perform on Passengers?");
		String in = scan.nextLine();
		switch (in) {
		case "Add":
			List<Booking> bookings = new ArrayList<Booking>();
			bookings = serv.readBooking();
			int ct1 = 0;
			for (Booking b : bookings) {
				System.out.println(ct1 + "--" + b.toString());
				ct1++;
			}
			System.out.println("Select a booking by index or say NEW to create new:");
			String input1 = scan.nextLine();
			Booking booking = new Booking();
			if (input1.contentEquals("NEW")) {
				Random rnd = new Random();
				int number = rnd.nextInt(999999);
				String s = String.format("%06d", number);
				booking.setIsActive(1);
				booking.setConfirmationCode(s);
				booking = serv.addBooking(booking);
			} else {
				Integer index1 = Integer.parseInt(input1);
				booking = bookings.get(index1);
			}
			Passenger npassenger = new Passenger();
			npassenger.setBookingId(booking);
			System.out.println("Enter passenger first name");
			npassenger.setFirstName(scan.nextLine());
			System.out.println("Enter passenger last name");
			npassenger.setLastName(scan.nextLine());
			System.out.println("Enter passenger Date of Birth");
			npassenger.setDateOfBirth(scan.nextLine());
			System.out.println("Enter passenger gender");
			npassenger.setGender(scan.nextLine());
			System.out.println("Enter passenger address");
			npassenger.setAddress(scan.nextLine());
			serv.addPassenger(npassenger);
			break;
		case "Update":
			List<Passenger> passengers2 = new ArrayList<Passenger>();
			passengers2 = serv.readPassengers();
			int ct2 = 0;
			for (Passenger p : passengers2) {
				System.out.println(ct2 + "--" + p.toString());
				ct2++;
			}
			System.out.println("Select a passenger by index to update:");
			String input2 = scan.nextLine();
			Integer index2 = Integer.parseInt(input2);
			Passenger upassenger = new Passenger();
			upassenger.setPassId(passengers2.get(index2).getPassId());
			System.out.println("Enter passenger first name");
			upassenger.setFirstName(scan.nextLine());
			System.out.println("Enter passenger last name");
			upassenger.setLastName(scan.nextLine());
			System.out.println("Enter passenger Date of Birth");
			upassenger.setDateOfBirth(scan.nextLine());
			System.out.println("Enter passenger gender");
			upassenger.setGender(scan.nextLine());
			System.out.println("Enter passenger address");
			upassenger.setAddress(scan.nextLine());
			serv.updatePassenger(upassenger);
			break;
		case "Delete":
			List<Passenger> passenger3 = new ArrayList<Passenger>();
			passenger3 = serv.readPassengers();
			int ct3 = 0;
			for (Passenger p : passenger3) {
				System.out.println(ct3 + "--" + p.toString());
				ct3++;
			}
			System.out.println("Select a passenger by index to delete:");
			String input3 = scan.nextLine();
			Integer index3 = Integer.parseInt(input3);
			serv.deletePassenger(passenger3.get(index3));
			break;
		case "Read":
			List<Passenger> passengers4 = new ArrayList<Passenger>();
			passengers4 = serv.readPassengers();
			for (Passenger p : passengers4)
				System.out.println(p.toString());
			break;
		}
	}

	public static void adminAirportConsole() throws SQLException {
		Scanner scan = new Scanner(System.in);
		AdminService serv = new AdminService();
		System.out.println("What operation would you like to perform on airports?");
		String in = scan.nextLine();
		switch (in) {
		case "Add":
			Airport nairport = new Airport();
			System.out.println("What is the new Airport Code?");
			nairport.setAirportCode(scan.nextLine());
			System.out.println("What is the new Airport City Location?");
			nairport.setCityName(scan.nextLine());
			serv.addAirport(nairport);
			break;
		case "Update":
			List<Airport> airports2 = new ArrayList<Airport>();
			airports2 = serv.readAirports();
			int ct1 = 0;
			for (Airport a : airports2) {
				System.out.println(ct1 + "--" + a.toString());
				ct1++;
			}
			System.out.println("Select an airport by index to update:");
			String input2 = scan.nextLine();
			Integer index2 = Integer.parseInt(input2);
			Airport uairport = new Airport();
			uairport.setAirportCode(airports2.get(index2).getAirportCode());
			System.out.println("Enter the Airport city location");
			uairport.setCityName(scan.nextLine());
			serv.updateAirport(uairport);
			break;
		case "Delete":
			List<Airport> airports3 = new ArrayList<Airport>();
			airports3 = serv.readAirports();
			int ct3 = 0;
			for (Airport a : airports3) {
				System.out.println(ct3 + "--" + a.toString());
				ct3++;
			}
			System.out.println("Select an airport by index to delete:");
			String input3 = scan.nextLine();
			Integer index3 = Integer.parseInt(input3);
			serv.deleteAirport(airports3.get(index3));
			break;
		case "Read":
			List<Airport> airports = new ArrayList<Airport>();
			airports = serv.readAirports();
			for (Airport a : airports)
				System.out.println(a.toString());
			break;
		}
	}

	public static void adminBUsersConsole() throws SQLException {
		Scanner scan = new Scanner(System.in);
		AdminService serv = new AdminService();
		System.out.println("What operation would you like to perform on Travelers?");
		String in = scan.nextLine();
		switch (in) {
		case "Add":
			User nuser = new User();
			nuser.setRoleId(serv.getUserRole(3));
			System.out.println("What is the first name of this Traveler?");
			nuser.setFirstName(scan.nextLine());
			System.out.println("What is the last name of this Traveler?");
			nuser.setLastName(scan.nextLine());
			System.out.println("What is the username of this Traveler?");
			nuser.setUsername(scan.nextLine());
			System.out.println("What is the email of this Traveler?");
			nuser.setEmail(scan.nextLine());
			System.out.println("What is the pasword of this Traveler?");
			nuser.setPassword(scan.nextLine());
			System.out.println("What is the phone number of this Traveler?");
			nuser.setPhoneNumber(scan.nextLine());
			serv.addBUser(nuser);
			break;
		case "Update":
			List<User> users2 = new ArrayList<User>();
			users2 = serv.readBUsers();
			int ct2 = 0;
			for (User u : users2) {
				System.out.println(ct2 + "--" + u.toString());
				ct2++;
			}
			System.out.println("Select a Traveler by index to update:");
			String input2 = scan.nextLine();
			Integer index2 = Integer.parseInt(input2);
			User uuser = new User();
			uuser.setUserId(users2.get(index2).getUserId());
			uuser.setRoleId(serv.getUserRole(3));
			System.out.println("What is the first name of this Traveler?");
			uuser.setFirstName(scan.nextLine());
			System.out.println("What is the last name of this Traveler?");
			uuser.setLastName(scan.nextLine());
			System.out.println("What is the username of this Traveler?");
			uuser.setUsername(scan.nextLine());
			System.out.println("What is the email of this Traveler?");
			uuser.setEmail(scan.nextLine());
			System.out.println("What is the pasword of this Traveler?");
			uuser.setPassword(scan.nextLine());
			System.out.println("What is the phone number of this Traveler?");
			uuser.setPhoneNumber(scan.nextLine());
			serv.updateBUser(uuser);
			break;
		case "Delete":
			List<User> users3 = new ArrayList<User>();
			users3 = serv.readBUsers();
			int ct3 = 0;
			for (User u : users3) {
				System.out.println(ct3 + "--" + u.toString());
				ct3++;
			}
			System.out.println("Select a Traveler by index to delete:");
			String input3 = scan.nextLine();
			Integer index3 = Integer.parseInt(input3);
			serv.deleteBUser(users3.get(index3));
			break;
		case "Read":
			List<User> users4 = new ArrayList<User>();
			users4 = serv.readBUsers();
			for (User u : users4)
				System.out.println(u.toString());
			break;
		}
	}

	public static void adminAgentsConsole() throws SQLException {
		Scanner scan = new Scanner(System.in);
		AdminService serv = new AdminService();
		System.out.println("What operation would you like to perform on Employees?");
		String in = scan.nextLine();
		switch (in) {
		case "Add":
			User nagent = new User();
			nagent.setRoleId(serv.getUserRole(2));
			System.out.println("What is the first name of this Employee?");
			nagent.setFirstName(scan.nextLine());
			System.out.println("What is the last name of this Employee?");
			nagent.setLastName(scan.nextLine());
			System.out.println("What is the username of this Employee?");
			nagent.setUsername(scan.nextLine());
			System.out.println("What is the email of this Employee?");
			nagent.setEmail(scan.nextLine());
			System.out.println("What is the pasword of this Employee?");
			nagent.setPassword(scan.nextLine());
			System.out.println("What is the phone number of this Employee?");
			nagent.setPhoneNumber(scan.nextLine());
			serv.addAgent(nagent);
			break;
		case "Update":
			List<User> agents2 = new ArrayList<User>();
			agents2 = serv.readAgents();
			int ct2 = 0;
			for (User u : agents2) {
				System.out.println(ct2 + "--" + u.toString());
				ct2++;
			}
			System.out.println("Select an Employee by index to update:");
			String input2 = scan.nextLine();
			Integer index2 = Integer.parseInt(input2);
			User uagent = new User();
			uagent.setUserId(agents2.get(index2).getUserId());
			uagent.setRoleId(serv.getUserRole(2));
			System.out.println("What is the first name of this Employee?");
			uagent.setFirstName(scan.nextLine());
			System.out.println("What is the last name of this Employee?");
			uagent.setLastName(scan.nextLine());
			System.out.println("What is the username of this Employee?");
			uagent.setUsername(scan.nextLine());
			System.out.println("What is the email of this Employee?");
			uagent.setEmail(scan.nextLine());
			System.out.println("What is the pasword of this Employee?");
			uagent.setPassword(scan.nextLine());
			System.out.println("What is the phone number of this Employee?");
			uagent.setPhoneNumber(scan.nextLine());
			serv.updateAgent(uagent);
			break;
		case "Delete":
			List<User> agents3 = new ArrayList<User>();
			agents3 = serv.readAgents();
			int ct = 0;
			for (User u : agents3) {
				System.out.println(ct + "--" + u.toString());
				ct++;
			}
			System.out.println("Select an Employee by index to delete:");
			String input = scan.nextLine();
			Integer index = Integer.parseInt(input);
			serv.deleteAgent(agents3.get(index));
			break;
		case "Read":
			List<User> agents4 = new ArrayList<User>();
			agents4 = serv.readAgents();
			for (User a : agents4)
				System.out.println(a.toString());
			break;
		}
	}
	
	private static void adminTripOverideConsole() throws SQLException {
		Scanner scan = new Scanner(System.in);
		AdminService serv = new AdminService();
		List<Booking> bookings = new ArrayList<Booking>();
		bookings = serv.readBookingOveride();
		int ct = 0;
		for (Booking b : bookings) {
			System.out.println(ct + "--" + b.toString());
			ct++;
		}
		System.out.println("What Trip would you like to Overide?");
		String in = scan.nextLine();
		Integer index = Integer.parseInt(in);
		serv.tripOveride(bookings.get(index));
	}
}
