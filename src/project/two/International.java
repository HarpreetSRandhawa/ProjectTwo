/**
@author Mikita Belausau, Harpreet Randhawa
*/
package project.two;

public class International extends NonResident {
	public static final int ADDITIONAL_FEE_FULL_TIME = 2650;

    public International(String name, Major major, int TOTAL_CREDIT_HOURS){
        super(name, major, TOTAL_CREDIT_HOURS);
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
