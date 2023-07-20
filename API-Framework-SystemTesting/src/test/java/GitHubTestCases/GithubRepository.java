package GitHubTestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.baseapiclass.Baseclass;

import io.restassured.response.Response;
import utility.Authentication;
import utility.CreateURL;
import utility.commonres;
import utility.payloadconvertor;

public class GithubRepository {
	
	public static String endpoint = CreateURL.getbaseuri("/user/repos");
	public static String bearer_token = Authentication.getbearertoken();
	public static Response response;
	//This is my test method 
	
	
	@Test
	public void createrepository() throws IOException
	{
		
		//First thing i need //body
		
		//so here my json format body is getting converted to string format 
		String request_payload = payloadconvertor.generatepayload("CreateRepo.json");
		
		//create a repository in github
		response = Baseclass.PostRequest(endpoint, request_payload, bearer_token);
		
		String responsebody = response.getBody().asString();
		//apply assertion 
		//when it create a github respository i am checking weather the name of the repository is same as request and response name
		Assert.assertEquals(commonres.getResponsevalue(request_payload, "name"), commonres.getResponsevalue(responsebody, "name"));
		//This assert will check weather the status code in the response is equal to expected
		Assert.assertEquals(commonres.getstatuscode(response), 201);
	}

}
