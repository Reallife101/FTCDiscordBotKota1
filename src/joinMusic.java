import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.GuildVoiceState;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.managers.AudioManager;

public class joinMusic extends ModuleBase {

	public joinMusic(MessageReceivedEvent event) {
		super(event, "");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(String s) {
		// TODO Auto-generated method stub
		AudioManager audioManager = guild.getAudioManager();
		
		if(audioManager.isConnected()) {
			new SendMessage(event, "I am currently already in a channel.");
			return;
		}
		
		GuildVoiceState memberVoiceState = member.getVoiceState();
		
		if(!memberVoiceState.inVoiceChannel()) {
			new SendMessage(event, "Please join a voice channel");
			return;
		}
		
		net.dv8tion.jda.core.entities.VoiceChannel voiceChannel = memberVoiceState.getChannel();
		net.dv8tion.jda.core.entities.Member selfMember = guild.getSelfMember();
		
		if (!selfMember.hasPermission(voiceChannel, Permission.VOICE_CONNECT)) {
			new SendMessage(event, "I am missing permissions to join the channel.");
			return;
		}
		
		audioManager.openAudioConnection(voiceChannel);
		new SendMessage(event, "Joining Voice Channel!");
		ChatRefrences.playingMusic(true);
		

	}

}
