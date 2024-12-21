class Solution {
    public int findDays(int weights[], int capacity) {
        int days = 1;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            if ((weights[i] + sum) <= capacity) {
                sum += weights[i];
            } else {
                sum = weights[i];
                days++;
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int left = Integer.MIN_VALUE;
        int right = 0;
        for (int i = 0; i < n; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            if (findDays(weights, mid) <= days) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}