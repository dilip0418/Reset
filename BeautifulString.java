public class BeautifulString {

    public static int makeBeautiful(String str) {
        char[] ch = str.toCharArray();
        int changes = 0;
        for (int i = 1; i < ch.length; i++) {
            if (ch[i - 1] == ch[i]) {
                if (ch[i - 1] == '0') {
                    ch[i] = '1';
                } else {
                    ch[i] = '0';
                }
                changes++;
            }
        }
        return changes;
    }

    public static void main(String[] args) {
        // String str = "01010110101";
        String str = "0000";
        System.out.println(makeBeautiful(str));
    }
}
