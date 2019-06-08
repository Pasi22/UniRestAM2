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
import Utility.JsonReader;

public class TestCase {

	GetRequest getReq = new GetRequest();
	PostRequest postReq = new PostRequest();
	DeleteRequest deleteReq = new DeleteRequest();
	
	@Test
	public void test() throws UnirestException, IOException, ParseException 
	{
		  JsonReader jsRead = new JsonReader();
		  JsonNode response = 	getReq.sendGetRequest(jsRead.ReadJSONFile("Request_Get3",".\\Data\\wsData.json"));
		  System.out.println(response.getObject().get("Temperature"));
		  System.out.println(response.getObject().get("City"));
		
		}
	
	@Test
	public void testPost () throws  IOException, ParseException, UnirestException
	{
		JsonReader _JsonRead = new JsonReader();
		
		String Req_URL = _JsonRead.ReadJSONFile("Request_Post", ".\\Data\\wsData.json");
		String email = _JsonRead.ReadJSONFile("email", ".\\Data\\wsData.json");
		String password = _JsonRead.ReadJSONFile("password", ".\\Data\\wsData.json");
		HttpResponse<JsonNode> response = postReq.sendPostRequest(Req_URL, "{\"email:"+ email+", \"password:"+password+"}");
		System.out.println(response.getStatus());
		assertEquals(200, response.getStatus());
	}
	
	@Test
	public void testDelete() throws FileNotFoundException, UnirestException, IOException, ParseException 
	{
		JsonReader jsRead = new JsonReader();
		HttpResponse<JsonNode> response = deleteReq.sendDeleteRequest(jsRead.ReadJSONFile("Request_Delete",".\\Data\\wsData.json"));
		System.out.println(((HttpResponse<JsonNode>) response).getStatus());
		assertEquals(204, response.getStatus());
	}
	
	
	
	}

