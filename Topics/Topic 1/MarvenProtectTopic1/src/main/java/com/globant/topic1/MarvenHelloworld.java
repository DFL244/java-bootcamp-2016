package com.globant.topic1;
import org.apache.logging.log4j.Logger;


public class MarvenHelloworld {
	
	private int z;
	
	public  int multiply(int x, int y){		
		z=x*y;
		return z;
	}

	public static void main(String[] args) {
		
		int x=2,y=3,res;
		// TODO Auto-generated method stub
		MarvenHelloworld obj1= new MarvenHelloworld();
		
		res=obj1.multiply(x, y);
		
		System.out.println("The product of "+x+" and "+y+" is: "+res);

	}

}
