package main;

import list.List;
import list.ListSort;

public class Aufgabe8A {

	public static void main(String[] args) {
		List<List<Number>> testdata = new List<List<Number>>();
		testdata.add(wrapNumbers(26,8.67));
		testdata.add(wrapNumbers(39, 7.80));
		testdata.add(wrapNumbers(26, 8.67));
		testdata.add(wrapNumbers(53, 7.57));
		testdata.add(wrapNumbers(17, 5.67));
		testdata.add(wrapNumbers(26, 8.67));
		testdata.add(wrapNumbers(22, 7.33));
		testdata.add(wrapNumbers(53, 8.83));
		testdata.add(wrapNumbers(31, 10.33));
		testdata.add(wrapNumbers(18, 6.00));
		testdata.add(wrapNumbers(25, 8.33));
		testdata.add(wrapNumbers(30, 7.50));
		testdata.add(wrapNumbers(42, 14.00));
		testdata.add(wrapNumbers(45, 9.00));
		testdata.add(wrapNumbers(40, 10.00));
		testdata.add(wrapNumbers(195, 39.00));
		testdata.add(wrapNumbers(114, 38.00));
		testdata.add(wrapNumbers(87, 21.75));
		testdata.add(wrapNumbers(87, 29.00));
		testdata.add(wrapNumbers(25, 8.33));
		testdata.add(wrapNumbers(53, 13.25));
		testdata.add(wrapNumbers(47, 11.75));
		testdata.add(wrapNumbers(58, 5.80));
		testdata.add(wrapNumbers(49, 7.00));
		testdata.add(wrapNumbers(88, 14.67));
		testdata.add(wrapNumbers(82, 16.40));
		testdata.add(wrapNumbers(46, 5.75));
		testdata.add(wrapNumbers(55, 13.75));
		testdata.add(wrapNumbers(32, 10.67));
		testdata.add(wrapNumbers(18, 6.00));
		testdata.add(wrapNumbers(89, 29.67));
		testdata.add(wrapNumbers(18, 6.00));
		testdata.add(wrapNumbers(36, 12.00));
		testdata.add(wrapNumbers(161, 40.25));
		testdata.add(wrapNumbers(112, 37.33));
		testdata.add(wrapNumbers(89, 22.25));
		testdata.add(wrapNumbers(85, 28.33));
		testdata.add(wrapNumbers(82, 20.55));
		testdata.add(wrapNumbers(82, 16.40));
		testdata.add(wrapNumbers(46, 7.67));
		testdata.add(wrapNumbers(184, 36.80));
		testdata.add(wrapNumbers(145, 24.17));
		testdata.add(wrapNumbers(96, 19.20));
		testdata.add(wrapNumbers(123, 41.00));
		testdata.add(wrapNumbers(211, 30.14));
		testdata.add(wrapNumbers(405, 50.63));
		testdata.add(wrapNumbers(58, 14.50));
		testdata.add(wrapNumbers(264, 52.80));
		testdata.add(wrapNumbers(58, 19.33));
		testdata.add(wrapNumbers(305, 25.42));
		
		System.out.println("Test row 0:");
		List<List<Number>> t1 = ListSort.sort(testdata, 0);
		while(t1.hasNext()) {
			List<Number> next = (List<Number>) t1.getNext();
			if(next == null)
				continue;
			
			Number tmp = (Number) next.get(0);
			System.out.print(tmp.intValue()+", ");
			tmp = (Number) next.get(1);
			System.out.println(tmp.doubleValue());
		}
		
		System.out.println("\n\nTest row 1:");
		List<List<Number>> t2 = ListSort.sort(testdata, 1);
		while(t2.hasNext()) {
			List<Number> next = (List<Number>) t2.getNext();
			if(next == null)
				continue;
			
			Number tmp = (Number) next.get(0);
			System.out.print(tmp.intValue()+", ");
			tmp = (Number) next.get(1);
			System.out.println(tmp.doubleValue());
		}

	}
	
	private static List<Number> wrapNumbers(double x, double y) {
		List<Number> list = new List<Number>();
		list.add(x);
		list.add(y);
		
		return list;
	}

}
