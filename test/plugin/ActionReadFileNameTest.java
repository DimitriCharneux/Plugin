package plugin;

import static org.junit.Assert.assertEquals;

import java.io.FilenameFilter;

import org.junit.Before;
import org.junit.Test;

public class ActionReadFileNameTest {

	private FilenameFilter filter;
	private FileChecker checker;
	ActionReadFileName reader;
	String[] listClassFile;
	public int nbFichiers = 0;

	@Before
	public void toDoBefore() {
		checker = new MockUpChecker(filter);
		reader = new ActionReadFileName(filter, checker);
		listClassFile = new String[2];
		listClassFile[0] = "File1.class";
		listClassFile[1] = "File2.class";
	}
	
	@Test
	public void detectFileAddedthenRemovedTest() {
		reader.fileAddedDetected(listClassFile);
		assertEquals(2, nbFichiers);

		listClassFile = new  String[1];
		listClassFile[0] = "File1.class";
		reader.fileRemovededDetected(listClassFile);
		assertEquals(1, nbFichiers);
	}

	
	class MockUpChecker extends FileChecker {

		public MockUpChecker(FilenameFilter filter) {
			super(filter);
		}

		@Override
		public void fireFileAdded(String name) {
			nbFichiers += 1;
		}

		@Override
		public void fireFileRemoved(String name) {
			nbFichiers -= 1;
		}

		
	}
}
