package shoppingCart;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class ShoppingCartTest {
	
	

	@Test
	public void shouldaEmptyCreateShoopingCart(){
		
		ShoppingCartReal cl1 =new ShoppingCartReal();
		cl1.createShopList();
		LinkedList<Object> sveList1 = new LinkedList<Object>();
		sveList1=cl1.saveShopList();
		System.out.println("Size sve list "+sveList1.size());
		assertTrue(sveList1.isEmpty());
		System.out.println("****");
	}
	
	
	@Test
	
	public void shouldAddItemToShoppingListByName(){
		
		LinkedList<Product> Inventory = new LinkedList<Product>();
		Product p1= new Product("Gum",1234);
		Product p2= new Product("meat",4987);
		Product p3= new Product("rice",3859);
		Inventory.add(p1);
		Inventory.add(p2);
		Inventory.add(p3);
		
		
		ShoppingCartReal cl2 =new ShoppingCartReal();
		LinkedList<Object> sveList2 = new LinkedList<Object>();
		cl2.createShopList();
		
		cl2.addItemByName("meat",2, Inventory);
		sveList2=cl2.saveShopList();		
		assertEquals("Should have one item",1,sveList2.size());
		System.out.println("Size sve list "+sveList2.size());		
		cl2.showShopListByName();
		System.out.println("****");
		
		cl2.addItemByName("Gum",1, Inventory);
		sveList2=cl2.saveShopList();
		assertEquals("Should have two item",2,sveList2.size());
		System.out.println("Size sve list "+sveList2.size());
		cl2.showShopListByName();
		System.out.println("****");
		
		cl2.addItemByName("meat",2, Inventory);
		sveList2=cl2.saveShopList();
		assertEquals("Should have two item",2,sveList2.size());
		System.out.println("Size sve list "+sveList2.size());
		cl2.showShopListByName();
		System.out.println("****");
	}
	
	
	
	@Test
	
	public void shouldAddItemToShoppingListById(){
	
		LinkedList<Product> Inventory = new LinkedList<Product>();
		Product p1= new Product("Gum",1234);
		Product p2= new Product("meat",4987);
		Product p3= new Product("rice",3859);
		Inventory.add(p1);
		Inventory.add(p2);
		Inventory.add(p3);
		
		ShoppingCartReal cl3 =new ShoppingCartReal();
		LinkedList<Object> sveList3 = new LinkedList<Object>();
		cl3.createShopList();
		
		
		cl3.addItemByID(4987, 2, Inventory);
		sveList3=cl3.saveShopList();
		assertEquals("Should have one item",1,sveList3.size());
		System.out.println("Size sve list "+sveList3.size());		
		cl3.showShopListByID();
		System.out.println("****");
		
		
		cl3.addItemByID(1234, 1, Inventory);
		sveList3=cl3.saveShopList();
		assertEquals("Should have Two item",2,sveList3.size());
		System.out.println("Size sve list "+sveList3.size());		
		cl3.showShopListByID();
		System.out.println("****");
		
		cl3.addItemByID(4987, 1, Inventory);
		sveList3=cl3.saveShopList();
		assertEquals("Should have Two item",2,sveList3.size());
		System.out.println("Size sve list "+sveList3.size());		
		cl3.showShopListByID();
		System.out.println("****");
		

		cl3.addItemByID(4987, 3, Inventory);
		sveList3=cl3.saveShopList();
		assertEquals("Should have two item",2,sveList3.size());
		System.out.println("Size sve list "+sveList3.size());		
		cl3.showShopListByID();
		System.out.println("****");
	
		
		cl3.addItemByID(3859, 1, Inventory);
		sveList3=cl3.saveShopList();
		assertEquals("Should have three item",3,sveList3.size());
		System.out.println("Size sve list "+sveList3.size());		
		cl3.showShopListByID();
		System.out.println("****");
	}
	
	@Test
	public void shouldDeletaItemByName(){
		
		LinkedList<Product> Inventory = new LinkedList<Product>();
		Product p1= new Product("Gum",1234);
		Product p2= new Product("meat",4987);
		Product p3= new Product("rice",3859);
		Inventory.add(p1);
		Inventory.add(p2);
		Inventory.add(p3);
		
		ShoppingCartReal cl4 =new ShoppingCartReal();
		LinkedList<Object> sveList4 = new LinkedList<Object>();
		cl4.createShopList();
		
		
		
		
		
		cl4.addItemByName("meat",2, Inventory);
		cl4.addItemByName("meat",1, Inventory);
		cl4.addItemByName("meat",3, Inventory);
		cl4.addItemByName("Gum",4, Inventory);
		cl4.addItemByName("rice",5, Inventory);
		cl4.showShopListByName();
		System.out.println("****");
		
		sveList4=cl4.saveShopList();
		
		cl4.deletItemByName("Gum", 1);
		int cnt_test1=cl4.getItemCnt("Gum");
		assertEquals("Gum quantity should be 3",3,cnt_test1);
		cl4.showShopListByName();
		System.out.println("****");
		
		cl4.deletItemByName("meat", 5);
		int cnt_test2=cl4.getItemCnt("meat");
		assertEquals("meat quantity should be 1",1,cnt_test2);
		cl4.showShopListByName();
		System.out.println("****");
		
		cl4.deletItemByName("rice", 5);
		sveList4=cl4.saveShopList();
		assertEquals("Should have two items rice gone",2,sveList4.size());
		cl4.showShopListByName();
		System.out.println("****");
		
		
	}
	
	
	@Test
	public void shouldDeletaItemById(){
		
		LinkedList<Product> Inventory = new LinkedList<Product>();
		Product p1= new Product("Gum",1234);
		Product p2= new Product("meat",4987);
		Product p3= new Product("rice",3859);
		Inventory.add(p1);
		Inventory.add(p2);
		Inventory.add(p3);
		
		ShoppingCartReal cl5 =new ShoppingCartReal();
		LinkedList<Object> sveList5 = new LinkedList<Object>();
		cl5.createShopList();
		
			
		cl5.addItemByID(4987,2, Inventory);
		cl5.addItemByID(4987,1, Inventory);
		cl5.addItemByID(4987,3, Inventory);
		cl5.addItemByID(1234,4, Inventory);
		cl5.addItemByID(3859,5, Inventory);
		cl5.showShopListByID();
		System.out.println("****");
		
		sveList5=cl5.saveShopList();
		
		cl5.deletItemByID(1234, 1);
		int cnt_test1=cl5.getItemCnt("Gum");
		assertEquals("1234 quantity should be 3",3,cnt_test1);
		cl5.showShopListByID();
		System.out.println("****");
		
		cl5.deletItemByID(4987, 5);
		int cnt_test2=cl5.getItemCnt("meat");
		assertEquals("4987 quantity should be 1",1,cnt_test2);
		cl5.showShopListByID();
		System.out.println("****");
		
		cl5.deletItemByID(3859, 100);
		sveList5=cl5.saveShopList();
		assertEquals("Should have two items 3859 gone",2,sveList5.size());
		cl5.showShopListByID();
		System.out.println("****");
		
		
	}
	
	
	@Test
	public void shouldGetItemName(){
		
		LinkedList<Product> Inventory = new LinkedList<Product>();
		Product p1= new Product("Gum",1234);
		Product p2= new Product("meat",4987);
		Product p3= new Product("rice",3859);
		Inventory.add(p1);
		Inventory.add(p2);
		Inventory.add(p3);
		
		ShoppingCartReal cl6 =new ShoppingCartReal();
		LinkedList<Object> sveList6 = new LinkedList<Object>();
		cl6.createShopList();
		
		cl6.addItemByID(4987,2, Inventory);
		cl6.addItemByID(4987,1, Inventory);
		cl6.addItemByID(4987,3, Inventory);
		cl6.addItemByID(1234,4, Inventory);
		cl6.addItemByID(3859,5, Inventory);
		cl6.showShopListByName();
		System.out.println("****");
		
		sveList6=cl6.saveShopList();
		
		String nameTest1=cl6.getItemName(4987);
		assertEquals("name should be meat","meat",nameTest1);
		System.out.println(""+nameTest1);
		
		String nameTest2=cl6.getItemName(1234);
		assertEquals("name should be meat","Gum",nameTest2);
		System.out.println(""+nameTest2);
		
	}
	
	
	@Test public void shouldGetItemID(){
		
		LinkedList<Product> Inventory = new LinkedList<Product>();
		Product p1= new Product("Gum",1234);
		Product p2= new Product("meat",4987);
		Product p3= new Product("rice",3859);
		Inventory.add(p1);
		Inventory.add(p2);
		Inventory.add(p3);
		
		ShoppingCartReal cl7 =new ShoppingCartReal();
		LinkedList<Object> sveList7 = new LinkedList<Object>();
		cl7.createShopList();
		System.out.println("****");
		
		cl7.addItemByName("meat",2, Inventory);
		cl7.addItemByName("Gum",3, Inventory);
		cl7.addItemByName("meat",1, Inventory);
		cl7.addItemByName("Gum",1, Inventory);
		cl7.addItemByName("rice",4, Inventory);
		
		int idx_test1=cl7.getItemID("Gum");
		assertEquals("ID should be 1234",1234,idx_test1);
		System.out.println(""+idx_test1);
		
		int idx_test2=cl7.getItemID("rice");
		assertEquals("ID should be 3859",3859,idx_test2);
		System.out.println(""+idx_test2);
		
		cl7.deletItemByName("Gum", 5);
		
		int idx_test3=cl7.getItemID("Gum");
		assertEquals("ID should be 0",0,idx_test3);
		System.out.println(""+idx_test3);
		System.out.println("****");
		
		cl7.showShopListByName();
		System.out.println("****");
	}
	
	
	

}
