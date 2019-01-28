package lab_07_02;

import lab_07_01.domain.Address;
import lab_07_01.domain.HealthProfile;
import lab_07_01.domain.SampleData;

/**
 * Use the Flyweight pattern to reduce the space need of concurrent requests
 * from online customers
 * 
 */
public class Client {

	public static void main(String[] args) {

		for (int i = 0; i < SampleData.ROW_COUNT; i++) {
			CustomerFlyweight c = CustomerFlyweightFactory.getByCity(SampleData.cities[i % 10]);
			c.processCustomer(c.getLocationMap(), SampleData.firstNames[i], SampleData.lastNames[i],
					new Address(SampleData.streets[i], SampleData.cities[i % 10], SampleData.states[i],
							SampleData.zips[i]),
					new HealthProfile());
		}
	}

}
