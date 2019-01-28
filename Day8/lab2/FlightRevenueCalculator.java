package StrategyPattern;

import java.util.ArrayList;
import java.util.List;

public class FlightRevenueCalculator {
	
	public static void main(String args[]) {
		Flight flight1 = new Flight();
		Flight flight2 = new Flight();
		Flight flight3 = new Flight();
		
		flight1.setNoOfPassenger(10);
		flight2.setNoOfPassenger(15);
		flight3.setNoOfPassenger(11);

		List<Flight> flights = new ArrayList<>();
		flights.add(flight1);
		flights.add(flight2);
		flights.add(flight3);
		
		Context context = new Context(new SinglePrice());
		System.out.println("Single Price: "+context.totalRevenue(flights));
		Context context2 = new Context(new TwoClasses());
		System.out.println("Two Classes Price: "+context.totalRevenue(flights));
		Context context3 = new Context(new MultiClass());

		System.out.println("Multi Class Price: "+context.totalRevenue(flights));

	}
	
}
