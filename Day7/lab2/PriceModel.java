package lab_08_02;

import java.util.List;

public interface PriceModel {
	public static final double BASE_PRICE = 300;
	public static final double BUSINESS_PRICE = 800;
	public static final double FIXED_COST = 50000;

	public double getRevenue(List<Flight> flights);
}
