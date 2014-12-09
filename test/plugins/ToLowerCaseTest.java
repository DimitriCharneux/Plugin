package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

public class ToLowerCaseTest {

	@Test
	public void test() {
		ToLowerCase lower = new ToLowerCase();
		String str1 = "Abc";
		String str2 = "xYz";
		
		assertEquals("abc", lower.transform(str1));
		assertEquals("xyz", lower.transform(str2));
	}

}
