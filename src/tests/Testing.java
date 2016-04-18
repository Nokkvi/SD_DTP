package tests;
import java.util.*;
import metaSearchEngine.program.*;
import classes.*;

public class Testing {

	public static void main(String[] args){
        Database.connectToDatabase();
		ArrayList<DaytripAbstract> x = DaytripSearcher.searchByName("e");
		DaytripExtend[] xy = new DaytripExtend[x.size()];
		xy = x.toArray(xy);
		for(int i = 0; i < xy.length; i++){
			System.out.println(xy[i].getName());
			System.out.println(xy[i].getEndTime());
		}
		Database.closeDatabase();
	}
}
