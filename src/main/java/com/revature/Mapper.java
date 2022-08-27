package com.revature;



public interface Mapper {
	
	String serialize(Object o );
	//deSerialize

	public <T> T deSerialize(String input, Class<T> clazz);

	

}
