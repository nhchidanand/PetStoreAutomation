package endpoints;

public class Routes {

	
/*
SWAGGER URL: https://petstore.swagger.io

Create User (Post): https://petstore.swagger.io/v2/user
Get User (Get): https://petstore.swagger.io/v2/user/{username}
Update User (Put): https://petstore.swagger.io/v2/user/{username}
Delete User (Delete): https://petstore.swagger.io/v2/user/{username}
*/
	//Below is the base url for all the models (Pet, Store, User)
	public static String base_url = "https://petstore.swagger.io/v2/";
	
	//Below are the url's for USER model
	public static String post_user_url = base_url+"user";
	public static String get_user_url = base_url+"user/{username}";
	public static String put_user_url = base_url+"user/{username}";
	public static String delete_user_url = base_url+"user/{username}";
	
	//Below are the url's for Store model
	public static String post_store_url= base_url+"store/order";
	public static String get_store_url= base_url+"store/order/{id}";
	public static String delete_store_url= base_url+"store/order/{id}";
}