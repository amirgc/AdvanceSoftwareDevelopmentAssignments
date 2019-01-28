package lab_11_02;

public class SubtractExpression extends Expression {

	private Expression leftExpression;
	private Expression rightExpression;

	public SubtractExpression(Expression left, Expression right) {
		leftExpression = left;
		rightExpression = right;
	}

	@Override
	public int interpret() {
		return leftExpression.interpret() - rightExpression.interpret();
	}

}
