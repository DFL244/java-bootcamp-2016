package com.proyecto01.pacakge;

import java.util.Map;

public class Buyer {
	
	
	Map<Integer,Product> shoplist;
	String username;
	String name;
	int listprice;
	
	
	public Buyer() {}
	
	
	public Buyer(Map<Integer, Product> shoplist, String username, String name, int listprice) {
		super();
		this.shoplist = shoplist;
		this.username = username;
		this.name = name;
		this.listprice = listprice;
	}


	public Map<Integer, Product> getShoplist() {
		return shoplist;
	}


	public void setShoplist(Map<Integer, Product> shoplist) {
		this.shoplist = shoplist;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getListprice() {
		return listprice;
	}


	public void setListprice(int listprice) {
		this.listprice = listprice;
	}
	



	
	
	
	
	
	

	
	
	

}
