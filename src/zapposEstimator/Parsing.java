
package zapposEstimator;

import java.io.*;
import java.net.*;

import org.json.simple.*;
import org.json.simple.parser.*;

public class Parsing {
	public static final String BASEURL = "http://api.zappos.com/Search?key=b05dcd698e5ca2eab4a0cd1eee4117e7db2a10c4";
	
	/**
	 * Prompts user for information
	 * @param s The prompt to display to user
	 * @return The user's response2
	 */
	public static String prompt (String s) {
    	try {
    		System.out.print(s);
    		System.out.flush();
    		return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    	}
    	catch (IOException e) { System.err.println(e); return ""; }
    }
	
	/**
	 * Sends a get request to the given URL and returns the result
	 * @param urlStr The URL to send a get request to
	 * @return The response from the server as a String
	 * @throws IOException If response code not 200 or unauthorized access
	 */
	public static String httpGet(String urlStr) throws IOException {
		URL url = new URL(urlStr);
		HttpURLConnection conn =
		      (HttpURLConnection) url.openConnection();
	
		if (conn.getResponseCode() != 200) {
		    throw new IOException(conn.getResponseMessage());
		}
	
		// Buffer the result into a string
		BufferedReader rd = new BufferedReader(
	      new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
	
		conn.disconnect();
		return sb.toString();
	}
	
	/**
	 * Parses the search API's JSON response into a JSON object
	 * @param reply The string of the server's JSON response
	 * @return The parsed JSON object
	 * @throws ParseException If an error is encountered during parsing
	 */
	public static JSONObject parseReply(String reply) throws ParseException{
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(reply);
		JSONObject object = (JSONObject)obj;
		return object;
	}
	
	/**
	 * Gets the "results" array out of the JSON object the server returns
	 * @param reply The JSON object form of the server's response
	 * @return The JSONArray of the results portion
	 */
	public static JSONArray getResults(JSONObject reply){
		Object resultObject = reply.get("results");
		JSONArray resultArray = (JSONArray)resultObject;
		return resultArray;
	}
}
