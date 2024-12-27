class Solution {
    // better approach
    // public boolean find(int arr[],int target){
    // int left=0,right=arr.length-1;
    // while(left<=right){
    // int mid=(left+right)/2;
    // if(arr[mid]==target){
    // return true;
    // }
    // else if(arr[mid]>target){
    // right=mid-1;
    // }
    // else{
    // left=mid+1;
    // }
    // }
    // return false;
    // }

    public boolean searchMatrix(int[][] arr, int target) {
        int n = arr.length;
        int m = arr[0].length;
        // brute force approach
        // for(int i=0;i<n;i++){
        // for(int j=0;j<m;j++){
        // if(arr[i][j]==target){
        // return true;
        // }
        // }
        // }
        // return false

        // better approach
        // for(int i=0;i<n;i++){
        // if(arr[i][0]<=target && arr[i][m-1]>=target){
        // return find(arr[i],target);
        // }
        // }
        // return false;

        // best solution
        int left = 0;
        int right = n * m - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int row = mid / m;
            int col = mid % m;
            if (arr[row][col] == target) {
                return true;
            } else if (arr[row][col] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}