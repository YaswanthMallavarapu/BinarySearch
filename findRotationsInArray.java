class Solution {
    public int findKRotation(List<Integer> arr) {
        int n = arr.size();
        int left = 0, right = n - 1;
        int min = Integer.MAX_VALUE;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr.get(left) <= arr.get(mid)) {
                if (arr.get(left) < min) {
                    min = arr.get(left);
                    index = left;
                }
                left = mid + 1;
            } else {
                if (arr.get(mid) < min) {
                    min = arr.get(mid);
                    index = mid;
                }
                right = mid - 1;
            }
        }
        return index;
    }
}