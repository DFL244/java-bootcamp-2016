package shoppingCart;

/**
 * This class specifies the prameters and methods of the
 * product class from which the inventory is made and shopping
 * cartList uses.
 * 
 * @author DFL
 *
 */

public class Product {
	
	private String name;
	private int id, cnt;
	
	
	
	public Product(){
	}
	
	/**
	 * Constructor create objects that represent
	 * products or items into the inventory and the shopping list
	 * @param name 	String 	it's the name of the product
	 * @param id	int 	the unique identifier for the product
	 */	
	public Product(String name, int id){
		this.name=name;
		this.id=id;
		cnt=1;		
		}
		
		
		
	
	
	
	//accessor methods
	
	/**
	 * Allow the name of the Product to be changed
	 * @param name String name of the product
	 * @return void
	 */
	public void setName(String name){
		this.name=name;	
	}
	
	/**
	 * Allow the id of the Product to be changed
	 * @param id int identifier for the product
	 * @return void
	 */

	public void setId(int id){
		this.id=id;
	}
	
		
	/**
	 * Allow to quantity of the product to be changed 
	 * @param cnt int Quantity of Product
	 */
	public void setCnt(int cnt){
		this.cnt=cnt;
	}
	
	/**
	 * Incremets by one unit the quantity value of a product
	 * @return void
	 */
	public void setCnt(){
		this.cnt=cnt+1;
	}
	
	//getters
	
	
	/**
	 * Retuns the Name of the specific product
	 * 
	 * @return name String
	 */
	public String getName(){
		return name;	
		
	}
	
	
	/**Retuns the Id of the specific product
	 * 
	 * 
	 * @return id int
	 */
	public int getId(){
		return id;
	}
	
	
	/**
	 * Retuns the Quantity of the specific product
	 * 
	 * @return cnt int
	 */
	public int getCnt(){
		return cnt;
	}
	
				
}


