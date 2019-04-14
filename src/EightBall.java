import java.util.Random;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class EightBall extends ModuleBase {

	public EightBall(MessageReceivedEvent event) {
		super(event,"");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(String s) {
		Random r = new Random();
		int low = 1;
		int high = 43;
		int result = r.nextInt(high-low) + low;
		String ball="";

		switch (result) { 
		case 1: 
			ball = "It is certain"; 
			break; 
		case 2: 
            ball = "It is decidedly so"; 
            break;
        case 3: 
            ball = "Without a doubt";
            break;
        case 4: 
            ball = "Yes-definitely"; 
            break;
        case 5: 
            ball = "You may rely on it"; 
            break;
        case 6: 
            ball = "As I see it, yes"; 
            break;
        case 7: 
            ball = "Most likely"; 
            break;
        case 8: 
            ball = "Outlook good"; 
            break;
        case 9: 
            ball = "Yes"; 
            break;
        case 10: 
            ball = "Signs point to yes"; 
            break;
        case 11: 
            ball = "Reply hazy, try again"; 
            break;
        case 12: 
            ball = "Ask again later"; 
            break;
        case 13: 
            ball = "Better not tell you now"; 
            break;
        case 14: 
            ball = "Cannot predict now"; 
            break;
        case 15: 
            ball = "Concentrate and ask again"; 
            break;
        case 16: 
            ball = "Don't count on it"; 
            break;
        case 17: 
            ball = "My reply is no"; 
            break;
        case 18: 
            ball = "My sources say no"; 
            break;
        case 19: 
            ball = "Outlook not so good"; 
            break;
        case 20: 
            ball = "Very doubtful"; 
            break;
        case 21: 
            ball = "Maybe"; 
            break;
        case 22: 
            ball = "Not a snowball's chance in hell"; 
            break;
        case 23: 
            ball = "Of course"; 
            break;
        case 24: 
            ball = "Yes boss"; 
            break;
        case 25: 
            ball = "Do pigs fly?"; 
            break;
        case 26: 
            ball = "No ma'am"; 
            break;
        case 27: 
            ball = "Once in a blue moon"; 
            break;
        case 28: 
            ball = "Is Andrea Italian?"; 
            break;
        case 29: 
            ball = "Maybe you can find the answer in the engineering notebook"; 
            break;
        case 30: 
            ball = "Ask someone else, not a random number generator"; 
            break;
        case 31: 
            ball = "If you think so then sure."; 
            break;
        case 32: 
            ball = "IDK"; 
            break;
        case 33: 
            ball = "yes. Yes. Yes! YES! YESSSSSSSSSSSSSS!!!!!!!!!!"; 
            break;
        case 34: 
            ball = "0-0 Do you really want to know?"; 
            break;
        case 35: 
            ball = "It's better if you don't know..."; 
            break;
        case 36: 
            ball = "Get your head out of your butt. No way."; 
            break;
        case 37: 
            ball = "I'm not sure."; 
            break;
        case 38: 
            ball = "As sure as the sun as the sun rises."; 
            break;
        case 39: 
            ball = "I can't say right now."; 
            break;
        case 40: 
            ball = "Hai! Mochi ro!"; 
            break;
        case 41: 
            ball = "Chotto...";
            break;
        case 42: 
            ball = "Dame!"; 
            break;
		default:
			ball = "The future is unclear right now"; 
			break; 
		}
		new SendMessage(event,user.getAsMention()+" "+ball);

	}

}
