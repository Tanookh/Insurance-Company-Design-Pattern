package mainClasses;

import java.util.List;

public class OrCriteria implements Criteria {

   private Criteria criteria;
   private Criteria otherCriteria;

   public OrCriteria(Criteria criteria, Criteria otherCriteria) {
      this.criteria = criteria;
      this.otherCriteria = otherCriteria; 
   }

   @Override
   public List<Insurance> meetCriteria(List<Insurance> insurance) {
      List<Insurance> firstCriteriaItems = criteria.meetCriteria(insurance);
      List<Insurance> otherCriteriaItems = otherCriteria.meetCriteria(insurance);

      for (Insurance insurances : otherCriteriaItems) {
         if(!firstCriteriaItems.contains(insurances)){
            firstCriteriaItems.add(insurances);
         }
      }	
      return firstCriteriaItems;
   }
}