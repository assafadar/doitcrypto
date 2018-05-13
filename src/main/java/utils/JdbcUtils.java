package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtils {
	// Connection String
	public static Connection getConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection	connection = (Connection) DriverManager.getConnection("jdbc:mysql://mgs0iaapcj3p9srz.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/vcnbvkovdl4h6bz4?useSSL=false&serverTimezone=UTC","tk3esr1ljtmyc2wl","fiszudog1m8594w3");

		return connection;

	}
	
	// Close connection
		private static void closeConnection(Connection connection) throws Exception{
			if (connection!=null){
				try{

					connection.close();

				}catch (Exception e){

					throw new Exception("Couldn't close connection");
				}
			}

		}

		// Close prepared Satatement 
		private static void closePreparedStatement(PreparedStatement preparedStatement) throws Exception{
			if(preparedStatement!=null){
				try{

					preparedStatement.close();

				}catch (Exception e){

					throw new Exception("Couldn't close PreparedStatement");
				}
			}
		}

		// Close result set
		private static void closeResultSet(ResultSet resultSet)throws Exception{
			if (resultSet!=null){
				try {

					resultSet.close();

				} catch (Exception e) {

					throw new Exception("Clodn't close ResultSet");
				}
			}
		}

		// Close all open resources
		public static void closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) throws Exception{

			closeResultSet(resultSet);
			closePreparedStatement(preparedStatement);
			closeConnection(connection);
		}

		// Close all open resouces - option 2
		public static void closeResources(Connection connection, PreparedStatement preparedStatement) throws Exception{

			closePreparedStatement(preparedStatement);
			closeConnection(connection);
		}
}
