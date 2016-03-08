package userservice.exc2;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class UserServiceCRUDImpTest {
	

	@Test
	public void shouldAddaUserToDB(){
		
		UserServiceCRUDImp uSCimp1 = new UserServiceCRUDImp();
		User u1= new User("Us1",1);
		User u12= new User("Us12",2);
		List l1 = new LinkedList<Object>();
		uSCimp1.connect();
		uSCimp1.create(u1);
		l1=uSCimp1.getAllTable();
		assertEquals("size of the array should be 1",1,l1.size());
		
		uSCimp1.create(u12);
		l1=uSCimp1.getAllTable();
		assertEquals("size of the array should be 2",2,l1.size());		
		
	}
	
	@Test
	
	public void ShouldGetUserFromDb(){
		
		UserServiceCRUDImp uSCimp2 = new UserServiceCRUDImp();
		User u1= new User("Us1",1);
		User u2= new User("Us2",2);
		User u3= new User("Us3",3);
		uSCimp2.connect();
		uSCimp2.create(u1);
		uSCimp2.create(u2);
		uSCimp2.create(u3);
		
		Object obj=uSCimp2.read(1);
		assertEquals("Should get the user u2",u2,obj);
				
	} 
	
	
	@Test
	public void ShouldChangeParametersOfUser(){
		
		UserServiceCRUDImp uSCimp3 = new UserServiceCRUDImp();
		List l3 = new LinkedList<Object>();
		User u1= new User("Us1",1);
		User u2= new User("Us2",2);
		User u3= new User("Us3",3);
		uSCimp3.connect();
		uSCimp3.create(u1);
		uSCimp3.create(u2);
		uSCimp3.create(u3);
		
		assertEquals("Both Names should be the same","Us3",u3.getName());
		assertEquals("Both Id should be the same",3,u3.getId());
		User.printUser(u3);
		
		u3.setName("Us3-3");
		u3.setId(33);	
		uSCimp3.update(u3);		
		assertNotSame("Both Names shouldn't be the same","Us3",u3.getName());
		assertNotSame("Both id shouldn't be the same",3,u3.getName());
		User.printUser(u3);
		l3=uSCimp3.getAllTable();
		System.out.println("****");
		User.printArray(l3);		
	}
	
	
	
	@Test	
	public void ShouldDeleteUser(){
		
		UserServiceCRUDImp uSCimp4 = new UserServiceCRUDImp();
		List l4 = new LinkedList<Object>();
		User u1= new User("Us1",1);
		User u2= new User("Us2",2);
		User u3= new User("Us3",3);
		uSCimp4.connect();
		uSCimp4.create(u1);
		uSCimp4.create(u2);
		uSCimp4.create(u3);
		l4=uSCimp4.getAllTable();
		User.printArray(l4);
		assertEquals("Array size should be 3",3,l4.size());
		
		uSCimp4.delete(u2);
		User.printArray(l4);
		assertEquals("Array size should be 2",2,l4.size());
		
	}
	
	
	
	//**************************Proxy*************************+
	
	
	@Test
	
	public void shouldAddaUserToDBProxy(){
			
		UserServiceCRUDImpProxy uSCimp1 = new UserServiceCRUDImpProxy();
			User u1= new User("Us1",1);
			User u12= new User("Us12",2);
			List l1 = new LinkedList<Object>();
			uSCimp1.connect();
			uSCimp1.create(u1);
			l1=uSCimp1.getAllTable();
			assertEquals("size of the array should be 1",1,l1.size());
			
			uSCimp1.create(u12);
			l1=uSCimp1.getAllTable();
			assertEquals("size of the array should be 2",2,l1.size());
		
	}


	@Test
	
	public void ShouldGetUserFromDbProxy(){
		
		UserServiceCRUDImpProxy uSCimp2 = new UserServiceCRUDImpProxy();
		User u1= new User("Us1",1);
		User u2= new User("Us2",2);
		User u3= new User("Us3",3);
		uSCimp2.connect();
		uSCimp2.create(u1);
		uSCimp2.create(u2);
		uSCimp2.create(u3);
		
		Object obj=uSCimp2.read(1);
		assertEquals("Should get the user u2",u2,obj);
				
		} 

	@Test
	public void ShouldChangeParametersOfUserProxy(){
		
		UserServiceCRUDImpProxy uSCimp3 = new UserServiceCRUDImpProxy();
		List l3 = new LinkedList<Object>();
		User u1= new User("Us1",1);
		User u2= new User("Us2",2);
		User u3= new User("Us3",3);
		uSCimp3.connect();
		uSCimp3.create(u1);
		uSCimp3.create(u2);
		uSCimp3.create(u3);
		
		assertEquals("Both Names should be the same","Us3",u3.getName());
		assertEquals("Both Id should be the same",3,u3.getId());
		User.printUser(u3);
		
		u3.setName("Us3-3");
		u3.setId(33);	
		uSCimp3.update(u3);		
		assertNotSame("Both Names shouldn't be the same","Us3",u3.getName());
		assertNotSame("Both id shouldn't be the same",3,u3.getName());
		User.printUser(u3);
		l3=uSCimp3.getAllTable();
		System.out.println("****");
		User.printArray(l3);		
	}

	
	@Test	
	public void ShouldDeleteUserProxy(){
		
		UserServiceCRUDImpProxy uSCimp4 = new UserServiceCRUDImpProxy();
		List l4 = new LinkedList<Object>();
		User u1= new User("Us1",1);
		User u2= new User("Us2",2);
		User u3= new User("Us3",3);
		uSCimp4.connect();
		uSCimp4.create(u1);
		uSCimp4.create(u2);
		uSCimp4.create(u3);
		l4=uSCimp4.getAllTable();
		User.printArray(l4);
		assertEquals("Array size should be 3",3,l4.size());
		
		uSCimp4.delete(u2);
		User.printArray(l4);
		assertEquals("Array size should be 2",2,l4.size());
		
	}
	
	
	//*************Final**************************
	
	
@Test
	
	public void shouldAddaUserToDBWebConn(){
			
	UserServiceCRUD uSCimp1 = UserServiceCRUDFactory.useWebConnection();
			User u1= new User("Us1",1);
			User u12= new User("Us12",2);
			List l1 = new LinkedList<Object>();
			uSCimp1.connect();
			uSCimp1.create(u1);
			l1=uSCimp1.getAllTable();
			assertEquals("size of the array should be 1",1,l1.size());
			
			uSCimp1.create(u12);
			l1=uSCimp1.getAllTable();
			assertEquals("size of the array should be 2",2,l1.size());
		
	}


	@Test
	
	public void ShouldGetUserFromDbWebConn(){
		
		UserServiceCRUD uSCimp2 = UserServiceCRUDFactory.useWebConnection();
		User u1= new User("Us1",1);
		User u2= new User("Us2",2);
		User u3= new User("Us3",3);
		uSCimp2.connect();
		uSCimp2.create(u1);
		uSCimp2.create(u2);
		uSCimp2.create(u3);
		
		Object obj=uSCimp2.read(1);
		assertEquals("Should get the user u2",u2,obj);
				
		} 

	@Test
	public void ShouldChangeParametersOfUserWebConn(){
		
		UserServiceCRUD uSCimp3 = UserServiceCRUDFactory.useWebConnection();
		List l3 = new LinkedList<Object>();
		User u1= new User("Us1",1);
		User u2= new User("Us2",2);
		User u3= new User("Us3",3);
		uSCimp3.connect();
		uSCimp3.create(u1);
		uSCimp3.create(u2);
		uSCimp3.create(u3);
		
		assertEquals("Both Names should be the same","Us3",u3.getName());
		assertEquals("Both Id should be the same",3,u3.getId());
		User.printUser(u3);
		
		u3.setName("Us3-3");
		u3.setId(33);	
		uSCimp3.update(u3);		
		assertNotSame("Both Names shouldn't be the same","Us3",u3.getName());
		assertNotSame("Both id shouldn't be the same",3,u3.getName());
		User.printUser(u3);
		l3=uSCimp3.getAllTable();
		System.out.println("****");
		User.printArray(l3);		
	}

	
	@Test	
	public void ShouldDeleteUserWebConn(){
		
		UserServiceCRUD uSCimp4 = UserServiceCRUDFactory.useWebConnection();
		List l4 = new LinkedList<Object>();
		User u1= new User("Us1",1);
		User u2= new User("Us2",2);
		User u3= new User("Us3",3);
		uSCimp4.connect();
		uSCimp4.create(u1);
		uSCimp4.create(u2);
		uSCimp4.create(u3);
		l4=uSCimp4.getAllTable();
		User.printArray(l4);
		assertEquals("Array size should be 3",3,l4.size());
		
		uSCimp4.delete(u2);
		User.printArray(l4);
		assertEquals("Array size should be 2",2,l4.size());
		
	}
	
	
}
