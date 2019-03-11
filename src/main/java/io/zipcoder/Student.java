package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student implements Comparable<Student>{
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;



    public Student(String firstName, String lastName, Double[] testScores){
        this.firstName =firstName;
        this.lastName = lastName;
        examScores = new ArrayList<Double>();
        examScores.addAll(Arrays.asList(testScores));
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Integer getNumberOfExamsTaken(){

        return examScores.size();
    }
    public String getExamScores(){
        String examScore = "Exam Scores:\n";

        for(int i =0; i < examScores.size();i++){
            String exam = "\tExam " + (i +1) + " -> " + examScores.get(i) + "\n";
            examScore += exam;
        }

        return examScore;
    }

    public void addExamScore(double examScore){
       examScores.add(examScore);
    }
    public void setExamScore(int examScore, double newScore){
        examScores.set(examScore -1, newScore);

    }
    public Integer getAverageExamScore(){
        double sum = 0;
        for(int i = 0; i < examScores.size(); i++){
            sum += examScores.get(i);
        }
        int average = (int)sum/examScores.size();
        return average;

    }
     public String toString(){
        String result = "Student Name:" + firstName + " " + lastName + "\n" + "Average Score: " + getAverageExamScore() + "\n" + getExamScores();
        return result;
     }


    @Override
    public int compareTo(Student o) {
        return o.getAverageExamScore().compareTo(getAverageExamScore());
    }

}
