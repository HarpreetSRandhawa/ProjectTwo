/**
 * @author Mikita Belausau, Harpreet Randhawa
 */
package project.two;

public class Roster {
    private Student[] roster;
    private int size; //keep track of the number of students in the roster

    public Roster() {
        this.roster = new Student[4];
        this.size = 0;
    }

    private static final int GROWTH_FACTOR = 4;
    private static final int NOT_FOUND = -1;

    /**
     Returns the size of the roster.

     @return Roster size.
     @author Harpreet Randhawa
     */
    public int getSize() {
        return size;
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
            if (roster[i].equals(student)) {
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
        increasedRoster.roster = new Student[this.roster.length + GROWTH_FACTOR];
        for (int i = 0; i < size; i++) {
            increasedRoster.roster[i] = this.roster[i];
        }
        this.roster = increasedRoster.roster;
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
            if (roster[i] == null) {
                roster[i] = student;
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
                roster[i] = roster[i + 1];
            } else if (roster[i].equals(student)) {
                found = true;
                roster[i] = roster[i + 1];
            }
        }
        if (found) {
            size--;
            return true;
        }
        return false;
    }

    /**
     * Check to see if the students in the roster for usage in TuitionManager
     * @param student
     * @return
     */
    public Student studentInRoster(Student student){
        int i = find(student);
        if(i == NOT_FOUND){
            return null;
        }
        return roster[i];
    }

    /**
     *
     * @param student
     * @return
     */
    public Student replaceFinancialAid(Student student){
        int i = find(student);
        if(i != -1){
            if(roster[i] instanceof Resident) {
                return roster[i];
            }
        }
        return null;
    }
}
