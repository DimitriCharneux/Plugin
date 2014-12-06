package plugin;

import static org.junit.Assert.*;

import java.io.FilenameFilter;

import org.junit.Test;

public class FileCheckerTest {

	FilenameFilter filter;
	FileChecker fc = new FileChecker(filter);
	
	FileListener l;
	
	@Test
	public void addAndRemoveFileListenerTest() {
		assertTrue(fc.fileListeners.isEmpty());
		fc.addFileListener(l);
		assertTrue(fc.fileListeners.contains(l));
		fc.addFileListener(l);
		assertEquals(1, fc.fileListeners.size());
		
		fc.removeFileListener(l);
		assertTrue(fc.fileListeners.isEmpty());		
	}

}
