package api.endpoints;

public class Routes {

	
/*
SWAGGER URL: https://petstore.swagger.io

Create User (Post): https://petstore.swagger.io/v2/user
Get User (Get): https://petstore.swagger.io/v2/user/{username}
Update User (Put): https://petstore.swagger.io/v2/user/{username}
Delete User (Delete): https://petstore.swagger.io/v2/user/{username}
*/
	
	public static String base_url = "https://petstore.swagger.io/v2/";
	
	//Below are the url's for USER model
	
	public static String post_url = base_url+"user";
	public static String get_url = base_url+"user/{username}";
	public static String put_url = base_url+"user/{username}";
	public static String delete_url = base_url+"user/{username}";
	
	
	//We can have the url's for STORE model and PET model
}
