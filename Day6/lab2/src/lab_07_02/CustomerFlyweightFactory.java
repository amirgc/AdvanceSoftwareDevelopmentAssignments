package lab_07_02;

import java.util.HashMap;
import java.util.Map;

import lab_07_01.domain.Image;

public class CustomerFlyweightFactory {
	private static Map<String, ConcreteCustomerFlyweight> byCity = new HashMap<>();

	public static CustomerFlyweight getByCity(String city) {
		if (byCity.containsKey(city)) {
			System.out.println("Shared object");
			return byCity.get(city);
		} else {
			Image locationMap = new Image();
			ConcreteCustomerFlyweight concreteCustomerFlyweight = new ConcreteCustomerFlyweight(locationMap);
			byCity.put(city, concreteCustomerFlyweight);
			System.out.println("New object");
			return concreteCustomerFlyweight;
		}
	}

}
