package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

public class ToUpperCaseTest {

	@Test
	public void test() {
		ToUpperCase upper = new ToUpperCase();
		String str1 = "Abc";
		String str2 = "xYz";
		
		assertEquals("ABC", upper.transform(str1));
		assertEquals("XYZ", upper.transform(str2));
	}

}
