

class Solution { // Count Inversion

    public void merge(int[] nums, int left, int mid, int right) { // O(n)
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] A = new int[n1];
        int[] B = new int[n2];
        for (int i = 0; i < n1; i++) {
            A[i] = nums[left + i];
        }
        for (int i = 0; i < n2; i++) {
            B[i] = nums[mid + 1 + i];
        }
        // merge two sorted arrays
        // left->mid > A  mid+1->right > B,, nums[left -> right]
        // merge two sorted arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (A[i] <= B[j]) {
                nums[k++] = A[i++];
            } else {
                nums[k++] = B[j++];
            }
        }
        // [1,2,3] , [5,6,7] |  , [5,6,7]  [1,2,3]
        while (i < n1) nums[k++] = A[i++];
        while (j < n2) nums[k++] = B[j++];
    }

    public void mergeSort(int[] nums, int left, int right) { // O(n * log n)
        if (left < right) {
            int mid = left + (right - left) / 2; // (left+right)/2
            mergeSort(nums, left, mid); // left partition
            mergeSort(nums, mid + 1, right); // right partition
            merge(nums, left, mid, right); // A=nums[left->mid], B=nums[mid+1 ->right]
        }
    } // TC: O(n * log n), SC: O(n)

    public int[] sortArray(int[] nums) {
        int left = 0, right = nums.length - 1;
        mergeSort(nums, left, right);
        return nums;
    }
}