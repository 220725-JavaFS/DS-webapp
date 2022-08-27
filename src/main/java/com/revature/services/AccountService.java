package com.revature.services;

import java.util.List;

import com.revature.daos.AccountDAO;
import com.revature.daos.AccountDAOimpl;
import com.revature.models.Account;
//import com.revature.models.CD;
import com.revature.repos.AccountRepo;

public class AccountService {
	
	private AccountDAO accountDao = new AccountDAOimpl();
	
	private AccountRepo accountRepo;
	
	public AccountService(AccountRepo accountRepo) {
		super();
		this.accountRepo = accountRepo;
	}
	
	public AccountService() {
		this.accountRepo = new AccountRepo();
	}
	
	public List<Account> getAllAccounts(){
		return accountDao.getAllAccounts();
	}

	public void insertAccount(Account account) {
		accountDao.insertAccount(account);
	}
	
	public void deleteAccount(Account account) {
		accountDao.deleteAccount(account);	
	}

	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
	}
	
//	public Account getAccountByUser_email(String user_email) {
//		return accountDao.getAccountByUser_email(user_email);
//	}
	
//	public boolean getAccountPassword(String user_email, String user_password) {
//		return accountDao.getAccountPassword(user_email, user_password);
//	}
	
//	public Boolean getAdmin(String user_email, Boolean is_admin) {
//		return accountDao.getAdmin(user_email, is_admin);
//	}
//	
//	public Boolean getSupport(String user_email, Boolean is_support) {
//		return accountDao.getSupport(user_email, is_support);
//	}
//	
//	public Boolean getBasic(String user_email, Boolean is_basic) {
//		return accountDao.getBasic(user_email, is_basic);
//	}
//	
//	public Account updateBasic(String user_email) {
//	return accountDao.updateBasic(user_email);
//	}
//
//	
//	public Account updateSupport(String user_email){
//		return accountDao.updateSupport(user_email);
//		}
//	
//	public Account updateAdmin(String user_email){
//		return accountDao.updateAdmin(user_email);
//		}
}
	

	
	
