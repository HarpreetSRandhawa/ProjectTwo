/**
 * @author Mikita Belausau, Harpreet Randhawa
 */
package project.two;

public class Resident extends Student {
    private static final int RESIDENT_TUITION_FULL_TIME = 12536;
    private int RESIDENT_TUITION_PART_TIME = 404 * getTotalCreditHours();
    private static final int RESIDENT_FINANCIAL_AID = 10000;
    private boolean recievedFinancialAid = false;

    public Resident(String name, Major major, int TOTAL_CREDIT_HOURS) {
        super(name, major, TOTAL_CREDIT_HOURS);
        this.tuitionDue();
    }

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

    public void tuitionPayment(int payment) {
        this.setTuitionDue(this.getTuitionDue() - payment);
    }

    public void setResidentFinancialAid(int financialAid) {
            this.setTuitionDue(this.getTuitionDue() - financialAid);
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
    // @Override
//    public String toString() {
//    	//toString finished, just need the data from last payments
//        
//    	return this.getName() + ":" + this.getMajor() + ":" + this.getTotalCreditHours() + " credit hours:"
//    			+ "tuition due:" + this.getTuitionDue() + ":" + "last payment:" + /* last payment amount */ +
//    			":" + "payment date:" + /* last payment date */ + ":" + "resident"; 		
//    }

}
