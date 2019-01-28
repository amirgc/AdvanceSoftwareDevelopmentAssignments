package lab_08_01;

public class RegularState implements RoadState {
	private CarDriving carDriving;

	public RegularState(CarDriving carDriving) {
		this.carDriving = carDriving;
	}

	@Override
	public void accelerate() {
		carDriving.setLevel(9);
	}

	@Override
	public void left() {
		carDriving.setLevel(5);
	}

	@Override
	public void right() {
		carDriving.setLevel(5);
	}

	@Override
	public void brake() {
		carDriving.setLevel(8);
	}

}
