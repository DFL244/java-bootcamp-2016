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


public final class  ShoppingCartReal implements ShoppingCart {
	
	
	private LinkedList<Object> inList;
	
	/**
	 * Constructor allows to create empty objets from 
	 * ShoppingCartReal
	 *  
	 */
	
	public ShoppingCartReal(){		
	}
	
	/**
	 * Create a LinkedList object that holds the present
	 * state of the Shopping List.
	 * @params None
	 * @return None
	 */	
	public void createShopList(){
		inList =new LinkedList<Object>();
		
	}	
	/**
	 * Erase current Shopping List, after been use size of 
	 * the Shopping list is 0 
	 * @params None
	 * @return None
	 */	
	public void delShopList(){
		inList.clear();		
	}	
	
	
	
	/**
	 * Prints on the command prompt, the current shopping list, 
	 * showing the NAME and the quantity of the items 
	 * included in the list. if current list has not items a 
	 * "Shopping List is Empty" message is Display
	 * @params None
	 * @return void
	 */	
	public void showShopListByName() {
		if(inList.isEmpty()){
			System.out.println("****");
			System.out.println("Shopping List is Empty");
			System.out.println("****");
		} else{
			System.out.println("****");
			for (int i=0; i<=(inList.size()-1);i++){
				String nameShow=((Product) inList.get(i)).getName();
				int cntShow=((Product) inList.get(i)).getCnt();
				System.out.println("Product: "+nameShow+" Cnt: "+cntShow);
				
			}System.out.println("****");
		}				
	}
			
	/**
	 * Prints on the command prompt, the current shopping list, 
	 * showing the ID and the quantity of the items 
	 * included in the list. if current list has not items a 
	 * "Shopping List is Empty" message is Display
	 * @params None
	 * @return void
	 */
	public void showShopListByID(){
		if (inList.isEmpty()){
			System.out.println("****");
			System.out.println("Shopping List is Empty");
			System.out.println("****");
		}else{
			for (int i=0; i<=(inList.size()-1);i++){
				int idx=((Product) inList.get(i)).getId();
				int cntShow=((Product) inList.get(i)).getCnt();
				System.out.println("Product Id: "+idx+" Cnt: "+cntShow);
				
			}System.out.println("****");
		
		}
		
	}
	
	/**Returns a Clone of the current Shopping list
	 * @param none
	 * @return	LinkedList Object  each item of the LinkedList is an
	 * object from Product class that contains name, ID and quantity
	 * @see <code> Product Class </code>
	 * 
	 */
	public LinkedList<Object> saveShopList(){	
		Object cl=inList.clone();
		return (LinkedList<Object>) cl;	
	}
	
	
	/**Takes a selected item by "Name" from inventory and add it to the Shopping list.
	 * Prints on the command prompt, the last addition to the Shopping List.
	 * 
	 * @param  name	String 	"Name" of the selected item from inventory
	 * @param	cnt int 	Quantity of the selected item (must be >=1)
	 * @param	inventory	LinkedList Contains the available range 
	 * 						of items, from which to select for adding to the 
	 * 						shopping list, each one of them is an object from 
	 * 						Product class that have "Name", "ID" and "Quantity".
	 * @throws	ArithmeticException if cnt=0
	 * @return	void
	 */
		
	public void addItemByName(String name,int cnt, LinkedList<Product> inventory){
		
		if(cnt==0){
			throw new ArithmeticException("Quantity valued must be cnt>=1");
			
		}else{
			for (int i=0; i<=(inventory.size()-1);i++){			
				String nam=(inventory.get(i)).getName();
				
					if (nam.equals(name)& inList.contains(inventory.get(i)) ){
						int shop_ind=inList.indexOf(inventory.get(i));
											
						if(cnt==1){
							((Product) inList.get(shop_ind)).setCnt();
							System.out.println("Product: "+((Product) inList.get(shop_ind)).getName()+" Total Cnt: "+((Product) inList.get(shop_ind)).getCnt());
						}else{
							int inListCnt=((Product) inList.get(shop_ind)).getCnt();
							inListCnt=inListCnt+cnt;
							((Product) inList.get(shop_ind)).setCnt(inListCnt);
							System.out.println("Product: "+((Product) inList.get(shop_ind)).getName()+" Total Cnt: "+((Product) inList.get(shop_ind)).getCnt());
						}										
						
					}else if (nam.equals(name) & !inList.contains(inventory.get(i))){
											
						inList.addFirst(inventory.get(i));
						((Product) inList.get(0)).setCnt(cnt);
						System.out.println("Product: "+((Product) inList.get(0)).getName()+" Total Cnt: "+((Product) inList.get(0)).getCnt());
										
					}
					
					
				
				}	
				
				
			
		}
		
		
	}
	
	/**Takes a selected item by "ID" from inventory and add it to the Shopping list.
	 * Prints on the command prompt, the last addition to the Shopping List.
	 * 
	 * @param  	id	int "Id" of the selected item from inventory
	 * @param	cnt int Quantity of the selected item (must be >=1)
	 * @param	inventory	LinkedList Contains the available range 
	 * 			of items, from which to select for adding to the 
	 * 			shopping list, each one of them is an object from 
	 * 			Product class that have "Name", "ID" and "Quantity".
	 * @throws	ArithmeticException if cnt=0
	 * @return	void
	 */
		
	public void addItemByID(int id,int cnt, LinkedList<Product> inventory){
		
		if(cnt==0){
			throw new ArithmeticException("Quantity valued must be cnt>=1");
			
		}else{
		
		for (int i=0; i<=(inventory.size()-1);i++){	
			int idx=(inventory.get(i)).getId();
			
			
			if (id==idx & inList.contains(inventory.get(i)) ){
				
				int shop_ind=inList.indexOf(inventory.get(i));								
				if(cnt==1){
					((Product) inList.get(shop_ind)).setCnt();
					System.out.println("Product: "+((Product) inList.get(shop_ind)).getId()+"Total Cnt: "+((Product) inList.get(shop_ind)).getCnt());
				}else{
					int inListCnt=((Product) inList.get(shop_ind)).getCnt();
					inListCnt=inListCnt+cnt;
					((Product) inList.get(shop_ind)).setCnt(inListCnt);
					System.out.println("Product: "+((Product) inList.get(shop_ind)).getId()+" Total Cnt: "+((Product) inList.get(shop_ind)).getCnt());
				}	
				
				
				
			}else if (id==idx & !inList.contains(inventory.get(i))){
				inList.addFirst(inventory.get(i));
				((Product) inList.get(0)).setCnt(cnt);
				System.out.println("Product: "+((Product) inList.get(0)).getId()+" Total Cnt: "+((Product) inList.get(0)).getCnt());
			}
			
		}
		
		}
		
	}
	
	/** Erase a item from the Shopping list. If cnt is equal to the
	 * quantity of the item "name" in Shopping list that item get Erase
	 * otherwise it's quantity drecrese.
	 * @see 	shoppingCartDemo
	 * @param 	name String	Selected item to be Erase or reduced it's quantity.
	 * @param	cnt	int 	Number of items of "name" to remove from Shopping list
	 */
	

	public void deletItemByName(String name, int cnt) {
		for (int i=0; i<=(inList.size()-1);i++){
			String nameShow=((Product) inList.get(i)).getName();
			
			if (nameShow.equals(name)){
				int inListCnt=((Product) inList.get(i)).getCnt();
				if(inListCnt<=cnt){
					inList.remove(i);
					break;
				}else{
					inListCnt=inListCnt-cnt;
					((Product) inList.get(i)).setCnt(inListCnt);
					break;
				}
			}
			
		}
		
		
		
	}
	
	/** Erase a item from the Shopping list. If cnt is equal to the
	 * quantity of the item "Id" in Shopping list that item get Erase
	 * otherwise it's quantity drecrese.
	 * @see 	shoppingCartDemo
	 * @param	id int		Selected item to be Erase or reduced it's quantity.
	 * @param	cnt	int 	Number of items of "name" to remove from Shopping list
	 */

	public void deletItemByID(int id, int cnt) {
		
		for (int i=0; i<=(inList.size()-1);i++){
			int idx=((Product) inList.get(i)).getId();
			
			if (id==idx){
				int inListCnt=((Product) inList.get(i)).getCnt();
				if(inListCnt<=cnt){
					inList.remove(i);
					break;
				}else{
					inListCnt=inListCnt-cnt;
					((Product) inList.get(i)).setCnt(inListCnt);
					break;
				}
			}
			
		}
		
	}
	
	
	
	
	/**
	 * Returns the "name" of the specific item in the Shopping list identified 
	 * with "id"
	 * @param	id	int	Identifier of the respective item 
	 * @return	name	String	name of the product.
	 */

	public String getItemName(int id) {
		String nameShow = null;
		for (int i=0; i<=(inList.size()-1);i++){
			int idx=((Product) inList.get(i)).getId();
			if (id==idx){
				nameShow=((Product) inList.get(i)).getName();
				break;
			}
		}
				
		return nameShow;
	}
	
	/**
	 * Returns the "id" of the specific item in the Shopping list identified 
	 * with "name"
	 * @param	name	String	Name of the respective item 
	 * @return	id		int		Identifier of the product.
	 */

	public int getItemID(String name) {
		int idx = 0;
		for (int i=0; i<=(inList.size()-1);i++){
			String nameShow=((Product) inList.get(i)).getName();
			if (nameShow.equals(name)){
				idx=((Product) inList.get(i)).getId();
				break;
			}
			
		}
		
		return idx;
	}

	
	/**
	 * Returns the number of elements of the specific item in the Shopping list identified 
	 * with "name"
	 * @param	name	String	Name of the respective item 
	 * @return	cnt		int		Number of items of "name" in the Shopping List.
	 */
	
	public int getItemCnt(String name) {
		int inListCnt = 0;
		for (int i=0; i<=(inList.size()-1);i++){
			String nameShow=((Product) inList.get(i)).getName();
			if (nameShow.equals(name)){	
				inListCnt=((Product) inList.get(i)).getCnt();
				break;
			}
		}
				
		return inListCnt;
	}
	
	

	

}
