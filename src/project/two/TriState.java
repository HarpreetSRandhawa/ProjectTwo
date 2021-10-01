/**
@author Mikita Belausau, Harpreet Randhawa
*/
package project.two;

public class TriState extends NonResident {
    private static final String NY = "NY";
    private static final String CT = "CT";
	private static final int NYC_DISCOUNT = 4000;
	private static final int CT_DISCOUNT = 5000;
    private String triState;


    public TriState(String name, Major major, int TOTAL_CREDIT_HOURS, String triState){
        super(name, major, TOTAL_CREDIT_HOURS);
        this.triState = triState;
      //  this.tuitionDue();
    }

    /**
    Calculates the tuition due for a tri-state student
    
    @return Tri-state student tuition due
    @author Harpreet Randhawa
    */
    @Override
    public void tuitionDue() {
        if (this.getTotalCreditHours() < 12) {
            this.setTuitionDue(RESIDENT_TUITION_PART_TIME + UNIVERSITY_FEE_PART_TIME);
        } else if ((!(this.getTotalCreditHours() > 16))) {
            this.setTuitionDue(RESIDENT_TUITION_FULL_TIME + UNIVERSITY_FEE_FULL_TIME);
        } else {
            this.setTuitionDue(RESIDENT_TUITION_FULL_TIME + ((this.getTotalCreditHours() - 16) * 404)
                    + UNIVERSITY_FEE_FULL_TIME);
        }
    }

    
    /**
    Creates a textual representation of tri-state in proper format
    
    @return Returns tri-state information
    @author Harpreet Randhawa
    */
    // @Override
    public String toString() {
    	return "Will Do later";
    }
    
}
