package codingfor30days.day12inheritance;

import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstName = scan.next();
        String lastName = scan.next();
        int id = scan.nextInt();
        int numScores = scan.nextInt();
        int[] testScores = new int[numScores];
        for(int i = 0; i < numScores; i++){
            testScores[i] = scan.nextInt();
        }
        scan.close();

        Student s = new Student(firstName, lastName, id, testScores);
        s.printPerson();
        System.out.println("Grade: " + s.calculate());
    }

    static class Person {
    protected String firstName;
    protected String lastName;
    protected int idNumber;

    // Constructor
    Person(String firstName, String lastName, int identification){
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = identification;
    }

    // Print person data
    public void printPerson(){
        System.out.println(
                "Name: " + lastName + ", " + firstName
                        + 	"\nID: " + idNumber);
    }

}

static class Student extends Person{
    private int[] testScores;

    /*
     *   Class Constructor
     *
     *   @param firstName - A string denoting the Person's first name.
     *   @param lastName - A string denoting the Person's last name.
     *   @param id - An integer denoting the Person's ID number.
     *   @param scores - An array of integers denoting the Person's test scores.
     */
    // Write your constructor here

    public Student(String firstName, String lastName, int identification, int[] testScores) {
        super(firstName, lastName, identification);
        this.testScores = testScores;
    }

    public String calculate() {

        int sum = 0;
        int average = 0;

        for (int i = 0; i < testScores.length; i++) {
            sum = sum + testScores[i];
        }

        if (testScores.length == 0) {
            average = 0;
        } else {
            average = sum / testScores.length;
        }

        String score = "";

        if (average < 40) {
            score = "T";
        } else if (average >= 40 && average < 55) {
            score = "D";
        } else if (average >= 55 && average < 70) {
            score = "P";
        } else if (average >= 70 && average < 80) {
            score = "A";
        } else if (average >= 80 && average < 90) {
            score = "E";
        } else if (average >= 90 && average <= 100) {
            score = "O";
        }

        return score;

    }
}
}
