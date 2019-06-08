package Test;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

import ReusableRequest.*; 
public class TestCase {

	GetRequest getReq = new GetRequest();
	
	@Test
	public void test() throws UnirestException, IOException, ParseException 
	{
		  
		  JsonNode response = 	getReq.sendGetRequest("http://restapi.demoqa.com/utilities/weather/city/Pune");
		  System.out.println(response.getObject().get("Temperature"));
		
		}
	}

