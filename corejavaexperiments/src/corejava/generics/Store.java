package corejava.generics;

public class Store<T> {

    private T	element;
	
	public void add(T element) {
		this.element=element;
	}
	
	public T  getElement() {
		return element;
	}
	
	
}
