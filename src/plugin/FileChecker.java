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
		FileEvent event = createFileEvent(name); //j'extrai le new FileEvent(name)
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
		FileEvent event = createFileEvent(name); //ici aussi
		for (FileListener listener : tl) {
			listener.fileRemoved(event);
		}
	}

//la fonction que j'aimerai changer dans le fichier test
	protected FileEvent createFileEvent(String name) {
		return new FileEvent(name);
	}


	public void startTimer() {
		timer.start();
	}
}
