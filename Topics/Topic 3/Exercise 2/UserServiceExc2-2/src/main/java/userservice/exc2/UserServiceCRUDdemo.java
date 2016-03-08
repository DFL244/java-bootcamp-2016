package userservice.exc2;

import java.util.LinkedList;
import java.util.List;

public class UserServiceCRUDdemo {

	public static void main(String[] args) {
		


/*		
		//*********************************************************************
		UserServiceCRUD proxyObj = UserServiceCRUDFactory.useLocalConnection();
		UserServiceCRUD proxyObj2 = UserServiceCRUDFactory.useLocalConnection();
		List l4 = new LinkedList<Object>();
		User u1= new User("Us1",1);
		User u2= new User("Us2",2);
		User u3= new User("Us3",3);
		User u4= new User("Us4",4);
		
		proxyObj.connect();
		proxyObj.create(u1);
		proxyObj.create(u2);
		proxyObj.create(u3);
		
		l4=proxyObj.getAllTable();
		User.printArray(l4);
		
		
		proxyObj2.connect();
		proxyObj2.create(u4);
		l4=proxyObj2.getAllTable();
		User.printArray(l4);
		
		
		
	*/	
		//********************************************************
		UserServiceCRUD proxyObj3 = UserServiceCRUDFactory.useWebConnection();
		UserServiceCRUD proxyObj4 = UserServiceCRUDFactory.useWebConnection();
		List l5 = new LinkedList<Object>();
		User u6= new User("Us6",6);
		User u7= new User("Us7",7);
		User u8= new User("Us8",8);
		User u9= new User("Us9",9);
		
		proxyObj3.connect();
		proxyObj3.create(u6);
		proxyObj3.create(u7);
		proxyObj3.create(u8);
		System.out.println("*************");
		l5=proxyObj3.getAllTable();
		User.printArray(l5);
		System.out.println("*************");
		proxyObj3.connect();
		l5=proxyObj3.getAllTable();
		User.printArray(l5);
		System.out.println("*************");
		
		
		//***delete**
		proxyObj3.delete(u7);
		l5=proxyObj3.getAllTable();
		User.printArray(l5);
		System.out.println("*************");
		
		//**Update
		u8.setName("u8-8");
		u8.setId(88);
		proxyObj3.update(u8);
		l5=proxyObj3.getAllTable();
		User.printArray(l5);
		System.out.println("*************");
		
		
		User uobj=proxyObj3.read(1);
		User.printUser(uobj);
		
				
		
		}
		
		
	


}
