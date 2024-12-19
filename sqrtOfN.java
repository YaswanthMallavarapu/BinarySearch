class Solution {
    int floorSqrt(int n) {
        // approach 1
        // (int)Math.sqrt(n);

        // approach 2
        // for(int i=1;i<=n;i++){
        // if(i*i>n){
        // return i-1;
        // }
        // }

        // approach 3
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((mid * mid) == n) {
                return mid;
            } else if ((mid * mid) > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}