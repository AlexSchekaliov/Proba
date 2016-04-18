package fishAppSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBOperation {

	private final static Connection connection = SqlConnectSingleton.getInstance().getConnection();
	private final static String SQL_QUERY_CREATE_DB = "CREATE DATABASE ";
	private final static String SQL_QUERY_DELITE_DB = "DROP DATABASE ";
	private final static String SQL_QUERY_GET_LIST_DB = "SELECT sysdatabases.name AS DBName "
			+ "FROM sysdatabases where sysdatabases.name LIKE 'FishAppDB%'";
	private final static ArrayList<String> listDB = new ArrayList<String>();

	public boolean CreateDB(String nameDB) {

		try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_CREATE_DB + nameDB)) {

			if (preparedStatement.executeUpdate() == 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean DeliteDB(String nameDB) {

		try (PreparedStatement preparedStatement = connection
				.prepareStatement(SQL_QUERY_DELITE_DB + nameDB)) {

			if (preparedStatement.executeUpdate() == 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<String> getListDBOnServer() {

		try (ResultSet result = connection
				.prepareStatement(SQL_QUERY_GET_LIST_DB).executeQuery()) {

			while (result.next()) {
				listDB.add(result.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listDB;
	}
}