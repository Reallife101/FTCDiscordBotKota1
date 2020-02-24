import java.io.PrintWriter;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class DownloadMusic extends ModuleBase {

	public DownloadMusic(MessageReceivedEvent event) {
		super(event, "");
	}

	@Override
	public void process(String s) {
		String url="";
		url = command.substring(5);
    		new SendMessage(event,user.getAsMention()+" Downloading: "+url);
    		
    		String download_path="";
    		String[] command =
    	    {
    	        "cmd",
    	    };
    	    Process p;
    		try {
    			p = Runtime.getRuntime().exec(command); 
    		        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
    	                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
    	                PrintWriter stdin = new PrintWriter(p.getOutputStream());
    	                stdin.println("cd \""+download_path+"\"");
    	                stdin.println("youtube-dl -x --audio-format \"mp3\" "+url);
    	                //-x --audio-format \"mp3\" 
    	                stdin.close();
    	                p.waitFor();
    	    	} catch (Exception e) {
    	 		e.printStackTrace();
    		}
    	}	

	

}
