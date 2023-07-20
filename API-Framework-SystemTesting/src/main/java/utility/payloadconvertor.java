package utility;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;

public class payloadconvertor {
	
	public static String generatepayload(String filename) throws IOException
	{
		
		String filepath = "/Users/administrator/Documents/RCE-Rest Assured/API-Framework-SystemTesting/src/main/java/resource/"+filename;
		
		//This is the one which will convert the json format in to string format.
		return new String(Files.readAllBytes(Paths.get(filepath)));
		
	}

}
