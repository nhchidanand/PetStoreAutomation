package test;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import endpoints.StoreEndPointsPropFile;
import io.restassured.response.Response;
import payload.Stores;

public class TC_005_StoreTest_02 {
	
	public Stores storePayload;
	public Faker faker;
	public StoreEndPointsPropFile sep;
	
	@BeforeClass
	public void setUp()
	{
		storePayload= new Stores();
		faker= new Faker();
		storePayload.setId(faker.idNumber().hashCode());
		storePayload.setPetId(faker.idNumber().hashCode());
		storePayload.setQuantity(29);
		storePayload.setShipDate("2025-12-31T17:19:37.650Z");
		storePayload.setStatus("placed");
		storePayload.setComplete(false);
	}
	
	@Test(priority=1)
	public void testPostStore() throws IOException
	{
		sep = new StoreEndPointsPropFile();
		Response response= sep.createStore(storePayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().log().body();
		System.out.println("This is the Post method: TC_005_StoreTest_02");
	}
	
	@Test(priority=2)
	public void testGetStore()
	{
		Response response= sep.readStore(this.storePayload.getId());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("This is the Get method: TC_005_StoreTest_02");
	}
	
	@Test(priority=3)
	public void testDeleteStore()
	{
		Response response= sep.deleteStore(this.storePayload.getId());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("This is the Delete method: TC_005_StoreTest_02");
	}
}
