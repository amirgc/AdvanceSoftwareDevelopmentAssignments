package lab_08_02;

import java.util.List;

public class TwoClassesModel implements PriceModel {

	@Override
	public double getRevenue(List<Flight> flights) {
		double totalRevenue = 0;
		for (Flight f : flights) {
			totalRevenue += calculateRevenueByFlight(f);
		}
		return totalRevenue;
	}

	private double calculateRevenueByFlight(Flight f) {
		int businessTickets = f.getNumberOfPassenger() / 3;
		int coachTickets = f.getNumberOfPassenger() - businessTickets;

		double businessIncome = BASE_PRICE * 1.5 * businessTickets;
		double coachIncome = BASE_PRICE * .75 * coachTickets;

		return businessIncome + coachIncome - FIXED_COST * 1.1;
	}

}
