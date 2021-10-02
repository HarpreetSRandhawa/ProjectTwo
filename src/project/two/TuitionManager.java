/**
 * @author Mikita Belausau, Harpreet Randhawa
 */
package project.two;

import java.util.Scanner;

public class TuitionManager {

    private static final int MINIMUM_CREDITS = 3;
    private static final int MAXIMUM_CREDITS = 24;

    /**
     * Turns user input into Major object
     *
     * @param parse
     * @return Major object
     * @author Mikita Belausau
     */
    private boolean majorCheck(String[] parse) {
        if (parse[2].equalsIgnoreCase("CS") || parse[2].equalsIgnoreCase("IT")
                || parse[2].equalsIgnoreCase("BA") || parse[2].equalsIgnoreCase("EE") ||
                parse[2].equalsIgnoreCase("ME")) {
            return true;
        }
        System.out.println("'" + parse[2] + "' is not a valid major.");
        return false;
    }

    private Major inputToMajor(String[] parse) {
        Major major = null;
        if (parse[2].equalsIgnoreCase("CS") || parse[2].equalsIgnoreCase("IT")
                || parse[2].equalsIgnoreCase("BA") || parse[2].equalsIgnoreCase("EE") ||
                parse[2].equalsIgnoreCase("ME")) {
            major = Major.valueOf(parse[2].toUpperCase());
        }
        return major;
    }

    private void performCommandFourInputF(String line, Roster roster1, String[] parse) {
        Student student = new Student(parse[1], inputToMajor(parse), 5);
        if (roster1.studentInRoster(student) == null) {
            System.out.println("Student not in the roster.");
        } else if (roster1.replaceFinancialAid(student) != null) {
            Resident resident = (Resident) roster1.replaceFinancialAid(student);
            if (resident.financialAid()) {
                System.out.println("Awarded once already.");
            } else if (resident.getTotalCreditHours() < 12) {
                System.out.println("Parttime student doesn't qualify for the award.");
            } else {
                resident.setResidentFinancialAid(Integer.valueOf(parse[3]));
                resident.setFinancialAidRecieved(true);
                System.out.println("Tuition updated.");
            }
        } else {
            System.out.println("Not a resident student.");
        }
    }

    /**
    * Updates the abroad status, total credit hours, tuition due, and payment dates for International students.
    
    * @param line The input line
    * @param roster1 The roster of students
    * @param parse The given input string
    * @return The desired print output 
    * @author Harpreet Randhawa
    */
    private void performCommandFourInputS(String line, Roster roster1, String[] parse) {
        Student student = new Student(parse[1], inputToMajor(parse), 5);
        if (roster1.studentInRoster(student) == null) {
            System.out.println("Couldn't find the international student.");
        } else if (roster1.replaceStudyAbroad(student) != null) {
            International international = (International) roster1.replaceStudyAbroad(student);
            if (international.getTotalCreditHours() < 12) {
                System.out.println("Parttime student doesn't qualify for the award.");
            } 
            else {
                System.out.println("BEFORE: " + international.getTuitionDue());
                System.out.println("BEFORE: " + international.getStudyAbroadStatus());
                international.setStudyAbroadStatus(true);
                international.setTotalCreditHours(12);
                international.setTuitionDue(0);
                international.tuitionDue();
                System.out.println("AFTER: " + international.getTuitionDue());
                System.out.println("AFTER: " + international.getStudyAbroadStatus());
                //Clear the payment date?
                System.out.println("Tuition updated.");
            }
        }
    }

    private void performCommandFourInputsAR(String line, Roster roster1, String[] parse) {
        Resident resident = new Resident(parse[1], inputToMajor(parse), Integer.valueOf(parse[3]));
        if (roster1.add(resident)) {
            System.out.println("Student added.");
        } else {
            System.out.println("Student is already in the roster");
        }
    }
    
    /**
    * Checks to see if the given input for AT is correct and outputs the desired prints
    
    * @param line The input line
    * @param roster1 The roster of students
    * @param parse The given input string
    * @return The desired print output 
    * @author Harpreet Randhawa
    */
    private void performCommandFourInputAT(String line, Roster roster1, String[] parse) {
        final int PROPER_LENGTH = 5;
        
    	if(parse.length != PROPER_LENGTH) {
    		System.out.println("Missing data in command line.");
    		return;
    	}
    	if(((parse[4].equals("NN")) == true)) {
    		System.out.println("Not part of the tri-state area.");
    		return;
    	}
        TriState triState = new TriState(parse[1], inputToMajor(parse), Integer.valueOf(parse[3]), parse[4].toUpperCase());
        if ((roster1.add(triState))) {
            System.out.println("Student added.");
        } 
        else {
            System.out.println("Student is already in the roster");
        }
    }

    private void performCommandFourInputAN(String line, Roster roster1, String[] parse) {
        NonResident nonResident = new NonResident(parse[1], inputToMajor(parse), Integer.valueOf(parse[3]));
        if (roster1.add(nonResident)) {
            System.out.println("Student added.");
        } else {
            System.out.println("Student is already in the roster");
        }
    }
    
    /**
    * Checks to see if the given input for AI is correct and outputs the desired prints
    
    * @param line The input line
    * @param roster1 The roster of students
    * @param parse The given input string
    * @return The desired print output 
    * @author Harpreet Randhawa
    */
    private void performCommandFourInputAI(String line, Roster roster1, String[] parse) {
        International international = new International(parse[1], inputToMajor(parse), Integer.valueOf(parse[3]), Boolean.valueOf(parse[4]));
        if ((Integer.valueOf(parse[3]) >= 12)) {
            if(roster1.add(international)){
                System.out.println("Student added.");
            }
        }
        else {
            System.out.println("International students must enroll at least 12 credits.");
        }
    }

    private boolean creditHourCheck(String[] parse) {
        if (!(parse[3].matches("-?\\d+"))) {
            System.out.println("Invalid credit hours.");
            return false;
        } else if (((Integer.valueOf(parse[3]) < 0))) {
            System.out.println("Credit hours cannot be negative.");
            return false;
        } else if (((Integer.valueOf(parse[3]) < MINIMUM_CREDITS))) {
            System.out.println("Minimum credit hours is 3.");
            return false;
        } else if (((Integer.valueOf(parse[3]) > MAXIMUM_CREDITS))) {
            System.out.println("Credit hours exceed the maximum 24.");
            return false;
        }
        return true;
    }

    private boolean performCommandThreeInputDelete(String line, Roster roster1, String[] parse) {
        Student student = new Student(parse[1], inputToMajor(parse), 5);
        if (roster1.remove(student)) {
            System.out.println("Student removed from the roster.");
            return true;
        } else {
            System.out.println("Student is not in the roster.");
            return false;
        }
    }
    
    /**
    * Prints out the roster in no particular order.
    
    * @param line The input line
    * @param roster1 The roster of students
    * @param parse The given input string
    * @return The student roster.
    * @author Harpreet Randhawa
    */
    private void performCommandPrint(String line, Roster roster1, String[] parse) {
    	if(roster1.getSize() == 0) {
    		System.out.println("Student roster is empty!");
    	}
    	else {
    		for(int i = 0; i < roster1.getSize(); i++) {
    			System.out.println(roster1.getRoster()[i]);
    		}
    	}

    }

    private boolean parseLengthThreeValidCheckRosterDelete(String[] parse) {
        if (!(parse[0].equals("D"))) {
            return false;
        }
        return true;
    }

    private boolean validCheckRosterAdd(String[] parse) {
        if (parse.length == 1) {
            System.out.println("Missing data in command line.");
            return false;
        } else if (parse.length == 2) {
            System.out.println("Missing data in command line.");
            return false;
        } else if (parse.length == 3) {
            System.out.println("Credit hours missing.");
            return false;
        } else if (!(majorCheck(parse))) {
            return false;
        } else if (!(creditHourCheck(parse))) {
            return false;
        }
        return true;
    }

    private boolean validityCheckOne(String[] parse) {
        if (!(parse[0].equals("C") || parse[0].equals("P") || parse[0].equals("PN") || parse[0].equals("PT"))) {
            System.out.println("Command '" + parse[0] + "' not supported!");
            return false;
        }
        return true;
    }

    private boolean validityCheckF(String[] parse) {
        if (parse.length == 3) {
            System.out.println("Missing the amount.");
            return false;
        } else if (((parse[0].equals("F")) && (!((((Integer.valueOf(parse[3])) < 10000)) || (Integer.valueOf(parse[3]) > 0))))) {
            System.out.println("Invalid amount.");
            return false;
        }
        return true;
    }

    private void performCommands(String line, Roster roster1) {
        String[] parse = line.split(",");
        if ((parse[0].equals("AR"))) {
            performCommandFourInputsAR(line, roster1, parse);
        } else if ((parse[0].equals("AN"))) {
            performCommandFourInputAN(line, roster1, parse);
        } else if ((parse[0].equals("AI"))) {
            performCommandFourInputAI(line, roster1, parse);
        } else if ((parse[0].equals("AT"))) {
            performCommandFourInputAT(line, roster1, parse);
        } else if ((parse[0].equals("F"))) {
            performCommandFourInputF(line, roster1, parse);
        } else if ((parse[0].equals("P"))) {
        	performCommandPrint(line, roster1, parse);
        }
        
        }

    private boolean isValidInput(String line) {
        String[] parse = line.split(",");
        if ((parse[0].equals("F"))) {
            validityCheckF(parse);
        } else if (parse[0].equals("AR") || parse[0].equals("AN") || parse[0].equals("AI") || parse[0].equals("AT")) {
            return validCheckRosterAdd(parse);
        } else if (parse.length == 1) {
            return validityCheckOne(parse);
        }
        return true;
    }

    /**
     * Runs Tuition Manager.
     *
     * @author Mikita Belausau, Harpreet Randhawa
     */
    public void run() {
        System.out.println("Tuition Manager starts running.");
        Roster rosters1 = new Roster();
        Scanner scanner = new Scanner(System.in);
        while (!(scanner.equals("Q"))) {
            String line = scanner.nextLine();
            if (isValidInput(line)) {
                performCommands(line, rosters1);
            } else if ((line.equals("\n")) || (line.equals(""))) {
                ;
            }
        }
    }

}
