package plugin;

import static org.junit.Assert.*;

import java.io.FilenameFilter;

import org.junit.Before;
import org.junit.Test;

public class FileCheckerTest {

	FilenameFilter filter;
	FileChecker fc;
	
	FileListener l;
	
	@Before
	public void init(){
		fc = new FileChecker(filter);
		l = new FileDetector();
	}
	
	@Test
	public void addAndRemoveFileListenerTest() {
		assertTrue(fc.fileListeners.isEmpty());
		fc.addFileListener(l);
		assertTrue(fc.fileListeners.contains(l));
		fc.addFileListener(l);
		assertEquals(1, fc.fileListeners.size());
		
		//j'essaie déjà juste de faire tourner les fonctions
		fc.fireFileAdded("name");		
		fc.fireFileRemoved("name");
		
		
		fc.removeFileListener(l);
		assertTrue(fc.fileListeners.isEmpty());		
	}

	//le pb c'est que c'est jamais la fct ci-dessous qui est prise,
	//du coup il sert à ren le MockFileEvent et on est obligé d'avoir un vrai file pour testes
	protected FileEvent createFileEvent(String name) {
		return new MockFileEvent(name);
	}
	
	class MockFileEvent extends FileEvent {

		protected int compteur;

		protected MockFileEvent(String source) {
			super(source);
			this.compteur = 0;
		}
		
	}

}
