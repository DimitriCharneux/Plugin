package plugin;

import java.io.FilenameFilter;
import java.util.ArrayList;

import javax.swing.Timer;

public class FileChecker {
	protected Timer timer;
	protected ArrayList<FileListener> fileListeners;

	public FileChecker(FilenameFilter filter) {
		fileListeners = new ArrayList<FileListener>();
		timer = new Timer(1000, new ActionReadFileName(filter, this));
	}

	public synchronized void addFileListener(FileListener l) {
		if (fileListeners.contains(l)) {
			return;
		}
		fileListeners.add(l);
	}

	public synchronized void removeFileListener(FileListener l) {
		fileListeners.remove(l);
	}

	public void fireFileAdded(String name) {
		ArrayList<FileListener> tl = (ArrayList<FileListener>) fileListeners
				.clone();
		if (tl.size() == 0) {
			return;
		}
		FileEvent event = new FileEvent(name);
		for (FileListener listener : tl) {
			listener.fileAdded(event);
		}
	}
	
	public void fireFileRemoved(String name) {
		ArrayList<FileListener> tl = (ArrayList<FileListener>) fileListeners
				.clone();
		if (tl.size() == 0) {
			return;
		}
		FileEvent event = new FileEvent(name);
		for (FileListener listener : tl) {
			listener.fileRemoved(event);
		}
	}
	
	public void startTimer(){
		timer.start();
	}
}
