package testFixtures;
import static org.junit.Assert.*;

import java.util.Date;

import mockObjects.*;
import interfaces.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import classes.*;

public class TimeSearcherTEst {
	private Searcher searchG;
	private Searcher searchL;
	private Searcher searchE;
	

	@Before
	public void setUp() throws Exception {
		I_IndivDayTripList tGen = new M_IndivDayTripList_Time();
		I_IndivDayTripList tLar = new M_IndivDayTripList_TimeL();
		I_IndivDayTripList tEmp = new M_IndivDayTripList_TimeE();
		
		searchG = new Searcher(tGen);
		searchL = new Searcher(tLar);
		searchE = new Searcher(tEmp);
	}
	
	@Test
	public void testGeneral() {
		System.out.println("Testing with general Input");
		Info[] k = searchG.searchByTime(new Date(116,8,12,18,11),new Date(117,8,12,18,11));
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
		Info[] k = searchL.searchByTime(new Date(116,6,12,18,11),new Date(117,8,12,18,11));
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
		Info[] k = searchE.searchByTime(new Date(117,8,12,18,11),new Date(117,8,12,18,11));
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