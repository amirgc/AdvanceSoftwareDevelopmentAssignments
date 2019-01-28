package lab_08_01;

public class WetState implements RoadState {

	private CarDriving carDriving;

	public WetState(CarDriving carDriving) {
		this.carDriving = carDriving;
	}

	@Override
	public void left() {
		carDriving.setLevel(4);

	}

	@Override
	public void accelerate() {
		carDriving.setLevel(9);
	}

	@Override
	public void right() {
		carDriving.setLevel(4);
	}

	@Override
	public void brake() {
		carDriving.setLevel(7);
	}

}
