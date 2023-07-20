package utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class commonres {
	public static JsonPath jsonpath;
	
	public static String getResponsevalue(String response_body, String response_obj)
	{
		jsonpath = new JsonPath(response_body);
		String obj_value = jsonpath.get(response_obj);
		return obj_value;
	}
	
	public static int getstatuscode(Response response)
	{
		int status_code = response.getStatusCode();
		return status_code;
	}

}
