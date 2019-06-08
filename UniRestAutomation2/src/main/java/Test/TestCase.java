package Test;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import Utility.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

import ReusableRequest.*; 
public class TestCase {

	GetRequest getReq = new GetRequest();
	
	@Test
	public void test() throws UnirestException, IOException, ParseException 
	{
		  JsonReader jsRead = new JsonReader();
		  JsonNode response = 	getReq.sendGetRequest(jsRead.ReadJSONFile("Request_Get2",".\\Data\\wsData.json"));
		  System.out.println(response.getObject().get("Temperature"));
		
		}
	}

