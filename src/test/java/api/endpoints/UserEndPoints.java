package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payload.Users;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	//Created for performing the CRUD (Create, Retrieve, Update, Delete) actions
	
	public static Response createUser(Users payload)
	{
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_url);
		return response;
	}
	
	
	public static Response readUser(String userName)
	{
		Response response = given()
			.pathParam("username", userName)
		.when()
			.get(Routes.get_url);
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
			.put(Routes.put_url);
		return response;
	}
	
	
	public static Response deleteUser(String userName)
	{
		Response response = given()
			.pathParam("username", userName)
		.when()
			.get(Routes.delete_url);
		return response;
	}
}
