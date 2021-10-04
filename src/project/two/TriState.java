/**
@author Mikita Belausau, Harpreet Randhawa
*/
package project.two;

public class TriState extends NonResident {
    private static final String NY = "NY";
    private static final String CT = "CT";
	private static final int NYC_DISCOUNT = 4000;
	private static final int CT_DISCOUNT = 5000;
    private int TRI_STATE_TUITION_FULL_TIME = 29737;
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
//        else if ((this.getTotalCreditHours() < 12) && (this.triState.equals(NY))) {
//            this.setTuitionDue((TRI_STATE_TUITION_PART_TIME + UNIVERSITY_FEE_PART_TIME));
//        }
//        else if ((this.getTotalCreditHours() < 12) && (this.triState.equals(CT))) {
//            this.setTuitionDue((TRI_STATE_TUITION_PART_TIME + UNIVERSITY_FEE_PART_TIME));
//        }
        else if (((this.getTotalCreditHours() >= 12)) && (this.getTotalCreditHours() <= 24) && (this.triState.equals(NY))) {
            this.setTuitionDue((TRI_STATE_TUITION_FULL_TIME + UNIVERSITY_FEE_FULL_TIME) - NYC_DISCOUNT);
        }
        else if (((this.getTotalCreditHours() >= 12)) && (this.getTotalCreditHours() <= 24) && (this.triState.equals(CT))) {
            this.setTuitionDue((TRI_STATE_TUITION_FULL_TIME + UNIVERSITY_FEE_FULL_TIME) - CT_DISCOUNT);
        }
        else {
        	if ((this.triState.equals(NY)) && (this.getTotalCreditHours() < 12) && (this.getTotalCreditHours() >= 3)) {
        		this.setTuitionDue((TRI_STATE_TUITION_PART_TIME * this.getTotalCreditHours()) + (UNIVERSITY_FEE_PART_TIME));
        	}
        	else if (this.triState.equals(CT) && (this.getTotalCreditHours() < 12) && (this.getTotalCreditHours() >= 3)) {
        		this.setTuitionDue((TRI_STATE_TUITION_PART_TIME * this.getTotalCreditHours()) + (UNIVERSITY_FEE_PART_TIME));
        	}
        }

    }

    
    /**
    Creates a textual representation of tri-state in proper format
    
    @return Returns tri-state information
    @author Harpreet Randhawa
    */
    @Override
    public String toString() {
    	//toString finished, just need the data from last payments
        if((this.triState.equals(NY)) && (this.getLastPaymentDate() == null)) {
        	return this.getName() + ":" + this.getMajor() + ":" + this.getTotalCreditHours() + " credit hours:"
        			+ "tuition due:" + this.getTuitionDue() + ":" + "last payment:" + this.getLastPayment() +
        			":" + "payment date:" + " --/--/--" + ":" + "non-resident(tri-state)" + 
        			":" + "NY";
        }
        else if((this.triState.equals(CT)) && (this.getLastPaymentDate() == null)) {
        	return this.getName() + ":" + this.getMajor() + ":" + this.getTotalCreditHours() + " credit hours:"
        			+ "tuition due:" + this.getTuitionDue() + ":" + "last payment:" + this.getLastPayment() +
        			":" + "payment date:" + " --/--/--" + ":" + "non-resident(tri-state)" + 
        			":" + "CT";
        }
        else if((this.triState.equals(NY)) && (this.getLastPaymentDate() != null)) {
        	return this.getName() + ":" + this.getMajor() + ":" + this.getTotalCreditHours() + " credit hours:"
        			+ "tuition due:" + this.getTuitionDue() + ":" + "last payment:" + this.getLastPayment() +
        			":" + "payment date:" + this.getLastPaymentDate() + ":" + "non-resident(tri-state)" + 
        			":" + "NY";
        }
        else if((this.triState.equals(CT)) && (this.getLastPaymentDate() != null)) {
        	return this.getName() + ":" + this.getMajor() + ":" + this.getTotalCreditHours() + " credit hours:"
        			+ "tuition due:" + this.getTuitionDue() + ":" + "last payment:" + this.getLastPayment() +
        			":" + "payment date:" + this.getLastPaymentDate() + ":" + "non-resident(tri-state)" + 
        			":" + "CT";
        }
        return "";
    }
    
}
