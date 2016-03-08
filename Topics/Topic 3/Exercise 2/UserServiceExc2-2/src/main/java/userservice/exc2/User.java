package userservice.exc2;

import java.util.List;

public class User {
	
	private String name;
	private int id;
	
	public User(String name,int id){		
		this.name=name;
		this.id=id;		
	}
	
	public User(){		
				
	}
	
	
	public String getName(){
		return name;		
	}
	
	public int getId(){
		return id;
	}
	
	
	public void setName(String name){		
		this.name= name;		
	}
	
	
	public void setId(int id){		
		this.id= id;		
	}
	
	
	public static void printUser(User user){
		System.out.println("Name: "+user.getName()+" id: "+user.getId());
	}
	
	public static void printArray(List <User> array){
		
		for(int i=0;i<=(array.size()-1);i++){
			//User.printUser(array.get(i));
			User Uobj=array.get(i);
			System.out.println("Name: "+Uobj.getName()+" id: "+Uobj.getId()+" index: "+i);
		}
		
	}
	

}
