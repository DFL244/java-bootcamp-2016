package TDDExcercise2;

import java.util.*;

public class BlogPost {

	ArrayList<String>PostList =new ArrayList<String>();
	Recentfilelist objList;
	
	public BlogPost(){
		PostList= new ArrayList<String>();
		objList=new Recentfilelist();
	}
	
	
	public ArrayList<String> PostNewEntry(String NewEntry){
		
		PostList=objList.addReceentFileList(PostList,NewEntry);	
		//System.out.println(""+NewEntry);
		for(int i=0;i<(PostList.size());i++){
			System.out.println(""+PostList.get(i));
			}
		System.out.println("");
		System.out.println("**********");
		
		return this.PostList;		
				
	}
	
	public ArrayList<String> delPost(String delEntry){
		
		PostList.remove(delEntry);
		
		for(int i=0;i<(PostList.size());i++){
			System.out.println(""+PostList.get(i));
			}
		System.out.println("");
		System.out.println("**********");
		
		
		return this.PostList;
	}
	
	public ArrayList<String> historical(int num_h){
		
		for(int i=14;i>=num_h;i-- ){
			PostList.remove(i);					
		}		
		
		System.out.println("The last "+num_h+" entries are: ");
		for(int i=0;i<(PostList.size());i++){
			System.out.println(""+PostList.get(i));
			}
		System.out.println("");
		System.out.println("**********");
				
		return this.PostList;
	}
	
	
	
	
	public static void main(String[] args) {
		
		BlogPost demo =new BlogPost();
		
		/*demo.PostNewEntry("Post1");
		demo.PostNewEntry("Post2");
		demo.PostNewEntry("Post3");
		demo.delPost("Post2");
		demo.delPost("Post1");
		*/
		
		for(int i=0; i<=20; i++){
			demo.PostNewEntry("Post"+i);			
		}
		
		demo.historical(10);
		
		

	}

}
