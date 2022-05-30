package myUlti;

import static data.StudentList.sc;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Inputter {

    public static Scanner sc = new Scanner(System.in);
    public static int inputInt(String msg, int min, int max) {
        if (min > max) {
            int temp;
            temp = min;
            min = max;
            max = temp;
        }
        int data;
        do {
            System.out.print(msg);
            data = Integer.parseInt(sc.nextLine());
        } while ((data < min) || (data > max));
        return data;
    }
    public static Double inputDouble(String msg, int min, int max) {
        if (min > max) {
            int temp;
            temp = min;
            min = max;
            max = temp;
        }
        double data;
        do {
            System.out.print(msg);
            data = Double.parseDouble(sc.nextLine());
        } while ((data < min) || (data > max));
        return data;
    }

    public static String inputString(String msg) {
        System.out.print(msg);
        String data = sc.nextLine().trim().toUpperCase();
        return data;
    }
    
    public static String inputStringNum(String msg){
        String data;
        do {
            System.out.print("Enter Phone number: ");
            data = sc.nextLine();
            if ((data.length() < 10) || (data.length() > 12)) {
                System.out.println("10 - 12 number!");
            }
        } while ((data.length() < 10) || (data.length() > 12));

    return data;
    }
    
    public static boolean checkNext(String msg) {
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
                        case 'Y':
                        case '1':
                        case 'T':
                            return true;
                        case '0':
                        case 'F':
                        case 'N':
                            return false;

                        default:
                            throw new Exception();
                    }
//                    if (strChoice.equals("Y")) {
//                    stopOperation = false;
//                } else {
//                    return;
//                }
//            }
//            if (stopOperation == true) {
//                break;
//            }

                }

            } catch (Exception e) {
                System.out.println("Data Invalid! Try again.");
                flag = true;
            }
        } while (flag);

        return false;
    }

    public static String inputNonBlankStr(String msg) {
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();
        } while (data.length() == 0);
        return data;
    }

    public static String inputPattern(String msg, String pattern) {
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();
        } while (!data.matches(pattern));
        return data;
    }

    public static final int DMY = 0;
    public static final int MDY = 1;
    public static final int YMD = 2;

    public static boolean isLeap(int y) {
        boolean result = false;
        if ((y % 400 == 0) || ((y % 4 == 0) && (y % 100 != 0))) {
            result = true;
        }
        return result;
    }

    public static boolean valid(int y, int m, int d) {
        if (y < 0 || m < 0 || m > 12 || d < 0 || d > 31) {
            return false;
        }

        int maxD = 31;
        if (m == 4 || m == 6 || m == 9 || m == 11) {
            maxD = 30;
        } else if (m == 2) {
            if (isLeap(y)) {
                maxD = 29;
            } else {
                maxD = 28;
            }
        }
        return d <= maxD;
        // chuyển y, m,dsang kiểu Date
    }

    public static Date toDate(int y, int m, int d) {
        if (!valid(y, m, d)) {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.set(y, m - 1, d); // month number: 0..11
        return cal.getTime();
    }
    // chuyển chuỗi ngày tháng thành Date theo một format

    public static Date toDate(String dateStr, int dateFormat) {
        int yIndex, mIndex, dIndex;
        switch (dateFormat) {
            case YMD:
                yIndex = 0;
                mIndex = 1;
                dIndex = 2;
                break;
            case MDY:
                yIndex = 2;
                mIndex = 0;
                dIndex = 1;
                break;
            case DMY:
                yIndex = 2;
                mIndex = 1;
                dIndex = 0;
                break;
            default:
                return null;

        }
        // cắt chuỗi thành3phần
        String[] parts = dateStr.split("[/-]");
// Nếu không đủ3phẩn
        if (parts.length != 3) {
            return null;
        }
// đủ3phấn, tách ra y, m,d
        int y = Integer.parseInt(parts[yIndex]);
        int m = Integer.parseInt(parts[mIndex]);
        int d = Integer.parseInt(parts[dIndex]);
        return toDate(y, m, d); // chuyển đổi sang Date
    }
// Các hàm đọc ngày tháng

    public static Date readMDY(String message) {
        Date d;
        String S;
        do {
            System.out.print(message + "[m/d/y]: ");
            S = sc.nextLine().trim();
            d = toDate(S, MDY);
            if (d == null) {
                System.out.println("Invalid date!");
            }
        } while (d == null);
        return d;
    }
    
  

    public static Date readDMY(String message) {
        Date d;
        String S;
        do {
            System.out.print(message + "[d/m/y]: ");
            S = sc.nextLine().trim();
            System.out.println(S);
            d = toDate(S, DMY);
            if (d == null) {
                System.out.println("Invalid date!");
            }
            //
        } while (d == null);
        return d;
    }

    public static Date readYMD(String message) {
        Date d;
        String S;
        do {
            System.out.print(message + "[y/m/d]: ");
            S = sc.nextLine().trim();
            d = toDate(S, YMD);
            if (d == null) {
                System.out.println("Invalid date!");
            }
        } while (d == null);
        return d;

    }

    public static String strDMY(Date d) {
        String s = "";
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return s + c.get(Calendar.DATE) + '-' + (c.get(Calendar.MONTH) + 1) + '-' + c.get(Calendar.YEAR);
    }

    public static String strMDY(Date d) {
        String s = "";
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return s + (c.get(Calendar.MONTH) + 1) + '-' + c.get(Calendar.DATE) + '-' + c.get(Calendar.YEAR);
    }
}
