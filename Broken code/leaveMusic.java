import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.managers.AudioManager;

public class leaveMusic extends ModuleBase {

	public leaveMusic(MessageReceivedEvent event) {
		super(event,"");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(String s) {
		AudioManager audioManager = guild.getAudioManager();

		if(!audioManager.isConnected()) {
			new SendMessage(event, "I am currently not in a channel.");
			return;
		}
		VoiceChannel voiceChannel = audioManager.getConnectedChannel();

		if(!voiceChannel.getMembers().contains(member)) {
			channel.sendMessage("You need to be in the same voice channel as me to use this.");
			return;
		}

		audioManager.closeAudioConnection();
		new SendMessage(event, "Disconnected from the channel!");
		ChatRefrences.playingMusic(false);
		

	}

}
