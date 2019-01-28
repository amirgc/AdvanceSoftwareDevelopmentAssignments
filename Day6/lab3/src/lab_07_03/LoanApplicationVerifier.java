package lab_07_03;

public class LoanApplicationVerifier implements ILoanApplicationVerifier {

	@Override
	public boolean isEligible(LoanApplication application) {
		System.out.println("LoanApplicationVerifier.isEligible");
		boolean personalDetailsAreValid = new PersonalDetailVerifier().verifyDetails(application);
		boolean professionalDetailsAreValid = new ProfessionalDetailVerifier().verifyDetails(application);
		boolean creditHistoryVerified = new CreditHistoryVerifier().verify(application);
		boolean isPreferredDeveloper = new DeveloperVerifier().isPreferredDeveloper(application.getDeveloperName());
		boolean isProjectApproved = isPreferredDeveloper ? true
				: new ProjectVerifier().isBlackListedProject(application.getProjectName());
		boolean isEligible = personalDetailsAreValid && professionalDetailsAreValid && creditHistoryVerified
				&& isProjectApproved;
		return isEligible;
	}

}
