package utility;

public class CreateURL {
	
	//i have a base URL //my baseURL will change
	public final static String baseuri = "https://api.github.com";
	
	public static String getbaseuri()
	{
		return baseuri;
	}
	//don't you think my baseuri should also be concatenated with resource

	public static String getbaseuri(String resource)
	{
		return baseuri + resource;
	}
}
