/**
 * @author Mikita Belausau, Harpreet Randhawa
 */
package project.two;

public class Student {
    private String name;
    private Major major;
    private int TOTAL_CREDIT_HOURS;
    public static final int UNIVERSITY_FEE_FULL_TIME = 3268;
    public static final double UNIVERSITY_FEE_PART_TIME = 0.80 * UNIVERSITY_FEE_FULL_TIME;
    private double tuitionDue;
    private Profile profile;

    public Student(String name, Major major, int TOTAL_CREDIT_HOURS) {
        this.name = name;
        this.major = major;
        this.TOTAL_CREDIT_HOURS = TOTAL_CREDIT_HOURS;
        this.profile = new Profile(this.name, this.major);
        this.tuitionDue();
    }


    public void tuitionDue() {

    }

    public double getTuitionDue(){
        return this.tuitionDue;
    }
    public void setTuitionDue(double tuitionDue){
        this.tuitionDue = tuitionDue;
    }

    /**
    * Get the hours of the part time student
    *
    * @return TOTAL_CREDIT_HOURS
    * @author Harpreet Randhawa
    */
    public int getTotalCreditHours() {
        return this.TOTAL_CREDIT_HOURS;
    }

    /**
    * Set the hours of the part time student
    
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
    // @Override
    public String toString() {
        return "Will Do later";
    }

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
