package testFixtures;
import static org.junit.Assert.*;
import mockObjects.M_IndivDayTripList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import classes.*;

public class SearcherTest {
	private Searcher search;
	

	@Before
	public void setUp() throws Exception {
		search = new Searcher();
	}
	
	@Test
	public void test() {
		Info[] k = new Info[10];
		k = search.searchBySize(5);
		for(int i = 0; i < 5;i++){
			String blee = "";
			blee = k[i].getName();
			System.out.println(blee);
		}
		
	}

	@After
	public void tearDown() throws Exception {
		search = null;
	}

	

}
