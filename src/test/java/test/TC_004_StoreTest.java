package test;
import org.testng.Assert;
import org.testng.annotations.*;
import com.github.javafaker.Faker;

import endpoints.StoreEndPoints;
import io.restassured.response.Response;
import payload.Stores;
public class TC_004_StoreTest {
	
	Stores storePaylaod;
	Faker faker;
	
	@BeforeClass
	public void setUp()
	{
		storePaylaod= new Stores();
		faker= new Faker();
		storePaylaod.setId(faker.idNumber().hashCode());
		storePaylaod.setPetId(faker.idNumber().hashCode());
		storePaylaod.setQuantity(10);
		storePaylaod.setShipDate("2025-12-31T17:19:37.650Z");
		storePaylaod.setStatus("placed");
		storePaylaod.setComplete(true);
	}
	
	@Test(priority=1)
	public void testPostStore()
	{
		Response response= StoreEndPoints.createStore(storePaylaod);
		Assert.assertEquals(response.getStatusCode(), 200);
		//response.then().log().all();
		Assert.assertEquals(response.jsonPath().get("status").toString(), "placed");
		System.out.println(response.jsonPath().get("status").toString());
		System.out.println("Post method is passed");
	}
	
	@Test(priority=2)
	public void testGetStore()
	{
		Response response= StoreEndPoints.getStore(this.storePaylaod.getId());
	 	System.out.println(response.getStatusCode());
	 	Assert.assertEquals(response.getStatusCode(), 200);
	 	//response.then().log().all();
	 	//response.then().log().body();
	 	Assert.assertEquals(response.jsonPath().get("complete"), true);
	 	System.out.println(response.jsonPath().get("complete").toString());
	 	System.out.println("Get method is passed");
	}
	
	@Test(priority=3)
	public void testDeleteStore()
	{
		Response response= StoreEndPoints.deleteStore(this.storePaylaod.getId());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Delete method is passed");
	}
}
