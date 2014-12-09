package plugin;

import listeners.FileListener;
import listeners.PluginDetector;

/**
 * Class to start the plugin application.
 * 
 * @author dimitri marion
 * 
 */
public class Main {
	public static void main(String[] args) {
		GraphicalDetector gd = new GraphicalDetector();
		FileListener listener = new PluginDetector(gd);
		gd.addFileListener(listener);
		gd.start();
	}

}
