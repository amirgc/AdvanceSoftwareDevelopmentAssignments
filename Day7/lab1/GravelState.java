package lab7;

public class GravelState extends CarPorperties implements CarState {

	@Override
	public void setLeft() {
		super.setLeft(3);
	}

	@Override
	public void setAccel() {
		super.setAccel(7);
	}

	@Override
	public void setRight() {
		super.setRight(3);
	}

	@Override
	public void setBrake() {
		super.setBrake(6);
	}

}
