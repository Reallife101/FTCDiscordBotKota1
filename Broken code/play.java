import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class play extends ModuleBase {

	public play(MessageReceivedEvent event) {
		super(event, "");
	}

	@Override
	public void process(String s) {
		String url = command.substring(11);
		
		//PlayerManager manager = new PlayerManager();
		PlayerManager manager = PlayerManager.getInstance();

        manager.getGuildMusicManager(event.getGuild()).player.setVolume(10);

        manager.loadAndPlay(event.getTextChannel(), "https://www.youtube.com/watch?v=5rFBkHb8CL8");

        manager.getGuildMusicManager(event.getGuild()).player.setVolume(10);
        
	}

}
