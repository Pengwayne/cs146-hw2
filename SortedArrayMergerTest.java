import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortedArrayMergerTest {

    @Test
    void mergesTypicalCase() {
        int[] a = {1, 3, 5};
        int[] b = {2, 4, 6};

        int[] merged = SortedArrayMerger.mergeSorted(a, b);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, merged);
        assertTrue(SortedArrayMerger.isSortedNonDecreasing(merged));
    }

    @Test
    void handlesDuplicates() {
        int[] a = {1, 2, 2, 5};
        int[] b = {2, 2, 3};

        int[] merged = SortedArrayMerger.mergeSorted(a, b);

        assertArrayEquals(new int[]{1, 2, 2, 2, 2, 3, 5}, merged);
        assertTrue(SortedArrayMerger.isSortedNonDecreasing(merged));
    }

    @Test
    void handlesEmptyArrays() {
        assertArrayEquals(new int[]{}, SortedArrayMerger.mergeSorted(new int[]{}, new int[]{}));
        assertArrayEquals(new int[]{1, 2}, SortedArrayMerger.mergeSorted(new int[]{1, 2}, new int[]{}));
        assertArrayEquals(new int[]{1, 2}, SortedArrayMerger.mergeSorted(new int[]{}, new int[]{1, 2}));
    }

    @Test
    void handlesNegativeNumbers() {
        int[] a = {-5, -2, 0};
        int[] b = {-3, 1, 4};

        int[] merged = SortedArrayMerger.mergeSorted(a, b);

        assertArrayEquals(new int[]{-5, -3, -2, 0, 1, 4}, merged);
        assertTrue(SortedArrayMerger.isSortedNonDecreasing(merged));
    }

    @Test
    void handlesAlreadyAllLessOrAllGreater() {
        int[] a = {1, 2, 3};
        int[] b = {10, 11};

        int[] merged1 = SortedArrayMerger.mergeSorted(a, b);
        assertArrayEquals(new int[]{1, 2, 3, 10, 11}, merged1);
        assertTrue(SortedArrayMerger.isSortedNonDecreasing(merged1));

        int[] merged2 = SortedArrayMerger.mergeSorted(b, a);
        assertArrayEquals(new int[]{1, 2, 3, 10, 11}, merged2);
        assertTrue(SortedArrayMerger.isSortedNonDecreasing(merged2));
    }

    @Test
    void doesNotMutateInputs() {
        int[] a = {1, 3, 5};
        int[] b = {2, 4, 6};

        int[] aCopy = Arrays.copyOf(a, a.length);
        int[] bCopy = Arrays.copyOf(b, b.length);

        SortedArrayMerger.mergeSorted(a, b);

        assertArrayEquals(aCopy, a);
        assertArrayEquals(bCopy, b);
    }

    @Test
    void rejectsNullInputs() {
        assertThrows(IllegalArgumentException.class, () -> SortedArrayMerger.mergeSorted(null, new int[]{}));
        assertThrows(IllegalArgumentException.class, () -> SortedArrayMerger.mergeSorted(new int[]{}, null));
    }
}
