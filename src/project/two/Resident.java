/**
 * @author Mikita Belausau, Harpreet Randhawa
 */
package project.two;

public class Resident extends Student {
    private static final int RESIDENT_TUITION_FULL_TIME = 12536;
    private int RESIDENT_TUITION_PART_TIME = 404 * getTotalCreditHours();
    private boolean recievedFinancialAid = false;

    public Resident(String name, Major major, int TOTAL_CREDIT_HOURS) {
        super(name, major, TOTAL_CREDIT_HOURS);
    }

    @Override
    public void tuitionDue() {
        if (this.getTotalCreditHours() < 12) {
            this.setTuitionDue((RESIDENT_TUITION_PART_TIME + UNIVERSITY_FEE_PART_TIME));
            this.setWasCalculated(true);
        } else if ((!(this.getTotalCreditHours() > 16))) {
            this.setTuitionDue((RESIDENT_TUITION_FULL_TIME + UNIVERSITY_FEE_FULL_TIME));
            this.setWasCalculated(true);
        } else {
            this.setTuitionDue((RESIDENT_TUITION_FULL_TIME + ((this.getTotalCreditHours() - 16) * 404)
                    + UNIVERSITY_FEE_FULL_TIME));
            this.setWasCalculated(true);
        }
    }


    public void setResidentFinancialAid(double financialAid) {
            this.setTuitionDue((this.getTuitionDue() - financialAid));
    }

    public void setFinancialAidRecieved(boolean financialAid){
        this.recievedFinancialAid = financialAid;
    }

    public boolean financialAid(){
        return this.recievedFinancialAid;
    }

    /**
     * Creates a textual representation of a resident in proper format
     *
     * @return Returns resident information
     * @author Harpreet Randhawa
     */
     @Override
    public String toString() {        
    	if(this.getLastPaymentDate() == null) {
    		return this.getName() + ":" + this.getMajor() + ":" + this.getTotalCreditHours() + " credit hours:"
    				+ "tuition due:" + this.getTuitionDue() + ":" + "last payment:" + this.getLastPayment() +
    				":" + "payment date:" + " --/--/--" + ":" + "resident"; 	
    	 }
    	else {
        	return this.getName() + ":" + this.getMajor() + ":" + this.getTotalCreditHours() + " credit hours:"
        			+ "tuition due:" + this.getTuitionDue() + ":" + "last payment:" + this.getLastPayment() +
        			":" + "payment date:" + this.getLastPaymentDate().toString() + ":" + "resident";
    	}	
    }

}
