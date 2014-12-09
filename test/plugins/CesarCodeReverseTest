package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

public class CesarCodeReverseTest {
	
	String str1 = "Abc";
	String str2 = "xYz";
	
	@Test
	public void testDoNotChange() {
		CesarCodeReverse noChange = new CesarCodeReverse(0);
		CesarCodeReverse theSame = new CesarCodeReverse(26);
		assertEquals("Cesar Code reverse 0", noChange.getLabel());
		assertEquals("Cesar Code reverse 26", theSame.getLabel());
		assertEquals("Abc", noChange.transform(str1));
		assertEquals("xYz", noChange.transform(str2));
		assertEquals("Abc", theSame.transform(str1)); //expected:<A[bc]> but was:<A[HI]> ???
		assertEquals("xYz", theSame.transform(str2));
	}

	@Test
	public void testShiftByOneOr28() {
		CesarCodeReverse code1 = new CesarCodeReverse();
		CesarCodeReverse code27 = new CesarCodeReverse(27);
		assertEquals("Cesar Code reverse 1", code1.getLabel());
		assertEquals("Cesar Code reverse 27", code27.getLabel());
		assertEquals("Zab", code1.transform(str1)); //expected:<[Z]ab> but was:<[@]ab> ???
		assertEquals("wXy", code1.transform(str2));
		assertEquals("Zab", code27.transform(str1));
		assertEquals("wXy", code27.transform(str2));
	}
}
