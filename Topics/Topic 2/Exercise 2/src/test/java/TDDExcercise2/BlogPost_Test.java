package TDDExcercise2;
import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Test;

public class BlogPost_Test {
	
	
	@Test
	public void should_Post_a_New_Entry(){
		
	ArrayList<String>Post =new ArrayList<String>();	
	//Recentfilelist objDemo =new Recentfilelist();
	BlogPost obj1=new BlogPost();
	Post=obj1.PostNewEntry("Post1");
	ArrayList<String> Post_test = new ArrayList<String>(Arrays.asList("Post1"));
	
	assertEquals("The post should be the same",Post_test,Post);
	
	}	
	
	
	@Test
	
	public void should_eliminate_a_Post(){
		
		ArrayList<String>delPost =new ArrayList<String>();
		BlogPost obj2=new BlogPost();
		delPost=obj2.PostNewEntry("Post1");
		delPost=obj2.PostNewEntry("Post2");
		delPost=obj2.PostNewEntry("Post3");
		ArrayList<String> delPost_test = new ArrayList<String>(Arrays.asList("Post3","Post1"));
		delPost=obj2.delPost("Post2");
		
		assertEquals("Post 2 is gone",delPost_test,delPost);
	}
	
	
	@Test 
	public void show_10_recent_entries(){
		
		ArrayList<String>hPost =new ArrayList<String>();
		ArrayList<String>hPost_test =new ArrayList<String>();
		BlogPost obj3=new BlogPost();
		
		for(int i=0; i<=20; i++){
			hPost=obj3.PostNewEntry("Post"+i);			
		}
						
		for(int i=20; i>=6; i--){
			hPost_test.add("Post"+i);			
		}				
		
		for(int i=14;i>=10;i-- ){
			hPost_test.remove(i);
		}
		
		hPost=obj3.historical(10);
		assertEquals("Show 10 most recent Post",hPost_test,hPost);				
		
	}
	
	


}
