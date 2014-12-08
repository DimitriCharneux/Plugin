package listeners;

import static org.junit.Assert.*;

import java.io.FilenameFilter;

import listeners.PluginDetector;

import org.junit.Before;
import org.junit.Test;

import plugin.FileEvent;
import plugin.GraphicalDetector;

public class PluginDetectorTest {

	GraphicalDetector gd;
	PluginDetector pld;
	FileEvent e;
	
	@Before
	public void init() {
		gd = new GraphicalDetector();
		pld = new PluginDetector(gd);
		e = new FileEvent("source.class");
	}
	
	@Test
	public void testAddAndRemoveFileListener() {
		assertTrue(gd.listMenuItemIsEmpty());
		pld.fileAdded(e);
		assertEquals(1, gd.listMenuItemSize());
		
		pld.fileRemoved(e);
		assertTrue(gd.listMenuItemIsEmpty());	
	}

}
