package userservice.exc2;

import java.util.List;


/**
 * Proxy class that manage the instantiation of UserServiceCRUDimp's objects.
 * 
 * @author Daniel Fernando Lopez
 * @version 0.0.1 
 *
 */
public class UserServiceCRUDImpProxy implements UserServiceCRUD {

	
	private UserServiceCRUDImp realobj;
	boolean conn=false;
		
	
	
	/**
	 * Constructor allows to create empty objets from 
	 * UserServiceCRUDImpProxy
	 *  
	 */
	
	public UserServiceCRUDImpProxy(){		
	}
	
	
	
	
	public void connect() {
		if (realobj==null){
			realobj= new UserServiceCRUDImp();
			realobj.connect();
			conn=true;
			//System.out.println("Create an object and Connect firstime");
		}else{
			realobj.connect();
			//System.out.println("Re-uses already create Connect object ");
		}
		
	}

	public void create(User objUser) {
		if (conn){		
			realobj.create(objUser);
			//System.out.println("Re-uses already create (create)");
		}else{
			System.out.println("Connection has not been established");
			
		}		
	}

	public User read(int idx) {
		if (conn){
			//System.out.println("Re-uses already create (read)");
			return realobj.read(idx);
			
		}else{			
			System.out.println("Connection has not been established");
			return null;
		}		
	}

	
	public void update(User objUser) {
		if (conn){
			realobj.update(objUser);
			//System.out.println("Re-uses already create (update)");
		}else{
			System.out.println("Connection has not been established");
		}
		
	}

	public void delete(User objUser) {
		if (conn){
			realobj.delete(objUser);
			//System.out.println("Re-uses already create (delete)");
		}else{
			System.out.println("Connection has not been established");
		}		
	}

	
	
	public List<User> getAllTable() {
		if (conn){
			//System.out.println("Re-uses already create (getAllTable)");
			return realobj.getAllTable();			
		}else{
			System.out.println("Connection has not been established");
			return null;
		}		
	}
	
		
	

}
