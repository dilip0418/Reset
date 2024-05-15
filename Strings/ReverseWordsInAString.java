package Strings;

/* 
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. 
The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note: that s may contain leading or trailing spaces or multiple spaces between two words. 
The returned string should only have a single space separating the words. 
Do not include any extra spaces. 
*/
public class ReverseWordsInAString {
    public static void main(String[] args) {
        // String str = "the sky is blue";
        String str = " hello world ";
        // String str = "a good example";
        // System.out.println(reverseWords(str));
        System.out.println(reverseWordsWithoutUtils(str));
    }

    // using the built-in utils of java
    private static String reverseWords(String str) {

        // using string utils and regex expression
        String[] words = str.trim().split("\s+");
        StringBuilder sb = new StringBuilder();

        // traversing the string array from the last and appending it to the ans string
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }

        // remove the space suffixed for the last word before returning
        return sb.toString().trim();
    }

    private static String reverseWordsWithoutUtils(String str) {
        int i = str.length() - 1;

        StringBuilder ans = new StringBuilder();

        while (i >= 0) {

            // remove the trailing spaces by moving i until a non-space character
            while (i >= 0 && str.charAt(i) == ' ')
                i--;

            /*
             * here at this point the i will be pointing to the last character of a word in
             * the sentence, assign j = i
             */
            int j = i;

            // this condition will ensure that the algo stops if the all words are reversed
            if (i < 0)
                break;

            /*
             * move i untill a space is encountered, this is used to get words any word will
             * be from (i+1){since i stops at a space} to j
             */
            while (i >= 0 && str.charAt(i) != ' ')
                i--;

            /*
             * In order to add spaces between the words check whether the ans string is
             * empty
             * if the ans string is empty --> we are adding the first word from the last
             * therefore no need of prefixing a space. If the ans already has few words then
             * prefix a space before appending a new word.
             */
            if (ans.length() != 0) {
                ans.append(" " + str.substring(i + 1, j + 1));
            } else {
                ans.append(str.substring(i + 1, j + 1));
            }
        }

        return new String(ans);
    }
}
