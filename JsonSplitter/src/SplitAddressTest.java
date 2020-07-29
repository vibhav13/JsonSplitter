import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.json.simple.JSONObject;

class SplitAddressTest {

	@Test
	void splitaddresstest() {
		
		int result;
		Jsonsplit js = new Jsonsplit();
		JSONObject JSON_DATA;
		String house_no,street_name;
		
		result = js.compareAddress("Calle 39 No 1540");
		JSON_DATA = js.splitAddress("Calle 39 No 1540",result);
		house_no = (String) JSON_DATA.get("housenumber");
		assertEquals(house_no,"No 1540");
		street_name = (String) JSON_DATA.get("street");
		assertEquals(street_name,"Calle 39");
		
		result = js.compareAddress("4, rue de la revolution");
		JSON_DATA = js.splitAddress("4, rue de la revolution",result);
		house_no = (String) JSON_DATA.get("housenumber");
		assertEquals(house_no,"4");
		street_name = (String) JSON_DATA.get("street");
		assertEquals(street_name,"rue de la revolution");
		
		result = js.compareAddress("xyzöü");
		JSON_DATA = js.splitAddress("xyzöü",result);
		house_no = (String) JSON_DATA.get("housenumber");
		assertEquals(house_no,"Not present as format of string is out of the given cases");
		street_name = (String) JSON_DATA.get("street");
		assertEquals(street_name,"Not present as format of string is out of the given cases");
		
		result = js.compareAddress("200 Broadway Av");
		JSON_DATA = js.splitAddress("200 Broadway Av",result);
		house_no = (String) JSON_DATA.get("housenumber");
		assertEquals(house_no,"200");
		street_name = (String) JSON_DATA.get("street");
		assertEquals(street_name,"Broadway Av");
	}

}
