package io.zipcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Classroom {
    private Student[] students;
    private int size;

    public Classroom(int maxNumberOfStudents){
        this.students = new Student[maxNumberOfStudents];
    }
    public Classroom(Student[] student){
        this.students = student;

    }
    public Classroom(){
        this.students = new Student[30];
    }

    public Student[] getStudents(){
        return students;
    }

    public Double getAverageExamScore(){
        Double average = 0.0;
        for(int i = 0; i < students.length; i++){
            average += students[i].getAverageExamScore();
        }
        return average/students.length;
    }
    public void addStudent(Student student){
        if (size == students.length) {

            Student[] newStudent = Arrays.copyOf(students, students.length + 1);
            newStudent[students.length] = student;
            students = newStudent;
        } else {
            students[size] = student;
        }
            size++;
    }

    public void removeStudent(String firstName, String lastName){
        Student[] removedStudent = Arrays.copyOf(students, students.length);
        int index = 0;
        for (int i = 0; i < students.length; i++) {
            if(students[i] != null) {
                if (!students[i].getFirstName().equals(firstName) && !students[i].getLastName().equals(lastName)) {
                    removedStudent[index] = students[i];
                    index++;
                }
            }
        }
        students = removedStudent;
    }


    public Student[] getStudentByScore(){
        Arrays.sort(students);
        return students;
    }

    public Map<Student,Character> getGradeBook(){
        Arrays.sort(students);
        Map<Student, Character> gradedStudents = new HashMap<>();

        int startingIndex = 0;
        int aNumber = (int) Math.ceil(students.length * .1);
        setStudentGrade(gradedStudents, aNumber, startingIndex, 'A');
        startingIndex = aNumber;

        int bNumber = (int) Math.ceil(students.length * .19);
        setStudentGrade(gradedStudents, bNumber, startingIndex, 'B');
        startingIndex += bNumber;

        int cNumber = (int) Math.ceil(students.length * .20);
        setStudentGrade(gradedStudents, cNumber, startingIndex, 'C');
        startingIndex += cNumber;

        int dNumber = (int) Math.ceil(students.length * .38);
        setStudentGrade(gradedStudents, dNumber, startingIndex, 'D');
        startingIndex += dNumber;

        int fNumber = students.length - startingIndex;
        setStudentGrade(gradedStudents, fNumber, startingIndex, 'F');

    return gradedStudents;
    }

    private void setStudentGrade(Map<Student, Character> gradedStudents, int numberOfStudent, int startingIndex, char grade) {
        //starting index= 0, add the number of students that was taken to get the the stop index
        int stopIndex = startingIndex + numberOfStudent;
        for(int i = startingIndex; i < stopIndex;i++){
             Student student = students[i];
             //Adding the student and their grades into the map
             gradedStudents.put(student, grade);
        }

    }









}
