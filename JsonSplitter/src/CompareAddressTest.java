import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CompareAddressTest {

	@Test
	void compareaddresstest() {
		
		int result;
		Jsonsplit js = new Jsonsplit();
		
		result = js.compareAddress("xyzöü12321");
		assertTrue(result>=0 && result<=5);
		
		result = js.compareAddress("Calle 39 No 1540");
		assertEquals(1,result);
		
		result = js.compareAddress("Musterstrasse 45");
		assertEquals(2,result);
		
		result = js.compareAddress("Winterallee 3");
		assertEquals(2,result);
		
		result = js.compareAddress("Blaufeldweg 123B");
		assertEquals(2,result);
		
		result = js.compareAddress("Am Bächle 23");
		assertEquals(2,result);
		
		result = js.compareAddress("Auf der Vogelwiese 23 b");
		assertEquals(5,result);
		
		result = js.compareAddress("4, rue de la revolution");
		assertEquals(4,result);
		
		result = js.compareAddress("200 Broadway Av");
		assertEquals(3,result);
		
		result = js.compareAddress("Calle Aduana, 29");
		assertEquals(2,result);
		
		result = js.compareAddress("xyzöü");
		assertEquals(0,result);
		
	}

}
