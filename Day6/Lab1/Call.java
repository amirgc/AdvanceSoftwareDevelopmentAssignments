package lab6;

import java.util.Date;

public class Call {
	private String requestId;
	private Agent agent;

	public void callPop(Agent agent) {
		this.agent = agent;
		this.requestId = "" + (new Date()).getTime();
		Request req = new Request();
		CallDirector callDirector = new CallDirector(new OpeningRequest());
		req = callDirector.getRequest();
		callDirector = new CallDirector(new ResponseContentRequest());
		req = callDirector.getRequest();
		callDirector = new CallDirector(new ClosingRequest());
		req = callDirector.getRequest();
	}
}
