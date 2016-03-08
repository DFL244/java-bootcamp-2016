package userservice.exc2;

import java.util.List;

/**
* This Class implements the methods of the interfce UserServiceCRUD for CRUD operations.
* 
* @author Daniel Fernando Lopez
* @version 0.0.1 
 */



public class UserServiceCRUDImp implements UserServiceCRUD{
	
	simulDb objsimuldb=null;
	boolean yn=false;

	
	/**
	 *Manage the connection to the "Database" creates an object that 
	 *initiate the ArrayList which makes the times of a database.
	 *@param	None
	 *@return 	void	
	 *<p>
	 *
	 *@see {@link #simulDb()}
	 * </p> 
	 */
	
	public void connect(){
		if(objsimuldb==null){
			objsimuldb=new simulDb();
			System.out.println("Connecting to data base..... Connection established");
		}		 
	}
	
	/**
	 *Insert a new User Object to the Database. Prints on the command prompt a menssage
	 *indicating if the procces was Done.
	 *
	 *@param	objUser		User type Object It includes Name and Id.  
	 *@return	void
	 * <p>
	 *@see {@link #User()}
	 * </p> 
	 */
	
	public void create(User objUser){
		yn=objsimuldb.insertdb(objUser);
		System.out.println("create Done ? "+yn);
	}
	
	
	/**
	 * Returns a User Objet type that contains String Name and Int Id, from the
	 * database  
	 * @param	idx 	Int index of item to get. 
	 * @return	objUser User type Object containig Name and Id
	 */
	public User read(int idx){		
		return objsimuldb.getdb(idx);		
	}
	
	/**
	 * Replace de original User Objet with the new updated version.Prints on the command prompt a menssage
	 *indicating if the procces was Done.	 * 
	 * @param objUser	User type Object
	 * @return	void
	 */
	public void update(User objUser){
		if(objsimuldb.setdb(objUser)){
			System.out.println("update Done ? true");
		}else {
			System.out.println("update Done ? false");
		}
		
		
	} 
	
	
	/**
	 * Erase the indicate Object from the database.Prints on the command prompt a menssage
	 *indicating if the procces was Done.	
	 * @param	objUser 	User type Object
	 * @return	void
	 * 
	 */
	public void delete(User objUser){
		if(objsimuldb.erasedb(objUser)){
			System.out.println("delete Done ? true");
		}else{
			System.out.println("delete Done ? false");
		}
		
	}
	
	
	/**
	 *Retrieves the current state of the database
	 * @param 	void
	 * @return	List<User>	LinkedArray
	 */
	
	public List <User> getAllTable(){
		
		return objsimuldb.getTabledb();
	}

}
