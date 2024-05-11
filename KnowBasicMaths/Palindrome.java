package KnowBasicMaths;

import java.util.Scanner;

public class Palindrome {
    public static void checkPalindrome1(int number) {
        int reverseNumber = 0, temp = number;

        // find the reversed number
        while (temp != 0) {
            reverseNumber = (reverseNumber * 10) + (temp % 10);
            temp = temp / 10;
        }
        if (number == reverseNumber) {
            System.out.println(number + " is a palindrome");
        } else {
            System.out.println(number + " is not a palindrome");
        }
    }

    public static void checkPalindrome2(StringBuffer number) {
        if (number.equals(number.reverse()))
            System.out.println(number + " is a palindrome");
        else
            System.out.println(number + " is not a palindrome");
    }

    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        checkPalindrome1(number);
        StringBuffer num = new StringBuffer(String.valueOf(number));
        System.out.println(num);
        checkPalindrome2(num);

    }

}
