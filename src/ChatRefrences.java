
public class ChatRefrences {
	 public static boolean nekoMode = false;
	 public static boolean owoMode = false;
	 
	public ChatRefrences() {
		    //ChatRefrences.nekoMode = true;
		 }
		  
		  public static void nekoMode(boolean b){
			  ChatRefrences.nekoMode = b;
			  ChatRefrences.owoMode = false;
			  
		  }
		  
		  public static void owoMode(boolean b){
			  ChatRefrences.owoMode = b;
			  ChatRefrences.nekoMode = false;
		  }

}