/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.text.SimpleDateFormat;

/**
 *
 * @author LENOVO
 */
public class Subject {

    public String subID;
    public String subName;
    public int Credit;

    public Subject() {

    }

    public Subject(String subID, String subName, int Credit) {
        this.subID = subID;
        this.subName = subName;
        this.Credit = Credit;
    }

    public Subject(String subID) {
        this.subID = subID;
    }

    public String getSubID() {
        return subID;
    }

    public void setSubID(String subID) {
        this.subID = subID;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getCredit() {
        return Credit;
    }

    public void setCredit(int Credit) {
        this.Credit = Credit;
    }

    @Override
    public String toString() {
        return "Subject{" + "subID=" + subID + ", subName=" + subName + ", subCredit=" + Credit + '}';
    }

    public void displayInformation() {
        System.out.printf("\n| %-10s | %-20s | %-10s |", subID, subName, Credit);
    }

    @Override
    public boolean equals(Object obj) {
        return subID.equals(((Subject)obj).subID);
    }

}
