/**
 * 
 */
package com.ss.utopia.menus;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.dao.RouteDAO;
import com.ss.utopia.entity.Airport;
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
		switch(in) {
		case "1" :
			Driver.adminConsole();
			break;
		case "2" :
			System.out.println("Hello Agent");
			break;
		case "3" :
			System.out.println("Hello Traveler");
			break;
		}
			
	}

	public static void adminConsole() throws SQLException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Add/Update/Delete/Read Flights - Enter 1");
		System.out.println("Add/Update/Delete/Read Seats - Enter 2");
		System.out.println("Add/Update/Delete/Read Tickets and Passengers - Enter 3");
		System.out.println("Add/Update/Delete/Read Airports - Enter 4");
		System.out.println("Add/Update/Delete/Read Travelers - Enter 5");
		System.out.println("Add/Update/Delete/Read Employess - Enter 6");
		System.out.println("Over-ride Trip Cancellation for a ticket - Enter 7");
		String in = scan.nextLine();
		switch(in) {
		case "1" :
			Driver.adminFlightConsole();
			break;
		case "2" :
			Driver.adminSeatsConsole();
			break;
		case "3" :
			Driver.adminPassengerConsole();
			break;
		case "4" :
			Driver.adminAirportConsole();
			break;
		case "5" :
			Driver.adminBUsersConsole();
			break;
		case "6" :
			Driver.adminAgentsConsole();
			break;
		case "7" :
			break;
		}
	}

	public static void adminFlightConsole() throws SQLException {
		Scanner scan = new Scanner(System.in);
		AdminService serv = new AdminService();
		System.out.println("What operation would you like to perform on flights?");
		String in = scan.nextLine();
		switch(in) {
		case "Add" :
			System.out.println("Enter Origin Airport:");
			break;
		case "Update" :
			break;
		case "Delete" :
			List<Flight> flights1 = new ArrayList<Flight>();
			flights1 = serv.readFlight();
			int ct = 0;
			for(Flight f: flights1) {
				System.out.println(ct + "--" + f.toString());
				ct++;
			}
			System.out.println("Select a flight by index to delete:");
			String input = scan.nextLine();
			Integer index = Integer.parseInt(input);
			serv.deleteFlight(flights1.get(index));
			break;
		case "Read" :
			List<Flight> flights2 = new ArrayList<Flight>();
			flights2 = serv.readFlight();
			for(Flight f: flights2)
				System.out.println(f.toString());
			break;
		}
	}
	
	public static void adminSeatsConsole() throws SQLException {
		Scanner scan = new Scanner(System.in);
		AdminService serv = new AdminService();
		System.out.println("What operation would you like to perform on Seats?");
		String in = scan.nextLine();
		switch(in) {
		case "Add" :
			break;
		case "Update" :
			break;
		case "Delete" :
			break;
		case "Read" :
			List<Flight> flights = new ArrayList<Flight>();
			flights = serv.readSeats();
			for(Flight f: flights)
				System.out.println("Flight #: " + f.getFlightId() + " Reserved Seats: " + f.getResvSeats());
			break;
		}
	}
	
	public static void adminPassengerConsole() throws SQLException {
		Scanner scan = new Scanner(System.in);
		AdminService serv = new AdminService();
		System.out.println("What operation would you like to perform on Passengers?");
		String in = scan.nextLine();
		switch(in) {
		case "Add" :
			break;
		case "Update" :
			break;
		case "Delete" :
			break;
		case "Read" :
			List<Passenger> passengers = new ArrayList<Passenger>();
			passengers = serv.readPassengers();
			for(Passenger p: passengers)
				System.out.println(p.toString());
			break;
		}
	}
	
	public static void adminAirportConsole() throws SQLException {
		Scanner scan = new Scanner(System.in);
		AdminService serv = new AdminService();
		System.out.println("What operation would you like to perform on airports?");
		String in = scan.nextLine();
		switch(in) {
		case "Add" :
			break;
		case "Update" :
			break;
		case "Delete" :
			break;
		case "Read" :
			List<Airport> airports = new ArrayList<Airport>();
			airports = serv.readAirports();
			for(Airport a: airports)
				System.out.println(a.toString());
			break;
		}
	}
	
	public static void adminBUsersConsole() throws SQLException {
		Scanner scan = new Scanner(System.in);
		AdminService serv = new AdminService();
		System.out.println("What operation would you like to perform on Travelers?");
		String in = scan.nextLine();
		switch(in) {
		case "Add" :
			break;
		case "Update" :
			break;
		case "Delete" :
			break;
		case "Read" :
			List<User> users = new ArrayList<User>();
			users = serv.readBUsers();
			for(User u: users)
				System.out.println(u.toString());
			break;
		}
	}
	
	public static void adminAgentsConsole() throws SQLException {
		Scanner scan = new Scanner(System.in);
		AdminService serv = new AdminService();
		System.out.println("What operation would you like to perform on Employees?");
		String in = scan.nextLine();
		switch(in) {
		case "Add" :
			break;
		case "Update" :
			break;
		case "Delete" :
			break;
		case "Read" :
			List<User> agents = new ArrayList<User>();
			agents = serv.readAgents();
			for(User a: agents)
				System.out.println(a.toString());
			break;
		}
	}
}
