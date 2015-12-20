package count.vowels;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class CountVowelsUnitTest {

	private Map<String,Integer> m;
	private CountVowels c;
	@Before
	public void setUp(){
		 c = new CountVowels();
	}
	
	@Test
	public void countVowelsNoMatchsUnitTest(){
		String noVowels = "nnnn";
		m = c.count(noVowels);
		
		assertEquals(0, m.size());
	}
	
	@Test
	public void countVowelsNullString(){
		m = c.count(null);
		
		assertNull(m);
	}
	
	@Test
	public void countVowelsOneString(){
		m = c.count("a");
		
		assertNotNull(m);
		assertEquals(true,m.containsKey("a"));
		assertEquals((Integer) 1, (Integer) m.get("a"));
	}
	
	@Test
	public void countVowelsThreeString(){
		m = c.count("aaa");
		
		assertNotNull(m);
		assertEquals(true,m.containsKey("a"));
		assertEquals((Integer) 3, (Integer) m.get("a"));
	}
	
	@Test
	public void countVowelsMultiplesString(){
		m = c.count("afsdeffaafefffifofufi");
		
		assertNotNull(m);
		assertEquals(true,m.containsKey("a"));
		assertEquals(true,m.containsKey("e"));
		assertEquals(true,m.containsKey("i"));
		assertEquals(true,m.containsKey("o"));
		assertEquals(true,m.containsKey("u"));
		
		assertEquals((Integer) 3, (Integer) m.get("a"));
		assertEquals((Integer) 2, (Integer) m.get("e"));
		assertEquals((Integer) 2, (Integer) m.get("i"));
		assertEquals((Integer) 1, (Integer) m.get("o"));
		assertEquals((Integer) 1, (Integer) m.get("u"));
	}
	
	
	
}
