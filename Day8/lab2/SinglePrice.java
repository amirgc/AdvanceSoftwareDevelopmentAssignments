package StrategyPattern;

import java.util.List;

public class SinglePrice implements Istrategy {
	

	@Override
	public long getRevenue(List<Flight> flights) {
		int totalPassenger = 0;
		for(Flight flight: flights) {
			totalPassenger += flight.getNoOfPassenger();
		}
		System.out.println(totalPassenger);
		
		double gainedFromTicket = totalPassenger * 300;
		System.out.println(gainedFromTicket);
		
		
		return (long) (gainedFromTicket-Istrategy.planeRunningPrice);
	}



}
