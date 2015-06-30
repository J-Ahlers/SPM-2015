package list;

public class ListSort {

	public static List<Number> sort(List<Number> list) {
		List<List<Number>> converted = new List<List<Number>>();
		List<Number> result = new List<Number>();
		while(list.hasNext()) {
			Number next = (Number) list.getNext();
			List<Number> tmp = new List<Number>();
			tmp.add(next);
			converted.add(tmp);
		}
		converted = sort(converted, 0);
		
		while(converted.hasNext()) {
			List<Number> next = (List<Number>) converted.getNext();
			Number tmp = (Number) next.getFirst();
			result.add(tmp);
		}
		
		return result;
	}
	
	public static List<List<Number>> sort(List<List<Number>> list, int index) {
		List<List<Number>> newResult = new List<List<Number>>();
		return sort(list, newResult, index);
	}
	
	private static List<List<Number>> sort(List<List<Number>> list, List<List<Number>> result, int index) {
		// end of recursion
		if(list.isEmpty())
			return result;
		
		List<List<Number>> rest = new List<List<Number>>();
		List<List<Number>> newResult = result;
		
		List<Number> minList = null;
		Double minValue = null;
		int minIndex = 0;
		// Find smallest element in remaining list
		for(int i = 0; i < list.length; i++) {
			List<Number> next = (List<Number>) list.get(i);
			if(next == null)
				continue;
			
			Number tmp = (Number) next.get(index);
			if(minValue == null || tmp.doubleValue() < minValue) {
				minValue = tmp.doubleValue();
				minList = next;
				minIndex = i;
			}
		}
		
		// Add all elements except for the smallest one to new list
		for(int i = 0; i < list.length; i++) {
			List<Number> next = (List<Number>) list.getNext();
			if(i != minIndex) {
				rest.add(next);
			}
		}
		
		// Add smallest element to result
		newResult.add(minList);
		return sort(rest, newResult, index);
	}
}
