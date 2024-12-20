class Solution {
    public boolean possible(int arr[], int day, int m, int k) {
        int bloomed = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day) {
                bloomed++;
                if (bloomed == k) {
                    count++;
                    bloomed = 0;
                    if (count == m) {
                        return true;
                    }
                }

            } else {
                bloomed = 0;
            }

        }
        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < (long) m * k) {
            return -1;
        }
        int min = bloomDay[0];
        int max = bloomDay[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }
        int left = min, right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (possible(bloomDay, mid, m, k)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}