import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Help extends ModuleBase {

	public Help(MessageReceivedEvent event) {
		super(event, "");
	}

	@Override
	public void process(String s) {
		new SendPM(event,"__**Commands:**__"+
				"\n**ping**: Pong!"+
				"\n**get.scoutURL**: Gets scouting sheet url."+
				"\n**get.teamInfo (Team Number)**: Gets basic infomation on inserted team."+
				"\n**get.topTeams**: lists all teams in order from best to worst."+
				"\n**NekoMode (on/off)**: Turns Neko mode on or off. (Automatically turns off other voice modes)"+
				"\n**OwoMode (on/off)**: Turns Owo mode on or off. (Automatically turns off other voice modes)"
				+ "\n**sevenSeconds**: Plays Seven Seconds (Not yet implemented)");

	}

}
