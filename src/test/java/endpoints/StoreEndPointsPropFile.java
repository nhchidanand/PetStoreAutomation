package endpoints;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.Stores;

public class StoreEndPointsPropFile {
	
	private Properties property;
	
	public StoreEndPointsPropFile() throws IOException
	{
		FileInputStream file= new FileInputStream("./src//test//resources//routes.properties");
		property= new Properties();
		property.load(file);
	}
	
	public Response createStore(Stores storePayload)
	{
		Response response= given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(storePayload)
		.when()
			.post(property.getProperty("post_store_url"));
		return response;
	}
	
	public Response readStore(int id)
	{
		Response response= given()
			.pathParam("id", id)
		.when()
			.get(property.getProperty("get_store_url"));
		return response;
	}
	
	public Response deleteStore(int id)
	{
		Response response= given()
			.pathParam("id", id)
		.when()
			.delete(property.getProperty("delete_store_url"));
		return response;
	}
}