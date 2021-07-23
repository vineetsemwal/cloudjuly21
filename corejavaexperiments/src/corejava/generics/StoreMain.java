package corejava.generics;

public class StoreMain {
	
	public static void main(String args[]) {		
		Store<String> store=new Store<>();
		store.add("hello");
		String element=store.getElement();
		System.out.println("element="+element);
		
	}

}
