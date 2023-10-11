package com.company;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        int year;
        do {
            System.out.println("Nabídka operací: ");
            System.out.println("1-zjištění přestupného roku");
            System.out.println("2-zjištění přestupného roku podle aktuálního data");
            System.out.println("3-vypsání systémového času ");
            System.out.println("4-vypsání zbývajícího času do určitého data ");
            System.out.println("5-konec programu");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Zadej rok: ");
                    year = sc.nextInt();
                    boolean leap = false;
                    if (year % 4 == 0) {
                        if (year % 100 == 0) {
                            if (year % 400 == 0)
                                leap = true;
                            else
                                leap = false;
                        } else
                            leap = true;
                    } else
                        leap = false;

                    if (leap)
                        System.out.println(year + " je přestupný rok");
                    else
                        System.out.println(year + " není přestupný rok");

                    break;
                case 2:
                    int currentYear = Year.now().getValue();
                    boolean leap2 = false;
                    if (currentYear % 4 == 0) {
                        if (currentYear % 100 == 0) {
                            if (currentYear % 400 == 0)
                                leap2 = true;
                            else
                                leap2 = false;
                        } else
                            leap2 = true;
                    } else
                        leap2 = false;

                    if (leap2)
                        System.out.println(currentYear + " je přestupný rok");
                    else
                        System.out.println(currentYear + " není přestupný rok");


                    boolean foundLeapYear = false;

                    while (!foundLeapYear) {
                        currentYear++;

                        boolean nextLeap = false;
                        if (currentYear % 4 == 0) {
                            if (currentYear % 100 == 0) {
                                if (currentYear % 400 == 0)
                                    nextLeap = true;
                            } else {
                                nextLeap = true;
                            }
                        }

                        if (nextLeap) {
                            System.out.println(currentYear + " je další přestupný rok");
                            foundLeapYear = true;
                        }
                    }
                    break;

                case 3:
                    long timeNow = System.currentTimeMillis();
                    Date currDate = new Date(timeNow);
                    SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                    String formatedDate = myFormat.format(currDate);
                    System.out.println("Aktuální čas: " + formatedDate);
                    break;
                case 4:
                    Calendar calendar = Calendar.getInstance();
                    int actYear = calendar.get(Calendar.YEAR);
                    int actMonth = calendar.get(Calendar.MONTH) + 1;
                    int actDay = calendar.get(Calendar.DAY_OF_MONTH);
                    System.out.print("Zadejte rok: ");
                    int tarYear = sc.nextInt();
                    System.out.print("Zadejte měsíc (1-12): ");
                    int tarMonth = sc.nextInt();
                    System.out.print("Zadejte den: ");
                    int tarDay = sc.nextInt();
                    int yearsLeft = tarYear - actYear;
                    int monthsLeft;
                    int daysLeft;

                    
                    if (tarMonth >= actMonth) {
                        monthsLeft = tarMonth - actMonth;
                    } else {
                        monthsLeft = 12 - actMonth + tarMonth;
                        yearsLeft--;
                    }

                    if (tarDay >= actDay) {
                        daysLeft = tarDay - actDay;
                    } else {
                        int dayInMonths = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
                        daysLeft = dayInMonths - actDay + tarDay;
                        if (actMonth == 12) {
                            monthsLeft--;
                        }
                    }

                    System.out.println("Zbývá " + yearsLeft + " let, " + monthsLeft + " měsíců, " + daysLeft + " dní, ");
                    break;
                default:
                    System.out.println("Nesprávná hodnota");
            }
        } while (choice > 0);
    }
}
