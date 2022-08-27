package com.revature.models;

import java.util.Objects;

public class Account {
	
	private Boolean is_admin;
	private Boolean is_support; 
	private Boolean is_basic; 
	private String user_email; 
	private String user_firstname; 
	private String user_lastname; 
	private String user_password;
	
	
	public Account(Boolean is_admin, Boolean is_support, Boolean is_basic, String user_email, String user_firstname,
			String user_lastname, String user_password) {
		super();
		this.is_admin = is_admin;
		this.is_support = is_support;
		this.is_basic = is_basic;
		this.user_email = user_email;
		this.user_firstname = user_firstname;
		this.user_lastname = user_lastname;
		this.user_password = user_password;
	}
	public Account() {
		super();
	}
	public Boolean getIs_admin() {
		return is_admin;
	}
	public void setIs_admin(Boolean is_admin) {
		this.is_admin = is_admin;
	}
	public Boolean getIs_support() {
		return is_support;
	}
	public void setIs_support(Boolean is_support) {
		this.is_support = is_support;
	}
	public Boolean getIs_basic() {
		return is_basic;
	}
	public void setIs_basic(Boolean is_basic) {
		this.is_basic = is_basic;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_firstname() {
		return user_firstname;
	}
	public void setUser_firstname(String user_firstname) {
		this.user_firstname = user_firstname;
	}
	public String getUser_lastname() {
		return user_lastname;
	}
	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	@Override
	public int hashCode() {
		return Objects.hash(is_admin, is_basic, is_support, user_email, user_firstname, user_lastname, user_password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(is_admin, other.is_admin) && Objects.equals(is_basic, other.is_basic)
				&& Objects.equals(is_support, other.is_support) && Objects.equals(user_email, other.user_email)
				&& Objects.equals(user_firstname, other.user_firstname)
				&& Objects.equals(user_lastname, other.user_lastname)
				&& Objects.equals(user_password, other.user_password);
	}
	@Override
	public String toString() {
		return "Account [is_admin=" + is_admin + ", is_support=" + is_support + ", is_basic=" + is_basic
				+ ", user_email=" + user_email + ", user_firstname=" + user_firstname + ", user_lastname="
				+ user_lastname + ", user_password=" + user_password + "]";
	}
	
}
	
	
	