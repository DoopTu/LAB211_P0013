/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm_lab211;

import java.util.ArrayList;
import java.util.Scanner;


public class Menu {
    public static int getChoice(ArrayList options) {
        for (int i = 0; i <options.size();i++) {
            System.out.print((i+1)+"-"+options.get(i));
        }
        System.out.print("\nEnter your choice: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        return Integer.parseInt(sc.nextLine());
    }
    
    public static int getChoice(Object[] options) {
        for (int i = 0; i<options.length; i++) {
            System.out.println((i+1) + ". "+options[i]);
        }
        System.out.print("\nEnter your choice: ");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }
}
