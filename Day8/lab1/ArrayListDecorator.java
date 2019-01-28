package lab8_2;

import java.util.ArrayList;

public class ArrayListDecorator extends ProfileDecorator {

	public ArrayListDecorator(ProfileComponent profileToBeDecorated) {
		super(profileToBeDecorated, new ArrayList<String>());
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
