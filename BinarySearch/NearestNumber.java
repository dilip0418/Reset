package BinarySearch;

public class NearestNumber {
    public static void main(String[] args) {
        // int[] arr = { 4, 5, 5, 6, 8, 12, 14, 16, 16, 19 };
        // int k = 10;
        // int[] arr = { 1, 2, 3, 5, 6, 8, 9 };
        // int k = 4;
        // int[] arr = { 2, 4, 5, 5, 13, 16, 17, 20 };
        // int k = 11; // output = 13
        int[] arr = { 1, 1, 2, 2, 2, 4, 4, 5, 5, 5, 5, 6, 7, 7, 7, 7, 8, 8, 9, 10, 11, 11, 11, 12, 12, 12, 14, 14, 14,
                15, 16, 16, 16, 16, 17, 17, 18, 19, 20, 21, 22, 24, 24, 24, 25, 25, 27, 27, 28, 30, 31, 31, 32, 32, 32,
                33, 33, 33, 33, 34, 35, 37, 37, 38, 38, 38, 38, 39, 42, 42, 42, 43, 43, 44, 44, 44, 45, 46, 48, 49, 49,
                49, 49, 50, 50, 50, 50, 51, 51, 51, 52, 52, 52, 53, 54, 56, 56, 56, 57, 58, 58, 59, 59, 59, 60, 60, 60,
                61, 61, 61, 61, 62, 63, 64, 64, 65, 66, 66, 67, 68, 68, 68, 68, 70, 70, 70, 70, 71, 71, 72, 73, 73, 73,
                73, 73, 74, 74, 74, 75, 75, 76, 77, 78, 80, 80, 80, 81, 81, 83, 83, 83, 84, 85, 85, 86, 87, 88, 88, 88,
                88, 89, 89, 90, 90, 91, 91, 92, 92, 94, 94, 95, 95, 96, 97, 97, 97, 98, 99, 99, 99, 100, 111, 119, 122,
                129, 132, 137, 153, 158, 162, 163, 166, 169, 172, 189, 192, 200, 213, 225, 227, 228, 229, 229, 231, 233,
                235, 241, 244, 247, 254, 254, 264, 269, 278, 281, 283, 289, 289, 293, 306, 310, 313, 324, 325, 327, 333,
                337, 355, 371, 371, 372, 376, 377, 378, 386, 390, 398, 407, 409, 418, 419, 431, 432, 435, 457, 464, 473,
                482, 495, 499, 503, 506, 509, 509, 512, 517, 524, 529, 533, 548, 551, 560, 561, 569, 572, 574, 574, 582,
                596, 606, 610, 620, 622, 632, 633, 638, 639, 649, 650, 654, 655, 662, 668, 669, 684, 687, 691, 696, 700,
                701, 702, 702, 708, 710, 711, 712, 716, 719, 724, 735, 743, 746, 749, 756, 762, 764, 766, 773, 778, 791,
                795, 797, 800, 801, 804, 808, 822, 823, 832, 844, 846, 848, 850, 852, 853, 862, 865, 867, 871, 872, 874,
                875, 892, 895, 895, 917, 924, 929, 933, 939, 945, 948, 948, 954, 958, 965, 983, 984, 990, 991, 1000,
                1014, 1065, 1101, 1118, 1259, 1379, 1413, 1473, 1503, 1518, 1554, 1644, 1653, 1697, 1704, 1772, 1772,
                1779, 1829, 1843, 1949, 1958, 1972, 2011, 2069, 2107, 2169, 2233, 2395, 2409, 2461, 2467, 2539, 2576,
                2587, 2639, 2658, 2779, 2800, 2924, 3030, 3042, 3051, 3262, 3332, 3356, 3366, 3411, 3486, 3491, 3527,
                3567, 3628, 3755, 3793, 3795, 4086, 4160, 4238, 4250, 4265, 4267, 4271, 4379, 4381, 4503, 4590, 4594,
                4602, 4638, 4682, 4733, 4922, 4949, 4953, 4963, 5004, 5088, 5108, 5275, 5292, 5293, 5315, 5319, 5552,
                5583, 5637, 5706, 5738, 5801, 5836, 5836, 5891, 5930, 5993, 5997, 6081, 6278, 6322, 6348, 6411, 6411,
                6439, 6524, 6678, 6762, 6811, 6832, 6924, 6954, 7044, 7051, 7156, 7201, 7209, 7217, 7230, 7276, 7371,
                7391, 7418, 7577, 7890, 7985, 8039, 8075, 8079, 8132, 8137, 8297, 8383, 8469, 8618, 8619, 8658, 8734,
                8787, 8808, 8915, 8917, 8945, 9164, 9168, 9315, 9336, 9348, 9375, 9383, 9436, 9478, 9511, 9597, 9620,
                9640, 9652, 9699, 9762, 9845, 9858, 9972, 9975, 11395, 11553, 11809, 12083, 12436, 12963, 13015, 13221,
                13393, 13560, 13701, 14505, 14786, 14871, 15171, 15251, 18305, 18915, 18916, 19503, 19894, 20028, 20134,
                20493, 20981, 22559, 23099, 23169, 23823, 24902, 25084, 25121, 25803, 25844, 26316, 26375, 26546, 26727,
                27307, 28252, 28429, 28865, 29371, 29761, 29821, 29905, 30186, 31047, 32851, 33246, 33451, 35507, 35677,
                35820, 36896, 37893, 38684, 39124, 39281, 39725, 40367, 40715, 41176, 41341, 42632, 42772, 43040, 43086,
                43147, 44695, 44798, 45159, 45769, 45888, 46642, 48750, 48756, 48766, 48776, 49819, 49913, 51454, 51477,
                51556, 51687, 52123, 52184, 53062, 53071, 53088, 55018, 55702, 55789, 56427, 56506, 56705, 57346, 57355,
                57583, 58486, 61226, 61227, 63116, 63264, 63954, 64177, 64368, 64515, 64525, 65142, 65556, 66183, 66371,
                67268, 68221, 69113, 69204, 69545, 70136, 70429, 70556, 70794, 71925, 72488, 72887, 73563, 73689, 73797,
                74216, 74274, 74299, 74375, 74424, 76186, 76792, 76952, 78327, 78824, 80451, 80463, 80621, 80820, 80887,
                81533, 82705, 83191, 84818, 85481, 87378, 87395, 87764, 87966, 88372, 90607, 92277, 92553, 92703, 92734,
                94262, 94455, 94818, 95009, 95643, 95673, 95947, 96078, 96539, 96706, 97072, 97871, 97897, 98528, 99428,
                107696, 127254, 131713, 133958, 142221, 145584, 146929, 153980, 158688, 163341, 166980, 173878, 184543,
                186956, 191872, 194880, 197329, 208371, 208870, 209478, 214002, 215511, 215580, 215854, 217124, 222430,
                223745, 233792, 235483, 237653, 238303, 240506, 241549, 245098, 246572, 248360, 254738, 270162, 274029,
                275454, 281462, 283593, 285803, 292672, 297850, 298815, 307271, 317541, 321846, 323195, 332163, 332205,
                336493, 341089, 353184, 353894, 358362, 366538, 383984, 387769, 388830, 389509, 390263, 391868, 407326,
                417335, 419673, 428804, 430839, 435315, 435553, 438176, 439022, 441328, 450231, 451924, 454911, 455280,
                456131, 459038, 460250, 464176, 464619, 468829, 472695, 477552, 478937, 481692, 484563, 488174, 492078,
                500143, 500207, 500912, 503486, 507786, 509216, 509942, 511430, 513915, 528544, 533001, 533580, 559965,
                562396, 563482, 564158, 566151, 567269, 568661, 570634, 592029, 601832, 611744, 620746, 621925, 625840,
                636754, 638232, 639735, 639959, 648232, 651534, 653287, 658913, 667162, 667861, 675578, 686144, 688094,
                697913, 698522, 705300, 706723, 723976, 724191, 727735, 728380, 736868, 737926, 738421, 739801, 740580,
                747367, 751471, 761360, 774292, 780835, 782966, 785678, 795109, 797555, 824553, 833978, 838992, 839603,
                842489, 848093, 865110, 879476, 884900, 889428, 890319, 893018, 893917, 898422, 904201, 906212, 907000,
                914430, 931667, 935069, 935707, 936487, 942685, 944461, 944470, 957700, 957781, 959022, 969745, 978031,
                981314, 982199, 984014 };
        int k = 984181; // output = 13
        System.out.println(nearestNumberBruteForce(arr, k, arr.length));
        System.out.println(nearestNumber(arr, k, arr.length));
    }

    private static int nearestNumberBruteForce(int arr[], int k, int n) {
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int temp = Math.abs(k - arr[i]);
            if (temp <= min) {
                min = temp;
                ans = arr[i];
            }
        }
        return ans;
    }

    private static int nearestNumber(int[] arr, int k, int n) {
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == k)
                return arr[mid];
            else if (arr[mid] < k)
                left = mid + 1;
            else
                right = mid - 1;
        }

        if (left > 0 && Math.abs(arr[left] - k) <= Math.abs(arr[left - 1] - k))
            return arr[left];
        else
            return arr[left - 1];
    }
}