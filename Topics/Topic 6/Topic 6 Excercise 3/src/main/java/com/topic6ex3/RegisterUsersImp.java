package com.topic6ex3;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;



public class RegisterUsersImp implements RegisterUsers{
	
	Statement newStmt;
	Connection newConn;
	ResultSet newResSet;
	private static RegisterUsersImp onlyInstance=null;
	List<User> r_user =new LinkedList<User>();
	StringBuilder strBuild = new StringBuilder();
	int up1;
	
	//public RegisterUsersImp(String Url, String User, String Pass){
	private RegisterUsersImp(String URL, String User, String Pass){
		try{			
			newConn =DriverManager.getConnection(URL,User,Pass);
			newStmt = newConn.createStatement();			
			
		}catch(Exception exc){
			exc.printStackTrace();			
		}
		
	}

	public synchronized static RegisterUsersImp connect (String URL, String User, String Pass){
		
		if(onlyInstance==null){
			onlyInstance= new RegisterUsersImp(URL,User,Pass);				
		}
		return onlyInstance;
		
	}
	
	
	public int Create(String query){
		try{
			up1=0;
			up1=newStmt.executeUpdate(query);		
			//System.out.println(""+up1);
			
		}catch(Exception exc){
			exc.printStackTrace();			
		}
		return up1;		
		
	}
	
	
	
	public Object read(String query) {
		try{
			
			newResSet= newStmt.executeQuery(query);			
			
		}catch(Exception exc){
			exc.printStackTrace();			
		}
				
		return newResSet;
	}
	
	
	
	public int update (String query){
		try{
			up1=0;
			up1=newStmt.executeUpdate(query);		
			//System.out.println(""+up1);
			
		}catch(Exception exc){
			exc.printStackTrace();			
		}
		return up1;						
	}	
		
	
	public int delete (String query){
		try{
			up1=0;
			up1=newStmt.executeUpdate(query);		
			//System.out.println(""+up1);
			
		}catch(Exception exc){
			exc.printStackTrace();			
		}
		return up1;						
	}	
	
	
		
	public List<User> formater(){
		r_user.clear();		
		try{
			
			while(newResSet.next()){
				
				r_user.add(new User(newResSet.getInt("id"),newResSet.getString("name"),newResSet.getString("nickname")));
				
			}
			
		}catch(Exception exc){
			exc.printStackTrace();			
		}
		return r_user;		
	}
	
	public String queryStringMaker(StringBuilder query,String pasQuery){
		strBuild.setLength(0);
		strBuild.append(query);		
		strBuild.append("'");
		strBuild.append(pasQuery);
		strBuild.append("'");
		return strBuild.toString();
	}
	
	
	
}
