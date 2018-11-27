import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Ping extends ModuleBase {

	public Ping(MessageReceivedEvent event) {
		super(event, "");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(String s) {
		// TODO Auto-generated method stub
    		new SendMessage(event,user.getAsMention()+" Pong! "+event.getJDA().getPing()+" Ping");

	}

}
