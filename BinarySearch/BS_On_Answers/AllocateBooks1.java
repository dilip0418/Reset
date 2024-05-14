package BinarySearch.BS_On_Answers;

public class AllocateBooks1 {
    public static void main(String[] args) {

        /*
         * Scanner scanner = new Scanner(System.in);
         * int m = scanner.nextInt(); // Number of chapters
         * int n = scanner.nextInt(); // Number of days
         * int[] time = new int[m];
         * for (int i = 0; i < m; i++) {
         * time[i] = scanner.nextInt(); // Time required for each chapter
         * }
         */
        int chapters = 7, days = 4;
        int[] time = { 2, 2, 3, 3, 4, 4, 1 }; // output: 6
        long result = ayushGivesNinjatest(chapters, days, time);
        System.out.println("Minimal value of the maximum amount of time for which Ayush studies in a day is: " + result);
    }

    private static long numOfChapters(int[] time, long mid) {
        long chapter = 1;
        long timeTaken = 0;
        for (int i = 0; i < time.length; i++) {

            if (timeTaken + time[i] <= mid)
                timeTaken += time[i];
            else {
                timeTaken = time[i];
                chapter++;
            }
        }
        return chapter;
    }

    public static long ayushGivesNinjatest(int n, int m, int[] time) {

        long mini = Integer.MIN_VALUE;

        long sum = 0;

        for (int i = 0; i < m; i++) {
            sum += time[i];
            if (mini < time[i]) {
                mini = time[i];
            }
        }

        long low = mini;

        long high = sum;

        while (low <= high) {
            long mid = (low + high) / 2;
            if (numOfChapters(time, mid) <= m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}
