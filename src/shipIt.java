import java.io.IOException;
import java.util.Random;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class shipIt extends ModuleBase {

	public shipIt(MessageReceivedEvent event) {
		super(event, "");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(String s) {
		
		String name="";
		
		name = command.substring(5);
		
		Random r = new Random();
		int low = 1;
		int high = 36;
		String hold="";
		int result = r.nextInt(14);
		
		String[] names = {"Ryan Ngoon", "Ryan Niemi", "Madeleine", "Andrea", "Terrence", "Deborah", "Jessica", "Emily", "Ethan", "Ellen", "Daniel N.", "Alex", "Tom", "Kobe","Aroshi", "Daniel X.", "Anahita","Amelia"};
		for (int i=0;i<names.length;i++ ) {
			result = r.nextInt(17);
			hold=names[i];
			names[i]=names[result];
			names[result]=hold;
		}
		
		result = r.nextInt(high-low) + low;
		String ship="";
		
		if (name.equals("p")) {
			
		} else if (name.equals("p me")) {
			name = command.substring(7);
			names[3]="you";
		} else if (name.equalsIgnoreCase("p meeting notes")) {
			name = command.substring(7);
			names[3]="Meeting Notes";
			names[4]="Alex";
		} else if (!name.equals("p")) {
			name = command.substring(7);
			names[3]=name;
		}

		switch (result) { 
		case 1: 
			ship = "I saw "+names[3]+" and "+names[4]+" holding hands the other day~ hmm~"; 
			break; 
		case 2: 
			ship = names[3]+" and "+names[4]+" sitting in a tree. And you better just be holding hands or I'm telling!"; 
			break; 
		case 3: 
			ship = names[3]+" and "+names[4]+" sitting in a tree. K I S S I-- is that the engineering notebook??"; 
			break; 
		case 4: 
			ship = "My OTP is "+names[3]+" x "+names[4]+"~ :heart:"; 
			break; 
		case 5:
			ship = "I think "+names[3]+" and "+names[4]+" look cute together...";
			break;
		case 6:
			ship = "Do you think "+names[3]+" and "+names[4]+" are dating? They totally could be.";
			break;
		case 7:
			ship = "I've been trying to get "+names[3]+" and "+names[4]+" together for a while now...";
			break;
		case 8:
			ship = names[3]+"! Just ask "+names[4]+" out already! We can all see it!";
			break;
		case 9:
			ship = names[3] + " has a crush; don't tell anyone I told you but it's " + names[4];
			break;		
		case 10:
			ship = names[3]+" totally looks great with "+names[4]+".";
			break;
		case 11:
			ship = "Shipping "+names[3]+" and "+names[4]+" so hard rn! ";
			break;
		case 12:
			ship = "I can't get enough of "+names[3]+" and "+names[4]+"! They are like so perfect for each other! ";
			break;
		case 13:
			ship = names[3]+" and "+names[4]+" should just get a room already...";
			break;
		case 14:
			ship = names[3]+" x "+names[4]+" should be a thing";
			break;
		case 15:
			ship = "Let the "+names[3]+" x "+names[4]+" ship sail!";
			break;
		case 16:
			ship = "The S.S. "+names[3]+" x "+names[4]+" sets sail for open waters!";
			break;
		case 17: 
            ship = " "+names[3]+" and "+names[4]+" are just meant to be!"; 
            break;
        case 18: 
            ship = "I can't stand that "+names[3]+" and "+names[4]+" aren't an item yet!"; 
            break;
        case 19: 
            ship = "Can I get a number 3 special? Its a "+names[3]+" with extra "+names[4]+" on the side!"; 
            break;
        case 20: 
            ship = ""+names[3]+" tots has the hots for "+names[4]+""; 
            break;
        case 21: 
            ship = "If "+names[3]+" had a garden, they put "+names[4]+"'s tulips and their tulips together!"; 
            break;
        case 22: 
            ship = ""+names[3]+"'s name is Microsoft cause they want to crash at"+names[4]+"'s place tonight!"; 
            break;
        case 23: 
            ship = ""+names[3]+" needs a bandaid, because they scraped their knee falling for"+names[4]+"!";; 
            break;
        case 24: 
            ship = ""+names[3]+" thinks that if "+names[4]+" was a transformer, they'd be Optimus Fine!"; 
            break;
        case 25: 
            ship = ""+names[3]+" thinks "+names[4]+" could never be ice cream because they're too hot... and a person *wink*"; 
            break;
        case 26: 
            ship = ""+names[3]+" must be tired, since they've been running through "+names[4]+"'s mind all day!"; 
            break;
        case 27: 
            ship = ""+names[3]+" thinks "+names[4]+" is made of Copper and Tellurium, because they are Cu-Te!"; 
            break;
        case 28: 
            ship = ""+names[3]+" tots has the hots for "+names[4]+"";
            break;
        case 29: 
            ship = ""+names[3]+" is commencing explosive containment procedures because "+names[4]+" is the bomb!"; 
            break;
        case 30: 
            ship = ""+names[3]+" thinks "+names[4]+" broke one of Asimov's three laws, because they've got 'fine' written all over them!";
            break;
        case 31: 
            ship = ""+names[3]+" thinks "+names[4]+" is the droid they're looking for!";
            break;
        case 32: 
            ship = ""+names[3]+" wants "+names[4]+"'s shirt, cause its made of boyfriend material!";
            break;
        case 33: 
            ship = ""+names[3]+" thinks if "+names[4]+" was a transformer then they be Optimus Fine!";
            break;
        case 34: 
            ship = ""+names[3]+" thinks "+names[4]+" invented the airplane cause they seem Wright to them!";
            break;
        case 35: 
            ship = ""+names[3]+" just called the police cause "+names[4]+" stole their heart!";
            break;
		default: 
			ship = "Love is... not in the air right now."; 
			break; 
		}
		new SendMessage(event,user.getAsMention()+" "+ship);

	}

}
