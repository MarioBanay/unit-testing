package com.mariobanay.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
	
	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
	
	@Test
	public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException{
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
		// true - strict assert - moraju sva polja postojati i biti iste vrijednosti
	}
	
	@Test
	public void jsonAssert_StrictFalse() throws JSONException{
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
		// false ne moraju, ali vrijednosti moraju
	}
	
	@Test
	public void jsonAssert_WithoutEscapeCharacter() throws JSONException{
		String expectedResponse = "{id: 1,name: Ball, price: 10}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
		// ako u nazivima polja nemaš razmaka ne trebaju niti "" kod false
	}
}
