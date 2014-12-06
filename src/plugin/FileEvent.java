package plugin;

import java.util.EventObject;

public class FileEvent extends EventObject{
	public FileEvent(String source) {
		super(source);
	}
}
