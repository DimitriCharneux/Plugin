package listeners;

import plugin.FileEvent;

/**
 * unused class
 * 
 * @author dimitri marion
 * 
 */
public class FileDetector implements FileListener {

	@Override
	public void fileAdded(FileEvent e) {
		System.out.printf("Nouveau .class %s détecté\n", e.getSource());
		/*
		 * interface.addMenuItem(e.getSource());
		 */
	}

	@Override
	public void fileRemoved(FileEvent e) {
		System.out.printf(".class %s supprimé detecté\n", e.getSource());
		/*
		 * interface.removeMenuItem(e.getSource());
		 */
	}

}
