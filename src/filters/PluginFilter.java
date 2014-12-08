package filters;

import java.io.File;
import java.io.FilenameFilter;

/**
 * class to whether a file is a plugin.
 * 
 * @author dimitri marion
 * 
 */
public class PluginFilter implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		if (!name.endsWith(".class"))
			return false;
		String nameNoExtent = name.substring(0, name.lastIndexOf(".class"));
		Class<?> classPlugin;
		try {
			classPlugin = Class.forName("plugins." + nameNoExtent);
		} catch (ClassNotFoundException e) {
			return false;
		}
		if (!classPlugin.getPackage().getName().equals("plugins"))
			return false;
		try {
			classPlugin.getConstructor(new Class[0]);
		} catch (NoSuchMethodException e) {
			return false;
		}
		Class<?>[] tabInterfaces = classPlugin.getInterfaces();
		for (Class<?> element : tabInterfaces) {
			if (element.getName().equals("plugin.Plugin")) {
				return true;
			}
		}
		return false;

	}

}
