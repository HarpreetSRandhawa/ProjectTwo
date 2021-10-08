package unitTesting;

import project.two.Roster;
import project.two.Student;
import project.two.Major;
import org.junit.Test;

import static org.junit.Assert.*;

public class RosterTest {

    @Test
    public void add() {
    	// Test to add 1 student
    	Student student = new Student("Person one", Major.CS, 12);
    	Roster roster = new Roster();
    	assertTrue(roster.add(student));
    	
    	// Test to ensure that roster's capacity is growing and results in true for adding the 5th student
    	student = new Student("Person two", Major.IT, 15);
    	roster.add(student);
    	student = new Student("Person three", Major.EE, 16);
    	roster.add(student);
    	student = new Student("Person four", Major.ME, 18);
    	student = new Student("Person five", Major.CS, 9);
    	roster.add(student);
    	student = new Student("Person six", Major.BA, 7);
    	assertTrue(roster.add(student));
    	
    	// Test to make sure it does not add duplicate students
    	student = new Student("Person two", Major.IT, 15);
    	assertFalse(roster.add(student));
  
    }

    @Test
    public void remove() {
     	Student studentOne = new Student("Person one", Major.CS, 12);
    	Roster roster = new Roster();
    	assertTrue(roster.add(studentOne)); //test to see if add works
    	Student studentTwo = new Student("Person two", Major.IT, 15);
    	roster.add(studentTwo);
    	Student studentThree = new Student("Person three", Major.EE, 16);
    	roster.add(studentThree);
    	Student studentFour = new Student("Person four", Major.ME, 18);
    	roster.add(studentFour);
    	Student studentFive = new Student("Person five", Major.CS, 9);
    	assertTrue(roster.add(studentFive)); //test to see if grow works
    	Student studentSix = new Student("Person six", Major.BA, 7);
    	roster.add(studentSix);
		Student studentEight = new Student("Person seven", Major.CS, 12);
    	
    	// Test to remove a student
    	assertTrue(roster.remove(studentOne));
    	
    	// Test to remove an already removed student
    	assertFalse(roster.remove(studentOne));
    	
    	// Test to remove a student not within the same roster
    	Roster rosterTwo = new Roster();
    	Student studentSeven = new Student("Person seven", Major.EE, 12);
    	rosterTwo.add(studentSeven);
    	assertFalse(roster.remove(studentSeven));

		//Test to remove a student that was never added to the roster
		assertFalse(roster.remove(studentEight));
    	
    }
}