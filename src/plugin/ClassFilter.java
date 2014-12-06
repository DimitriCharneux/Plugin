package plugin;

import java.io.File;
import java.io.FilenameFilter;

/*
 * regarde ça
 * http://www.fil.univ-lille1.fr/~routier/enseignement/licence/coo/tdtp/plugins.pdf
 */

public class ClassFilter implements FilenameFilter{

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(".class");
	}

}
