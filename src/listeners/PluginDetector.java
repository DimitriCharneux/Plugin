package listeners;

import plugin.FileEvent;
import plugin.GraphicalDetector;

/**
 * Class to detect appearance and disappearance from a plugin.
 * 
 * @author dimitri marion
 * 
 */
public class PluginDetector implements FileListener {
	private GraphicalDetector gd;

	/**
	 * constructor of this class.
	 * 
	 * @param gd
	 */
	public PluginDetector(GraphicalDetector gd) {
		this.gd = gd;
	}

	@Override
	public void fileAdded(FileEvent e) {
		String fileName = (String) e.getSource();
		gd.addMenuItem(fileName.substring(0, fileName.lastIndexOf(".class")));
	}

	@Override
	public void fileRemoved(FileEvent e) {
		String fileName = (String) e.getSource();
		gd.removeMenuItem(fileName.substring(0, fileName.lastIndexOf(".class")));
	}

}