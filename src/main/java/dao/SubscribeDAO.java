package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import beans.Prospect;
import utils.JdbcUtils;
@Repository
public class SubscribeDAO {

	public void createSubscriber(Prospect prospect)throws Exception{
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sqlQuery = "insert into subscribers (email,date)values(?,?)";
			preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, prospect.getEmail());
			preparedStatement.setString(2, prospect.getRegistrationDate());

			preparedStatement.executeUpdate();

		}catch(Exception e) {
			throw new Exception("Couldn't create subscriber");
		}
		finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}
	public Prospect getSubscriber(String email) throws Exception{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet=null;

		try {
			connection = JdbcUtils.getConnection();
			String sqlQuery ="select * from subscribers where email =?";
			preparedStatement=connection.prepareStatement(sqlQuery);

			preparedStatement.setString(1, email);

			resultSet= preparedStatement.executeQuery();
			Prospect subscriber = null;
			while(resultSet.next()) {
				subscriber = createProspectFromResultSet(resultSet);
			}
			return subscriber;
		}catch(Exception e) {
			throw new Exception("Couldn't get prospect: "+email);
		}
		finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
	}
	public List<Prospect> allSubscribers() throws Exception{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet=null;

		try {
			connection = JdbcUtils.getConnection();
			String sqlQuery ="select * from subscribers";
			preparedStatement=connection.prepareStatement(sqlQuery);

			resultSet= preparedStatement.executeQuery();
			List<Prospect> allSubscriber = new ArrayList<Prospect>();
			while(resultSet.next()) {
				allSubscriber.add(createProspectFromResultSet(resultSet));
			}
			return allSubscriber;
		}catch (Exception e) {
			throw new Exception("Couldn't get all subscribers");
		}
		finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
	}
	private Prospect createProspectFromResultSet(ResultSet resultSet) throws SQLException {
		Prospect prospect = new Prospect();
		while(resultSet.next()) {
			prospect.setEmail(resultSet.getString("email"));
			prospect.setRegistrationDate(resultSet.getString("date"));
		}
		return prospect;
	}
}
