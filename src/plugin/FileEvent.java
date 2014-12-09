package plugin;

import java.util.EventObject;

/**
 * Event for the appearance of a file.
 * 
 * @author dimitri marion
 * 
 */
public class FileEvent extends EventObject {
	public FileEvent(String source) {
		super(source);
	}
}
