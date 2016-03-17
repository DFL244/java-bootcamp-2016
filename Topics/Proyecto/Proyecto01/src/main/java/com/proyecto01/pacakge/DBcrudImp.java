package com.proyecto01.pacakge;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;



public class DBcrudImp implements DBcrud{
	
	Statement newStmt;
	Connection newConn;
	ResultSet newResSet;
	private static DBcrudImp onlyInstance=null;
	Product objP;
	User objU;
	List<Product> rt_catalog =new LinkedList<Product>();
	Map<Integer,Product> rt_ShopList=new LinkedHashMap<Integer, Product>();
	StringBuilder strBuild = new StringBuilder();
	int up1;
	int tLprice;
	
	
	private DBcrudImp(String URL, String User, String Pass){
		try{			
			newConn =DriverManager.getConnection(URL,User,Pass);
			newStmt = newConn.createStatement();			
			
		}catch(Exception exc){
			exc.printStackTrace();			
		}
		
	}

	public synchronized static DBcrudImp connect (String URL, String User, String Pass){
		
		if(onlyInstance==null){
			onlyInstance= new DBcrudImp(URL,User,Pass);				
		}
		return onlyInstance;
		
	}
	
	
	public int Create(String query){
		try{
			up1=0;
			up1=newStmt.executeUpdate(query);		
			
			
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
			
			
		}catch(Exception exc){
			exc.printStackTrace();			
		}
		return up1;						
	}	
		
	
	public int delete (String query){
		try{
			up1=0;
			up1=newStmt.executeUpdate(query);		
			
			
		}catch(Exception exc){
			exc.printStackTrace();			
		}
		return up1;						
	}	
	
	
		
	public Product formaterProduct(){
		//objP=null;
		try{
			
			while(newResSet.next()){
			objP=new Product(newResSet.getInt("id"),newResSet.getString("pname"),0,newResSet.getString("Category"),newResSet.getInt("uprice"),0);
			}
			
		}catch(Exception exc){
			exc.printStackTrace();			
		}
		return objP;		
	}

	
	public User formaterUser(){
		objU=null;	
		try{			
			while(newResSet.next()){
			objU=new User(newResSet.getString("username"),newResSet.getString("pass"),newResSet.getString("name"),newResSet.getString("namelist"),newResSet.getInt("listsize"));
			}		
		}catch(Exception exc){
			exc.printStackTrace();			
		}
		return objU;		
	}
	
	
	public List<Product> formaterCatalog(){
		rt_catalog.clear();		
		try{
			
			while(newResSet.next()){
				
				rt_catalog.add(new Product(newResSet.getInt("id"),newResSet.getString("pname"),0,newResSet.getString("Category"),newResSet.getInt("uprice"),0));
				
			}
			
		}catch(Exception exc){
			exc.printStackTrace();			
		}
		return rt_catalog;	
	}
	
	
	public Map<Integer,Product> formaterRetiveShopList(){
		rt_ShopList.clear();		
		try{
			
			while(newResSet.next()){
				
				rt_ShopList.put(newResSet.getInt("id"),new Product(newResSet.getInt("id"),newResSet.getString("pname"),newResSet.getInt("qty"),newResSet.getString("category"),newResSet.getInt("uprice"),newResSet.getInt("tprice")));
				
			}
			
		}catch(Exception exc){
			exc.printStackTrace();			
		}
		return rt_ShopList;	
	}
	
	
	public int formaterbuy(){
		tLprice=0;
		try{			
			while(newResSet.next()){
				tLprice=newResSet.getInt("sum(tprice)");
			}		
		}catch(Exception exc){
			exc.printStackTrace();			
		}
		return tLprice;		
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
