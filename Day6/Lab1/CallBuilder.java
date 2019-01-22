package lab6;

public interface CallBuilder {
	public void createRequestId();

	public void createCustomer();

	public void createAgent();

	public void setRequestContent();

	public void setResoibseContent();

	public void setIsAnswered();

	public void setIsSaleLead();

	public void setNeedCallBack();
	
	public Request getRequest();

}
