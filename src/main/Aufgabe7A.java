package main;

import list.List;
import list.PairList;
import math.CorrelationCalculator;
import math.SignificanceCalculator;
import metrics.ProjectData;
import metrics.ProjectDataManager;

public class Aufgabe7A {
	
	public static void main(String[] args) {
		PairList<Number> values = new PairList<Number>();
		values.add(186.0, 15.0);
		values.add(699.0, 69.9);
		values.add(132.0, 6.5);
		values.add(272.0, 22.4);
		values.add(291.0, 28.4);
		values.add(331.0, 65.9);
		values.add(199.0, 19.4);
		values.add(1890.0, 198.7);
		values.add(788.0, 38.8);
		values.add(1601.0, 138.2);
		
		CorrelationCalculator correlation = new CorrelationCalculator();
		SignificanceCalculator significance = new SignificanceCalculator();
		
		System.out.println("D12 Correlation: "+correlation.getCorrelation(values));
		System.out.println("D12 Significance: "+significance.getSignificance(values));
		
		ProjectDataManager manager = new ProjectDataManager();
		List<ProjectData> data = manager.getExerciseData();
		
		PairList<Number> estimated = new PairList<Number>();
		PairList<Number> actual = new PairList<Number>();
		while(data.hasNext()) {
			ProjectData next = (ProjectData) data.getNext();
			estimated.add(next.getENCLOC(), next.getAtime());
			actual.add(next.getANCLOC(), next.getAtime());
		}
		
		System.out.println();
		
		System.out.println("ANCLOC + Atime Correlation: "+correlation.getCorrelation(actual));
		System.out.println("ANCLOC + Atime Significance: "+significance.getSignificance(actual));
		
		System.out.println();
		
		System.out.println("ENCLOC + Atime Correlation: "+correlation.getCorrelation(estimated));
		System.out.println("ENCLOC + Atime Significance: "+significance.getSignificance(estimated));
	}
}
