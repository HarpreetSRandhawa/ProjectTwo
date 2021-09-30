/**
@author Mikita Belausau, Harpreet Randhawa
*/
package project.two;

public class International extends NonResident {
	private static final int ADDITIONAL_FEE_FULL_TIME = 2650;
    private boolean studyAbroad;

    public International(String name, Major major, int TOTAL_CREDIT_HOURS, boolean studyAbroad){
        super(name, major, TOTAL_CREDIT_HOURS);
        this.studyAbroad = studyAbroad;
    }

    private boolean getStudyAbroadStatus(){
        return this.studyAbroad;
    }

    private void setStudyAbroadStatus(boolean studyAbroad){
        this.studyAbroad = studyAbroad;
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
