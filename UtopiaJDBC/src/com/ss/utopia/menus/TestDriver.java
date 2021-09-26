package com.ss.utopia.menus;

import java.sql.SQLException;

import com.ss.utopia.service.AdminService;

public class TestDriver {

	public static void main(String[] args) throws SQLException {
		AdminService serv = new AdminService();
		serv.readRoutes();
	}
}
