/**
 * @author Mikita Belausau, Harpreet Randhawa
 */
package project.two;

public class NonResident extends Student {
    private static final int NON_RESIDENT_TUITION_FULL_TIME = 29737;
    private int NON_RESIDENT_TUITION_PART_TIME = 966 * getTotalCreditHours();

    public NonResident(String name, Major major, int TOTAL_CREDIT_HOURS) {
        super(name, major, TOTAL_CREDIT_HOURS);
        this.tuitionDue();
    }

    @Override
    public void tuitionDue() {
        if (this.getTotalCreditHours() < 12) {
            this.setTuitionDue(NON_RESIDENT_TUITION_PART_TIME + UNIVERSITY_FEE_PART_TIME);
        } else if ((!(this.getTotalCreditHours() > 16))) {
            this.setTuitionDue(NON_RESIDENT_TUITION_FULL_TIME + UNIVERSITY_FEE_FULL_TIME);
        } else {
            this.setTuitionDue(NON_RESIDENT_TUITION_FULL_TIME + ((this.getTotalCreditHours() - 16) * 404)
                    + UNIVERSITY_FEE_FULL_TIME);
        }
    }

    private void tuitionPayment(int payment) {
        this.setTuitionDue(this.getTuitionDue() - payment);
    }


    /**
     * Creates a textual representation of a non-resident in proper format
     *
     * @return Returns non-resident information
     * @author Harpreet Randhawa
     */
    // @Override
    public String toString() {
        return "Will Do later";
    }
}
