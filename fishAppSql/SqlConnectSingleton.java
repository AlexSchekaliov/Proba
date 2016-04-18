package fishAppSql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnectSingleton {

	private static SqlConnectSingleton instance; // Singleton
	private Connection connection;
	private final static String connectionUrl = "jdbc:sqlserver://localhost; user=sa; password=Index_1234;";

	private SqlConnectSingleton() {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(connectionUrl);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public static SqlConnectSingleton getInstance() {
		if (instance == null) {
			instance = new SqlConnectSingleton();
		}
		return instance;
	}

	public Connection getConnection() {

		return connection;
	}

	public void closeConnection() {
		instance = null;
	}
}