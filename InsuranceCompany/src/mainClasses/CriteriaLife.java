package mainClasses;

import java.util.ArrayList;
import java.util.List;

public class CriteriaLife implements Criteria{

	@Override
	public List<Insurance> meetCriteria(List<Insurance> insurances) {
		List<Insurance> LifeIns = new ArrayList<Insurance>();
		
		for (Insurance insurance : insurances) {
			if(insurance.getType().equalsIgnoreCase("LIFE")) {
				LifeIns.add(insurance);
			}
		}
		return LifeIns;
	}
}