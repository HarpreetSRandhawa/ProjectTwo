/**
 * @author Mikita Belausau, Harpreet Randhawa
 */
package project.two;

import java.text.DecimalFormat;

/**
 * Resident Student class, calculates tuitions due and creates Resident student objects.
 *
 * @author Mikita Belausau, Harpreet Randhawa
 */
public class Resident extends Student {
    private static final int RESIDENT_TUITION_FULL_TIME = 12536;
    private int RESIDENT_TUITION_PART_TIME = 404 * getTotalCreditHours();
    private boolean recievedFinancialAid = false;
    private double recievedFinancialAidAmount = 0;

    /**
     * Resident student constructor
     *
     * @param name
     * @param major
     * @param TOTAL_CREDIT_HOURS
     * @author Mikita Belausau
     */
    public Resident(String name, Major major, int TOTAL_CREDIT_HOURS) {
        super(name, major, TOTAL_CREDIT_HOURS);
    }

    /**
     * Calculates tuitionDue for resident students
     *
     * @author Mikita Belausau
     */
    @Override
    public void tuitionDue() {
        if (this.getTotalCreditHours() < MINIMUM_CREDIT_FOR_FULL_TIME) {
            this.setTuitionDue((RESIDENT_TUITION_PART_TIME + UNIVERSITY_FEE_PART_TIME));
            this.setWasCalculated(true);
        } else if ((!(this.getTotalCreditHours() > MAXIMUM_CREDIT_FOR_FULL_TIME_WITH_NO_ADDITIONAL_FEES))) {
            this.setTuitionDue((RESIDENT_TUITION_FULL_TIME + UNIVERSITY_FEE_FULL_TIME));
            this.setWasCalculated(true);
        } else {
            this.setTuitionDue((RESIDENT_TUITION_FULL_TIME +
                    ((this.getTotalCreditHours() - MAXIMUM_CREDIT_FOR_FULL_TIME_WITH_NO_ADDITIONAL_FEES) * 404)
                    + UNIVERSITY_FEE_FULL_TIME));
            this.setWasCalculated(true);
        }
    }

    /**
     * Set the amount of financial aid recieved for the student
     * @param financialAid
     * @author Mikita Belausau
     */
    public void setRecievedFinancialAidAmount(double financialAid){
        this.recievedFinancialAidAmount = financialAid;
    }


    /**
     * Applies financial aid to a resident student
     *
     * @param financialAid
     * @author Mikita Belausau
     */
    public void setResidentFinancialAid(double financialAid) {
        this.setTuitionDue((this.getTuitionDue() - financialAid));
    }

    /**
     * Let the program know if a student has recieved financial aid already.
     *
     * @param financialAid
     * @author Mikita Belausau
     */
    public void setFinancialAidRecieved(boolean financialAid) {
        this.recievedFinancialAid = financialAid;
    }

    /**
     * Returns a boolean true or false of if the student has recieved financial aid or not.
     *
     * @return true if the student has received financial aid false if not.
     * @author Mikita Belausau
     */
    public boolean financialAid() {
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
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        
        if (this.getLastPaymentDate() == null) {
            return this.getName() + ":" + this.getMajor() + ":" + this.getTotalCreditHours() + " credit hours:"
                    + "tuition due:" + decimalFormat.format(this.getTuitionDue()) + ":" + "total payment:" + 
                    decimalFormat.format(this.getLastPayment()) +
                    ":" + "last payment date:" + " --/--/--" + ":" + "resident";
        } else {
            return this.getName() + ":" + this.getMajor() + ":" + this.getTotalCreditHours() + " credit hours:"
                    + "tuition due:" + decimalFormat.format(this.getTuitionDue()) + ":" + "total payment:" + 
                    decimalFormat.format(this.getLastPayment()) +
                    ":" + "last payment date: " + this.getLastPaymentDate().toString() + ":" + "resident";
        }
    }

}
