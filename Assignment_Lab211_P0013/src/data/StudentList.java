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
public class StudentList extends ArrayList<Student> {

    public static Scanner sc = new Scanner(System.in);
    private List<Student> student;



    public StudentList(List<Student> student) {
        this.student = student;
    }


    public StudentList() {
        super();
    }

    public Student search(String code) {
        code = code.trim().toUpperCase();

        for (Student st : student) {
            if (st.getId().equals(code)) {
                return st;
            } else {
                return null;
            }
        }
//        for (int i = 0; i < student.size(); i++) {
//            if (student.get(i).getId().equals(code)) {
//                return student.get(i);
//            }
//            
//        } 
        return null;
    }

    public static boolean checkGender(String msg) {
        String str;

        boolean flag = false;
        do {
            System.out.print(msg);
            str = sc.nextLine();
            str = str.trim().toUpperCase();
            char c = str.charAt(0);
            try {

                if (null == str) {
                    throw new Exception();
                } else {
                    switch (c) {
                        case 'M':
                        case '1':
                        case 'T':
                            return true;
                        case '0':
                        case 'F':
                            return false;

                        default:
                            throw new Exception();
                    }

                }

            } catch (Exception e) {
                System.out.println("Data Invalid! Try again.");
                flag = true;
            }
        } while (flag);

        return false;
    }

    public static String convertToString(boolean sex) {
        if (sex == true) {
            return "MALE";
        } else {
            return "FEMALE";
        }
    }

    public static boolean checkBlank(String text) {
        if (text == "\n" || text.isEmpty() || text == null || text.length()==0) {
            return false;
        } else {
            return true;
        }
    }

//        public void descending() {
//
////        Comparator<Student> cmp = new Comparator<Student>() {
////            public int compare(Student a, Student b) {
////                if (a.getQuantity() != b.getQuantity()) {
////                    return  b.getQuantity() - a.getQuantity();
////                }
////                return a.getCode().compareTo(b.getCode());
////            }
////        };
}
