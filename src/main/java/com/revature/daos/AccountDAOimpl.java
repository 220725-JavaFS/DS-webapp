package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.revature.JsonMapper;
import com.revature.models.Account;
//import com.revature.models.CD;
import com.revature.utils.ConnectionUtil;

public class AccountDAOimpl implements AccountDAO {


//	
	
	@Override
	public Account updateAccount (Account account) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE accounts SET is_admin ="+ account.getIs_admin()+""
					+ ", is_support ="+ account.getIs_support()+""
					+ ", is_basic ="+ account.getIs_basic()+""
					+ ", user_firstname = '"+ account.getUser_firstname()+"'"
					+ ", user_lastname = '"+ account.getUser_lastname()+"'"
					+ ", user_password = '"+ account.getUser_password()+"'"
					+ " WHERE user_email = '"+account.getUser_email()+"';";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.execute();
		}
			 catch (SQLException e) {
			e.printStackTrace();
		}
	return account;
	}
	
	public void insertAccount(Account account) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			Account a = new Account();
			
			
			JsonMapper mapper = new JsonMapper();
			
			
			String sql = "INSERT INTO accounts (is_admin, is_support, is_basic, user_email, user_firstname,"
			+ "	user_lastname, user_password)" + " VALUES (?, ?, ?, ?, ?, ?, ?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count = 0;
			statement.setBoolean(++count, account.getIs_admin());
			statement.setBoolean(++count, account.getIs_support());
			statement.setBoolean(++count, account.getIs_basic());
			statement.setString(++count, account.getUser_email());
			statement.setString(++count, account.getUser_firstname());
			statement.setString(++count, account.getUser_lastname());
			statement.setString(++count, account.getUser_password());
			statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAccount(Account account) {
	    try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "DELETE FROM accounts WHERE user_email = '" + account.getUser_email() + "';";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.execute();

        }catch(SQLException e) {
            e.printStackTrace();
        }
		
	}
	
	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM accounts LEFT JOIN CDs ON CDs.user_email = accounts.user_email; ";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);

			List<Account> accountList = new LinkedList<Account>();

			while (result.next()) { // resultSets are curser based, each time .next called
									// curser goes to next group of values.
									// starts one before so need to call next.

				Account account = new Account(result.getBoolean("is_admin"), result.getBoolean("is_support"), 
						result.getBoolean("is_basic"), result.getString("user_email"),
						result.getString("user_firstname"), result.getString("user_lastname"),
						result.getString("user_password"));

//				String cdsDao = result.getString("user_email");
//				if (cdsDao != null) {
//				CD cd = new CD();
//					cd.setUser_email(result.getString("user_email"));
//					cd.setCd_deposit(result.getDouble("cd_deposit"));
//					cd.setCd_term(result.getInt("cd_term"));
//					cd.setCd_begin(result.getString("cd_begin"));
//					cd.setCd_rate(result.getDouble("cd_rate"));
//					cd.setCd_profit(result.getDouble("cd_profit"));
//					cd.setCd_end(result.getString("cd_end"));

				accountList.add(account);

			}
			return accountList;

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}
}

//@Override
//public Account getAccountByUser_email(String user_email) {
//	try (Connection conn = ConnectionUtil.getConnection()) {
//		String sql = "SELECT * FROM accounts WHERE user_email = " + "'" + user_email + "'" + ";";
//		Statement statement = conn.createStatement();
//		ResultSet result = statement.executeQuery(sql);
//
//		if (result.next()) { // resultSets are curser based, each time .next called
//								// curser goes to next group of values.
//								// starts one before so need to call next.
//
//			Account account = new Account(
//					result.getBoolean("is_admin"), 
//					result.getBoolean("is_support"),
//					result.getBoolean("is_basic"), 
//					result.getString("user_email"),
//					result.getString("user_firstname"), 
//					result.getString("user_lastname"),
//					result.getString("user_password"));
//			return account;
//		}
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//	return null;
//	
//}

//	@Override
//	public Account updateBasic (String user_email) {
//		try (Connection conn = ConnectionUtil.getConnection()) {
//			String sql = "UPDATE accounts SET is_basic = TRUE WHERE user_email = '"+user_email+"';"
//					   + "UPDATE accounts SET is_admin = FALSE WHERE user_email = '"+user_email+"';"
//					   + "UPDATE accounts SET is_support = FALSE WHERE user_email = '"+user_email+"';";
//
//			PreparedStatement statement = conn.prepareStatement(sql);
//			statement.execute();
//		}
//			 catch (SQLException e) {
//			e.printStackTrace();
//		}
//	return null;
//	}
//	
//	@Override
//	public Account updateSupport (String user_email) {
//		try (Connection conn = ConnectionUtil.getConnection()) {
//			String sql = "UPDATE accounts SET is_basic = FALSE WHERE user_email = '"+user_email+"';"
//					   + "UPDATE accounts SET is_admin = FALSE WHERE user_email = '"+user_email+"';"
//					   + "UPDATE accounts SET is_support = TRUE WHERE user_email = '"+user_email+"';";
//
//			PreparedStatement statement = conn.prepareStatement(sql);
//			statement.execute();
//		}
//			 catch (SQLException e) {
//			e.printStackTrace();
//		}
//	return null;
//	}
//	
//	@Override
//	public Account updateAdmin (String user_email) {
//		try (Connection conn = ConnectionUtil.getConnection()) {
//			String sql = "UPDATE accounts SET is_basic = FALSE WHERE user_email = '"+user_email+"';"
//					   + "UPDATE accounts SET is_admin = TRUE WHERE user_email = '"+user_email+"';"
//					   + "UPDATE accounts SET is_support = FALSE WHERE user_email = '"+user_email+"';";
//			PreparedStatement statement = conn.prepareStatement(sql);
//			statement.execute();
//		}
//			 catch (SQLException e) {
//			e.printStackTrace();
//		}
//	return null;
//	}
//
//	@Override
//	public Boolean getAdmin(String user_email, Boolean is_admin) {
//		try (Connection conn = ConnectionUtil.getConnection()) {
//			String sql = "SELECT * FROM accounts WHERE user_email = '"+user_email+"' AND is_admin = TRUE";
//			Statement statement = conn.createStatement();
//			ResultSet result = statement.executeQuery(sql);
//
//			if (result.next()) {
//				return true;
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//	
//	@Override
//	public Boolean getSupport(String user_email, Boolean is_Support) {
//		try (Connection conn = ConnectionUtil.getConnection()) {
//			String sql = "SELECT * FROM accounts WHERE user_email = '"+user_email+"' AND is_support = TRUE";
//			Statement statement = conn.createStatement();
//			ResultSet result = statement.executeQuery(sql);
//
//			if (result.next()) {
//				return true;
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//	
//	@Override
//	public Boolean getBasic(String user_email, Boolean is_basic) {
//		try (Connection conn = ConnectionUtil.getConnection()) {
//			String sql = "SELECT * FROM accounts WHERE user_email = '"+user_email+"' AND is_basic = TRUE";
//			Statement statement = conn.createStatement();
//			ResultSet result = statement.executeQuery(sql);
//
//			if (result.next()) {
//				return true;
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//		
//	@Override
//	public boolean getAccountPassword(String user_email, String user_password) {
//		try (Connection conn = ConnectionUtil.getConnection()) {
//			String sql = "SELECT * FROM accounts WHERE user_email = " + "'" + user_email + "'" + " AND user_password = "
//					+ "'" + user_password + "'" + ";";
//			Statement statement = conn.createStatement();
//			ResultSet result = statement.executeQuery(sql);
//
//			if (result.next()) {
//				return true;
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}

	



	

	


	

	

