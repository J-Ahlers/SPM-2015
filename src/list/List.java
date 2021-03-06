package list;

public class List<T> {
	
	private ListElement<T> elements;
	private ListElement<T> tmp;
	
	public int length;
	
	public void add(T element) {
		if(isEmpty()) {
			this.elements = new ListElement<T>(element);
		}
		else {
			elements.add(element);
		}
		length++;
	}
	
	public void add(List<T> list) {
		if(list != null) {
			while(list.hasNext()) {
				add(list.getNext());
			}
		}
	}
	
	public boolean hasNext() {
		if(isEmpty()) {
			return false;
		} else if(tmp == null) {
			return true;
		} else {
			boolean result = tmp.hasNext();
			if(!result)
				tmp = null;
			return result;
		}
	}
	
	public T getFirst() {
		return elements.get();
	}
	
	public T getNext() {
		if(tmp == null) {
			tmp = elements;
			return tmp.get();
		} else if (tmp.hasNext()) {
			T value = tmp.getNext();
			tmp = tmp.getSuccessor();
			return value;
		} else {
			tmp = null;
			return null;
		}
	}
	
	public int getActualCount() {
		if(elements == null)
			return 0;
		
		int count = 0;
		while(hasNext()) {
			if(getNext() != null)
				count++;
		}
		
		return count;
	}
	
	public T get(int position) {
		return elements.get(position);
	}
	
	public boolean isEmpty() {
		return this.elements == null;
	}
	
	public void print() {
		System.out.print("{");
		while(hasNext()) {
			Number n = (Number) getNext();
			if(n == null) {
				System.out.print("null, ");
				continue;
			}
			System.out.print(n.doubleValue() + ", ");
		}
		System.out.println("}");
	}
}
