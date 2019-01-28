package StrategyPattern;

import java.util.List;

public class TwoClasses implements Istrategy {

	@Override
	public long getRevenue(List<Flight> flights) {
		int totalPassenger = 0;
		for(Flight flight: flights) {
			totalPassenger += flight.getNoOfPassenger();
		}
		
		return (long) ((((totalPassenger/3)*1.5*Istrategy.ticketPrice)+((totalPassenger*2/3)*0.75*Istrategy.ticketPrice))-1.1 * Istrategy.planeRunningPrice);
	}



}
