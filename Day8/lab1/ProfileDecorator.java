package lab8_2;

import java.util.List;

public class ProfileDecorator implements ProfileComponent {

	protected ProfileComponent profileToBeDecorated;
	private List<String> eventList;

	public ProfileDecorator(ProfileComponent profileToBeDecorated, List<String> elst) {
		this.profileToBeDecorated = profileToBeDecorated;
		this.eventList = elst;
	}

	@Override
	public boolean add(String event) {
		return profileToBeDecorated.add(event);
	}

	@Override
	public boolean remove(Object o) {
		return profileToBeDecorated.remove(o);
	}

	@Override
	public boolean conatins(Object o) {
		return profileToBeDecorated.conatins(o);
	}

	@Override
	public int size() {
		return profileToBeDecorated.size();
	}

}
