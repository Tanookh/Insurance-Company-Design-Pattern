package mainClasses;

import java.util.ArrayList;
import java.util.List;

public class CriteriaCar implements Criteria{

	@Override
	public List<Insurance> meetCriteria(List<Insurance> insurances) {
		List<Insurance> CarIns = new ArrayList<Insurance>();
		
		for (Insurance insurance : insurances) {
			if(insurance.getType().equalsIgnoreCase("CAR")) {
				CarIns.add(insurance);
			}
		}
		return CarIns;
	}
}
