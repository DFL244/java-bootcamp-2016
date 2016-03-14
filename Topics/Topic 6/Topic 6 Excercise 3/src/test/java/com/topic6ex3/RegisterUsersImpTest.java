package com.topic6ex3;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;


// This tests are running base on a real database connection.


public class RegisterUsersImpTest {
	
	String URL ="jdbc:mysql://localhost:3306/dbtest";
	String User="root";
	String Pass="root1234";
	RegisterUsersImp db=RegisterUsersImp.connect(URL, User, Pass);
	
	// 
	
	
	
	
	@Test
	public void shouldGetandUserByName(){
		
		List <User> l1= new ArrayList<User>();
		User u1=new User(1,"name1","nickname1");
		User u6=new User(6,"name1","nickname6");		
		
		
		String query1="Select id, name, nickname from testTable where name = 'name1'";
		db.read(query1);
		l1=db.formater();
		assertEquals("Name must be the same for User 1",u1.getName(),(l1.get(0)).getName());
		assertEquals("Nickname must be the same for User 1",u1.getNickName(),(l1.get(0)).getNickName());		
		assertEquals("Name must be the same for User 6",u6.getName(),(l1.get(1)).getName());
		assertEquals("Nickname must be the same for User 6",u6.getNickName(),(l1.get(1)).getNickName());			
		
	}
	
	@Test
	public void shouldGetUserByNickname(){
		
		List <User> l2= new ArrayList<User>();
		User u3=new User(3,"name3","nickname6");
		User u6=new User(6,"name1","nickname6");
		
				
		
		String query2="Select id, name, nickname from testTable where nickname = 'nickname6'";
		db.read(query2);
		l2=db.formater();
		assertEquals("Name must be the same for User 3",u3.getName(),(l2.get(0)).getName());
		assertEquals("Nickname must be the same for User 3",u3.getNickName(),(l2.get(0)).getNickName());		
		assertEquals("Name must be the same for User 6",u6.getName(),(l2.get(1)).getName());
		assertEquals("Nickname must be the same for User 6",u6.getNickName(),(l2.get(1)).getNickName());
		
	}
	
	
	@Test
	public void shouldInsertaUser(){
		
			
		int op=0;
		String query3= "insert into testTable values (7,'name7','nickname7')";
		op=db.Create(query3);
		assertEquals("Should return one row affected",1,op);
		
		op=0;
		String query4= "insert into testTable values (8,'name8','Nickname8'),(9,'name9','nickname9')";
		op=db.Create(query4);
		assertEquals("Should return two row affected",2,op);	
		
		
		db.delete("delete from testTable where id = 7");
		db.delete("delete from testTable where id = 8");
		db.delete("delete from testTable where id = 9");
		
		
	}
	
	

	
	@Test
	public void shouldUpdateName(){
		int op=0;
		String query5= "UPDATE testTable SET name = 'name22' WHERE id = 2";
		op=db.update(query5);
		assertEquals("Should return one row affected",1,op);		
		
	}
	
	
	@Test
	public void shouldDeleteUser(){	

		
		int op=0;		
		String query5= "insert into testTable values (10,'name10','Nickname10')";
		op=db.Create(query5);
		assertEquals("Should return one row affected",1,op);	
		
		
		op=0;
		String query6= "delete from testTable where id = 10";
		op=db.delete(query6);
		assertEquals("Should return one row affected",1,op);
	
			
		
		
	}
	
	
	
	
	
	

	
	

}
