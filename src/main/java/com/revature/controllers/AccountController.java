package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Account;
import com.revature.services.AccountService;

public class AccountController extends HttpServlet{
	
	private AccountService accountDao = new AccountService();
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		String URI = request.getRequestURI();
		System.out.println(URI);
		// /HelloJackson/avenger/{id}
		
		String[] urlSections = URI.split("/");
		
		if(urlSections.length==3) {
		
		List<Account> list = accountDao.getAllAccounts();
		
		String json = objectMapper.writeValueAsString(list);
		System.out.println(json);
		
		PrintWriter printWriter = response.getWriter();
		printWriter.print(json);
		
		response.setStatus(200);
		
		response.setContentType("application/json");
		}
		}
		
	
	
	@Override
	protected void doPost (HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		StringBuilder sb = new StringBuilder();
		
		BufferedReader reader = request.getReader();
		
		String line = reader.readLine();
		
		while(line!=null) {
			sb.append(line);
			line=reader.readLine();
			
		}
		
		String json = new String(sb);
		System.out.println(json);
		
		Account account = objectMapper.readValue(json, Account.class);
		
		accountDao.insertAccount(account);
		
		response.setStatus(201);
		
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line = reader.readLine();

        while(line!=null) {
            sb.append(line);
            line=reader.readLine();
        }

        String json = new String(sb);
        System.out.println("Deleted account " + json);
        Account account = objectMapper.readValue(json,  Account.class);

        //CALL ORM HERE
        accountDao.deleteAccount(account);;

        response.setStatus(200);


    }
	
	@Override
	protected void doPut (HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		StringBuilder sb = new StringBuilder();
		
		BufferedReader reader = request.getReader();
		
		String line = reader.readLine();
		
		while(line!=null) {
			sb.append(line);
			line=reader.readLine();
			
		}
		
		String json = new String(sb);
		System.out.println(json);
		
		Account account = objectMapper.readValue(json, Account.class);
		
		accountDao.updateAccount(account);
		
		response.setStatus(201);
		
	}

}



