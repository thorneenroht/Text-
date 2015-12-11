package string.reverse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class StringReverseUnitTest {
	StringReverse s;
	public static String expected = "YAWYSAE";
	@Before
	public void setUp() {
		s = new StringReverse();
	}

	@Test
	public void StringReverseNullStringTest() {

		String actual = s.hardStringReverse(null);
		assertNull(actual);
	}

	@Test
	public void StringReverseTest() {

		String actual = s.hardStringReverse(s.EASY);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}

	@Test
	public void StringReverseEasyNullStringTest() {

		String actual = s.easyStringReverse(null);
		assertNull(actual);
	}

	@Test
	public void StringReverseEasyTest() {

		String actual = s.easyStringReverse(s.EASY);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}
}
