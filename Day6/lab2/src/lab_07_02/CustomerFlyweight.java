package lab_07_02;

import lab_07_01.domain.Address;
import lab_07_01.domain.HealthProfile;
import lab_07_01.domain.Image;

public interface CustomerFlyweight {
	void processCustomer(Image locationMap, String firstName, String lastName, Address residenceAddress,
			HealthProfile profile);

	Image getLocationMap();
}
