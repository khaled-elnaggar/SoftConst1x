package tests;

import model.Transcript;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TranscriptTest {

    private Transcript testTranscript;

    @Before
    public void setUp(){
        testTranscript = new Transcript("Student", 1000);
    }

    @Test
    public void gettersTest(){
        assertEquals(testTranscript.getStudentName(), "Student");
        assertEquals(testTranscript.getStudentID(), 1000);
    }

    @Test
    public void settersTest(){
        testTranscript.setStudentID(500);
        assertEquals(testTranscript.getStudentID(), 500);
        testTranscript.setStudentName("Khalid");
        assertEquals(testTranscript.getStudentName(), "Khalid");
    }

    @Test
    public void addGradeTest(){
        testTranscript.addGrade("CS1601", 3.1);
        assertEquals(testTranscript.getCourseAndGrade("CS1601"), "CS1601: 3.1");
    }



    @Test
    public void getCourseAndGradeTest(){
        testTranscript.addGrade("CS1601", 3.1);
        testTranscript.addGrade("CS101", 4.0);
        assertEquals(testTranscript.getCourseAndGrade("CS101"), "CS101: 4.0");

    }


    @Test
    public void getGPATest(){
        testTranscript.addGrade("CS1601", 3.1);
        testTranscript.addGrade("CS101", 4.0);
        assertEquals(testTranscript.getGPA(),(3.1+4)/2, 0.001);
    }

    @Test
    public void calculateAverageTest(){
        List<Double> x = new ArrayList<Double>();
        x.add(2.1);
        x.add(3.2);
        assertEquals(testTranscript.calculateAverage(x),2.65, .001);



    }

    @Test
    public void getGradeByCourseTest(){
        testTranscript.addGrade("CS1601", 3.1);
        testTranscript.addGrade("CS101", 4.0);
        assertEquals(testTranscript.getGradeByCourse("CS1601"), 3.1,0);
        assertEquals(testTranscript.getGradeByCourse("CS101"), 4.0,0);

    }

    @Test
    public void getAverageOverSelectedCourses(){
        testTranscript.addGrade("CS1601", 3.1);
        testTranscript.addGrade("CS101", 4.0);
        testTranscript.addGrade("CS16013", 3.1);
        testTranscript.addGrade("CS160150", 3.0);
        List<String> x = new ArrayList<String>();
        x.add("CS101");
        x.add("CS160150");
        assertEquals(3.5, testTranscript.getAverageOverSelectedCourses(x),  0.01);

    }

}
