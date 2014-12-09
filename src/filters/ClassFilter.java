/*
	On pourra la retirer du projet cette classe, non ?
*/

package filters;

import java.io.File;
import java.io.FilenameFilter;

/**
 * unused method
 * 
 * @author dimitri marion
 * 
 */
public class ClassFilter implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(".class");
	}

}
