import java.util.ArrayList;
public class Solution {
    public static int NoOfStudents(ArrayList<Integer>arr,int pages){
        int currPages=0;
        int students=1;
        for(int ele:arr){
            if((currPages+ele)<=pages){
                currPages+=ele;
            }
            else{
                students++;
                currPages=ele;
            }
        }
        return students;
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if(m>n)return -1;
        int max=-1;
        int sum=0;
       for(int ele:arr){
           max=Math.max(max,ele);
           sum+=ele;
       }
       int left=max,right=sum;
       while(left<=right){
           int mid=(left+right)/2;
           int stud=NoOfStudents(arr,mid);
           if(stud>m){
               left=mid+1;
           }
           else{
               right=mid-1;
           }
       }
       return left;
    }
}