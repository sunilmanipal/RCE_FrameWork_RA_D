package StepDefinition;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import utility.payloadconvertor;

public class definition {
	
	
	public static String BaseURL = "https://simple-books-api.glitch.me";
	public static String Loginpayload;
	public static String createorderpayload;
	RequestSpecification requestspecification;
	Response response;
	JsonPath jsonpath;
	public static String token;
	public static String ID;
	
	
	
	@Given("Login API")
	public void login_api() throws IOException {
		//so this is going to convert my request in to string format
		//my request name is login.json
	Loginpayload =	payloadconvertor.generatepayload("Login.json");
	System.out.println(Loginpayload);
	    
	}
	@When("Execute Login {string} which provides accessToken")
	public void execute_login_which_provides_access_token(String reourcepath) {
		
		//given//when 
		//in the below code i am providing the body
		requestspecification = RestAssured.given().body(Loginpayload);
		requestspecification.contentType(ContentType.JSON);
		
		//so the below code will send the request and collect the response in the response variable
		response = requestspecification.post(BaseURL + reourcepath);
	    
	}

	
	

	@Then("verify the status code for accesstoken {int}")
	public void verify_the_status_code_for_accesstoken(Integer statuscode) {
		//System.out.println("Working");
	
		//Assert.assertEquals(statuscode, response.getStatusCode());
		//Assert.assertEquals(statuscode, response.getStatusCode());
		//Assert.assertEquals(statuscode, response.getStatusCode());
	}



	@Then("verify accessToken in the response")
	public void verify_access_token_in_the_response() {
		//This will convert me response in the json object
		
		jsonpath = new JsonPath(response.getBody().asString()) ;
		//The below code will contain token as json object
		token = jsonpath.get("accessToken");
		System.out.println("accesstoken");
		System.out.println(token);
	    
	}

//Second one
	


	@Given("Login successfull with accessToken")
	public void login_successfull_with_access_token() throws IOException {
		createorderpayload = payloadconvertor.generatepayload("createorders.json");
		System.out.println(createorderpayload);
	    
	}
	@When("order a book {string} and fetch the orderId")
	public void order_a_book_and_fetch_the_order_id(String resourcepath) {
		requestspecification = RestAssured.given().body(createorderpayload);
		requestspecification.contentType(ContentType.JSON);
		requestspecification.header("Authorization","Bearer "+token);
		
		//so the below code will send the request and collect the response in the response variable
		response = requestspecification.post(BaseURL + resourcepath);
	   
	}
	
	
	
	@Then("verify the status code for orderId {int}")
	public void verify_the_status_code_for_order_id(Integer statuscode) {
		//Assert.assertEquals(statuscode, response.getStatusCode());
		//Assert.assertEquals(statuscode, response.getStatusCode());
	}
	
	@Then("verify orderId in the response")
	public void verify_order_id_in_the_response() {
		jsonpath = new JsonPath(response.getBody().asString()) ;
		//The below code will contain token as json object
		ID = jsonpath.get("orderId");
		System.out.println(ID);
	  
	}





}












