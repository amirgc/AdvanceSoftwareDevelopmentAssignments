package lab_07_03;

public class LoanManagerFacade {
	public void process(LoanApplication application) {
		System.out.println("LoanManagerFacade.process");
		ILoanApplicationVerifier loanApplicationVerifier = new LoanApplicationVerifier();
		boolean isEligible = loanApplicationVerifier.isEligible(application);
		if (isEligible) {
			NotificationService notificationService = new NotificationService();
			notificationService.notify(application);
		}
	}
}
