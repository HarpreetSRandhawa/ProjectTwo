/**
@author Mikita Belausau, Harpreet Randhawa
*/
package project.two;

public class Profile {
	private String name;
	private Major major; //5 majors and 2-character each; CS, IT, BA, EE, ME

    public Profile(String name, Major major){
        this.name = name;
        this.major = major;
    }
	
    /**
    Determines if two given profiles have the same name and major.
    
    @param obj The profile object being compared.
    @return True if the two profiles have the same name and major. Returns false otherwise.
    @author Harpreet Randhawa
    */
    @Override
    public boolean equals(Object obj) {
        Profile profileObject = Profile.class.cast(obj);
        if (this.name.equals(profileObject.name) && this.major.equals(profileObject.major)) {
            return true;
        } else {
            return false;
        }
    }
	
    /**
    Creates a textual representation of a profile in proper format
    
    @return Returns profile information
    @author Harpreet Randhawa
    */
    @Override
    public String toString() {
    	return this.name + ":" + this.major;
    }
	
}
