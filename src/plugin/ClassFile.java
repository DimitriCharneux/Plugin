package plugin;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Class to listing the file in a directory.
 * 
 * @author dimitri marion
 * 
 */
public class ClassFile {
	protected File file;

	/**
	 * Constructor of this class.
	 */
	public ClassFile() {
		file = new File("/home/dimitri/workspace/Plugin/classPlugins");
	}

	/**
	 * Constructor of this class.
	 * 
	 * @param dir
	 *            directory content the files.
	 */
	public ClassFile(String dir) {
		file = new File(dir);
	}

	/**
	 * Method to have a list of file in the directory.
	 * 
	 * @param filter
	 *            filter for the file
	 * @return list of file respected a filter
	 */
	public String[] listName(FilenameFilter filter) {
		return file.list(filter);
	}
}
