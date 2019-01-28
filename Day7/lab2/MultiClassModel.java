package lab_08_02;

import java.util.List;

public class MultiClassModel implements PriceModel {

	@Override
	public double getRevenue(List<Flight> flights) {
		double totalRevenue = 0;
		for (Flight f : flights) {
			totalRevenue += calculateRevenueByFlight(f);
		}
		return totalRevenue;
	}

	private double calculateRevenueByFlight(Flight f) {
		int firstClassTickets = f.getNumberOfPassenger() / 10;
		int businessClassTickets = f.getNumberOfPassenger() / 5;
		int remainTickets = f.getNumberOfPassenger() - (firstClassTickets + businessClassTickets);

		double firstClassIncome = BASE_PRICE * 4 * firstClassTickets;
		double businessClassIncome = BASE_PRICE * 1.5 * businessClassTickets;
		double remainIncome = BASE_PRICE * .75 * remainTickets;

		return firstClassIncome + businessClassIncome + remainIncome - FIXED_COST * 1.2;
	}
}
