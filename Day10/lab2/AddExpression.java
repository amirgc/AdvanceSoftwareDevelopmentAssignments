package lab_11_02;

public class AddExpression extends Expression {

	private Expression leftExpression;
	private Expression rightExpression;

	public AddExpression(Expression left, Expression right) {
		leftExpression = left;
		rightExpression = right;
	}

	@Override
	public int interpret() {
		return leftExpression.interpret() + rightExpression.interpret();
	}

	public Expression getLeftExpression() {
		return leftExpression;
	}

	public void setLeftExpression(Expression leftExpression) {
		this.leftExpression = leftExpression;
	}

	public Expression getRightExpression() {
		return rightExpression;
	}

	public void setRightExpression(Expression rightExpression) {
		this.rightExpression = rightExpression;
	}

}
