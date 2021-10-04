/**
@author Mikita Belausau, Harpreet Randhawa
*/
package project.two;

public class TriState extends NonResident {
    private static final String NY = "NY";
    private static final String CT = "CT";
	private static final int NYC_DISCOUNT = 4000;
	private static final int CT_DISCOUNT = 5000;
    private int TRI_STATE_TUITION_PART_TIME = 966 * getTotalCreditHours();
    private String triState;

    /**
    * Allows for proper calculation of tutionDue for an Tri-state student
    
    * @param name
    * @param major
    * @param TOTAL_CREDIT_HOURS
    * @return the tuition due for a Tri-state student
    * @author Mikita Belausau
    */
    public TriState(String name, Major major, int TOTAL_CREDIT_HOURS, String triState){
        super(name, major, TOTAL_CREDIT_HOURS);
        this.triState = triState;
        this.tuitionDue();
    }

    /**
    Calculates the tuition due for a tri-state student
    
    @return Tri-state student tuition due
    @author Harpreet Randhawa
    */
    @Override
    public void tuitionDue() {
        if(this.triState == null){
            ;
        }
        else if ((this.getTotalCreditHours() < 12) && (this.triState.equals("NY"))) {
            this.setTuitionDue((TRI_STATE_TUITION_PART_TIME + UNIVERSITY_FEE_PART_TIME) - NYC_DISCOUNT);
        }
        else if ((this.getTotalCreditHours() < 12) && (this.triState.equals("CT"))) {
            this.setTuitionDue((TRI_STATE_TUITION_PART_TIME + UNIVERSITY_FEE_PART_TIME - CT_DISCOUNT));
        }
        else if (((!(this.getTotalCreditHours() > 16))) && (this.triState.equals("NY"))) {
            this.setTuitionDue((TRI_STATE_TUITION_PART_TIME + UNIVERSITY_FEE_FULL_TIME - NYC_DISCOUNT));
        }
        else if (((!(this.getTotalCreditHours() > 16))) && (this.triState.equals("CT"))) {
            this.setTuitionDue((TRI_STATE_TUITION_PART_TIME + UNIVERSITY_FEE_FULL_TIME - CT_DISCOUNT));
        }
        else {
        	if (this.triState.equals("NY")) {
                this.setTuitionDue((TRI_STATE_TUITION_PART_TIME + ((this.getTotalCreditHours() - 16) * 404)
                        + UNIVERSITY_FEE_FULL_TIME - NYC_DISCOUNT));
        	}
        	else if (this.triState.equals("CT")) {
                this.setTuitionDue((TRI_STATE_TUITION_PART_TIME + ((this.getTotalCreditHours() - 16) * 404)
                        + UNIVERSITY_FEE_FULL_TIME - CT_DISCOUNT));
        	}
        }
    }

    
    /**
    Creates a textual representation of tri-state in proper format
    
    @return Returns tri-state information
    @author Harpreet Randhawa
    */
    // @Override
//    public String toString() {
//    	//toString finished, just need the data from last payments
//        if(this.triState == NY) {
//        	return this.getName() + ":" + this.getMajor() + ":" + this.getTotalCreditHours() + " credit hours:"
//        			+ "tuition due:" + this.getTuitionDue() + ":" + "last payment:" + /* last payment amount */ +
//        			":" + "payment date:" + /* last payment date */ + ":" + "non-resident(tri-state):" + 
//        			":" + "NY";
//        }
//        else if(this.triState == CT) {
//        	return this.getName() + ":" + this.getMajor() + ":" + this.getTotalCreditHours() + " credit hours:"
//        			+ "tuition due:" + this.getTuitionDue() + ":" + "last payment:" + /* last payment amount */ +
//        			":" + "payment date:" + /* last payment date */ + ":" + "non-resident(tri-state):" + 
//        			":" + "CT";
//        }
//
//    }
    
}
