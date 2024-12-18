class Solution {
    public int findMin(int[] arr) {
        int left = 0, right = arr.length - 1;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[left] <= arr[mid]) {
                if (arr[left] <= min) {
                    min = arr[left];
                }

                left = mid + 1;
            } else {
                if (min > arr[mid]) {
                    min = arr[mid];
                }
                right = mid - 1;
            }

        }
        return min;
    }
}