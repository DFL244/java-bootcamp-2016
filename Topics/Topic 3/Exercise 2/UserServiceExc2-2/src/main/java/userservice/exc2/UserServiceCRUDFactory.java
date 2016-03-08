package userservice.exc2;

public class UserServiceCRUDFactory {
	
	private UserServiceCRUDFactory(){
		
	}
	
	
	public static UserServiceCRUD useLocalConnection(){
		return new UserServiceCRUDImp();
	}
	
	public static UserServiceCRUD useWebConnection(){
		
		
		
		return new UserServiceCRUDWebConnection();
	}
	

}
