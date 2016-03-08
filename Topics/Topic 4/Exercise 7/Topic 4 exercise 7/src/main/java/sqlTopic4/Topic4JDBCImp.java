package sqlTopic4;
import java.sql.*;

public class Topic4JDBCImp implements Topic4JDBC{
	
	Statement newStmt;
	Connection newConn;
	ResultSet newResSet;
	
	private static Topic4JDBCImp onlyDbInstance = null;
	
	private Topic4JDBCImp(String Url, String User, String Pass){
		
		try{			
			newConn =DriverManager.getConnection(Url,User,Pass);
			newStmt = newConn.createStatement();			
			
		}catch(Exception exc){
			exc.printStackTrace();			
		}
		
	}

	
	
	public Object read(String query) {
		try{
			
			newResSet= newStmt.executeQuery(query);
			
		}catch(Exception exc){
			exc.printStackTrace();			
		}
				
		return newResSet;
	}

	
			
	public synchronized static Topic4JDBCImp logIn (String Url, String User, String Pass){
		
		if(onlyDbInstance==null){
			onlyDbInstance=new Topic4JDBCImp(Url,User,Pass);
			return onlyDbInstance;
		}else{
			
			return onlyDbInstance;
		}
		
		
	}
	
	
	
	public void showQuery(){
		try{
			while(newResSet.next()){
				System.out.println(newResSet.getString("Teacher: <last-name>, <first-name>")+"    "+newResSet.getString("Schedule:"));			
			}
			
		}catch(Exception exc){
			exc.printStackTrace();			
		}
		
	}
	
	
	
}
