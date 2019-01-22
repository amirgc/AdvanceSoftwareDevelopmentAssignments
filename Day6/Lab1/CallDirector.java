package lab6;

public class CallDirector {
	private CallBuilder callBuilder = null;

	public CallDirector(CallBuilder mb) {
		this.callBuilder = mb;
	}

	public void ConstructRequestObject() {
		callBuilder.createRequestId();

		callBuilder.createCustomer();

		callBuilder.createAgent();

		callBuilder.setRequestContent();

		callBuilder.setResoibseContent();

		callBuilder.setIsAnswered();

		callBuilder.setIsSaleLead();

		callBuilder.setNeedCallBack();
	}
	
	public Request getRequest()
	{
		return callBuilder.getRequest();
	}
}
