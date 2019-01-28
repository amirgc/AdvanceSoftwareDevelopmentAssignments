package StrategyPattern;

import java.util.List;

public interface Istrategy {

	public int ticketPrice = 300;
	public int planeRunningPrice = 50000;
	
	public long getRevenue(List<Flight> flights);
	
}
