package plugin;

import java.io.File;
import java.io.FilenameFilter;

public class ClassFile {
	protected File file;
	public ClassFile (){
		file = new File("/home/dimitri/workspace/Plugin/src/plugin");
	}
	
	public ClassFile (String dir){
		file = new File(dir);
	}
	
	public String[] listName(FilenameFilter filter){
		return file.list(filter);
	}
}
