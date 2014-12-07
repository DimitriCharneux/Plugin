package plugin;

public class Main {
	public static void main(String[] args) {
		GraphicalDetector gd = new GraphicalDetector();
		FileListener listener = new PluginDetector(gd);
		gd.addFileListener(listener);
		gd.start();
	}

}
