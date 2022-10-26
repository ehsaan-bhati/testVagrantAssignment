package testAssignment;

import org.testng.Assert;

import files.teamPayload;
import io.restassured.path.json.JsonPath;

public class testWicketKeeper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonPath js = new JsonPath(teamPayload.team_info());
		
		//Print No of players 
		int teamSize = js.getInt("player.size()");
		System.out.println("Number of Players: "+ teamSize);
		
		int wkCount=0;
		String role="Wicket-keeper";
		for(int i=0; i<teamSize; i++) {
			if(role.equalsIgnoreCase(js.getString("player["+i+"].role"))) {
//				System.out.println(js.getString("player["+i+"].name"));
				wkCount++;
			}
		}
		System.out.println("Number of Wicket-keeper: "+wkCount);
		Assert.assertTrue(wkCount>0,"There should be at least 1 wicket keeper in the team");

	}

}
