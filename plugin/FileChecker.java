package plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

public class FileChecker {
	protected Timer timer;
	protected FilenameFilter filter;
	protected ArrayList<FileListener> fileListeners;
	protected List<String> readFileName ;

	public FileChecker(FilenameFilter filter) {
		this.filter = filter;
		fileListeners = new ArrayList<FileListener>();
		readFileName = new ArrayList<String>();
		timer = new Timer(1000, new ActionReadFileName());
	}

	public synchronized void addTelephoneListener(FileListener l) {
		if (fileListeners.contains(l)) {
			return;
		}
		fileListeners.add(l);
	}

	public synchronized void removeTelephoneListener(FileListener l) {
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
	
	private class ActionReadFileName implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ClassFile file = new ClassFile();
			String[] str = file.listName(filter);
			for(String st : str){
				if(!readFileName.contains(st)){
					readFileName.add(st);
					fireFileAdded(st);
				}
			}
		}
		
	}
}
