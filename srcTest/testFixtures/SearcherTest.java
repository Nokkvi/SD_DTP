package testFixtures;
import static org.junit.Assert.*;
import mockObjects.M_IndivDayTripList;
import interfaces.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import classes.*;

public class SearcherTest {
	private Searcher search;
	

	@Before
	public void setUp() throws Exception {
		I_IndivDayTripList i = new M_IndivDayTripList();
		search = new Searcher(i);
	}
	
	@Test
	public void test() {
		Info[] k = search.searchBySize(25);
		for(int i = 0; i < k.length;i++){
			String blee = "";
			int id = 0;
			id = k[i].getIndivId();
			blee = k[i].getName();
			System.out.println(id+" "+blee);
		}
		
	}

	@After
	public void tearDown() throws Exception {
		search = null;
	}

	

}
