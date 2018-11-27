
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class Main {
	public static void main(String[] args) throws Exception {
		try {
			JDA api = new JDABuilder(AccountType.BOT).setToken(Reference.token).build();
			api.addEventListener(new CommandHandler());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
