package com.proyecto01.pacakge;

import java.util.LinkedHashMap;

public class DemoShopping {

	
	
	
	public static void main(String[] args) {
	
		String URL ="jdbc:mysql://localhost:3306/proyecto";
		String User="root";
		String Pass="root1234";
		DBcrudImp db=DBcrudImp.connect(URL, User, Pass);
		
	LinkedHashMap <Integer, Product> ShoppingList = new LinkedHashMap<Integer, Product>();
	
	ShoppingListImp sl =new ShoppingListImp(9);
	User u1=new User("username1","pass1","name1","test_tablenamelist1",3);
	
	
	Product p1 = new Product(1,"name1",0,"cat1",200,0);
	Product p2 = new Product(2,"name2",0,"cat2",100,0);
	Product p3 = new Product(3,"name3",0,"cat1",300,0);	
	Product p4 = new Product(2,"name2",0,"cat2",100,0);	
	Product p5 = new Product(5,"name5",0,"cat5",400,0);
	Product p6 = new Product(6,"name6",0,"cat6",600,0);
	Product p7 = new Product(7,"name7",0,"cat7",1000,0);
	Product p8 = new Product(8,"name8",0,"cat8",50,0);
	Product p9 = new Product(9,"name9",0,"cat9",20,0);
	Product p10 = new Product(10,"name10",0,"cat10",40,0);
	Product p11 = new Product(11,"name11",0,"cat11",60,0);
	Product p12 = new Product(12,"name12",0,"cat12",2,0);
	
	
	sl.addtoShopList(2,p1,ShoppingList,u1.getNamelist(),db);
	sl.addtoShopList(1,p1,ShoppingList,u1.getNamelist(),db);
	sl.addtoShopList(4,p1,ShoppingList,u1.getNamelist(),db);
	sl.addtoShopList(3,p1,ShoppingList,u1.getNamelist(),db);
	sl.addtoShopList(1,p2,ShoppingList,u1.getNamelist(),db);
	sl.addtoShopList(2,p3,ShoppingList,u1.getNamelist(),db);
	sl.addtoShopList(3,p4,ShoppingList,u1.getNamelist(),db);
	sl.addtoShopList(1,p5,ShoppingList,u1.getNamelist(),db);
	
	System.out.println(""+ShoppingList);
	System.out.println("**************");
	
	
	sl.delProdfromShopList(2, ShoppingList,u1.getNamelist(),db);
	System.out.println(""+ShoppingList);
	System.out.println("**************");
	
	sl.addtoShopList(3,p4,ShoppingList,u1.getNamelist(),db);
	System.out.println(""+ShoppingList);
	System.out.println("**************");
	
	
	sl.addtoShopList(1,p5,ShoppingList,u1.getNamelist(),db);
	System.out.println(""+ShoppingList);
	System.out.println("**************");
	
	sl.addtoShopList(1,p6,ShoppingList,u1.getNamelist(),db);
	sl.addtoShopList(1,p7,ShoppingList,u1.getNamelist(),db);
	sl.addtoShopList(3,p8,ShoppingList,u1.getNamelist(),db);
	
	sl.addtoShopList(1,p9,ShoppingList,u1.getNamelist(),db);
	sl.addtoShopList(2,p10,ShoppingList,u1.getNamelist(),db);
	sl.addtoShopList(5,p11,ShoppingList,u1.getNamelist(),db);
	sl.addtoShopList(7,p12,ShoppingList,u1.getNamelist(),db);
	
	System.out.println(""+ShoppingList);
	System.out.println("**************");
	
	sl.delProdfromShopList(7, ShoppingList,u1.getNamelist(),db);
	System.out.println(""+ShoppingList);
	System.out.println("**************");
	
	sl.addtoShopList(3,p12,ShoppingList,u1.getNamelist(),db);
	System.out.println(""+ShoppingList);
	System.out.println("**************");
	
	
	sl.delQtyProduct(5, 1, ShoppingList, u1.getNamelist(), db);
	System.out.println(""+ShoppingList);
	System.out.println("**************");
	
	
	sl.delQtyProduct(3, 8, ShoppingList, u1.getNamelist(), db);
	System.out.println(""+ShoppingList);
	System.out.println("**************");
	
	
	//sl.clearShoppingList(ShoppingList, u1.getNamelist(), db);
	
	
	
	}
	
	
}

