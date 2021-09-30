/**
@author Mikita Belausau, Harpreet Randhawa
*/
package project.two;

public class TriState extends NonResident {
    private static final String NY = "NY";
    private static final String CT = "CT";
	private static final int NYC_DISCOUNT = 4000;
	private static final int CT_DISCOUNT = 5000;
    private String triState;

    public TriState(String name, Major major, int TOTAL_CREDIT_HOURS, String triState){
        super(name, major, TOTAL_CREDIT_HOURS);
        this.triState = triState;
      //  this.tuitionDue();
    }


    /**
    Creates a textual representation of tri-state in proper format
    
    @return Returns tri-state information
    @author Harpreet Randhawa
    */
    // @Override
    public String toString() {
    	return "Will Do later";
    }
    
}
