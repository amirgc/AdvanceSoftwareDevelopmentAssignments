package lab_11_02;

import java.util.List;

public class Parser {

	public Expression parse(List<String> tokenList) {
		return next(tokenList);
	}

	private Expression next(List<String> tokenList) {
		int number;
		if (isInteger(tokenList.get(0))) {
			number = Integer.parseInt(tokenList.get(0));
			tokenList.remove(0);
			return new NumberExpression(number);
		} else {
			return parseNonTerminal(tokenList);
		}
	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}

	private Expression parseNonTerminal(List<String> tokenList) {
		String token = tokenList.get(0);
		tokenList.remove(0);
		Expression left = next(tokenList);
		Expression right = next(tokenList);
		if (token.equals("+")) {
			return new AddExpression(left, right);
		} else if (token.equals("-")) {
			return new SubtractExpression(left, right);
		}
		return null;
	}
}
