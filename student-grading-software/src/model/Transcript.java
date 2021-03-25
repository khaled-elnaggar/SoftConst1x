package model;

import java.util.ArrayList;
import java.util.List;

public class Transcript {
    /**
     * INVARIANT: course list and grade list are the same size
     * each course has a grade associated, and vice versa, at matching indices
     */
    private String studentName;
    private int studentID;
    private ArrayList<String> courses;
    private ArrayList<Double> grades;

    public Transcript(String studentName, int studentID){
        this.studentName = studentName;
        this.studentID = studentID;
        courses = new ArrayList<String>();
        grades = new ArrayList<Double>();
    }

    // getters
    public String getStudentName() { return studentName; }
    public int getStudentID() { return studentID; }

    // setters
    public void setStudentID(int studentID) { this.studentID = studentID; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    //REQUIRES: 0.0 <= grade <= 4.0
    //MODIFIES: courses
    //EFFECT: adds the grade of the course
    public void addGrade(String course, double grade){
        courses.add(course);
        grades.add(grade);
    }

    //REQUIRES: a course the student has already taken.
    //EFFECT returns the course name and grade of the given course
    public String getCourseAndGrade(String course){
        return course + ": " + getGradeByCourse(course);
    }

    //EFFECT: prints the courses and their grades, and the final GPA
    public void printTranscript(){
        for (String course : courses){
            System.out.print(getCourseAndGrade(course)+ ", ");
        }
        System.out.println();
    }

    //REQUIRES: a course the student has already taken.
    //EFFECT: gets the GPA for all courses
    public double getGPA(){
        return calculateAverage(grades);
    }

    //REQUIRES: a course the student has already taken.
    //EFFECT: returns the average of the given course grades
    public double calculateAverage(List<Double> selectedGrades){
        double gradesSum = 0;
        for (double grade : selectedGrades){
            gradesSum += grade;
        }
        return gradesSum/selectedGrades.size();
    }

    //REQUIRES: the student has already took that course
    //EFFECT: returns the grade of that course
    public double getGradeByCourse(String course){
        int cIndex = courses.indexOf(course);
        return grades.get(cIndex);
    }

    //EFFECT: returns the average of these certain courses
    public double getAverageOverSelectedCourses(List<String> selectedCourses){
        List<Double> selectedGrades = new ArrayList<Double>();
        for(String course : selectedCourses){
            selectedGrades.add(getGradeByCourse(course));
        }

        return calculateAverage(selectedGrades);
    }

}
