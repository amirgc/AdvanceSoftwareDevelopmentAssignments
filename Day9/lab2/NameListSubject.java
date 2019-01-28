package lab_10_02;

import java.util.ArrayList;
import java.util.List;

public class NameListSubject implements Subject {
	private List<Observer> observers;
	private List<String> names;
	private static final int ROW_COUNT = 10;

	public NameListSubject() {
		observers = new ArrayList<>();
		names = new ArrayList<>();
		for (int i = 0; i < ROW_COUNT; i++) {
			names.add(SampleData.firstNames[i]);
		}
	}

	@Override
	public void attach(Observer observer) {
		observers.add(observer);
		notifyObservers();
	}

	@Override
	public void detach(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

	public List<String> getNames() {
		return this.names;
	}

	public void addName(String name) {
		this.names.add(name);
		notifyObservers();
	}

	public void removeName(String name) {
		this.names.remove(name);
		notifyObservers();
	}
}
