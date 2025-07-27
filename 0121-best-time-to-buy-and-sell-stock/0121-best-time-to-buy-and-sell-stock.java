import java.util.Scanner;
class Solution {
    public static int maxProfit(int[] prices) {
        int max=Integer.MAX_VALUE;
        int maxprofit=0;

        for(int i=0;i<prices.length;i++){
            if(prices[i]<max){
                max=prices[i];
            }

            else{
                int profit=prices[i]-max;
                maxprofit=Math.max(profit,maxprofit);
            }
        }
        return maxprofit;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(maxProfit(arr));
    }
}