import java.io.PrintWriter;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.managers.AudioManager;

public class play extends ModuleBase {

		public play(MessageReceivedEvent event) {
			super(event, "");
		}

		@Override
		public void process(String s) {
			String url="";
			url = command.substring(7);
	    		new SendMessage(event,user.getAsMention()+" Playing: "+url);
	    		
	    		Guild guild = event.getGuild();
	            // This will get the first voice channel with the name "music"
	            // matching by voiceChannel.getName().equalsIgnoreCase("music")
	            VoiceChannel channel = member.getVoiceState().getChannel();
	            AudioManager manager = guild.getAudioManager();
	            
	            AudioPlayerManager playerManager = new DefaultAudioPlayerManager();
	            AudioSourceManagers.registerRemoteSources(playerManager);
	            AudioPlayer player = playerManager.createPlayer();

	            // MySendHandler should be your AudioSendHandler implementation
	            //manager.setSendingHandler(new AudioPlayerSendHandler(player));
	            
	            // Here we finally connect to the target voice channel 
	            // and it will automatically start pulling the audio from the MySendHandler instance
	            manager.openAudioConnection(channel);

	}


}
