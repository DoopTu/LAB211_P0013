/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class SubjectsList extends ArrayList<Subject> {

    private List<Subject> subject;
    Scanner sc = new Scanner(System.in);



    public SubjectsList(List<Subject> subject) {
        this.subject = subject;
    }

    
    public SubjectsList() {
        super();
    }

    public Subject searchSub(String code) {
        code = code.trim().toUpperCase();

        for (Subject sb : subject) {
            if (sb.getSubID().equals(code)) {
                return sb;
            } else {
                return null;
            }

        }
        return null;
    }

    public boolean isCodeDupplicated(String code) {
        code = code.trim().toUpperCase();
        return searchSub(code) != null;
    }

    public  boolean isCodeNull(String code) {
        code = code.trim().toUpperCase();
        return searchSub(code) == null;
    }

    public static boolean checkBlank(String text) {
        if ("\n".equals(text) || text.isEmpty() || text == null || text.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    
}
