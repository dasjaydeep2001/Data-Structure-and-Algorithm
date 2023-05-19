class Solution
{
    public static long merge(long[] nums, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        long[] A = new long[n1];
        long[] B = new long[n2];
        for (int i = 0; i < n1; i++) {
            A[i] = nums[left + i];
        }
        for (int i = 0; i < n2; i++) {
            B[i] = nums[mid + 1 + i];
        }
        long count = 0;
        // merge two sorted arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (A[i] > B[j]) {
                count += n1 - i; // (n1-1) - i + 1FF
                nums[k++] = B[j++];
            } else {
                nums[k++] = A[i++];
            }
        }
        while (i < n1) nums[k++] = A[i++];
        while (j < n2) nums[k++] = B[j++];
        return count;
    }

    public static long mergeSort(long[] nums, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2; // (left+right)/2
            count += mergeSort(nums, left, mid); // left
            count += mergeSort(nums, mid+1, right); // right
            count += merge(nums, left, mid, right); // merging two sorted arrays
        }
        return count;
    }

    static long inversionCount(long arr[], long N)
    {
        int left = 0, right = arr.length - 1;
        return mergeSort(arr, left, right);
    }
}