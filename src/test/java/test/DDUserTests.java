package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import endpoints.UserEndPoints;
import io.restassured.response.Response;
import payload.Users;
import utilities.DataProviders;

public class DDUserTests {
	
	
	@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testPostUser(String userID, String userName, String firstName, String lastName, String emailID, String password, String ph)
	{
		Users userPayload = new Users();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(firstName);
		userPayload.setLastName(lastName);
		userPayload.setEmail(emailID);
		userPayload.setPassword(password);
		userPayload.setPhone(ph);
		
		Response response = UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test(priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String userName)
	{
		Response response = UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
