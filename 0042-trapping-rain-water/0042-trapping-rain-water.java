import java.util.Scanner;

class Solution {
    public static int trap(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        int leftmax = 0;
        int rightmax = 0;

        int trapped = 0;

        while (left < right) {
            if (arr[left] < arr[right]) {
                if (arr[left] >= leftmax) {
                    leftmax = arr[left];
                }

                else {
                    trapped = trapped + (leftmax - arr[left]);
                }

                left++;
            } else {

                if (arr[right] >= rightmax) {
                    rightmax = arr[right];
                }

                else {
                    trapped = trapped + (rightmax - arr[right]);
                }
                right--;
            }
        }
        return trapped;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int result = trap(arr);
        System.out.println(result);
    }
}