package lab8_2;

import java.util.LinkedList;

public class LinkedListDecorator extends ProfileDecorator {

	public LinkedListDecorator(ProfileComponent profileToBeDecorated) {
		super(profileToBeDecorated, new LinkedList<String>());
	}
	
	@Override
	public boolean add(String event) {
		return super.add(event);
	}

	@Override
	public boolean remove(Object o) {
		return super.remove(o);
	}

	@Override
	public boolean conatins(Object o) {
		return super.conatins(o);
	}

	@Override
	public int size() {
		return super.size();
	}

}
