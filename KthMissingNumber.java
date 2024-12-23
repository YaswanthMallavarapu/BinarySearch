class Solution {
    public int findKthPositive(int[] arr, int k) {
        // Set<Integer>set=new HashSet<>();
        // for(int num:arr){
        //     set.add(num);
        // }
        // int missing=0;
        // int n=arr.length;
        // for(int i=1;i<=(n+k);i++){
        //     if(!set.contains(i)){
        //         missing++;
        //         if(missing==k){
        //             return i;
        //         }
        //     }
        // }
        // return -1;
        int n=arr.length;
        int left=0,right=n-1;
        while(left<=right){
            int mid=(left+right)/2;
            int missing=arr[mid]-(mid+1);
            if(missing>=k){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return left+k;
    }
}