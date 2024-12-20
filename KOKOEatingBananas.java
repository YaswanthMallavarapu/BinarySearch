class Solution {
    public boolean canEat(int piles[], int h, int k) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += Math.ceil((double) piles[i] / k);
        }
        if (hours <= h) {
            // System.out.println(hours);
            return true;
        } else {
            return false;
        }
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        int n = piles.length;
        for (int i = 0; i < n; i++) {
            if (max < piles[i]) {
                max = piles[i];
            }
        }
        int left = 1, right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canEat(piles, h, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}