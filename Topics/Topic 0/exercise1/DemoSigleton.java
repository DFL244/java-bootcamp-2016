
public class DemoSigleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SingletonDBconnect obj1 = SingletonDBconnect.getInstance();
		System.out.println("The number of created objects is: "+SingletonDBconnect.getcntIsntances());
		SingletonDBconnect obj2 = SingletonDBconnect.getInstance();
		System.out.println("The number of created objects is: "+SingletonDBconnect.getcntIsntances());
		
		
		
	}

}
