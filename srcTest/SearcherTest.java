import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Classes.Searcher;

public class SearcherTest {
	private Searcher search;

	@Before
	public void setUp() throws Exception {
		search = new Searcher();
	}

	@After
	public void tearDown() throws Exception {
		search = null;
	}

	@Test
	public void test() {
		assertEquals("foo", "bar");
	}

}
