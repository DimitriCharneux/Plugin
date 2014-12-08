package listeners;

import java.util.EventListener;

import plugin.FileEvent;

/**
 * Interface from the listeners from file appearance.F
 * @author dimitri marion
 *
 */
public interface FileListener extends EventListener{
	public void fileAdded(FileEvent e);
	public void fileRemoved(FileEvent e);
}
