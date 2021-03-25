package ui;

import model.Transcript;

import java.util.ArrayList;
import java.util.List;

public class MainTranscript {



    public static void main(String[] args){
        Transcript t1 = new Transcript("Jane Doe", 7830);
        Transcript t2 = new Transcript("Ada Lovelace", 8853);
        Transcript t3 = new Transcript("Khalid", 010);

        t1.addGrade("CPSC-210", 3.5);
        t1.addGrade("ENGL-201", 4.0);
        t1.addGrade("CPSC-110", 3.1);

        t3.addGrade("SC-6.001", 4);
        t3.addGrade("HtCx-1", 4);
        t3.addGrade("HtCx-2", 4);


        System.out.print(t1.getStudentName() + ": ");
        t1.printTranscript();

        System.out.println(t1.getGPA());

        List<String> x = new ArrayList<String>();
        x.add("CPSC-210");
        x.add("ENGL-201");
        x.add("CPSC-110");
        t1.getAverageOverSelectedCourses(x);

        //TODO: add more use cases here
    }
}
