package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Airplane;
import com.ss.utopia.entity.Airport;

public class AirplaneDAO extends BaseDAO<Airplane> {

	public AirplaneDAO(Connection conn) {
		super(conn);
	}
	
	public void addAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
		save("INSERT INTO airplane (type_id) VALUES (?)", new Object[] {airplane.getTypeId()});
	}

	public void updateAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
		save("UPDATE airplane set type_id = ? WHERE id = ?",
				new Object[] {airplane.getTypeId(), airplane.getAirplaneId()});
	}

	public void deleteAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
		save("Delete airplane where id = ?", new Object[] { airplane.getAirplaneId() });
	}

	public List<Airplane> readAirport() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM airplane", null);
	}

	@Override
	protected List<Airplane> extractData(ResultSet rs) throws SQLException {
		List<Airplane> airplanes = new ArrayList<>();

		while (rs.next()) {
			Airplane airplane = new Airplane();
			airplane.getTypeId().setTypeId(rs.getInt("type_id"));
			airplanes.add(airplane);
		}
		return airplanes;
	}
}
