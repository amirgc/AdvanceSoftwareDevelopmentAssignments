package lab_08_02;

import java.util.List;

public class SinglePriceModel implements PriceModel {

	@Override
	public double getRevenue(List<Flight> flights) {
		double totalRevenue = 0;
		for (Flight f : flights) {
			totalRevenue += f.getNumberOfPassenger() * BASE_PRICE - FIXED_COST;
		}
		return totalRevenue;
	}

}
