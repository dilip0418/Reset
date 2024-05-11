package KnowBasicMaths;

import java.util.Scanner;

/**
 * CountDigits
 */
public class CountDigits {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int number = scanner.nextInt();
            int count = 0;
            System.out.print("The number has " + number + ", ");
            while (number != 0) {
                count++;
                number = number / 10;
            }
            System.out.println(count + " digits in it.");
        }
    }
}