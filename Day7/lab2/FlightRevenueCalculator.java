package lab_08_02;

import java.util.List;

public class FlightRevenueCalculator {
	private PriceModel priceModel;

	public PriceModel getPriceModel() {
		return priceModel;
	}

	public void setPriceModel(PriceModel priceModel) {
		this.priceModel = priceModel;
	}

	public double getRevenue(List<Flight> flights) {
		return priceModel.getRevenue(flights);
	}

}
