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
        this.setName(name);
        this.setMajor(major);
        this.TOTAL_CREDIT_HOURS = TOTAL_CREDIT_HOURS;
        this.profile = new Profile(this.getName(), this.getMajor());
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
    * Get the student's name.
    
    * @return name
    * @author Harpreet Randhawa
    */
	public String getName() {
		return name;
	}

    /**
    * Setter for the student's name.
    
    * @return this.name
    * @param name Student's name
    * @author Harpreet Randhawa
    */
	public void setName(String name) {
		this.name = name;
	}
	
    /**
    * Get the student's major.
    
    * @return major
    * @author Harpreet Randhawa
    */
	public Major getMajor() {
		return major;
	}

    /**
    * Setter for the student's major.
    
    * @return this.jaor
    * @param major Student's major
    * @author Harpreet Randhawa
    */
	public void setMajor(Major major) {
		this.major = major;
	}

    /**
    * Get the hours of the part time student.
    
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
