package endpoints;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.Stores;

//CR(U)D operations are specified here
public class StoreEndPoints {
	
	//Create store
	public static Response createStore(Stores payload)
	{
		Response response= given()
			.auth().basic("admin", "admin")
			.contentType(ContentType.JSON)
			.accept("application/json")
			.body(payload)
			
		.when()
			.post(Routes.post_store_url);
		return response;
	}
	
	//Get store by id
	public static Response getStore(int id)
	{
		Response response = given()
			.accept(ContentType.JSON)
			.pathParam("id", id)
			
		.when()
			.get(Routes.get_store_url);
		return response;
	}
	
	//Delete store
	public static Response deleteStore(int id)
	{
		Response response= given()
			.pathParam("id", id)
		.when()
			.delete(Routes.delete_store_url);
		return response;
	}
}