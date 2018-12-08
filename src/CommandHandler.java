import java.util.Arrays;

import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class CommandHandler extends ListenerAdapter{
	 public void onMessageReceived(MessageReceivedEvent evt) {
		 if (evt.getAuthor().isBot()) return;
	    			
	    	//Objects
	    	User objUser = evt.getAuthor();
	    	Message objMsg= evt.getMessage();
	    	MessageChannel objChn=evt.getChannel();

	    	
	    	//Variables
	    	String message = objMsg.getContentRaw();
	    	
	    	//Commands
	    	
	    	//Commands with a separate class
	    	//Help command: lists commands
	    	if(message.equalsIgnoreCase(Reference.prefix+"help")) {
	    		new Help(evt);
	    	}
	    	
	    	//NekoMode command: Turns on and off Neko mode
	    	if(message.startsWith(Reference.prefix+"nekomode")) {
	    		new NekoMode(evt);
	    	}
	    	
	    	//OwoMode command: Turns on and off owo mode
	    	if(message.startsWith(Reference.prefix+"owomode")) {
	    		new owoMode(evt);
	    	}
	    	
	    	//Ping: displays ping
	    	if(message.equalsIgnoreCase(Reference.prefix+"ping")) {
	    		new Ping(evt);
	    	}
	    	
	    	//PrintData: prints file "AttendanceDatabase"
	    	if(message.equalsIgnoreCase(Reference.prefix+"printattendance")) {
	    		new PrintAttendance(evt);
	    	}
	    	
	    	//SevenSeconds: plays a game of Seven Seconds
	    	if(message.equalsIgnoreCase(Reference.prefix+"sevenseconds")) {
	    		new SevenSeconds(evt);
	    	}
	    	
	    	//get info about a certain team
	    	if(message.startsWith(Reference.prefix+"get.teaminfo")) {
	    		new GetTeamInfo(evt);
	    	}
	    	
	    	//get teams in order of score
	    	if(message.startsWith(Reference.prefix+"get.topteams")) {
	    		new GetTopTeams(evt);
	    	}

	    	//Commands that don't have a separate class
	    	//Get.pregameURL: gets pre-game scouting sheet URL
	    	if(message.equalsIgnoreCase(Reference.prefix+"get.pregameurl")) {
	    		objChn.sendMessage(objUser.getAsMention()+" https://goo.gl/forms/bMccLuBcIZyHyzvx1").queue();
	    	}
	    	
	    	//Get.ingameURL: gets in-game scouting sheet URL
	    	if(message.equalsIgnoreCase(Reference.prefix+"get.ingameurl")) {
	    		objChn.sendMessage(objUser.getAsMention()+" https://goo.gl/forms/Er3VNWnTsNa0iBf33").queue();
	    	}
	    	
	    	//Get.buddies: gets in-game scouting sheet URL
	    	if(message.equalsIgnoreCase(Reference.prefix+"get.buddies")) {
	    		new SendMessage(evt,objUser.getAsMention()+(Arrays.toString(Reference.buddies)));
	    	}
	    	
	    	
	    }
}
