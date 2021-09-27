package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.User;
import com.ss.utopia.entity.UserRole;

public class UserDAO extends BaseDAO<User> {

	public UserDAO(Connection conn) {
		super(conn);
	}

	public void addUser(User user) throws ClassNotFoundException, SQLException {
		save("INSERT INTO user (role_id, given_name, family_name, username, email, password, phone) VALUES (?, ?, ?, ?, ?, ?, ?)", new Object[] {
				user.getRoleId().getRoleId(), user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail(),
				user.getPassword(), user.getPhoneNumber()});
	}

	public void updateUser(User user) throws ClassNotFoundException, SQLException {
		save("UPDATE user set role_id = ?, given_name = ?, family_name = ?, username = ?, email = ?, password = ?, phone = ?  WHERE id = ?",
				new Object[] {user.getRoleId().getRoleId(), user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail(),
						user.getPassword(), user.getPhoneNumber(), user.getUserId()});
	}

	public void deleteUser(User user) throws ClassNotFoundException, SQLException {
		save("Delete from user where id = ?", new Object[] { user.getUserId() });
	}

	public List<User> readUser() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM user", null);
	}
	
	public List<User> readUserByRole(Integer in) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM user WHERE role_id = ?", new Object[] { in });
	}

	@Override
	protected List<User> extractData(ResultSet rs) throws SQLException {
		List<User> users = new ArrayList<>();

		while (rs.next()) {
			User user = new User();
			user.setUserId(rs.getInt("id"));
			user.setRoleId(new UserRole());
			user.getRoleId().setRoleId(rs.getInt("role_id"));
			user.setFirstName(rs.getString("given_name"));
			user.setLastName(rs.getString("family_name"));
			user.setUsername(rs.getString("username"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setPhoneNumber(rs.getString("phone"));
			users.add(user);
		}
		return users;
	}
}
