package lab_08_01;

public class CarDriving {
	private int level;

	private RoadState regularState;
	private RoadState gravelState;
	private RoadState wetState;
	private RoadState iceState;

	private RoadState currentState;

	public RoadState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(RoadState currentState) {
		this.currentState = currentState;
	}

	public RoadState getRegularState() {
		return regularState;
	}

	public void setRegularState(RoadState regularState) {
		this.regularState = regularState;
	}

	public RoadState getGravelState() {
		return gravelState;
	}

	public void setGravelState(RoadState gravelState) {
		this.gravelState = gravelState;
	}

	public RoadState getWetState() {
		return wetState;
	}

	public void setWetState(RoadState wetState) {
		this.wetState = wetState;
	}

	public RoadState getIceState() {
		return iceState;
	}

	public void setIceState(RoadState iceState) {
		this.iceState = iceState;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void left() {
		currentState.left();
	}

	public void accelerate() {
		currentState.accelerate();
	}

	public void right() {
		currentState.right();
	}

	public void brake() {
		currentState.brake();
	}
}
