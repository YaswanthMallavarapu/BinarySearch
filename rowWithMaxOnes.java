class Solution {

    public int findOnes(int arr[]) {
        int n = arr.length;
        int left = 0, right = n - 1;
        if (arr[right] == 0)
            return 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == 1)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return n - left;
    }

    public int rowWithMax1s(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;
        int row = 0;
        int MaxOnes = 0;
        for (int i = 0; i < n; i++) {
            int ones = findOnes(arr[i]);
            if (ones > MaxOnes) {
                MaxOnes = ones;
                row = i;
            }
        }
        return row;
    }
}