/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.Subject;
import data.Student;
import java.util.Comparator;

/**
 *
 * @author LENOVO
 */
public class Transcript {

    Student StObj;
    Subject SubObj;
    double labMark;
    double testMark;
    double finalMark;

    public Transcript(Student StObj, Subject SubObj, double labMark, double testMark, double finalMark) {
        this.StObj = StObj;
        this.SubObj = SubObj;
        this.labMark = labMark;
        this.testMark = testMark;
        this.finalMark = finalMark;
    }
    
    

    public Transcript() {
    }

    public Transcript(Student StObj, Subject SubObj) {
        this.StObj = StObj;
        this.SubObj = SubObj;
    }

    public Student getStObj() {
        return StObj;
    }

    public void setStObj(Student StObj) {
        this.StObj = StObj;
    }

    public Subject getSubObj() {
        return SubObj;
    }

    public void setSubObj(Subject SubObj) {
        this.SubObj = SubObj;
    }

    public double getLabMark() {
        return labMark;
    }

    public void setLabMark(double labMark) {
        this.labMark = labMark;
    }

    public double getTestMark() {
        return testMark;
    }

    public void setTestMark(double testMark) {
        this.testMark = testMark;
    }

    public double getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(double finalMark) {
        this.finalMark = finalMark;
    }

    public double getAvrg() {
        return (0.3 * labMark + 0.4 * finalMark + 0.3 * testMark);
    }

    public static Comparator compareByName = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Transcript e1 = (Transcript) o1;
            Transcript e2 = (Transcript) o2;
            int d = e1.StObj.getName().compareTo(e2.StObj.getName());
            if (d > 0) {
                return 1;
            }
            if (d == 0) {
                return 0;
            }
            return -1;
        }
    };
    
    @Override
    public boolean equals(Object obj) {
        Transcript t = (Transcript)obj;
        return this.StObj == t.StObj && this.SubObj == t.SubObj;
    }
            

}
