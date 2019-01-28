package lab_08_01;

public class GravelState implements RoadState {

	private CarDriving carDriving;

	public GravelState(CarDriving carDriving) {
		this.carDriving = carDriving;
	}

	@Override
	public void left() {
		carDriving.setLevel(3);

	}

	@Override
	public void accelerate() {
		carDriving.setLevel(7);
	}

	@Override
	public void right() {
		carDriving.setLevel(3);

	}

	@Override
	public void brake() {
		carDriving.setLevel(6);
	}

}
