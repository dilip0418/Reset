package KnowBasicMaths;

import java.util.Scanner;

/**
 * Reverese a given number
 */
public class ReverseNumber {
    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        System.out.println("Number to be reversed " + number);
        int reverseNumber = 0;
        while (number != 0) {
            int temp = number % 10;
            reverseNumber = (reverseNumber * 10) + temp;
            number /= 10;
        }
        System.out.println("The reversed number is " + reverseNumber);
    }
}

/*
 * Another variant of this problem:
 * link:
 * https://www.codingninjas.com/studio/problems/count-digits_8416387?utm_source=
 * striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=
 * PROBLEM
 */