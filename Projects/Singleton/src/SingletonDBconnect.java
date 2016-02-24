/*
 *******************************
import com.mysql.jdbc.Connection;
import java.sql.*;
import java.sql.DriverManager;
********************************
 */

public final class SingletonDBconnect {
	
	// This is the static variable that has the only instance of the singletonDBconnect class
	private static SingletonDBconnect onlyInstance = null;
	private String text="";
	
	
	private SingletonDBconnect(){// Constructor is private so not other class nor object is capable to instantiate others objects
		
		// Database connection stuff
		
		/*
		 ************************************************************
		String url= "jdbc:mysql://localhost:3306/database_name";
        String userName = "username";
        String password = "password";
           
         //There is suppose to be a sql connection here. something like this no sure:
        
         try{
         	Connection Connect= DriverManager.getConnection(url,userName,password);
             }
          catch(Exception exc){
          	exc.printStackTrace();
          
          }
          **********************************************************             
		 */
	}
	
	/* This method assures to creates the only Object of the singleton Class
	 * and also returns an instance of it. (For the  case of the database connection the instances "onlyInstance" will be a Database connection object)
	*/
	public synchronized static SingletonDBconnect getInstance (){
		// the method uses the synchonized stantment so in case of threaded environments, it won create an other object of this class.
		if(onlyInstance==null){
			onlyInstance= new SingletonDBconnect();			
		}		
		return onlyInstance; 
	}
	
	/*
	 * Here should be some query methods 
	 * 
	 */
}
