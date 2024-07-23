package Strings;

public class StringCompressor {

    public static String compressedString(String message) {
        if (message == null || message.isEmpty()) {
            return "";
        }

        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 1; i < message.length(); i++) {
            if (message.charAt(i) == message.charAt(i - 1)) {
                count++;
            } else {
                if (count == 1) {
                    compressed.append(message.charAt(i - 1));
                } else {
                    compressed.append(message.charAt(i - 1)).append(count);
                }
                count = 1;
            }
        }

        // Handle the last group
        if (count == 1) {
            compressed.append(message.charAt(message.length() - 1));
        } else {
            compressed.append(message.charAt(message.length() - 1)).append(count);
        }

        return compressed.toString();
    }

    public static void main(String[] args) {
        String message = "abaasass";
        System.out.println(compressedString(message)); // Output: "aba2sas2"
    }
}