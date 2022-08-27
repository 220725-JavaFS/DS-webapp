package com.revature.exceptions;

public class Exceptions extends RuntimeException{

		private static final long serialVersionUID = 1L;

		public Exceptions(){}

	    public Exceptions(String message){
	        super(message);
	    }

	    public Exceptions(String message, Exception e){
	        super(message, e);
	    }

	}


