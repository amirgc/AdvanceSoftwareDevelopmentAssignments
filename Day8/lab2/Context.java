package StrategyPattern;

import java.util.List;

public class Context {

	
	private Istrategy strategy;
	
	public Context(Istrategy strategy) {
		this.strategy = strategy;
	}
	
	public long totalRevenue(List<Flight> flights) {
		return strategy.getRevenue(flights);
	}
}
