package testFixtures;
import static org.junit.Assert.*;

import java.util.Date;

import mockObjects.*;
import interfaces.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import classes.*;

public class SizeSearcherTest {
	private DaytripSearcher searchG;
	private DaytripSearcher searchL;
	private DaytripSearcher searchE;
	

	@Before
	public void setUp() throws Exception {
		I_IndivDayTripList tGen = new M_IndivDayTripList_Size();
		I_IndivDayTripList tLar = new M_IndivDayTripList_SizeL();
		I_IndivDayTripList tEmp = new M_IndivDayTripList_SizeE();
		
		searchG = new DaytripSearcher(tGen);
		searchL = new DaytripSearcher(tLar);
		searchE = new DaytripSearcher(tEmp);
	}
	
	@Test
	public void testGeneral() {
		System.out.println("Testing with general Input");
		Info[] k = searchG.searchBySize(25);
		for(int i = 0; i < k.length;i++){
			String blee = "";
			int id = 0;
			id = k[i].getIndivId();
			blee = k[i].getName();
			System.out.println(id+" "+blee);
		}
		
	}
	
	@Test
	public void testLarge() {
		System.out.println("Testing with large Input");
		Info[] k = searchL.searchBySize(25);
		for(int i = 0; i < k.length;i++){
			String blee = "";
			int id = 0;
			id = k[i].getIndivId();
			blee = k[i].getName();
			System.out.println(id+" "+blee);
		}
		
	}
	
	@Test
	public void testEmpty() {
		System.out.println("Testing with input that returns no usable values");
		Info[] k = searchE.searchBySize(25);
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
		searchG = null;
		searchE = null;
		searchL = null;
	}

	

}