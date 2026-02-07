import java.util.Arrays;

public final class SortedArrayMerger {

    private SortedArrayMerger() {}

    /**
     * Merges two sorted int arrays (non-decreasing order) into a single sorted array.
     * Runs in O(n + m) time.
     */
    public static int[] mergeSorted(int[] a, int[] b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Input arrays must not be null.");
        }

        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < a.length) {
            result[k++] = a[i++];
        }

        while (j < b.length) {
            result[k++] = b[j++];
        }

        return result;
    }


}
