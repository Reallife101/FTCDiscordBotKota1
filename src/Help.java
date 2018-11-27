import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Help extends ModuleBase {

	public Help(MessageReceivedEvent event) {
		super(event, "");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(String s) {
		new SendPM(event,"__**Commands:**__"+
				"\n**ping**: Pong!"+
				"\n**get.preGameURL**: Gets pre-game scouting sheet url. (Google Form)"+
				"\n**get.inGameURL**: Gets in-game scouting sheet url. (Google Form)"+
				"\n**NekoMode (on/off)**: Turns Neko mode on or off. (Automatically turns off other voice modes)"+
				"\n**OwoMode (on/off)**: Turns Owo mode on or off. (Automatically turns off other voice modes)"
				+ "\n**get.buddies**: Lists all current buddies for a tournament.");

	}

}
