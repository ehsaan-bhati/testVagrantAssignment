package testAssignment;

import org.testng.Assert;
import files.teamPayload;
import io.restassured.path.json.JsonPath;
public class testForeignplayers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonPath js = new JsonPath(teamPayload.team_info());
		
		//Print No of players 
		int teamSize = js.getInt("player.size()");
		System.out.println("Number of Players: "+ teamSize);
		int playerCount=0;
		for(int i=0; i<teamSize; i++) {
			if(!js.getString("player["+i+"].country").equalsIgnoreCase("India")) {
//				System.out.println(js.getString("player["+i+"].name"));
				playerCount++;
			}
		}
		System.out.println("Number of foreign players: "+playerCount);
		Assert.assertTrue(playerCount<=4,"There can be only 4 foreign players in the team");
	}

}
