
import java.util.*;

class Main{

    public static boolean isPossible(int m,int arr[],int c){
        int laststall=arr[0];
        int cows=1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]-laststall>=m){
                cows++;
                laststall=arr[i];
            }

            if(cows==c) return true;
        }
        return false;
    }

    public static int getDistance(int arr[],int n,int c){
         Arrays.sort(arr); //Nlogn
         int si=1,end=arr[n-1]-arr[0],ans=0;

        while(si<=end){ //O(log(Range)*N)
            int mid=si+(end-si)/2;
            if(isPossible(mid,arr,c)){
                ans=Math.max(ans,mid);
                si=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
    public static void main(String args[]){

        int arr[]={1,2,8,4,9};
        int n=5,c=3;
        System.out.println(getDistance(arr,n,c));
    }
}