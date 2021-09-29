/**
 * @author Mikita Belausau, Harpreet Randhawa
 */
package project.two;

//Git Test

public class Resident extends Student {
    private static final int RESIDENT_TUITION_FULL_TIME = 12536;
    private int RESIDENT_TUITION_PART_TIME = 404 * getTotalCreditHours();
    private static final int RESIDENT_FINANCIAL_AID = 10000;

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

    /**
     * Creates a textual representation of a resident in proper format
     *
     * @return Returns resident information
     * @author Harpreet Randhawa
     */
    // @Override
    public String toString() {
        return "Will Do later";
    }

}
