import java.lang.Math;

import list.List;


public class Aufgabe1A {

    public static void main(String[] args) {
        //double[] values = new double[] { 160, 591, 114, 229, 230, 270, 128, 1657, 624, 1503 };
        //double[] values = new double[] { 186, 699, 132, 272, 291, 331, 199, 1890, 788, 1601 };
        //double[] values = new double[] { 15.0, 69.9, 6.5, 22.4, 28.4, 65.9, 19.4, 198.7, 38.8, 138.2 };
		
		List<Double> values = new List<Double>();
		values.add(160d);
		values.add(591d);
		values.add(114d);
		values.add(229d);
		values.add(230d);
		values.add(270d);
		values.add(128d);
		values.add(1657d);
		values.add(624d);
		values.add(1503d);

		Double avg = Aufgabe1A.avg(values);
		Double stddev = Aufgabe1A.stddev(values);
		
		if(avg != null)
			System.out.println("Avg: "+ avg);
		else
			System.out.println("Average could not be calculated");
		
		if(stddev != null)
			System.out.println("Stddev: "+ stddev);
		else
			System.out.println("Standard deviation could not be calculated");
    }
	
	private static Double avg(List<Double> values) {
		double avg = 0;
		double sum = 0;
		
		if(values.isEmpty())
			return null;
		
		while(values.hasNext()) {
			sum += (double) values.getNext();
		}
		avg = sum / values.length;
		return avg;
	}
	
	private static Double stddev(List<Double> values) {
		double stddev = 0;
		double avg = avg(values);
		
		if(values.length <= 1)
			return null;
		
		while(values.hasNext()) {
			double next = ((double) values.getNext()) - avg;
			stddev += next * next;
		}
		
		stddev = stddev / (values.length - 1);
		stddev = Math.sqrt(stddev);
		
		return stddev;
	}
}