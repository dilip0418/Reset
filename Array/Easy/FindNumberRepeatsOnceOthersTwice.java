package Array.Easy;

public class FindNumberRepeatsOnceOthersTwice {
    public static void main(String[] args) {
        int[] arr = new int[] { 4, 1, 2, 1, 2 }; // unsorted array
        System.out.println(findNumberRepeatsOnce(arr, arr.length));

        int[] arr1 = new int[] { 2, 2, 5, 5, 20, 30, 30 }; // sorted array
        System.out.println(findNumberRepeatsOnceForSortedArr(arr1, arr1.length));
    }

    private static int findNumberRepeatsOnceForSortedArr(int[] arr1, int n) {
        // if the arr size is 1 return the element.
        if (n == 1)
            return arr1[0];

        // check for the cases (boundaries i.e at 0th index and (n-1)th index)
        if (arr1[0] != arr1[1])
            return arr1[0];
        if (arr1[n - 1] != arr1[n - 2])
            return arr1[n - 1];

        // applying binary search
        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            /*
             * check for the adjacent numbers if the mid element is different then return
             * the mid element.
             */
            if (arr1[mid] != arr1[mid + 1] && arr1[mid] != arr1[mid - 1]) {
                return arr1[mid];
            }
            /*
             * The intuition behind this approach is that since all elements appear twice
             * except for one, if we look at any index and see that it's not repeating, then
             * the unique number must lie on the side where the repetition pattern is
             * broken. By leveraging binary search, this algorithm efficiently narrows down
             * the search space until it finds the unique element.
             * 
             * If the mid is at even index then the pattern is to check for the element
             * next (mid + 1) index.
             * And if the mid is at odd index then we have check for the element at
             * previous (mid -1) index.
             *
             * Adjusting Search Range:
             * 
             * If the mid element is not unique, it checks whether the mid is at an even or
             * odd index. If it's at an even index and the mid element is equal to its next
             * element, then the unique element lies to the right of mid, so it moves the
             * low pointer to mid + 1. Similarly, if the mid element is at an odd index and
             * it's equal to its previous element, then the unique element lies to the right
             * of mid, so it moves the low pointer to mid + 1.
             * 
             * Otherwise, the unique element lies to the left of mid, so it moves the
             * high pointer to mid - 1.
             */
            else if ((mid & 1) == 1 && (arr1[mid] == arr1[mid - 1])
                    || (mid & 1) == 0 && (arr1[mid] == arr1[mid + 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /*
     * Intuition: using XOR logical operator.
     * XORing a number with itself will nullify the number to 0.
     * As the problem states that all the numbers except one will be repeated twice
     * Hence xoring all the numbers will ultimately leave us the number that is
     * repeated only once.
     */
    private static int findNumberRepeatsOnce(int[] arr, int n) {
        if (n == 1)
            return arr[0];

        int XOR = 0; // we can take the first element in the array

        /*
         * start with index 0 if XOR = 0 orelse start from index 1
         * becuase if first element is the output (the number whose frequency is 1)
         * then if will be lost because XORing a number with same number will make it 0.
         */
        for (int i = 0; i < n; i++) {
            XOR ^= arr[i];
        }

        return XOR;
    }
}
