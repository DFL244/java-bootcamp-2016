package shoppingCart;

import java.util.LinkedList;

public class shoppingCartDemo {

	public static void main(String[] args) {
		
		
		Product p1= new Product("Gum",1234);
		Product p2= new Product("meat",4987);
		Product p3= new Product("raice",3859);

		LinkedList<Product> Inventory = new LinkedList<Product>();
		
		
		Inventory.add(p1);
		Inventory.add(p2);
		Inventory.add(p3);
		
			
		ShoppingCartReal pt =new ShoppingCartReal();
		
		
		pt.createShopList();
		pt.addItemByName("meat",2, Inventory);		
		pt.addItemByName("Gum",3, Inventory);
		pt.addItemByName("meat",1, Inventory);
		pt.addItemByName("raice",5, Inventory);
		pt.addItemByName("meat",1, Inventory);
		pt.addItemByName("meat",2, Inventory);
		
		pt.showShopListByName();
		
		pt.deletItemByName("meat", 1);
		
		pt.showShopListByName();
			
		int idx=pt.getItemID("Gum");
		int cntx=pt.getItemCnt("Gum");
		System.out.println("Gum id is: "+idx+"Currently in shopping list are: "+cntx+" items of Gum");
		
		pt.deletItemByID(idx, cntx);
		pt.showShopListByName();

	}

}
