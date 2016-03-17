package com.proyecto01.pacakge;

import java.util.List;
import java.util.Map;

public interface ShoppingList {
	
	
	 public boolean addtoShopList(int qty,Product retPrd,Map<Integer,Product> shopL, String namelist,DBcrudImp db);	 
	 public boolean delProdfromShopList(int id,Map<Integer,Product> shopL,String namelist,DBcrudImp db);
	 public boolean delQtyProduct(int qty,int id,Map<Integer,Product> shopL,String namelist,DBcrudImp db);
	 public boolean clearShoppingList(Map<Integer,Product> shopL,String namelist,DBcrudImp db);
	 
	

}
