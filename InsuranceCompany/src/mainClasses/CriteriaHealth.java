package mainClasses;

import java.util.ArrayList;
import java.util.List;

public class CriteriaHealth implements Criteria{

	@Override
	public List<Insurance> meetCriteria(List<Insurance> insurances) {
		List<Insurance> HealthIns = new ArrayList<Insurance>();
		
		for (Insurance insurance : insurances) {
			if(insurance.getType().equalsIgnoreCase("HEALTH")) {
				HealthIns.add(insurance);
			}
		}
		return HealthIns;
	}
}