/**
 * @author Mikita Belausau, Harpreet Randhawa
 */
package project.two;

public class Roster {
    private Student[] roster;
    private int size; //keep track of the number of students in the roster

    private static final int GROWTH_FACTOR = 4;
    private static final int NOT_FOUND = -1;
    
    public Roster() {
        this.setRoster(new Student[4]);
        this.size = 0;
    }
    
    /**
    Returns the size of the roster.
	
    @return size Roster size.
    @author Harpreet Randhawa
    */
    public int getSize() {
        return size;
    }
    
    /**
    Getter for roster.

    @return roster Student roster
    @author Harpreet Randhawa
    */
	public Student[] getRoster() {
		return roster;
	}
	
    /**
    Setter for roster.

	@param roster Student roster
    @return this.roster
    @author Harpreet Randhawa
    */
	public void setRoster(Student[] roster) {
		this.roster = roster;
	}

    /**
    Iterates through roster to find the given student's index.
    If index is not found, returns -1.

    @return The album's index. Returns NOT_FOUND if index is not found.
    @param student The given student to be searched.
    @author Harpreet Randhawa
    */
    private int find(Student student) {
        for (int i = 0; i < size; i++) {
            if (getRoster()[i].equals(student)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
    Automatically grow the array list when it reaches full capacity.

    @author Harpreet Randhawa
    */
    private void grow() {
        Roster increasedRoster = new Roster();
        increasedRoster.setRoster(new Student[this.getRoster().length + GROWTH_FACTOR]);
        for (int i = 0; i < size; i++) {
            increasedRoster.getRoster()[i] = this.getRoster()[i];
        }
        this.setRoster(increasedRoster.getRoster());
    }

    /**
    Adds the given student to the array list.

    @return True if the student was added successfully and false otherwise.
    @param student The given student to be added.
    @author Harpreet Randhawa
    */
    public boolean add(Student student) {
        if (find(student) != NOT_FOUND) {
            return false;
        }
        if ((this.size % GROWTH_FACTOR == 0) && (size != 0)) {
            this.grow();
        }
        for (int i = 0; i <= size; i++) {
            if (getRoster()[i] == null) {
                getRoster()[i] = student;
                size++;
                return true;
            }
        }
        return false;
    }

    /**
    Removes the given student from the array list while maintaining the relative sequence of the objects.

    @return True if the student was removed successfully and false otherwise.
    @param student The given student to be removed.
    @author Harpreet Randhawa
    */
    public boolean remove(Student student) {
        if (find(student) != NOT_FOUND) {
            return false;
        }
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (found == true) {
                getRoster()[i] = getRoster()[i + 1];
            } else if (getRoster()[i].equals(student)) {
                found = true;
                getRoster()[i] = getRoster()[i + 1];
            }
        }
        if (found) {
            size--;
            return true;
        }
        return false;
    }

    /**
    * Check to see if the students in the roster for usage in TuitionManager.
    
    * @param student
    * @return The student or null if the student is not in the roster.
    * @author Mikita Belausau
    */
    public Student studentInRoster(Student student){
        int i = find(student);
        if(i == NOT_FOUND){
            return null;
        }
        return getRoster()[i];
    }

    /**
    * 
    
    * @param student
    * @return The student or null if the student is not in the roster.
    * @author Mikita Belausau
    */
    public Student replaceFinancialAid(Student student){
        int i = find(student);
        if(i != -1){
            if(getRoster()[i] instanceof Resident) {
                return getRoster()[i];
            }
        }
        return null;
    }
    
    /**
    * Checks if the given student is an international student or not.
    
    * @param student
    * @return The student or null if the student is not in the roster.
    * @author Harpreet Randhawa
    */
    public Student replaceStudyAbroad(Student student){
        int i = find(student);
        if(i != -1){
            if(getRoster()[i] instanceof International) {
                return getRoster()[i];
            }
        }
        return null;
    }

}
