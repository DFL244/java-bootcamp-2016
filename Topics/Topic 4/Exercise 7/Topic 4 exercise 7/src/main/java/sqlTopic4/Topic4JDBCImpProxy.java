package sqlTopic4;

public class Topic4JDBCImpProxy implements Topic4JDBC{

	private Topic4JDBCImp ImpObj;
	
	
	public Topic4JDBCImpProxy(){		
	}
	
	
	public Object read(String query) {		
		
		return ImpObj.read(query);
	}
	
	
	public synchronized Object logIn(String Url, String User, String Pass){
		
		ImpObj=Topic4JDBCImp.logIn(Url, User, Pass);
		return ImpObj;
	}
	
	public void showQuery(){
		ImpObj.showQuery();
	}
	

}
