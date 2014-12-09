package plugin;

import static org.junit.Assert.*;

import java.io.FilenameFilter;

import listeners.FileListener;

import org.junit.Before;
import org.junit.Test;

public class FileCheckerTest {

	FilenameFilter filter;
	FileChecker fc;
	
	MockFileListener l;
	
	@Before
	public void init(){
		fc = new FileChecker(filter);
		l = new MockFileListener();
	}
	
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

	@Test
	public void testFireFile() {
		fc.addFileListener(l);

		assertEquals(0,l.cpt);
		fc.fireFileAdded("name");		
		assertEquals(1, l.cpt);
		fc.fireFileRemoved("name");
		assertEquals(0, l.cpt);
	}
	
	class MockFileListener implements FileListener {

		protected int cpt;

		public MockFileListener() {
			this.cpt = 0;
		}
		
		@Override
		public void fileAdded(FileEvent e) {
			cpt++;
			
		}

		@Override
		public void fileRemoved(FileEvent e) {
			cpt--;
			
		}

		
	}

}
