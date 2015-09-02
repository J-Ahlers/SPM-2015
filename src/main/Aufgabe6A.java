package main;

import list.List;
import list.PairList;
import math.RangeCalculator;
import math.RegressionCalculator;
import metrics.ProjectData;
import metrics.ProjectDataManager;

public class Aufgabe6A {

	public static void main(String[] args) {
		int estimatedObjectLOC = 197;
		
		ProjectDataManager manager = new ProjectDataManager();
		
		System.out.println("********** Sample Data **********");
		List<ProjectData> data = manager.getTestdata_4a();
		PairList<Number> size = new PairList<Number>();
		while(data.hasNext()) {
			ProjectData next = (ProjectData) data.getNext();
			size.add(next.getEOLOC(), next.getANCLOC());
		}
		
		generateOutput(386, size, null);
		System.out.println("");
		System.out.println("");
		
		
		System.out.println("********** Actual Data **********");
		data = manager.getExerciseData();
		size = new PairList<Number>();
		while(data.hasNext()) {
			ProjectData next = (ProjectData) data.getNext();
			size.add(next.getENCLOC(), next.getANCLOC());
		}
		generateOutput(estimatedObjectLOC, size, data);
	}
	
	private static void generateOutput(int estimatedObjectLOC, PairList<Number> size, List<ProjectData> data) {
		RangeCalculator rc = new RangeCalculator();
		
		RegressionCalculator rcSize = new RegressionCalculator(size);
		float range_70 = rc.getRange(size, estimatedObjectLOC, 0.85f);
		float b0 = rcSize.getB0();
		float b1 = rcSize.getB1();
		float adjustedSize = b0 + estimatedObjectLOC * b1;
		System.out.println("Size: ß0 = " + b0 + " | ß1 = " + b1);
		System.out.println("Size-range(70%): " + range_70);
		System.out.println("       UPI(70%): " + (adjustedSize + range_70));
		System.out.println("       LPI(70%): " + (adjustedSize - range_70));
		
		float range_90 = rc.getRange(size, estimatedObjectLOC, 0.95f);
		System.out.println("Size-range(90%): " + range_90);
		System.out.println("       UPI(90%): " + (adjustedSize + range_90));
		System.out.println("       LPI(90%): " + (adjustedSize - range_90));
		System.out.println("");
		
		if(data != null) {
			PairList<Number> time = new PairList<Number>();
			List<Integer> actualTimes = new List<Integer>();
			while(data.hasNext()) {
				ProjectData next = (ProjectData) data.getNext();
				time.add(next.getEtime(), next.getAtime());
				actualTimes.add(next.getAtime());
			}
			RegressionCalculator rcTime = new RegressionCalculator(time);
			int estimatedTime = (int) ((int) rcTime.getB0() + adjustedSize * rcTime.getB1());
			float timeRange_70 = rc.getRange(time, estimatedTime, 0.85f);
			float timeRange_90 = rc.getRange(time, estimatedTime, 0.95f);
			System.out.println("Time: ß0 " + rcTime.getB0() + " | ß1 = " + rcTime.getB1());
			System.out.println("Time-range(70%): = " + timeRange_70);
			System.out.println("       UPI(70%): " + (estimatedTime + timeRange_70));
			System.out.println("       LPI(70%): " + (estimatedTime - timeRange_70));
			System.out.println("Time-range 90%: = " + timeRange_90);
			System.out.println("       UPI(70%): " + (estimatedTime + timeRange_90));
			System.out.println("       LPI(70%): " + (estimatedTime - timeRange_90));
		}
	}
}
