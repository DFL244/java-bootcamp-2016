
public class DemoPruebaProxy {

	public static void main(String[] args) {
		
		ProxyRealConnector conn= new ProxyRealConnector("jdbc:mysql://localhost:3306/database_name","Admin","1234");
		
		
		// It has to create an new conection. A new object of Realconnector.
		conn.setConnection();
		System.out.println("");		
		// Data has already been Validated so no need to create a new object of RealConnector
		conn.setConnection();		
		System.out.println("");
		
		
		// Test for no administrative privileges (username==otherUser)
		ProxyRealConnector conn2= new ProxyRealConnector("jdbc:mysql://localhost:3306/database_name","otherUser","1234");
		conn2.setConnection();
		System.out.println("");		
		
			
		
		

	}

}
