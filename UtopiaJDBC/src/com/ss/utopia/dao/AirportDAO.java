package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Route;

public class AirportDAO extends BaseDAO<Airport> {

	public AirportDAO(Connection conn) {
		super(conn);
	}
	
	public void addAirport(Airport airport) throws ClassNotFoundException, SQLException {
		save("INSERT INTO airport (iata_id, city) VALUES (?, ?)", new Object[] {
				airport.getAirportCode(), airport.getCityName() });
	}

	public void updateAirport(Airport airport) throws ClassNotFoundException, SQLException {
		save("UPDATE airport set city = ? WHERE iata_id = ?",
				new Object[] {airport.getCityName(), airport.getAirportCode()});
	}

	public void deleteAirport(Airport airport) throws ClassNotFoundException, SQLException {
		save("Delete airport where id = ?", new Object[] { airport.getAirportCode() });
	}

	public List<Airport> readAirport() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM airport", null);
	}

	@Override
	protected List<Airport> extractData(ResultSet rs) throws SQLException {
		List<Airport> airports = new ArrayList<>();

		while (rs.next()) {
			Airport airport = new Airport();
			airport.setAirportCode(rs.getString("iata_id"));
			airport.setCityName(rs.getString("city"));
			airports.add(airport);
		}
		return airports;
	}
}
