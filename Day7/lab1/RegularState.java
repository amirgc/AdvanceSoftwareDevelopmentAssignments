package lab7;

public class RegularState extends CarPorperties implements CarState {

	@Override
	public void setLeft() {
		super.setLeft(5);
	}

	@Override
	public void setAccel() {
		super.setAccel(9);
	}

	@Override
	public void setRight() {
		super.setRight(5);
	}

	@Override
	public void setBrake() {
		super.setBrake(8);
	}

}
