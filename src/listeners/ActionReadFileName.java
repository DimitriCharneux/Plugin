package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import plugin.ClassFile;
import plugin.FileChecker;

/**
 * Class to detect if files are added or remove.
 * 
 * @author dimitri marion
 * 
 */
public class ActionReadFileName implements ActionListener {
	protected ArrayList<String> readFileName;
	protected FilenameFilter filter;
	protected FileChecker checker;

	/**
	 * Constructor of this class.
	 * 
	 * @param filter
	 * @param checker
	 */
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

	/**
	 * Method to detect files appearance.
	 * 
	 * @param str
	 *            the names of the file present in the repertory.
	 */
	public void fileAddedDetected(String[] str) {
		for (String st : str) {
			if (!readFileName.contains(st)) {
				readFileName.add(st);
				checker.fireFileAdded(st);
			}
		}
	}

	/**
	 * Method to detect files disappearance.
	 * 
	 * @param str
	 *            the names of the file present in the repertory.
	 */
	public void fileRemovededDetected(String[] str) {
		boolean isDetected = false;
		List<String> readFileNameCopy = (ArrayList<String>) readFileName
				.clone();
		for (String st : readFileNameCopy) {
			for (int i = 0; i < str.length; i++) {
				if (str[i].equals(st) || isDetected) {
					isDetected = true;
				}
			}
			if (isDetected) {
				isDetected = false;
			} else {
				readFileName.remove(st);
				checker.fireFileRemoved(st);
			}
		}
	}

}
