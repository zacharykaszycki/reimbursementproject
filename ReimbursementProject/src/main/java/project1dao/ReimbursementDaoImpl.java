package project1dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import project1models.Reimbursement;
import project1models.User;

public class ReimbursementDaoImpl implements ReimbursementDao {
	String url = "jdbc:postgresql://revbase.ctlzafcs0hn5.us-east-2.rds.amazonaws.com/ersdb";
	String username = "revbase";
	String password = "p4ssw0rd";

//	public void addNewReimbursement(Reimbursement newReim) {
//		try(Connection conn = CustomConnectionFactory.getConnection()){
//			String sql = "INSERT INTO ers_reimbursement VALUES(DEFAULT, ?, DEFAULT, DEFAULT, ?, ?, ?, DEFAULT, DEFAULT, (SELECT reimb_type_id FROM ers_reimbursement_type B WHERE B.reimb_type = ?));";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setDouble(1, newReim.getReimbAmount());
//			ps.setString(2, newReim.getReimbDescription());
//			ps.setBytes(3, newReim.getReimbReceipt());
//			ps.setInt(4, newReim.getReimbAuthor());
//			ps.setString(5, newReim.getReimbTypeId());
//			ps.executeUpdate();
//
//		}catch(SQLException e) {
//			e.printStackTrace();
//			UserDaoImpl.loggy.error("SQL exception has been triggered", e);
//		}
//		
//	}
	
	public void addNewReimbursement(Reimbursement newReim, int id) {
		try(Connection conn = CustomConnectionFactory.getConnection()){
			String sql = "INSERT INTO ers_reimbursement VALUES(DEFAULT, ?, DEFAULT, DEFAULT, ?, ?, ?, DEFAULT, DEFAULT, (SELECT reimb_type_id FROM ers_reimbursement_type B WHERE B.reimb_type = ?));";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, newReim.getReimbAmount());
			ps.setString(2, newReim.getReimbDescription());
			ps.setBytes(3, newReim.getReimbReceipt());
			ps.setInt(4, id);
			ps.setString(5, newReim.getReimbTypeId());
			ps.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
			UserDaoImpl.loggy.error("SQL exception has been triggered", e);
		}
		
	}

//	@Override
//	public List<Reimbursement> getUsersReimbursements(User us) {
////		System.out.println("In Get All Reimb");
//		List<Reimbursement> userReimb = new ArrayList<>();
//		try(Connection conn = CustomConnectionFactory.getConnection()){
//			String sql = "SELECT A.reimb_id, A.reimb_amount, A.reimb_submitted, A.reimb_resolved, A.reimb_description, A.reimb_receipt, A.reimb_author, A.reimb_resolver, B.reimb_status, C.reimb_type\r\n"
//					+ "FROM ers_reimbursement A INNER JOIN ers_reimbursement_status B ON A.reimb_status_id = B.reimb_status_id\r\n"
//					+ "INNER JOIN ers_reimbursement_type C ON A.reimb_type_id = C.reimb_type_id"
//					+ "INNER JOIN ers_users D ON A.reimb_author = D.ers_users_id"
//					+ "INNER JOIN ers_users D ON A.reimb_author = D.ers_users_id"
//					+ " WHERE A.reimb_author = ? ORDER BY A.reimb_id DESC;";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, us.getErsUsersId());
//			
//			ResultSet rs = ps.executeQuery();
//			while(rs.next())
//			{
//				userReimb.add(new Reimbursement((Integer) rs.getInt(1),(Double) rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBytes(6),(Integer) rs.getInt(7),(Integer) rs.getInt(8), rs.getString(9), rs.getString(10)));
//			}
//
//		}catch(SQLException e) {
//			e.printStackTrace();
//			UserDaoImpl.loggy.error("SQL exception has been triggered", e);
//		}
//		for(Reimbursement re : userReimb)
//			re.shrinkDates();
//		return userReimb;
//	}


	@Override
	public List<Reimbursement> getUsersReimbursements(User us) {
//		System.out.println("In Get All Reimb");
		List<Reimbursement> userReimb = new ArrayList<>();
		try(Connection conn = CustomConnectionFactory.getConnection()){
			String sql = "SELECT A.reimb_id, A.reimb_amount, A.reimb_submitted, A.reimb_resolved, A.reimb_description, A.reimb_receipt, D.user_first_name,  D.user_last_name, E.user_first_name, E.user_last_name, B.reimb_status, C.reimb_type\r\n"
					+ "FROM ers_reimbursement A INNER JOIN ers_reimbursement_status B ON A.reimb_status_id = B.reimb_status_id\r\n"
					+ "INNER JOIN ers_reimbursement_type C ON A.reimb_type_id = C.reimb_type_id\r\n"
					+ "INNER JOIN ers_users D ON A.reimb_author = D.ers_users_id\r\n"
					+ "LEFT JOIN ers_users E ON A.reimb_resolver = E.ers_users_id\r\n"
					+ " WHERE A.reimb_author = ? ORDER BY A.reimb_id DESC;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, us.getErsUsersId());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				if (rs.getString(9) == null)
					userReimb.add(new Reimbursement((Integer) rs.getInt(1),(Double) rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBytes(6),(rs.getString(7) +" " + rs.getString(8)), (rs.getString(9)), rs.getString(11), rs.getString(12)));				
				else
					userReimb.add(new Reimbursement((Integer) rs.getInt(1),(Double) rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBytes(6), (rs.getString(7) +" " + rs.getString(8)), (rs.getString(9) +" " + rs.getString(10)), rs.getString(11), rs.getString(12)));
			}

		}catch(SQLException e) {
			e.printStackTrace();
			UserDaoImpl.loggy.error("SQL exception has been triggered", e);
		}
		for(Reimbursement re : userReimb)
			re.shrinkDates();
		return userReimb;
	}
	
	
//	@Override
//	public List<Reimbursement> getAllReimbursements() {
//		System.out.println("In Get All Reimb");
//		List<Reimbursement> allReimb = new ArrayList<>();
//		try(Connection conn = CustomConnectionFactory.getConnection()){
//			String sql = "SELECT A.reimb_id, A.reimb_amount, A.reimb_submitted, A.reimb_resolved, A.reimb_description, A.reimb_receipt, A.reimb_author, A.reimb_resolver, B.reimb_status, C.reimb_type\r\n"
//					+ "FROM ers_reimbursement A INNER JOIN ers_reimbursement_status B ON A.reimb_status_id = B.reimb_status_id\r\n"
//					+ "INNER JOIN ers_reimbursement_type C ON A.reimb_type_id = C.reimb_type_id ORDER BY A.reimb_id DESC;";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			
//			ResultSet rs = ps.executeQuery();
//			while(rs.next())
//			{
//				allReimb.add(new Reimbursement((Integer) rs.getInt(1),(Double) rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBytes(6),(Integer) rs.getInt(7),(Integer) rs.getInt(8), rs.getString(9), rs.getString(10)));
//			}
//
//		}catch(SQLException e) {
//			e.printStackTrace();
//			UserDaoImpl.loggy.error("SQL exception has been triggered", e);
//		}
//		for(Reimbursement re : allReimb)
//			re.shrinkDates();
//		return allReimb;
//	}
	
	@Override
	public List<Reimbursement> getAllReimbursements() {
		System.out.println("In Get All Reimb");
		List<Reimbursement> allReimb = new ArrayList<>();
		try(Connection conn = CustomConnectionFactory.getConnection()){
			String sql = "SELECT A.reimb_id, A.reimb_amount, A.reimb_submitted, A.reimb_resolved, A.reimb_description, A.reimb_receipt, D.user_first_name,  D.user_last_name, E.user_first_name, E.user_last_name, B.reimb_status, C.reimb_type\r\n"
					+ "FROM ers_reimbursement A INNER JOIN ers_reimbursement_status B ON A.reimb_status_id = B.reimb_status_id\r\n"
					+ "INNER JOIN ers_reimbursement_type C ON A.reimb_type_id = C.reimb_type_id\r\n"
					+ "INNER JOIN ers_users D ON A.reimb_author = D.ers_users_id\r\n"
					+ "LEFT JOIN ers_users E ON A.reimb_resolver = E.ers_users_id ORDER BY A.reimb_id DESC;";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				if (rs.getString(9) == null)
					allReimb.add(new Reimbursement((Integer) rs.getInt(1),(Double) rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBytes(6),(rs.getString(7) +" " + rs.getString(8)), (rs.getString(9)), rs.getString(11), rs.getString(12)));				
				else
					allReimb.add(new Reimbursement((Integer) rs.getInt(1),(Double) rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBytes(6),(rs.getString(7) +" " + rs.getString(8)), (rs.getString(9) +" " + rs.getString(10)), rs.getString(11), rs.getString(12)));
			}

		}catch(SQLException e) {
			e.printStackTrace();
			UserDaoImpl.loggy.error("SQL exception has been triggered", e);
		}
		for(Reimbursement re : allReimb)
			re.shrinkDates();
		return allReimb;
	}
	
	public void changeApproval(Integer id, String approval, Integer approver) {
		try(Connection conn = CustomConnectionFactory.getConnection()){
			String sql = "UPDATE ers_reimbursement SET reimb_status_id = (SELECT reimb_status_id FROM ers_reimbursement_status WHERE reimb_status = ?), reimb_resolved = CURRENT_TIMESTAMP, reimb_resolver = ? WHERE reimb_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, approval);
			ps.setInt(2, approver);
			ps.setInt(3, id);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			UserDaoImpl.loggy.error("SQL exception has been triggered", e);
		}
		
	}
	

	@Override
	public List<Reimbursement> getUncheckedReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resolveReimb(Integer userId, Integer newStatus) {
		// TODO Auto-generated method stub
		
	}

	
	
}
