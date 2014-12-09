package plugin;

import static org.junit.Assert.*;

import org.junit.Test;

public class PluginFilterTest {

	PluginFilter plgFilter = new PluginFilter();
	
	@Test
	public void testIfHasGoodExtent() {
		String good = "good.class";
		String bad = "bad.other";
		assertTrue(plgFilter.isDotClass(good));
		assertFalse(plgFilter.isDotClass(bad));
		
	}

}
