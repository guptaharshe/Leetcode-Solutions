import java.util.Scanner;
class Solution {
    public  static int search(int[] arr, int target) {
        int start=0;
        int end=arr.length-1;

        while(start<=end){
            int mid=(start+end)/2;

            if(arr[mid]==target){
                return mid;
            }

            else if(arr[start]<=arr[mid]){
                if(target>=arr[start] && target<arr[mid]){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else{
                if(target>arr[mid] && target<=arr[end]){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
        }
        return -1;
        
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int target=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        int result=search(arr,target);
        System.out.println(result);
        sc.close();

    }
}