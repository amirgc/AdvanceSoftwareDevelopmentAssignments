package lab7;

public class WetState extends CarPorperties implements CarState {
	@Override
	public void setLeft() {
		super.setLeft(4);
	}

	@Override
	public void setAccel() {
		super.setAccel(9);
	}

	@Override
	public void setRight() {
		super.setRight(4);
	}

	@Override
	public void setBrake() {
		super.setBrake(7);
	}

}
