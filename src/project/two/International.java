/**
@author Mikita Belausau, Harpreet Randhawa
*/
package project.two;

public class International extends NonResident {
    private static final int INTERNATIONAL_TUITION_FULL_TIME = 29737;
	private static final int ADDITIONAL_FEE_FULL_TIME = 2650;
	private static final int INTERNATIONAL_ADDITIONAL_FEE = 2650;
    private boolean studyAbroad;

    public International(String name, Major major, int TOTAL_CREDIT_HOURS, boolean studyAbroad){
        super(name, major, TOTAL_CREDIT_HOURS);
        this.studyAbroad = studyAbroad;
        tuitionDue();
    }

    public boolean getStudyAbroadStatus(){
        return this.studyAbroad;
    }

    public void setStudyAbroadStatus(boolean studyAbroad){
        this.studyAbroad = studyAbroad;
    }
	
    /**
    Calculates the tuition due for an International student
    
    @return International student tuition due
    @author Harpreet Randhawa
    */
    @Override
    public void tuitionDue() {
        if ((this.getTotalCreditHours() >= 12) && (this.studyAbroad == false)) {
            this.setTuitionDue(INTERNATIONAL_TUITION_FULL_TIME + UNIVERSITY_FEE_FULL_TIME + INTERNATIONAL_ADDITIONAL_FEE);
        }
        else if ((this.getTotalCreditHours() >= 12) && (this.studyAbroad == true)) {
            this.setTuitionDue(UNIVERSITY_FEE_FULL_TIME + INTERNATIONAL_ADDITIONAL_FEE);
        }
    }
    
    /**
    Creates a textual representation of an international student in proper format
    
    @return Returns international student information
    @author Harpreet Randhawa
    */
    // @Override
    public String toString() {
    	return "Will Do later";
    }

}
