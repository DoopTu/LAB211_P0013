/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static data.StudentList.checkBlank;
import static data.StudentList.checkGender;
import static data.StudentList.convertToString;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import myUlti.Inputter;

/**
 *
 * @author LENOVO
 */
public class StudentManager {

    Scanner sc = new Scanner(System.in); 
    StudentList student;
    SubjectsList subject;
    TranscriptList transcript;

    public StudentManager(StudentList student, SubjectsList subject, TranscriptList transcript) {
        this.student = student;
        this.subject = subject;
        this.transcript = transcript;
    }

    public StudentManager() {
        student = new StudentList();
        subject = new SubjectsList();
        transcript = new TranscriptList();
    }

    //-------------------------------------STUDENT--------------------------------//
    public Student search(String code) {
        code = code.trim().toUpperCase();

        for (Student st : student) {
            if (st.getId().equals(code)) {
                return st;
            } else {
                return null;
            }
        }
        return null;
    }

    public boolean isCodeDupplicated(String code) {
        code = code.trim().toUpperCase();
        return search(code) != null;
    }

    public void addNewStudent() throws ParseException {
        String newId;
        String newFname;
        String newLname;
        Date newDob;
        String newEmail;
        String newPhone;
        boolean codeDupplicated;
        boolean check;
        boolean newGender;
        boolean stop = false;
        do {
            System.out.println("-------Input Information-------");
            do {
                newId = Inputter.inputString("Enter ID: ");
                newId = newId.trim().toUpperCase();
                codeDupplicated = isCodeDupplicated(newId);
                if (codeDupplicated) {
                    System.err.println("**STUDENT ID IS DUPLICATED!**");
                }
                if (!StudentList.checkBlank(newId)) {
                    System.err.println("**STUDENT ID DOES NOT EMPTY!**");
                }
            } while (codeDupplicated || !StudentList.checkBlank(newId));
            newFname = Inputter.inputString("Enter First Name: ");
            newLname = Inputter.inputString("Enter Last Name: ");
            newGender = StudentList.checkGender("Enter Gender [Male: T/1 - Female: F/0]: ");
            newDob = Inputter.readDMY("Enter Day Of Birth ");
            newEmail = Inputter.inputString("Enter Email: ");
            newPhone = Inputter.inputStringNum("Enter Phone number: ");
            Student st = new Student(newId, newFname, newLname, newGender, newDob, newEmail, newPhone);
            this.student.add(st);
            System.out.println("**STUDENT WAS ADDED!**");
            check = Inputter.checkNext("DO YOU WANT TO CONTINUE [Y/N]: ");
            if (check == true) {
                stop = false;
            } else {
                return;
            }
            if (check == false) {
                stop = true;
                break;
            }
        } while (stop == false);

    }

    public void printListOfStudent() {
        if (this.student.isEmpty()) {
            System.err.println("**EMPTY LIST!**");
        } else {
            System.out.println("+-----------------------------------------------------------------------------------------------------------------------------+");
            System.out.printf("| %-10s | %-20s | %-10s | %-10s | %-15s | %-25s | %-15s |", "ID", "FIRST NAME", "LAST NAME", "GENDER", "DAY OF BIRTH", "EMAIL", "PHONE NUMBER");
            System.out.print("\n+-----------------------------------------------------------------------------------------------------------------------------+");
            for (Student st : student) {
                st.displayInformation();
            }
            System.out.println("\n+-----------------------------------------------------------------------------------------------------------------------------+");
        }

    }

    public void removeStudent() {
        boolean check = false;
        boolean stop = false;
        int pos = 0;
        String rCode = null;
        Student st = null;

        if (this.student.isEmpty()) {
             System.err.println("**EMPTY LIST!**");
        } else {
            do {

                //         if (st == null) {
                //             System.out.println("**STUDENT '" + rCode + "' DOES NOT EXISTED!!**");
                //         } else {
                do {
                    rCode = Inputter.inputString("Enter the code: ");
                    pos = student.indexOf(new Student(rCode));
                    if (pos < 0) {
                        System.err.println("**NOT FOUND!**");
                    } else {
                        st = student.get(pos);
                    }
                } while (pos < 0);
                if (transcript.containStudent(rCode)) {
                    System.err.println("**DEPLOYED. IT CAN NOT BE REMOVE!**");
                } else {
                    this.student.remove(st);
                    System.out.println("**STUDENT '" + rCode + "' HAS BEEN REMOVED.**");
                }
                check = Inputter.checkNext("DO YOU WANT TO CONTINUE [Y/N]: ");
                if (check == true) {
                    stop = false;
                } else {
                    return;
                }
                if (check == false) {
                    stop = true;
                    break;
                }

            } while (stop == false);
        }
        //         }

    }

    public void updateStudent() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        boolean check = false;
        boolean stop = false;
        int pos = 0;
        Student st = null;

        if (this.student.isEmpty()) {
             System.err.println("**EMPTY LIST!**");

        } else {
            do {
                do {
                    String Code = Inputter.inputString("Enter Student ID: ");
                    pos = student.indexOf(new Student(Code));
                    if (pos < 0) {
                        System.err.println("**NOT FOUND!**");
                    } else // do {
                    //                if (st == null) {
                    //                    System.out.println("**STUDENT '" + Code + "' DOESN'T EXITSTED**");
                    //                } else 
                    {
                        st = student.get(pos);
                        String oldFname = st.getFname();
                        System.out.println("Old First Name: " + oldFname);
                        String newFname = Inputter.inputString("New First Name: ");
                        if (student.checkBlank(newFname)) {
                            st.setFname(newFname);
                        } else {
                            st.setFname(oldFname);
                        }

                        String oldLname = st.getLname();
                        System.out.println("Old Last Name: " + oldLname);
                        String newLname = Inputter.inputString("New Last Name: ");
                        if (student.checkBlank(newLname)) {
                            st.setLname(newLname);
                        } else {
                            st.setLname(oldLname);
                        }

                        boolean oldGender = st.getGender();
                        System.out.println("Old Gender: " + convertToString(oldGender));
                        boolean newGender = checkGender("New Gender: ");
                        String newStr = convertToString(newGender);
                        if (student.checkBlank(newStr)) {
                            st.setGender(newGender);
                        } else {
                            st.setGender(oldGender);
                        }

                        Date oldDob = st.getDob();
                        Date newDob;
                        System.out.println("Old Day of Birth: " + df.format(oldDob));

                        newDob = Inputter.readDMY("New Day of Birth: ");
                        if (newDob != null) {
                            st.setDob(newDob);
                        } else {
                            st.setDob(oldDob);
                        }

                        String oldEmail = st.getEmail();
                        System.out.println("Old Email: " + oldEmail);
                        String newEmail = Inputter.inputString("New Email: ");
                        if (student.checkBlank(newEmail)) {
                            st.setEmail(newEmail);
                        } else {
                            st.setEmail(oldEmail);
                        }

                        String oldPhone = st.getPhone();
                        System.out.println("Old Phone Number: " + oldPhone);
//                String newPhone = Inputter.inputStringNum("New Phone Number: ");
                        String newPhone;
                        do {
                            newPhone = Inputter.inputString("Enter Phone number: ");
                            if ((newPhone.length() < 10) || (newPhone.length() > 12)) {
                                System.out.println("10 - 12 number!");
                            }

                            if (student.checkBlank(newPhone)) {
                                st.setPhone(newPhone);
                            } else {
                                st.setPhone(oldPhone);
                            }
                        } while ((newPhone.length() < 10) || (newPhone.length() > 12));
                    }
                } while (pos < 0);
                System.out.println("**STUDENT HAS BEEN UPDATED**");

                check = Inputter.checkNext("DO YOU WANT TO CONTINUE [Y/N]: ");
                if (check == true) {
                    stop = false;
                } else {
                    return;
                }
                if (check == false) {
                    stop = true;
                    break;
                }
            } while (stop == false);

        }
    }

    //-------------------------------------SUBJECT--------------------------------//
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

    private boolean isCodeDupplicatedSub(String code) {
        code = code.trim().toUpperCase();
        return searchSub(code) != null;
    }

    private boolean isCodeNull(String code) {
        code = code.trim().toUpperCase();
        return searchSub(code) == null;
    }

    public void addNewSubject() throws ParseException {
        String newSubId;
        String newSubName;
        int newCredit;
        boolean codeDupplicated;
        boolean check = false;
        boolean stop = false;
        do {
            System.out.println("-------Input Subject Information-------");

            do {
                System.out.print("Enter Subject ID: ");
                newSubId = sc.nextLine();
                newSubId = newSubId.trim().toUpperCase();
                codeDupplicated = isCodeDupplicatedSub(newSubId);

                if (codeDupplicated) {
                    System.err.println("**STUDENT ID IS DUPLICATED!**");
                }

                if (!checkBlank(newSubId)) {
                    System.err.println("**SUBJECT ID DOES NOT EMPTY!**");
                }
            } while (codeDupplicated || !checkBlank(newSubId));

            do {
                System.out.print("Enter Subject Name: ");
                newSubName = sc.nextLine();
                if (!checkBlank(newSubName)) {
                    System.err.println("**SUBJECT NAME DOES NOT EMPTY!**");
                }
            } while (!checkBlank(newSubName));

            newCredit = Inputter.inputInt("New Credit: ", 1, 10);

            Subject sb = new Subject(newSubId, newSubName, newCredit);
            this.subject.add(sb);
            System.out.println("**SUBJECT WAS ADDED!**");
            check = Inputter.checkNext("DO YOU WANT TO CONTINUE [Y/N]: ");
            if (check == true) {
                stop = false;
            } else {
                return;
            }
            if (check == false) {
                stop = true;
                break;
            }
        } while (stop == false);
    }

    public void printListOfSubject() {
        if (this.subject.isEmpty()) {
             System.err.println("**EMPTY LIST!**");

        } else {
            System.out.println("+------------------------------------------------+");
            System.out.printf("| %-10s | %-20s | %-10s |", "SUBJECT ID", "SUBJECT NAME", "CREDIT");
            System.out.print("\n+------------------------------------------------+");
            for (Subject st : subject) {
                st.displayInformation();
            }
            System.out.println("\n+------------------------------------------------+");
        }

    }

    public void updateSubject() throws ParseException {
        boolean check = false;
        boolean stop = false;
        int pos = 0;
        Subject st = null;
        if (this.subject.isEmpty()) {
            System.err.println("**EMPTY LIST!**");

        } else {
            do {
                do {
                    String Code = Inputter.inputString("Enter Subject ID: ");
//                Subject st = this.searchSub(Code);
//                if (st == null) {
//                    System.out.println("**SUBJECT '" + Code + "' DOES NOT EXISTED!!**");
//                } else 
                    pos = subject.indexOf(new Subject(Code));
                    if (pos < 0) {
                        System.err.println("**NOT FOUND!**");
                    } else {
                        st = subject.get(pos);
                        String oldSubName = st.getSubName();
                        System.out.println("Old Subject Name: " + oldSubName);
                        String newSubName = Inputter.inputString("New Subject Name: ");
                        if (SubjectsList.checkBlank(newSubName)) {
                            st.setSubName(newSubName);
                        } else {
                            st.setSubName(oldSubName);
                        }

                        int oldCredit = st.getCredit();
                        System.out.println("Old Credit: " + oldCredit);
                        int newCredit = Inputter.inputInt("New Credit: ", 0, 10);
                        String CreditString = String.valueOf(newCredit);
                        if (SubjectsList.checkBlank(CreditString)) {
                            st.setCredit(newCredit);
                        } else {
                            st.setCredit(oldCredit);
                        }

                    }
                } while (pos < 0);
                System.out.println("**SUBJECT HAS BEEN UPDATED!**");

                check = Inputter.checkNext("DO YOU WANT TO CONTINUE [Y/N]: ");
                if (check == true) {
                    stop = false;
                } else {
                    return;
                }
                if (check == false) {
                    stop = true;
                    break;
                }
            } while (stop == false);
        }
    }

    public void removeSubject() {
        boolean check = false;
        boolean stop = false;
        int pos = 0;
        String rCode = null;
        Subject st = null;

        if (this.subject.isEmpty()) {
            System.err.println("**EMPTY LIST!**");
        } else {
            do {

                //         if (st == null) {
                //             System.out.println("**STUDENT '" + rCode + "' DOES NOT EXISTED!!**");
                //         } else {
                do {
                    rCode = Inputter.inputString("Enter Subject ID: ");

                    pos = subject.indexOf(new Subject(rCode));
                    if (pos < 0) {
                        System.err.println("**NOT FOUND!**");
                    } else {
                        st = subject.get(pos);
                    }
                } while (pos < 0);
                if (transcript.containSubject(rCode)) {
                    System.err.println("**DEPLOYED. IT CAN NOT BE REMOVE!**");
                } else {
                    this.subject.remove(st);
                    System.out.println("**STUDENT '" + rCode + "' HAS BEEN REMOVED.**");
                }
                //   }

                check = Inputter.checkNext("DO YOU WANT TO CONTINUE [Y/N]: ");
                if (check == true) {
                    stop = false;
                } else {
                    return;
                }
                if (check == false) {
                    stop = true;
                    break;
                }
            } while (stop == false);
        }
    }

    //-------------------------------------GRADE--------------------------------//
    public void addGrade() {
        String newStId;
        String newSubID;
        Student st = null;
        Subject sub = null;
        double newLabMark;
        double newTestMark;
        double newFinalMark;
        int pos;
        boolean check = false;
        boolean stop = false;
        do {
            do {
                newStId = Inputter.inputString("Enter Student ID: ");
                newStId = newStId.trim().toUpperCase();
                pos = student.indexOf(new Student(newStId));
                if (pos < 0) {
                    System.err.println("**NOT FOUND!**");
                } else {
                    st = student.get(pos);
                }
            } while (pos < 0);
//        do {
//            newStId = Inputter.inputString("Enter ID: ");
//            newStId = newStId.trim().toUpperCase();
//            if (search(newStId) == null) {
//                System.out.println("**STUDENT ID DOES NOT EXIST!**");
//            }
//            if (!StudentList.checkBlank(newStId)) {
//                System.out.println("**STUDENT ID DOES NOT EMPTY!**");
//            }
//        } while (search(newStId) == null || !StudentList.checkBlank(newStId));
            pos = 0;
            do {
                newSubID = Inputter.inputString("Enter Subject ID: ");
                pos = subject.indexOf(new Subject(newSubID));
                if (pos < 0) {
                    System.err.println("**NOT FOUND!**");
                } else {
                    sub = subject.get(pos);
                }
            } while (pos < 0);
//        do {
//            System.out.print("Enter Subject ID: ");
//            newSubId = sc.nextLine();
//            newSubId = newSubId.trim().toUpperCase();
//            
//            if (searchSub(newSubId) == null) {
//                System.out.println("**SUBJECT ID DOES NOT EXIST!**");
//            }
//            
//            if (!checkBlank(newSubId)) {
//                System.out.println("**SUBJECT ID DOES NOT EMPTY!**");
//            }
//        } while (searchSub(newSubId) == null || !checkBlank(newSubId));

            pos = transcript.indexOf(new Transcript(st, sub));

            newLabMark = Inputter.inputDouble("Enter Lab Mark: ", 0, 10);
            newTestMark = Inputter.inputDouble("Enter Test Mark: ", 0, 10);
            newFinalMark = Inputter.inputDouble("Enter Final Mark: ", 0, 10);

            Transcript o = new Transcript(st, sub, newLabMark, newTestMark, newFinalMark);
            if (pos < 0) {
                transcript.add(o);
            } else {
                transcript.set(pos, o);
            }
            System.out.println("\n**GRADE WAS ADDED!**");
            check = Inputter.checkNext("DO YOU WANT TO CONTINUE [Y/N]: ");
            if (check == true) {
                stop = false;
            } else {
                return;
            }
            if (check == false) {
                stop = true;
                break;
            }
        } while (stop == false);
    }

    //-------------------------------------REPORT--------------------------------//
    public String isPass(double mark) {
        if (mark >= 5) {
            return "PASS";
        }
        return "NOT PASS";
    }

    public void reportSubject() {
        String newSubID;
        int pos;
        Subject sub;
        String name = "";
        int i = 0;
        do {
            newSubID = Inputter.inputString("Enter Subject ID: ");
            pos = subject.indexOf(new Subject(newSubID));
            if (pos < 0) {
                System.out.println("**NOT FOUND!**");
            } else {
                sub = subject.get(pos);
                name = sub.getSubName();
            }
        } while (pos < 0);

        boolean check = transcript.containSubject(newSubID);

        if (check == false) {
            System.out.println("**IT IS NOT DEPLOYED YET!**");
        } else {
            System.out.println("Subject Name: " + name);
            System.out.println("+----------------------------------------------------------------------------+");
            System.out.printf("| %-20s | %-20s | %-15s | %-10s |", "Student ID", "Student name", "Average mark", "Status");
            System.out.print("\n+----------------------------------------------------------------------------+");
            for (Transcript trs : this.transcript) {
                if (trs.SubObj.subID.equals(newSubID)) {
                    i++;
                    System.out.printf("\n| %-20s | %-20s | %-15s | %-10s |", trs.StObj.getId(), trs.StObj.getName(), trs.getAvrg(), this.isPass(trs.getAvrg()));

                }
            }
            System.out.println("\n+----------------------------------------------------------------------------+");
        }

    }

    public void reportStudent() {
        String newStID;
        int pos;
        Student sub;
        String name = "";
        int i = 0;
        do {
            newStID = Inputter.inputString("Enter Student ID: ");
            pos = student.indexOf(new Student(newStID));
            if (pos < 0) {
                System.err.println("**NOT FOUND!**");
            } else {
                sub = student.get(pos);
                name = sub.getName();
            }
        } while (pos < 0);

        boolean check = transcript.containStudent(newStID);

        if (check == false) {
            System.err.println("**IT IS NOT DEPLOYED YET!**");
        } else {
            System.out.println("STudent Name: " + name);
            System.out.println("+------------------------------------------------------------------+");
            System.out.printf("| %-10s | %-20s | %-15s | %-10s |", "No.", "Student name", "Average mark", "Status");
            System.out.print("\n+------------------------------------------------------------------+");
            for (Transcript trs : this.transcript) {
                if (trs.StObj.id.equals(newStID)) {
                    i++;
                    System.out.printf("\n| %-10s | %-20s | %-15s | %-10s |", i, trs.SubObj.subName, trs.getAvrg(), this.isPass(trs.getAvrg()));

                }
            }
            System.out.println("\n+------------------------------------------------------------------+");
        }

    }
}
 //    print Student grade format
//    public void stGradeReport(TranscriptList grade, String stID, String fName, String lName) {
//
//        String status;
//        System.out.println("");
//        System.out.println("Student ID: " + stID);
//        System.out.println("Student name: " + fName + " " + lName);
//        System.out.println("List of subject sort by Subject Name");
//        System.out.println("|++ No ++| +++++++ Subject name +++++++ | +++ Average mark +++ | ++ Status ++");
//        for (int i = 0; i < grade.size(); i++) {
//
//            if (isPass(grade.get(i).getAvrg())) {
//                status = "Pass";
//            } else {
//                status = "Not Pass";
//            }
//
//            System.out.println("    " + i + "\t\t   " + grade.get(i).getStObj().getName() + String.format("\t\t      %,.1f", grade.get(i).getAvrg()) + "   \t\t" + status);
//        }
//        System.out.println("\n");
//    }
//
//    public void reportStudent() {
//        if (this.transcript.isEmpty()) {
//            System.out.println("**EMPTY LIST!**");
//        }
//        {
//            for (Transcript trs : transcript) {
//                System.out.printf("\n| %-10s | %-20s | %-10s |", trs.getStObj().getId(), trs.getSubObj().getSubName(), trs.getAvrg());
//            }
//        }
//
//    }
//    public void printStudentGrade() {
//        boolean stopOperation;
//        TranscriptList arrayResult = new TranscriptList();
//        String stID;
//        do {
//            stID = Inputter.inputNonBlankStr("Input student ID:");
//            stID = stID.toUpperCase();
//            if (student.contains(stID)) {
//                // case student id has been founded
//                for (int i = 0; i < transcript.size(); i++) {
//                    if (transcript.get(i).getStObj().getId().equals(stID)) {
//                        Student stObj = transcript.get(i).getStObj();
//                        Subject subObj = transcript.get(i).getSubObj();
//                        double lab = transcript.get(i).getLabMark();
//                        double test = transcript.get(i).getTestMark();
//                        double finalm = transcript.get(i).getFinalMark();
//                        Transcript transcript = new Transcript(stObj, subObj, lab, test, finalm);
//                        arrayResult.add(transcript);
//                    }
//                }
//                Collections.sort(arrayResult, Transcript.compareByName);
//                stGradeReport(arrayResult, student.search(stID).getId(), student.search(stID).getFname(), student.search(stID).getLname());
//                break;
//
//            } else {
//                System.out.println("Student does not exist.");
//                // student id cannot founded
//                System.out.println("Do you want to continue or not?(Y/N)");
//                String strChoice = sc.nextLine();
//                strChoice = strChoice.trim().toUpperCase();
//                if (strChoice.equals("Y")) {
//                    stopOperation = false;
//                } else {
//                    return;
//                }
//            }
//            if (stopOperation == true) {
//                break;
//            }
//        } while (stopOperation == false);
//    }

