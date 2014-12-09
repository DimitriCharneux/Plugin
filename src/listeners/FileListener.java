package listeners;

import java.util.EventListener;

import plugin.FileEvent;

/**
 * Interface for the listeners for file appearance and disappearance.
 * @author dimitri marion
 *
 */
public interface FileListener extends EventListener{
	public void fileAdded(FileEvent e);
	public void fileRemoved(FileEvent e);
}
