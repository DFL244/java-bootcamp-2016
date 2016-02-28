package exercise1;

import java.util.*;

public class Recentfilelist {
	
	private ArrayList<String> rFList= new ArrayList<String>(15);
	
	public Recentfilelist(){	
		rFList= new ArrayList<String>();
	
	}
	
	public ArrayList<String> clearList( ArrayList<String> arList){
		arList.clear();
		System.out.println("Recent File list has been Cleaned"+this.rFList);
		return this.rFList=arList;		
		
	}
	
	public ArrayList<String> addReceentFileList(ArrayList<String> arList, String File){
		
		int ind=arList.indexOf(File);		
		if(ind==-1){
			if(arList.size()==15){
				arList.remove(14);	
			}
			arList.add(0, File);
		}else {
			arList.remove(ind);
			arList.add(0, File);
		}
		
		this.rFList=arList;		
		System.out.println("The File "+File+" has been opened");
		System.out.println("Recent File list "+this.rFList);
		return this.rFList;
	}

	
	
	public static void main(String[] args) {
		
		ArrayList<String> Demo = new ArrayList<String>();
		Recentfilelist objDemo =new Recentfilelist();
		
		for(int i=0;i<=19;i++){
			Demo=objDemo.addReceentFileList(Demo, "File"+i);
			System.out.println("The size of the List is: "+Demo.size());
		}
		
		Demo=objDemo.addReceentFileList(Demo, "File8");
		Demo=objDemo.addReceentFileList(Demo, "File13");
		
		objDemo.clearList(Demo);
		
				
		
	}
}
