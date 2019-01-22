package lab7;

public class Car {

	private CarState state;

	public Car(CarState state) {
		this.setState(state);
		state.setAccel();
		state.setBrake();
		state.setLeft();
		state.setRight();
	}

	public int getLeft() {
		return state.getLeft();
	}

	public int getAccel() {
		return state.getAccel();
	}

	public int getRight() {
		return state.getRight();
	}

	public int getBrake() {
		return state.getBrake();
	}

	public CarState getState() {
		return state;
	}

	public void setState(CarState state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return String.format(""
				+ "Car acceleration is set to :%s \n"
				+ "Car acceleration is set to :%s \n"
				+ "Car acceleration is set to :%s \n"
				+ "Car acceleration is set to :%s \n", getLeft(), getAccel(), getRight(), getBrake());
	}
}
