package POTD;

public class MailingProblem {
    public static void main(String[] args) {
        String keyBoard = "abcdefghijklmnopqrstuvwxyz";
        String s = "abc";
        System.out.println(timeTakenToMail(keyBoard, s));
    }

    public static int timeTakenToMail(String keyboard, String s) {
        // Write your code here.
        int sum = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int k = 0; k < keyboard.length(); k++) {
                if (s.charAt(i) == keyboard.charAt(k)) {
                    sum += Math.abs(k - j);
                    j = k;
                    break;
                }
            }
        }

        return sum;
    }

}
