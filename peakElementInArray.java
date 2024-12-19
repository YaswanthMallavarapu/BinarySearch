class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[n - 1] > nums[n - 2])
            return n - 1;
        // for(int i=1;i<n-1;i++){
        // if(nums[i]>nums[i-1] && nums[i]>nums[i+1]){
        // return i;
        // }
        // }
        int left = 1, right = n - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                // peak on right
                left = mid + 1;
            } else {
                // peak on left
                right = mid - 1;
            }
        }
        return -1;
    }
}