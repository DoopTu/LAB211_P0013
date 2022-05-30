/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author LENOVO
 */
public class Student {

    public String id;
    public String fname;
    public String lname;
    public boolean gender;
    public Date dob;
    public String email;
    public String phone;

    public Student() {

    }

    public Student(String id, String fname, String lname, boolean gender, Date dob, String email, String phone) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
    }
    
        public Student(String id) {
        this.id = id;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getName(){
        return fname + " " + lname; 
    }
    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", fname=" + fname + ", lname=" + lname + ", gender=" + gender + ", dob=" + dob + ", email=" + email + ", phone=" + phone + '}';
    }

    public void displayInformation() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("\n| %-10s | %-20s | %-10s | %-10s | %-15s | %-25s | %-15s |", id, fname, lname, convertToString(gender), df.format(dob), email, phone);
    }



    public String convertToString(boolean sex) {
        if (sex == true) {
            return "Male";
        } else {
            return "Female";
        }
    }

    @Override
    public boolean equals(Object obj) {
        return id.equals(((Student)obj).id);
    }
    
    

}
