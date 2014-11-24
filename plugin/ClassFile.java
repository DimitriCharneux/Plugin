package plugin;

import java.io.File;
import java.io.FilenameFilter;

public class ClassFile {
	protected File file;
	public ClassFile (){
		file = new File("/home/dimitri/workspace/Plugin/src/plugin");
	}
	
	public String[] listName(FilenameFilter filter){
		return file.list(filter);
	}
	
	public static void main(String[] args){
		ClassFile file = new ClassFile();
		String[] str = file.listName(new ClassFilter());
		for(String st : str){
			System.out.println(st);
		}
	}
}
