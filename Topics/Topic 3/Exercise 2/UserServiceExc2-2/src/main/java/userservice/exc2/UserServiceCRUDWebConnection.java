package userservice.exc2;

import java.util.List;

public class UserServiceCRUDWebConnection implements UserServiceCRUD{

	UserServiceCRUDImpProxy jmsObject;
	
	public UserServiceCRUDWebConnection(){		
		jmsObject=new UserServiceCRUDImpProxy();
		
	}	
	
	public void connect() {
		jmsObject.connect();
		
	}

	public void create(User objUser) {
		jmsObject.create(objUser);
		
	}

	public User read(int idx) {
		
		return jmsObject.read(idx);
	}

	public void update(User objUser) {
		jmsObject.update(objUser);
		
	}

	public void delete(User objUser) {
		jmsObject.delete(objUser);
		
	}

	public List<User> getAllTable() {
		
		return jmsObject.getAllTable();
	}

}
