package lab_07_03;

/**
 * Refactor the demo class with the Façade pattern to simplify the client code.
 *
 */
public class Client {

	public static void main(String[] args) {
		LoanManagerFacade loanManagerFacade = new LoanManagerFacade();
		loanManagerFacade.process(new LoanApplication());
	}

}
