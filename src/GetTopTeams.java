import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.json.JSONException;
import org.json.JSONObject;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class GetTopTeams extends ModuleBase {

	private static final String SCORE_URL = "https://8404pals.azurewebsites.net/api/team-info/";



	public GetTopTeams(MessageReceivedEvent event) {
		super(event, "");
	}


	@Override
	public void process(String s) {
		String response = "Ordered Teams:";
		
		JSONObject server = null;
		try {
			server = readJsonFromUrl(SCORE_URL);
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
		
		Map<Integer, String> teams = new HashMap<>();
		Map<Integer, Double> teamScores = new HashMap<>();
		
		for( int i : teams.keySet() ) {
			Double score = server.getJSONObject("performance").getJSONObject("match").getDouble("auton") + server.getJSONObject("performance").getJSONObject("match").getDouble("teleOp");
			teamScores.put(i, score);
		}
		
		// https://stackoverflow.com/a/22132422
		Map<Integer, Double> sortedTeamScores = teamScores.entrySet().stream()
                .sorted(Entry.comparingByValue())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		for( int i : sortedTeamScores.keySet() ) {
			response += "\n" + teams.get(i) + " " + i;
		}		
		
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
