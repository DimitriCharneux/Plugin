package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

public class CesarCodeTest {
	
	String str1 = "Abc";
	String str2 = "xYz";
	
	@Test
	public void testDoNotChange() {
		CesarCode noChange = new CesarCode(0);
		CesarCode theSame = new CesarCode(26);
		assertEquals(0, noChange.shift);
		assertEquals(26, theSame.shift);
		assertEquals("Abc", noChange.transform(str1));
		assertEquals("xYz", noChange.transform(str2));
		assertEquals("Abc", theSame.transform(str1));
		assertEquals("xYz", theSame.transform(str2));
	}

	@Test
	public void testShiftByOneOr28() {
		CesarCode code1 = new CesarCode(1);
		CesarCode code28 = new CesarCode(27);
		assertEquals(1, code1.shift);
		assertEquals(27, code28.shift);
		assertEquals("Bcd", code1.transform(str1));
		assertEquals("yZa", code1.transform(str2));
		assertEquals("Bcd", code28.transform(str1));
		assertEquals("yZa", code28.transform(str2));
	}
	
}
