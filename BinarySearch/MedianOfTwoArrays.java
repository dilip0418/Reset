package BinarySearch;


public class MedianOfTwoArrays {
    public static void main(String[] args) {
        int[] a = new int[]{2, 4, 6};
        int[] b = new int[]{1, 3, 5};

        System.out.println("The median of two arrays a and b:"+medianOfTwoArrays(a, b));
    }

    private static double medianOfTwoArrays(int[] a, int[] b) {
        int aMid = a[a.length/2];
        int bMid = b[b.length/2];

        return (aMid + bMid)/(2.0);
    }
}
