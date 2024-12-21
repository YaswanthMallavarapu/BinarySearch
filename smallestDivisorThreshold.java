class Solution {
    public int findDivisor(int nums[], int mid) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += Math.ceil((double) nums[i] / mid);
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int max = nums[0];
        int ans = -1;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
        }
        int left = 1, right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (findDivisor(nums, mid) <= threshold) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}