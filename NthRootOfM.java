class Solution {
    public int nthRoot(int n, int m) {
        int left = 1;
        int right = m;
        while (left <= right) {

            int mid = (left + right) / 2;
            int midpown = (int) Math.pow(mid, n);

            if (midpown == m) {
                return mid;
            } else if (midpown > m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}