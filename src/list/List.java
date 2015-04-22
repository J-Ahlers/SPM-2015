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
	
	public T get(int position) {
		return elements.get(position);
	}
	
	public boolean isEmpty() {
		return this.elements == null;
	}
}
