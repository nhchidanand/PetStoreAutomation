package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import endpoints.StoreEndPoints;
import io.restassured.response.Response;
import payload.Stores;

public class TC_007_DDStoreTests {
	
	@Test(priority=1, dataProvider="StoreData", dataProviderClass=utilities.DataProviders.class)
	public void storePostTest(String id, String petId, String qty, String shipDate, String status, String complete)
	{
		Stores storePayload= new Stores();
		storePayload.setId(Integer.parseInt(id));
		storePayload.setPetId(Integer.parseInt(petId));
		storePayload.setQuantity(Integer.parseInt(qty));
		storePayload.setShipDate(shipDate);
		storePayload.setStatus(status);
		storePayload.setComplete(Boolean.parseBoolean(complete.toLowerCase()));
		
		Response response= StoreEndPoints.createStore(storePayload);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2, dataProvider="StoreUserID", dataProviderClass=utilities.DataProviders.class)
	public void storeGetTest(String id)
	{
		Response response= StoreEndPoints.getStore(Integer.parseInt(id));
		Assert.assertEquals(response.getStatusCode(), 404);
	}
	
	@Test(priority=3, dataProvider="StoreUserID", dataProviderClass= utilities.DataProviders.class)
	public void storeDeleteTest(String id)
	{
		Response response= StoreEndPoints.deleteStore(Integer.parseInt(id));
	 	Assert.assertEquals(response.getStatusCode(), 404);
	}
}
