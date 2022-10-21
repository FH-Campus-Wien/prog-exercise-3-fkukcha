/**
 * Author: Ferdaws Kukcha
 * Title: Exercise 3
 * Date of Commit: 21.10.2022
 */

package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {


    // Implement all methods as public static

    //Aufgabe 1
    public static void oneMonthCalendar(int monthDays, int firstDay) {

        for (int i = 0; i < 3*(firstDay-1); i++)
            System.out.print(" ");


        for (int i=1; i<=monthDays; i++) {

            if ((i + firstDay) / 7 > 0 && (i + firstDay) % 7 == 2)
                System.out.println("");
            if (i >= 1 && i <= 9)
                System.out.print(" ");

            System.out.print(i + " ");

        }

        System.out.println("");
    }


    //Aufgabe 2
    public static long[] lcg(long x_0) {

        long m = (long) Math.pow(2, 31);
        int a = 1_103_515_245;
        int c = 12_345;
        long[] arr = new long[10];

        for (int i=0; i<10; i++) {
            x_0 = (a * x_0 + c) % m;
            arr[i] = x_0;
        }
        return arr;
    }


    // Aufgabe 3
    public static void guessingGame(int numberToGuess) {

        Scanner scanner = new Scanner(System.in);

        int count = 1;

        do {

            System.out.print("Guess number " + count + ": ");
            int guessNum = scanner.nextInt();

            if (guessNum == numberToGuess) {
                System.out.println("You won wisenheimer!");
                break;
            } else if (count == 10) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                break;
            } else if (guessNum < numberToGuess) {
                System.out.println("The number AI picked is higher than your guess.");
            } else {
                System.out.println("The number AI picked is lower than your guess.");
            }

            count += 1;

        } while (count <= 10);
    }

    public static int randomNumberBetweenOneAndHundred() {
        Random randomNum = new Random();
        int randomOneToHundred = randomNum.nextInt(1,100);
        return randomOneToHundred;
    }


    // Aufgabe 4
    public static boolean swapArrays(int[] array1, int[] array2) {

        if (array1.length == array2.length) {

            int temp;

            for (int i=0; i<array1.length; i++) {
                temp = array1[i];
                array1[i] = array2[i];
                array2[i] = temp;
            }
            return true;

        }
        return false;

    }


    // Aufgabe 5
    public static String camelCase(String sentence) {
        char[] sentenceChar = sentence.toCharArray();
        int a = (int) 'a';            // 97
        int z = (int) 'z';            // 122
        int aUpperCase = (int) 'A';     // 65
        int zUpperCase = (int) 'Z';     // 90
        int blankSpace = (int) ' ';   // 32
        boolean checkIfUpper = true;
        boolean checkIfLower = false;

        StringBuilder modifiedString = new StringBuilder();
        String modifiedStringToString = "";

        for (int i=0; i<sentenceChar.length; i++) {
            if (sentenceChar[i] == blankSpace) {
                checkIfUpper = true;
                checkIfLower = false;
            }
            else if (checkIfUpper && (aUpperCase <= sentenceChar[i] && sentenceChar[i] <= zUpperCase ||
                    a <= sentenceChar[i] && sentenceChar[i] <= z)) {

                if (a <= sentenceChar[i] && sentenceChar[i] <= z)
                    modifiedString.append((char) (sentenceChar[i] - 32));
                else
                    modifiedString.append(sentenceChar[i]);

                checkIfUpper = false;
                checkIfLower = true;
            }
            else if (checkIfLower && (aUpperCase <= sentenceChar[i] && sentenceChar[i] <= zUpperCase ||
                    a <= sentenceChar[i] && sentenceChar[i] <= z)) {

                if (aUpperCase <= sentenceChar[i] && sentenceChar[i] <= zUpperCase)
                    modifiedString.append((char) (sentenceChar[i] + 32));
                else
                    modifiedString.append(sentenceChar[i]);
            }
        }

        modifiedStringToString = modifiedString.toString();

        return modifiedStringToString;

    }


    // Aufgabe 6
    public static int checkDigit(int[] arr) {

        int sum = 0;
        int sumMod11;

        for (int i=0; i<arr.length; i++) {
            sum += arr[i] * (i + 2);
        }

        sumMod11 = sum % 11;

        if (11 - sumMod11 == 11)
            return 5;
        else if (11 - sumMod11 == 10)
            return 0;


        return 11 - sumMod11;

    }




    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.

        App exercise3 = new App();

        // test oneMonthCalendar method
        App.oneMonthCalendar(28,5);

        // test randomNumberBetweenOneAndHundred method
        int randNum = App.randomNumberBetweenOneAndHundred();
        // test guessingGame method
        App.guessingGame(randNum);

        // test checkDigit method
        int[] myArr = {5, 1, 8, 3, 2, 9, 2, 4, 3};
        int pruefZiffer = App.checkDigit(myArr);
        System.out.println(pruefZiffer);

        // test camelCase
        String c = App.camelCase("hi23423f sdfsd !fds");
        System.out.println(c);

    }
}