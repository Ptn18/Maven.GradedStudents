package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

public class ClassroomTest {

    @Test
    public void GetAverageExamScore() {
        // : Given
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        double expected = 125.0;

        Student[] students = new Student[]{s1, s2};
        Classroom classroom = new Classroom(students);

        // When
        double output = classroom.getAverageExamScore();

        // Then
        Assert.assertEquals(expected, output, 0.01);
    }

    @Test
     public void addStudentTest(){
    // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);

        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);

        }
      @Test
     public void removeStudentTest(){
        //Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);
        Student[] expected = {null};
        //When
        classroom.removeStudent("Leon","Hunter");
        Student[] students = classroom.getStudents();
        //Then
        Assert.assertArrayEquals(expected, students);

      }

    @Test
    public void getStudentsByScoreTest(){
     // : Given
     Double[] s1Scores = {100.0, 150.0};
     Double[] s2Scores = {225.0, 25.0};

     Student s1 = new Student("student", "one", s1Scores);
     Student s2 = new Student("student", "two", s2Scores);
     Student[] expected = {s1,s2};

      Student[] students = new Student[]{s1, s2};
      Classroom classroom = new Classroom(students);

      // When
      Student[] output = classroom.getStudentByScore();

      // Then
       Assert.assertEquals(expected, output);
        }


@Test
public void GradeBookTest() {
    //Given
    Student[] newStudent = new Student[10];
    newStudent[0] = new Student("Student", "zero",new Double[]{100.0});
    newStudent[1] = new Student("Student", "one",new Double[]{94.0});
    newStudent[2] = new Student("Student", "two",new Double[]{93.0});
    newStudent[3] = new Student("Student", "three",new Double[]{80.0});
    newStudent[4] = new Student("Student", "four",new Double[]{95.0});
    newStudent[5] = new Student("Student", "five",new Double[]{87.0});
    newStudent[6] = new Student("Student", "six",new Double[]{99.0});
    newStudent[7] = new Student("Student", "seven",new Double[]{92.0});
    newStudent[8] = new Student("Student", "eight",new Double[]{85.0});
    newStudent[9] = new Student("Student", "nine",new Double[]{90.0});

    Student[] aStudent = {newStudent[0]};
    Student[] bStudent = {newStudent[6],newStudent[4]};
    Student[] cStudent = {newStudent[1],newStudent[2]};
    Student[] dStudent = {newStudent[5],newStudent[7],newStudent[8],newStudent[9]};
    Student[] fStudent = {newStudent[3]};

    //When
    Classroom classroom = new Classroom(Arrays.copyOf(newStudent, newStudent.length));
    Map<Student,Character> actual =  classroom.getGradeBook();

    testStudentGrades(aStudent, 'A', actual);
    testStudentGrades(bStudent, 'B', actual);
    testStudentGrades(cStudent, 'C', actual);
    testStudentGrades(dStudent, 'D', actual);
    testStudentGrades(fStudent, 'F', actual);

}

    private void testStudentGrades(Student[] students, Character expectedGrade, Map<Student, Character> actual) {
        for(Student student : students) {
            Character actualGrade =  actual.get(student);
            Assert.assertEquals(actualGrade, expectedGrade);
        }
    }

}

