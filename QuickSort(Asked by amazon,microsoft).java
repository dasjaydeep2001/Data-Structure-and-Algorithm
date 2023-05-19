class Solution {
    //FunctFion to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        if (low < high) {
            int pi = partition(arr, low, high); // sorted_element_index
            quickSort(arr, low, pi - 1); // left
            quickSort(arr, pi + 1, high); // right
        }
    }
    static int partition(int arr[], int low, int high)
    {
        int i = low - 1; // 0 ~ i : always element less than pivot
        int pivot = arr[high];
        for (int j = low; j < high; j++) {
            if (pivot > arr[j]) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}