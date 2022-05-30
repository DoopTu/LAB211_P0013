/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm_lab211;

import data.StudentManager;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Program {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String[] options = {"Add a new Student.", "Update Student. ", "Add a new Subject.", "Update Subject.", "Add Grade. ", "Student Report.", "Subject Report.", "Display list of Student.", "Display list of Subject.", "Other to Exist."};
        StudentManager obj = new StudentManager();
        int subChoiceSJ;
        int subchoice;
        int choice;
        do {
            System.out.println("\n----------MENU----------");
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    obj.addNewStudent();
                    break;
                case 2:
                    
                    String[] submenu = {"2-1. Update Information.", "2-2. Remove Student.", "2-3. Other to exist."};
                    do {
                        System.out.println("\n-------2. UPDATE STUDENT-------");
                        subchoice = Menu.getChoice(submenu);
                        switch (subchoice) {
                            case 1:
                                obj.updateStudent();
                                break;
                            case 2:
                                obj.removeStudent();
                                break;
                            default: break;
                        }
                    } while (subchoice > 0 && subchoice <= 2);
                    break;
                case 3:
                    obj.addNewSubject();
                    break;
                case 4:
                    
                    String[] submenu2 = {"4-1. Update Information Subject.", "4-2. Remove Subject.", "4-3. Other to exist."};
                    do {
                        System.out.println("\n-------4. UPDATE SUBJECT-------");
                        subChoiceSJ = Menu.getChoice(submenu2);
                        switch (subChoiceSJ) {
                            case 1:
                                obj.updateSubject();
                                break;
                            case 2:
                                obj.removeSubject();
                                break;
                            default: break;
                        }
                    } while (subChoiceSJ > 0 && subChoiceSJ <= 2);
                    break;

                case 5:
                    obj.addGrade();
                    break;
                case 6:
                    obj.reportStudent();
                    break;
                case 7:
                    obj.reportSubject();
                    break;
                case 8:
                    obj.printListOfStudent();
                    break;
                case 9:
                    obj.printListOfSubject();
                    break;
                default: System.out.println("----BYE!----");
                break;
            }
        } while (choice > 0 && choice < 10);

    }
}
