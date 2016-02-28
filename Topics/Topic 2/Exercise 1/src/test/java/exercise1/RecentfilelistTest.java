package exercise1;

import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Test;

import exercise1.Recentfilelist;


public class RecentfilelistTest {

	@Test
	public void list_should_be_empty(){
		
		Recentfilelist firstlist =new Recentfilelist();
		ArrayList<String> listEmpty = new ArrayList<String>(15);
		listEmpty.add("FileList1");
		listEmpty.add("FileList2");
		ArrayList<String> listEmpty_Test = new ArrayList<String>(15);
		
		assertEquals("List should be empty",listEmpty_Test,firstlist.clearList(listEmpty));
	
	}
	@Test
	public void item_should_be_added_to_the_Recent_filelist(){
		
		Recentfilelist obj =new Recentfilelist();
		ArrayList<String> rFlist = new ArrayList<String>(Arrays.asList("File1", "File2","File3","File4","File5"));
		rFlist=obj.addReceentFileList(rFlist,"File6");
		ArrayList<String> rFlist_test = new ArrayList<String>(Arrays.asList("File1", "File2","File3","File4","File5","File6"));
				
		assertEquals("File must be added to the list",rFlist_test.contains("File6"),rFlist.contains("File6"));
		
	}
	
	@Test
	
	public void item_should_be_bumped_to_the_top_if_repeated(){
		
		Recentfilelist obj2 =new Recentfilelist();
		ArrayList<String> top_List = new ArrayList<String>(Arrays.asList("File1", "File2","File3","File4","File5"));
		top_List=obj2.addReceentFileList(top_List, "File4");
		ArrayList<String> top_List_test = new ArrayList<String>(Arrays.asList("File4", "File1","File2","File3","File5"));
		
		assertEquals("The File4 should be at the top of the list",top_List_test,top_List);
		
		
	}
	
	
	@Test
	public void List_size_should_always_be_15(){
		
		Recentfilelist obj3 =new Recentfilelist();
		ArrayList<String> size15List = new ArrayList<String>();
		
		for(int i=0; i<=20;i++){
			size15List=obj3.addReceentFileList(size15List,"File"+i);
			System.out.println("The size of the List is: "+size15List.size());
		}
		
		assertEquals("The size should be 15",15,size15List.size());
	}
	
		
	
	@Test
	public void oldes_item_should_be_removed_when_capacity_is_full(){
		
		Recentfilelist obj4 =new Recentfilelist();
		ArrayList<String> Full_List = new ArrayList<String>(Arrays.asList("File1", "File2","File3","File4","File5",
				"File6", "File7","File8","File9","File10","File11", "File12","File13","File14","File15"));
		Full_List=obj4.addReceentFileList(Full_List, "File16");
		
		ArrayList<String> Full_List_Test = new ArrayList<String>(Arrays.asList("File16","File1", "File2","File3","File4","File5",
				"File6", "File7","File8","File9","File10","File11", "File12","File13","File14"));
	
		
		assertEquals("The File15 should be removed from the list",Full_List_Test,Full_List);
		
	
	}
	
	
	
}
