package mainClasses;

import java.util.List;

public class AndCriteria implements Criteria{

	private Criteria criteria;
	private Criteria otherCriteria;
	
	public AndCriteria(Criteria criteria, Criteria otherCriteria) {
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}
	
	@Override
	public List<Insurance> meetCriteria(List<Insurance> insurance) {
		List<Insurance> firstCriteriaIns = criteria.meetCriteria(insurance);
		return otherCriteria.meetCriteria(firstCriteriaIns);
	}

}
