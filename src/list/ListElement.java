package list;

public class ListElement<T> {
	
	private T t;
	private int position;
	
	private ListElement<T> successor;
	
	public ListElement(T t) {
		this(t, 0);
	}
	
	public ListElement(T t, int position) {
		this.t = t;
		this.position = position;
	}
	
	public void add(T element) {
		if(hasNext()) {
			this.successor.add(element);
		}
		else {
			this.successor = new ListElement<T>(element, position+1);
		}
	}
	
	public T get() {
		return this.t;
	}
	
	public T get(int position) {
		if(this.position == position) {
			return this.t;
		}
		else {
			return this.successor.get(position);
		}
	}
	
	public boolean hasNext() {
		return this.successor != null;
	}
	
	public T getNext() {
		return this.successor.get();
	}
	
	public ListElement<T> getSuccessor() {
		return this.successor;
	}	
}
