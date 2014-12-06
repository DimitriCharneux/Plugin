package plugin;

public class Main {
	public static void main(String[] args) {
		/*FileChecker checker = new FileChecker(new ClassFilter());*/
		FileChecker checker = new FileChecker(new PluginFilter());
		FileListener listener = new FileDetector();
		checker.addFileListener(listener);
		checker.startTimer();
		while(true){
			
		}
	}

}
