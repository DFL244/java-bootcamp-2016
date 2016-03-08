package userservice.exc2;

import java.util.LinkedList;
import java.util.List;

/**
 * This Class simulates a database by means of a LinkedList Array
 * 
 * @author DFL
 *
 */

public class simulDb {
	
	private int indx;
	
	public LinkedList<User> objdb;
	
	public simulDb(){		
		objdb= new LinkedList<User>();		
	}
	
	
	
	public boolean insertdb(User objUser){		
		objdb.add(objUser);
		if (objdb.contains(objUser)){			
			return true;
		}else{
			return false;
		}
			
		
	}

	public User getdb(int idx){		
		//		
		return objdb.get(idx);
	}
	
	
	public boolean setdb(User objUser){		
		if(objdb.contains(objUser)){		
		indx=objdb.indexOf(objUser);
		objdb.set(indx, objUser);
		return true;
		}else{
			return false;
		}
	}
	
	
	public void setdb(String name, int id){
		
	}
	
	
	public boolean erasedb(User objUser){		
		if(objdb.contains(objUser)){
			objdb.remove(objUser);
			return true;
		}else {		
			return false;
		}
	}
	
	
	public List <User> getTabledb(){		
		return objdb;
	}
	
	
	
}
