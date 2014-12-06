package plugin;

import java.io.File;
import java.io.FilenameFilter;

public class ClassFile {
	protected File file;
	public ClassFile (){
		file = new File("/home/l3/charneux/workspace/Plugin/src/plugin");
	}
	
	public String[] listName(FilenameFilter filter){
		return file.list(filter);
	}
}
