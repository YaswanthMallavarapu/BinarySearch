class Solution {
    public int first(int arr[], int n, int k) {
        int left = 0, right = n - 1;
        int first = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == k) {
                first = mid;
                right = mid - 1;
            } else if (arr[mid] > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return first;
    }

    public int last(int arr[], int n, int k) {
        int left = 0, right = n - 1;
        int last = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == k) {
                last = mid;
                left = mid + 1;
            } else if (arr[mid] > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return last;
    }

    public int[] searchRange(int[] arr, int k) {
        int n = arr.length;
        int f = first(arr, n, k);
        if (f == -1)
            return new int[] { -1, -1 };
        int l = last(arr, n, k);
        return new int[] { f, l };
    }
}