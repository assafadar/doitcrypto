package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import beans.Lead;
import utils.HibernateUtils;

@Repository
public class RegisterDAO {
	private Session session;

	public void CreateLead(Lead lead)throws Exception{
		session = getHibernateSession();
		session.beginTransaction();
		session.persist(lead);
		session.getTransaction().commit();

		/* 
		 * JDBC CODE
		 * */
		//			Connection connection=null ;
		//			PreparedStatement preparedStatement=null;
		//			try {
		//				connection = JdbcUtils.getConnection();
		//				
		//				String sqlQuery ="insert into leads(first_name,level,country,email,phone,date)values(?,?,?,?,?,?)";
		//				preparedStatement=connection.prepareStatement(sqlQuery);
		//				
		//				preparedStatement.setString(1, lead.getFullName());
		//				preparedStatement.setString(3, lead.getCountry());
		//				preparedStatement.setString(4, lead.getEmail());
		//				preparedStatement.setString(5, lead.getPhone());
		//				preparedStatement.setString(6, lead.getRegistrationDate());
		//				
		//				preparedStatement.executeUpdate();
		//			}catch (Exception e) {
		//				throw new Exception("Couldn't completet registration");
		//			}
		//			finally {
		//				JdbcUtils.closeResources(connection, preparedStatement);
		//			}
	}

	public Lead getLead(long id) throws Exception{
		session = getHibernateSession();
		session.beginTransaction();
		String q = "from Lead where id=?";
		Query query = session.createQuery(q);
		query.setLong(0, id);
		Lead lead = (Lead)query.uniqueResult();
		session.getTransaction().commit();
		return lead;
		/* 
		 * JDBC CODE
		 * */

		//		Connection connection =null;
		//		PreparedStatement preparedStatement = null;
		//		ResultSet resultSet=null;
		//		try {
		//			connection = JdbcUtils.getConnection();
		//			String sqlQuer ="select * from leads where id=?";
		//			preparedStatement = connection.prepareStatement(sqlQuer);
		//			preparedStatement.setLong(1, id);
		//			resultSet = preparedStatement.executeQuery();
		//			Lead lead = null;
		//			while(resultSet.next()) {
		//				lead = getLeadDetails(resultSet);
		//			}
		//			return lead;
		//
		//		}catch (Exception e) {
		//			throw new Exception("Coudln't get Lead");
		//		}
		//		finally {
		//			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		//		}
	}

	//	//private Lead getLeadDetails(ResultSet resultSet) throws SQLException {
	//		Lead lead = new Lead();
	//		lead.setId(resultSet.getInt("id"));
	//		lead.setFullName(resultSet.getString("first_name"));
	//		lead.setCountry(resultSet.getString("country"));
	//		lead.setPhone(resultSet.getString("phone"));
	//		lead.setEmail(resultSet.getString("email"));
	//		lead.setRegistrationDate(resultSet.getString("date"));
	//		return lead;
	//	}
	public List<Lead> getAllLeads() throws Exception{
		session = getHibernateSession();
		session.beginTransaction();
		List<Lead> allLeads=(List<Lead>) session.createQuery("from Lead").list();
		session.getTransaction().commit();
		return allLeads;

		/* 
		 * JDBC CODE
		 * */
		//		
		//		Connection connection=null;
		//		PreparedStatement preparedStatement = null;
		//		ResultSet resultSet = null;
		//		try {
		//			connection = JdbcUtils.getConnection();
		//			String sqlQuery="select * from leads";
		//			preparedStatement=connection.prepareStatement(sqlQuery);
		//			resultSet = preparedStatement.executeQuery();
		//			List<Lead>allLeads = new ArrayList<Lead>();
		//			while(resultSet.next()) {
		//				allLeads.add(getLeadDetails(resultSet));
		//			}
		//			return allLeads;
		//
		//		}catch(Exception e) {
		//			throw new Exception("Coudlnt get all leads");
		//		}
		//		finally {
		//			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		//		}
	}

	public void validateUser(String phoneFromOTP) throws Exception {

		session = getHibernateSession();
		session.beginTransaction();
		Query q = session.createQuery("update Lead set activated = true "
				+ "where phone= ?");
		q.setParameter(0, phoneFromOTP);
		q.executeUpdate();
		session.getTransaction().commit();

		/* 
		 * JDBC CODE
		 * */
		//		Connection connection =null;
		//		PreparedStatement preparedStatement=null;
		//		
		//		try {
		//			connection = JdbcUtils.getConnection();
		//			String sqlQuery = "update leads set otp=true where phone=?";
		//			preparedStatement = connection.prepareStatement(sqlQuery);
		//			preparedStatement.setString(1, phoneFromOTP);
		//			preparedStatement.executeUpdate();
		//		}catch(Exception e) {
		//			throw new Exception("Couldn't validate OTP");
		//		}
		//		finally {
		//			JdbcUtils.closeResources(connection, preparedStatement);
		//		}
	}
	private Session getHibernateSession() throws HibernateException, Exception {
		return HibernateUtils.getSessionFactory().openSession();
	}	

}
