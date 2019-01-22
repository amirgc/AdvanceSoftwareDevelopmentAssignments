package lab7;

public class IceState extends CarPorperties implements CarState {

	@Override
	public void setLeft() {
		super.setLeft(1);

	}

	@Override
	public void setAccel() {
		super.setAccel(3);
	}

	@Override
	public void setRight() {
		super.setRight(1);
	}

	@Override
	public void setBrake() {
		super.setBrake(2);
	}

}
