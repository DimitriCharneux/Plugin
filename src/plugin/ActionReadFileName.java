package plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class ActionReadFileName implements ActionListener {
	protected ArrayList<String> readFileName;
	protected FilenameFilter filter;
	protected FileChecker checker;

	public ActionReadFileName(FilenameFilter filter, FileChecker checker) {
		this.filter = filter;
		this.checker = checker;
		readFileName = new ArrayList<String>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ClassFile file = new ClassFile();
		String[] str = file.listName(filter);
		fileAddedDetected(str);
		fileRemovededDetected(str);
	}

	protected void fileAddedDetected(String[] str) {
		for (String st : str) {
			if (!readFileName.contains(st)) {
				readFileName.add(st);
				checker.fireFileAdded(st);
			}
		}
	}

	protected void fileRemovededDetected(String[] str) {
		boolean isDetected = false;
		List<String> readFileNameCopy = (ArrayList<String>) readFileName.clone();
		for (String st : readFileNameCopy) {
			for (int i = 0; i < str.length; i++){
				if (str[i].equals(st) || isDetected) {
					isDetected = true;
				}
			}
			if(isDetected){
				isDetected = false;
			} else {
				readFileName.remove(st);
				checker.fireFileRemoved(st);
			}
		}
	}

}
