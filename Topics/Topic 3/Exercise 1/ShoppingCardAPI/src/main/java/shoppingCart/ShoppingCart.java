package shoppingCart;
import java.util.*;

/**
 * This interface and its class ShoppingCartReal definies and 
 * implements the methods to access to a previously create 
 * inventory of products and create a shopping cart list.
 * 
 * 
 * @author DFL
 *
 */


public interface ShoppingCart {

	public void createShopList();
	public void delShopList();
	public void showShopListByName();
	public void showShopListByID();
	public LinkedList<Object> saveShopList();
	
	
	
	public void addItemByName(String name,int cnt, LinkedList<Product> inventory);
	public void addItemByID(int id,int cnt, LinkedList<Product> inventory);
	
	public void deletItemByName(String name, int cnt);
	public void deletItemByID(int id, int cnt);
	
	public String getItemName(int id);
	public int getItemID(String name);
	public int getItemCnt(String name);	
	
	
	
	
}
