class Solution {
    // public boolean isPeak(int arr[][],int i,int j){
    // int n=arr.length;
    // int m=arr[0].length;
    // int top=-1,bottom=-1,left=-1,right=-1;
    // if(i-1>=0)top=arr[i-1][j];
    // if(i+1<n)bottom=arr[i+1][j];
    // if(j-1>=0)left=arr[i][j-1];
    // if(j+1<m)right=arr[i][j+1];
    // return (arr[i][j]>left) && (arr[i][j]>right) && arr[i][j]>top &&
    // arr[i][j]>bottom;
    // }
    public int findMax(int arr[][], int n, int row) {
        int max = -1;
        int maxIdx = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i][row] > max) {
                max = arr[i][row];
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        // for(int i=0;i<n;i++){
        // for(int j=0;j<m;j++){
        // if(isPeak(mat,i,j)){
        // return new int[]{i,j};
        // }
        // }
        // }
        // return new int[]{-1,-1};
        int low = 0, high = m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = findMax(mat, n, mid);
            int left = (mid - 1 >= 0) ? mat[row][mid - 1] : -1;
            int right = (mid + 1 < m) ? mat[row][mid + 1] : -1;
            if (mat[row][mid] > left && mat[row][mid] > right) {
                return new int[] { row, mid };
            } else if (mat[row][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[] { -1, -1 };
    }
}