package JavaBasicWk1Cap;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public /* static */ class SingletonFix {

	private static Connection conn = null;

	// thread safe
	volatile private static SingletonFix instance = null;

	// Constructor must be private.
	private SingletonFix() {

	}

	public static SingletonFix getInstance() {
		// thread safe and only one instance is created.
		synchronized (instance) {
			if(instance == null) {
				instance = new SingletonFix();
			}
		}
		return instance;
	}
}
