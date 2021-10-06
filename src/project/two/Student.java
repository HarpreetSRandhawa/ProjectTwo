/**
 * @author Mikita Belausau, Harpreet Randhawa
 */
package project.two;

/**
 * Student class, calculates tuitions due and creates Student objects.
 * @author Mikita Belausau, Harpreet Randhawa
 */
public class Student {
    private String name;
    private Major major;
    private int TOTAL_CREDIT_HOURS;
    public static final int UNIVERSITY_FEE_FULL_TIME = 3268;
    public static final double UNIVERSITY_FEE_PART_TIME = 0.80 * UNIVERSITY_FEE_FULL_TIME;
    private double tuitionDue;
    private Profile profile;
    private Date lastPaymentDate = null;
    private double lastPayment = 0.00;
    private boolean wasCalculated = false;
    public static final int MINIMUM_CREDIT_FOR_FULL_TIME = 12;
    public static final int MAXIMUM_CREDIT_FOR_FULL_TIME_WITH_NO_ADDITIONAL_FEES = 16;

    /**
     * Student constructor
     *
     * @param name
     * @param major
     * @param TOTAL_CREDIT_HOURS
     * @author Mikita Belausau
     */
    public Student(String name, Major major, int TOTAL_CREDIT_HOURS) {
        this.setName(name);
        this.setMajor(major);
        this.TOTAL_CREDIT_HOURS = TOTAL_CREDIT_HOURS;
        this.profile = new Profile(this.getName(), this.getMajor());
    }

    /**
     * calculates tuitionDue for students
     *
     * @author Harpreet Randhawa
     */
    public void tuitionDue() {

    }

    /**
     * returns if the tuition was already calculated for a student or not
     *
     * @return true if the tuition has been calculated, false if not.
     * @author Mikita Belausau
     */
    public boolean wasCalculated() {
        return this.wasCalculated;
    }

    /**
     * Set a boolean value to be true or false depending on if the students tuition was calculated.
     *
     * @param wasCalculated
     * @author Mikita Belausau
     */
    public void setWasCalculated(boolean wasCalculated) {
        this.wasCalculated = wasCalculated;
    }

    /**
     * Getter for student's last payment.
     *
     * @return The last payment.
     * @author Harpreet Randhawa
     */
    public double getLastPayment() {
        return this.lastPayment;
    }

    /**
     * Getter for student's last payment date.
     *
     * @return The last payment date.
     * @author Harpreet Randhawa
     */
    public Date getLastPaymentDate() {
        return this.lastPaymentDate;
    }

    /**
     * Getter for student's tuition due.
     *
     * @return The tuition due.
     * @author Harpreet Randhawa
     */
    public double getTuitionDue() {
        return this.tuitionDue;
    }

    /**
     * Setter for student's tuition due.
     *
     * @param tuitionDue Student's tuition due.
     * @return The tuition due.
     * @author Mikita Belausau
     */
    public void setTuitionDue(double tuitionDue) {
        this.tuitionDue = tuitionDue;
    }

    /**
     * Setter for student's last payment date.
     *
     * @param lastPaymentDate Student's last payment date.
     * @return The last payment date.
     * @author Mikita Belausau
     */
    public void setLastPaymentDate(Date lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    /**
     * Setter for student's total payment amount
     *
     * @param payment Student's payment.
     * @return The student's total payment amount.
     * @author Mikita Belausau
     */
    public void setLastPayment(double payment) {
        this.lastPayment += payment;
    }

    /**
     * Get the student's name.
     *
     * @return The student's name.
     * @author Harpreet Randhawa
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the student's name.
     *
     * @param name Student's name
     * @return this.name
     * @author Harpreet Randhawa
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the student's major.
     *
     * @return major
     * @author Harpreet Randhawa
     */
    public Major getMajor() {
        return major;
    }

    /**
     * Setter for the student's major.
     *
     * @param major Student's major
     * @return this.jaor
     * @author Harpreet Randhawa
     */
    public void setMajor(Major major) {
        this.major = major;
    }

    /**
     * Get the hours of the part time student.
     *
     * @return TOTAL_CREDIT_HOURS
     * @author Harpreet Randhawa
     */
    public int getTotalCreditHours() {
        return this.TOTAL_CREDIT_HOURS;
    }

    /**
     * Set the hours of the part time student
     *
     * @param partTimeHours
     * @return partTimeHours
     * @author Harpreet Randhawa
     */
    public void setTotalCreditHours(int partTimeHours) {
        this.TOTAL_CREDIT_HOURS = partTimeHours;
    }

    /**
     * Creates a textual representation of a student in proper format
     *
     * @return Returns student information
     * @author Harpreet Randhawa
     */
    @Override
    public String toString() {
        if (this.getLastPaymentDate() == null) {
            return this.getName() + ":" + this.getMajor() + ":" + this.getTotalCreditHours() + " credit hours:"
                    + "tuition due:" + this.getTuitionDue() + ":" + "last payment:" + this.getLastPayment() +
                    ":" + "payment date:" + " --/--/--";
        } else {
            return this.getName() + ":" + this.getMajor() + ":" + this.getTotalCreditHours() + " credit hours:"
                    + "tuition due:" + this.getTuitionDue() + ":" + "last payment:" + this.getLastPayment() +
                    ":" + "payment date:" + this.getLastPaymentDate();
        }
    }

    /**
     * Checks to see if two students are equal based on their profiles.
     * @param obj
     * @return true if the students have the same name and major, false if not
     * @author Mikita Belausau
     */
    @Override
    public boolean equals(Object obj) {
        Student profileObject = Student.class.cast(obj);
        if (this.profile.equals(profileObject.profile)) {
            return true;
        } else {
            return false;
        }
    }


}
