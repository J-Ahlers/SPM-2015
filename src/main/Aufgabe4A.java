package main;

import list.List;
import list.PairList;
import math.RegressionCalculator;
import metrics.ProjectData;
import metrics.ProjectDataManager;

public class Aufgabe4A {

	public static void main(String[] args) {
		ProjectDataManager manager = new ProjectDataManager();
		List<ProjectData> testdata = manager.getTestdata_4a();
		
		PairList<Integer> t1 = new PairList<Integer>();
		while(testdata.hasNext()) {
			ProjectData next = (ProjectData) testdata.getNext();
			t1.add(next.getEOLOC(), next.getANCLOC());
		}
		RegressionCalculator r1 = new RegressionCalculator(t1);
		System.out.println("T1: ß0 = " + r1.getB0() + " | ß1 = " + r1.getB1());
		
		
		PairList<Integer> t2 = new PairList<Integer>();
		while(testdata.hasNext()) {
			ProjectData next = (ProjectData) testdata.getNext();
			t2.add(next.getENCLOC(), next.getANCLOC());
		}
		RegressionCalculator r2 = new RegressionCalculator(t2);
		System.out.println("T2: ß0 = " + r2.getB0() + " | ß1 = " + r2.getB1());
		
		testdata = manager.getActualdata_4a();
		
		PairList<Integer> t3 = new PairList<Integer>();
		while(testdata.hasNext()) {
			ProjectData next = (ProjectData) testdata.getNext();
			t3.add(next.getENCLOC(), next.getANCLOC());
		}
		
		RegressionCalculator r3 = new RegressionCalculator(t3);
		System.out.println("T3: ß0 = " + r3.getB0() + " | ß1 = " + r3.getB1());
	}
}
