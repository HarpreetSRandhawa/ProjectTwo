/**
 * @author Mikita Belausau, Harpreet Randhawa
 */
package project.two;

public class NonResident extends Student {
    private static final int NON_RESIDENT_TUITION_FULL_TIME = 29737;
    private int NON_RESIDENT_TUITION_PART_TIME = 966 * getTotalCreditHours();

    public NonResident(String name, Major major, int TOTAL_CREDIT_HOURS) {
        super(name, major, TOTAL_CREDIT_HOURS);
    }


    /**
     Creates a textual representation of a non-resident in proper format

     @return Returns non-resident information
     @author Harpreet Randhawa
     */
    // @Override
    public String toString() {
        return "Will Do later";
    }
}
