
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.globant.topic1.MarvenHelloworld;

public class MarvenHelloworldTest {

	@Test
	public void multiplication_twoIntegersShouldReturnInteger() {
		
		MarvenHelloworld tester1= new MarvenHelloworld();
		
		assertEquals("5 x 6 must be 30", 30, tester1.multiply(6, 5));
	    assertEquals("0 x 10 must be 0", 0, tester1.multiply(0, 10));
	    assertEquals("1 x 1 must be 1", 1, tester1.multiply(1, 1));
	}
	
	@Test
	public void multiplication_oneNegative_and_onePositve_ShouldReturnNegative(){
		
		MarvenHelloworld tester2= new MarvenHelloworld();
		
		assertEquals("4 x -6 must be -24", -24, tester2.multiply(4, -6));
	    assertEquals("5 x -3 must be -15", -15, tester2.multiply(5, -3));
	    
	}
	
	
}
