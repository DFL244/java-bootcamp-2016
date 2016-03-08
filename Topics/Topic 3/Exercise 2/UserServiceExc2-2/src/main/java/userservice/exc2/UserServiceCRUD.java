package userservice.exc2;

import java.util.List;


/**This Interfce allows to manage a database by providing CRUD operations using UserServiceCRUDImp and 
* a proxy to isolate the client. In order to get the instance of this manager, the class 
* {@link #UserServiceCRUDImp()} can be used.
* 
* @author Daniel Fernando Lopez
* @version 0.0.1
* 
*/

public interface UserServiceCRUD {
	
	
	public void connect();
	
	// Insert
	public void create(User objUser );
	
	//get
	public User read(int idx);
	
	
	//set
	public void update(User objUser);
	
	
	//del
	public void delete(User objUser);
	
	public List <User> getAllTable();
	
}

