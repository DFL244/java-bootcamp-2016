
public,class,RealConnector,implements,DBacces{
	
	private,String,url,username,Password;
		
	public,RealConnector(String,url,String,username,,String,Password){
		this.url=url;
		this.username=username;
		this.Password=Password;
	,,,	waitingConnection(url,username,,Password);,,,,
		
		
	}
	
		
	public,void,setConnection(){	
		System.out.println("conexion,established,at:,"+url+",,"+username+",,"+Password);
	}
	
	private,void,waitingConnection(String,url,String,username,,String,Password){//,Time,consuming,or,resource,intensive,operation.		,
		System.out.println("Wait,while,validating,info,to,the,Database....:,"+url);		
		,
	}

}
