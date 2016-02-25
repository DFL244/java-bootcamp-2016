


public final class SingletonDBconnect {
	
	// This is the static variable that has the only instance of the singletonDBconnect class
	private static SingletonDBconnect onlyInstance = null;
		
	private static int objcnt=0;
			
	private SingletonDBconnect(){// Constructor is private so not other class is capable to instantiate others objects
		objcnt++;
		System.out.println("It Creates the Object for the first time # Objects: "+objcnt);
	}
	
	/* This method assures to creates the only Object of the singleton Class
	 * and also returns an instance of it.
	 * 	*/
	public synchronized static SingletonDBconnect getInstance (){
		// the method uses the synchonized stantment so in case of threaded environments, it won create an other object of this class.
		if(onlyInstance==null){
			onlyInstance= new SingletonDBconnect();				
		}
		return onlyInstance;
		
	}
	
	/*
	 * Here should be some other methods for this class as well some SQL query methods. 
	 * 
	 */
	public static int getcntIsntances(){
		return objcnt;
		
	}
	
}
