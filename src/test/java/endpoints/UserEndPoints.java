package endpoints;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.Users;

public class UserEndPoints {

	//Created for performing the CRUD (Create, Retrieve, Update, Delete) actions
	
	public static Response createUser(Users payload)
	{
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_user_url);
		return response;
	}
	
	
	public static Response readUser(String userName)
	{
		Response response = given()
			.pathParam("username", userName)
		.when()
			.get(Routes.get_user_url);
		return response;
	}
	
	
	public static Response updateUser(String userName, Users payload)
	{
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.pathParam("username", userName)
		.when()
			.put(Routes.put_user_url);
		return response;
	}
	
	
	public static Response deleteUser(String userName)
	{
		Response response = given()
			.pathParam("username", userName)
		.when()
			.get(Routes.delete_user_url);
		return response;
	}
}
