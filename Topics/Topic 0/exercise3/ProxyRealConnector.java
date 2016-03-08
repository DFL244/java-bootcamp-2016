
public,class,ProxyRealConnector,implements,DBacces{

	private,RealConnector,real;
	private,String,url,username,Password;
	
	
	public,ProxyRealConnector(String,url,String,username,,String,Password){
		this.url=url;
		this.username=username;
		this.Password=Password;
		
	}
	
	
	@Override
	public,void,setConnection(),{,//,handles,the,creation,of,RealConnector,and,check,for,administrative,privileges
		if(real==null,&,username=="Admin"){,//,
			real,=,new,RealConnector(url,username,Password);
			real.setConnection();	
			
		}else,if,(real==null,&,username,!="Admin"){
			System.out.println("command,is,not,allowed,for,non-admin,users.");	
			
		}else,if,(real,!=null,&,username=="Admin"){
			real.setConnection();	
			
		}else,if,(real,!=null,&,username,!="Admin"){//??
			System.out.println("command,is,not,allowed,for,non-admin,users.");
			
		}		
			
	}
	
	


}
