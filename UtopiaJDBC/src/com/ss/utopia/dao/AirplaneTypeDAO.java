package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.AirplaneType;
import com.ss.utopia.entity.Airport;

public class AirplaneTypeDAO extends BaseDAO<AirplaneType> {

	public AirplaneTypeDAO(Connection conn) {
		super(conn);
	}
	
	public void addAirplaneType(AirplaneType type) throws ClassNotFoundException, SQLException {
		save("INSERT INTO airplane_type (max_capacity) VALUES (?)", new Object[] {type.getMaxCapacity() });
	}

	public void updateAirplaneType(AirplaneType type) throws ClassNotFoundException, SQLException {
		save("UPDATE airplane_type set max_capacity = ? WHERE id = ?",
				new Object[] {type.getMaxCapacity(), type.getTypeId()});
	}

	public void deleteAirplaneType(AirplaneType type) throws ClassNotFoundException, SQLException {
		save("Delete airplane_type where id = ?", new Object[] { type.getTypeId() });
	}

	public List<AirplaneType> readAirplaneType() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM airplane_type", null);
	}

	@Override
	protected List<AirplaneType> extractData(ResultSet rs) throws SQLException {
		List<AirplaneType> types = new ArrayList<>();

		while (rs.next()) {
			AirplaneType type = new AirplaneType();
			type.setTypeId(rs.getInt("id"));
			type.setMaxCapacity(rs.getInt("max_capacity"));
			types.add(type);
		}
		return types;
	}
}
