package com.baseapiclass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Baseclass {
	
	//What are the different HTTP Methods we use in RestAPI
	//Get //POST //PUT //PATCH //Delete //when ever i create my request 
	
	//Basically why did i create all this methods because//i want reduce my redundency(repetation)
	
	//this is a static method because i don't have to create a object for this.
	//my get method will have a body?
	//get method is used only to fetch the data from the server 
	public static Response GetRequest(String requesturl)
	{
		    RequestSpecification requestSpecification = RestAssured.given();
				requestSpecification.contentType(ContentType.JSON);
				//i am providing the get method along with the request URL	
				//This get method is going to execute and fetch the resposne that response i am stroing it in a variable
				Response response = requestSpecification.get(requesturl);
				//This return response will be called in my test method //where ever i create a test method to execute i call the return 
				return response;
	}
	//post method is used to create the data Login, 
	//This is the post request with body
	public static Response PostRequest(String requesturl,String requestpayLoad,String bearer_token)
	{
		RequestSpecification requestSpecification = RestAssured.given().body(requestpayLoad);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization","Bearer "+ bearer_token);
		Response resposne = requestSpecification.post(requesturl);
		return resposne;
	}
	//This is the post request without body
	public static Response PostRequest(String requesturl,String bearer_token)
	{
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization","Bearer "+ bearer_token);
		Response resposne = requestSpecification.post(requesturl);
		return resposne;
	}
	
	public static Response PutRequest(String requesturl,String requestpayLoad,String bearer_token)
	{
		RequestSpecification requestSpecification = RestAssured.given().body(requestpayLoad);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization","Bearer "+ bearer_token);
		Response resposne = requestSpecification.put(requesturl);
		return resposne;
	}
	
	public static Response DeleteRequest(String requesturl,String requestpayLoad,String bearer_token)
	{
		RequestSpecification requestSpecification = RestAssured.given().body(requestpayLoad);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization","Bearer "+ bearer_token);
		Response resposne = requestSpecification.delete(requesturl);
		return resposne;
		
	}

}
