package com.revature.repos;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;

public class AccountRepo {

	private List<Account> accounts;

	public AccountRepo() {
		Account account1 = new Account(true, false, false, "dustin@revature.com", "Dustin", "Shipley", "password");
		Account account2 = new Account();
		Account account3 = new Account();
		Account account4 = new Account();
		Account account5 = new Account();

		accounts = new ArrayList<>();
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		accounts.add(account4);
		accounts.add(account5);
	}

	public Account getAccountByUser_email(String user_email) {
		for (Account a : accounts) {
			if (user_email.equals(a.getUser_email())) {
				return a;
			}
		}
		return null;
	}

	
	public void insertAccount(Account account) {
		for(Account a : accounts) {
			
		}
	}

	
}

		


	


		
	



	

