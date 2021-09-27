package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Route;

public class RouteDAO extends BaseDAO<Route> {

	public RouteDAO(Connection conn) {
		super(conn);
	}

	public Integer addRoute(Route route) throws ClassNotFoundException, SQLException {
		return saveWithPK("INSERT INTO route (origin_id, destination_id) VALUES (?, ?)", new Object[] {
				route.getOriginAirport().getAirportCode(), route.getDestinationAirport().getAirportCode() });
	}

	public void updateRoute(Route route) throws ClassNotFoundException, SQLException {
		save("UPDATE route set origin_id = ? AND destination_id = ? WHERE id = ?",
				new Object[] { route.getOriginAirport().getAirportCode(),
						route.getDestinationAirport().getAirportCode(), route.getRouteId() });
	}

	public void deleteRoute(Route route) throws ClassNotFoundException, SQLException {
		save("Delete route where id = ?", new Object[] { route.getRouteId() });
	}

	public List<Route> readRoute() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM route", null);
	}
	
	public List<Route> readRouteById(Integer id) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM route WHERE id = ?", new Object[] {id});
	}

	public List<Route> readRouteByAirportCode(String airportCode) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM route WHERE origin_id = ? OR destination_id = ?",
				new Object[] { airportCode, airportCode });
	}

	@Override
	protected List<Route> extractData(ResultSet rs) throws SQLException {
		List<Route> routes = new ArrayList<>();

		while (rs.next()) {
			Route route = new Route();
			route.setRouteId(rs.getInt("id"));
			route.setOriginAirport(new Airport());
			route.getOriginAirport().setAirportCode(rs.getString("origin_id"));
			route.setDestinationAirport(new Airport());
			route.getDestinationAirport().setAirportCode(rs.getString("destination_id"));
			routes.add(route);
		}
		return routes;
	}
}
