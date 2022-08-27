package com.revature.daos;

import java.util.List;

import com.revature.models.Account;

public interface AccountDAO {
	
	
	 	
	public List<Account> getAllAccounts();

	public void insertAccount(Account account);
	
	public void deleteAccount(Account account);

	public Account updateAccount(Account account);
	
//	public Account getAccountByUser_email(String user_email);

//	public boolean getAccountPassword(String user_email, String user_password);
//	
//	public Account updateBasic(String user_email);
//	
//	public Account updateSupport(String user_email);
//	
//	public Account updateAdmin(String user_email);
//	
//	public Boolean getAdmin(String user_email, Boolean is_admin);
//	
//	public Boolean getSupport(String user_email, Boolean is_support);
//	
//	public Boolean getBasic(String user_email, Boolean is_basic);

	

	
	
	
		
}
