package plugin;

import static org.junit.Assert.*;

import java.io.FilenameFilter;

import org.junit.Before;
import org.junit.Test;

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
		assertTrue(gd.listMenuItem.isEmpty());
		pld.fileAdded(e);
		assertEquals(1, gd.listMenuItem.size());
		
		pld.fileRemoved(e);
		assertTrue(gd.listMenuItem.isEmpty());	
	}

}
