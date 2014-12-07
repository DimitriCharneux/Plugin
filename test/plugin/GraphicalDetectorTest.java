package plugin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GraphicalDetectorTest {

	GraphicalDetector gd = new GraphicalDetector();
	
	@Test
	public void testText() {
		assertEquals("Plugin", gd.getTitle());
		
		gd.setText("text");
		assertEquals("text", gd.getText());
	}
	
	@Test
	public void testChangeMenuItem() {
		gd.addMenuItem("item");
		assertEquals("item", gd.listMenuItem.get(0).getText());
		
		gd.removeMenuItem("item");
		assertTrue(gd.listMenuItem.isEmpty());
	}

}
