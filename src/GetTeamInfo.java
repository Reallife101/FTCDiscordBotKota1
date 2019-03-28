import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class GetTeamInfo extends ModuleBase {

	private static final String BASEURL = "https://8404pals.azurewebsites.net/api/team-info/";

	public GetTeamInfo(MessageReceivedEvent event) {
		super(event, "");
	}

	@Override
	public void process(String s) {
		String teamNum = command.substring(15);
		String response = "Team: " + teamNum;
		JSONObject server = null;

		try {
			server = readJsonFromUrl(BASEURL + teamNum + "/");
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		response += "/" + server.getJSONObject("generalInfo").getString("teamName");
		// "Team: 8404/Quixilver"
		response += "\n"+"https://8404pals.azurewebsites.net/team-info/" + teamNum+"/";
		// "https://8404pals.azurewebsites.net/team-info/[teamNumber]/"

		Double preTotal = (double) -1;
		try {
			preTotal = server.getJSONObject("performance").getJSONObject("preGame").getDouble("auton") + server.getJSONObject("performance").getJSONObject("preGame").getDouble("teleOp");
		} catch( Exception e ) {}
		response += "\nPREGAME: " + preTotal;

		Double realTot = (double) -1;
		try {
			realTot = server.getJSONObject("performance").getJSONObject("match").getDouble("auton") + server.getJSONObject("performance").getJSONObject("match").getDouble("teleOp");
		} catch( Exception e ) {}		
		response += "\nMATCHs: " + realTot;

		channel.sendMessage(response).queue();
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

}
