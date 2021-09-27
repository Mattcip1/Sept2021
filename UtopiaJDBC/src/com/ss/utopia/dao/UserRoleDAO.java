package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.UserRole;

public class UserRoleDAO extends BaseDAO<UserRole> {

	public UserRoleDAO(Connection conn) {
		super(conn);
	}

	public void addUserRole(UserRole role) throws ClassNotFoundException, SQLException {
		save("INSERT INTO user_role (name) VALUES (?)", new Object[] {
				role.getName()});
	}

	public void updateUserRole(UserRole role) throws ClassNotFoundException, SQLException {
		save("UPDATE user_role set name = ? WHERE id = ?",
				new Object[] {role.getName(), role.getRoleId()});
	}

	public void deleteUserRole(UserRole role) throws ClassNotFoundException, SQLException {
		save("Delete user_role where id = ?", new Object[] { role.getRoleId() });
	}

	public List<UserRole> readUserRole() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM user_role", null);
	}
	
	public List<UserRole> getUserRole() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM user_role WHERE id = 3", null);
	}
	
	public List<UserRole> getAgentRole() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM user_role WHERE id = 2", null);
	}

	@Override
	protected List<UserRole> extractData(ResultSet rs) throws SQLException {
		List<UserRole> roles = new ArrayList<>();

		while (rs.next()) {
			UserRole role = new UserRole();
			role.setRoleId(rs.getInt("id"));
			role.setName(rs.getString("name"));
			roles.add(role);
		}
		return roles;
	}
}
