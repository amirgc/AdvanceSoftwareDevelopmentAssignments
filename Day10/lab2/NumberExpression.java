package lab_11_02;

public class NumberExpression extends Expression {
	private int number;

	public NumberExpression(int number) {
		this.number = number;
	}

	@Override
	public int interpret() {
		return number;
	}

	@Override
	public String toString() {
		return number + "";
	}
}
