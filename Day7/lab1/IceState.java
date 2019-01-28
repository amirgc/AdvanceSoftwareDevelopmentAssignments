package lab_08_01;

public class IceState implements RoadState {

	private CarDriving carDriving;

	public IceState(CarDriving carDriving) {
		this.carDriving = carDriving;
	}

	@Override
	public void left() {
		carDriving.setLevel(1);
	}

	@Override
	public void accelerate() {
		carDriving.setLevel(3);
	}

	@Override
	public void right() {
		carDriving.setLevel(1);
	}

	@Override
	public void brake() {
		carDriving.setLevel(2);
	}
}
