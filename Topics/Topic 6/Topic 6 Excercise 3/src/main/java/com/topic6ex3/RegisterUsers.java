package com.topic6ex3;



public interface RegisterUsers {
	
	//Insert(POST)
	public int Create(String query);
	
	//Get (GET)
	public Object read(String query);
	
	//Update (PUT)
	public int update (String querty);
	
	//Delete (Delete)
	
	public int delete(String querty);
}
