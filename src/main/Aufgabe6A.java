package main;

import list.List;
import list.PairList;
import math.RangeCalculator;
import math.RegressionCalculator;
import metrics.ProjectData;
import metrics.ProjectDataManager;

public class Aufgabe6A {

	public static void main(String[] args) {
		RangeCalculator rc = new RangeCalculator();
		ProjectDataManager manager = new ProjectDataManager();
		List<ProjectData> data = manager.getTestdata_4a();
		
		PairList<Integer> size = new PairList<Integer>();
		while(data.hasNext()) {
			ProjectData next = (ProjectData) data.getNext();
			size.add(next.getENCLOC(), next.getANCLOC());
		}
		RegressionCalculator rcSize = new RegressionCalculator(size);
		System.out.println("Size: ß0 = " + rcSize.getB0() + " | ß1 = " + rcSize.getB1());
		System.out.println("Size-range 70%: = " + rc.getRange(size, 62, 0.85));
		System.out.println("Size-range 90%: = " + rc.getRange(size, 62, 0.95) + "\n");
		
		PairList<Integer> time = new PairList<Integer>();
		List<Integer> actualTimes = new List<Integer>();
		while(data.hasNext()) {
			ProjectData next = (ProjectData) data.getNext();
			time.add(next.getEtime(), next.getAtime());
			actualTimes.add(next.getAtime());
		}
		RegressionCalculator rcTime = new RegressionCalculator(time);
		System.out.println("Time: ß0 " + rcTime.getB0() + " | ß1 = " + rcTime.getB1());
		System.out.println("Time-range 70%: = " + rc.getRange(time, 89, 0.85));
		System.out.println("Time-range 90%: = " + rc.getRange(time, 89, 0.95));
		
		System.out.println("\n\n gamma(9 / 2): "+math.Math.gamma(4.5d));
		System.out.println("\n\n gamma(n + 1 / 2): "+math.Math.gamma(5d));

	}
}
