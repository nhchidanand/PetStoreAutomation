package endpoints;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.Users;

public class UserEndPointsPropFile {

	
	 static ResourceBundle getURL()
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	//Created for performing the CRUD (Create, Retrieve, Update, Delete) actions
	public static Response createUser(Users payload)
	{
		String post_url = getURL().getString("post_user_url");
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(post_url);
		return response;
	}
	
	
	public static Response readUser(String userName)
	{
		String get_url = getURL().getString("get_user_url");
		Response response = given()
			.pathParam("username", userName)
		.when()
			.get(get_url);
		return response;
	}
	
	
	public static Response updateUser(String userName, Users payload)
	{
		String update_url = getURL().getString("update_user_url");
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.pathParam("username", userName)
		.when()
			.put(update_url);
		return response;
	}
	
	
	public static Response deleteUser(String userName)
	{
		String delete_url = getURL().getString("delete_user_url");
		Response response = given()
			.pathParam("username", userName)
		.when()
			.get(delete_url);
		return response;
	}
}
