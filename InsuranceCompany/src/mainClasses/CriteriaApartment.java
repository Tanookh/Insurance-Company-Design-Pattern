package mainClasses;

import java.util.ArrayList;
import java.util.List;

public class CriteriaApartment implements Criteria{

	@Override
	public List<Insurance> meetCriteria(List<Insurance> insurances) {
		List<Insurance> ApartmentIns = new ArrayList<Insurance>();
		
		for (Insurance insurance : insurances) {
			if(insurance.getType().equalsIgnoreCase("APARTMENT")) {
				ApartmentIns.add(insurance);
			}
		}
		return ApartmentIns;
	}
}
