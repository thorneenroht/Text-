package pig.latin;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PigLatinUnitTest {
	
	private static String S = "piglatin";
	
	private static String S2 = "idea";
	
	private PigLatin p;
	
	@Before
	public void setUp(){
		p = new PigLatin();
	}
	
	@Test
	public void pigLatinNullTest(){
		String actual =	p.pigLatin(null);
		assertNull(actual);
	}
	
	@Test
	public void pigLatinConversionTest(){
		String s = p.pigLatin(S);
		String sTwo = p.pigLatin(S2);
		
		
		String expectedOne = "iglatin-pay";
		String expectedTwo = "ea-iday";
		assertEquals(expectedOne, s);
		assertEquals(expectedTwo, sTwo);
	}
	
	
}
