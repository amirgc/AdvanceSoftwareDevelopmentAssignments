package StrategyPattern;

import java.util.List;

public class MultiClass implements Istrategy {

	@Override
	public long getRevenue(List<Flight> flights) {
		int totalPassenger = 0;
		for(Flight flight: flights) {
			totalPassenger += flight.getNoOfPassenger();
		}
		
		return (long) (((totalPassenger/10)*4*Istrategy.ticketPrice)+((totalPassenger/5)*1.5*Istrategy.ticketPrice)+((totalPassenger*7/10)*0.75*Istrategy.ticketPrice)-(1.2*Istrategy.planeRunningPrice));
	
	}



}
