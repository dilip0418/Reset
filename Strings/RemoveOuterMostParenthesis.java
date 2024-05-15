package Strings;

public class RemoveOuterMostParenthesis {
    public static void main(String[] args) {
        // String s = "(()())(())"; // output: "()()()"
        String s = "(()())(())(()(()))"; // output: "()()()()(())"
        // String s = "()()"; // output: ""

        System.out.println(removeOuterParenthesis(s));
    }

    private static String removeOuterParenthesis(String s) {

        StringBuilder ans = new StringBuilder();

        // using the counter to keep track of open & close parenthesis
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            /*
             * if the current parenthesis is '(' open then check whether the count is
             * greater than 0 - if count = 0 then the current '(' will be an outermost one.
             */
            if (s.charAt(i) == '(' && count++ > 0)
                ans.append('(');
            /*
             * Similarly in order to append an '(' there should be opened parenthesis that
             * is the count should be greater then 1
             */
            else if (s.charAt(i) == ')' && count-- > 1)
                ans.append(')');

            /*
             * Note:
             * Observe that we are using post increment operators in the coditions itself
             * that will ensure the count can be used for validating both open as well as
             * closed parenthesis updates simultaneously irrespective of the type of
             * parenthesis (open | close) otherwise we can do so by having two separate
             * variables for open and close.
             */
        }
        return new String(ans);
    }
}
