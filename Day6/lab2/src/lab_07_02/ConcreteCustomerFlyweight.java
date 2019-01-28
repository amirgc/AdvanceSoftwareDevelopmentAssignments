package lab_07_02;

import lab_07_01.domain.Address;
import lab_07_01.domain.HealthProfile;
import lab_07_01.domain.Image;

public class ConcreteCustomerFlyweight implements CustomerFlyweight {

	private Image locationMap;

	public ConcreteCustomerFlyweight(Image locationMap) {
		this.locationMap = locationMap;
	}

	@Override
	public void processCustomer(Image locationMap, String firstName, String lastName, Address residenceAddress,
			HealthProfile profile) {
		System.out.println(
				"processCustomer: " + firstName + " " + lastName + ", " + residenceAddress + ", " + locationMap);
	}

	@Override
	public Image getLocationMap() {
		return locationMap;
	}

}
