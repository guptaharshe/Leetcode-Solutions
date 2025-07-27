class Solution {
    public static int majorityElement(int[] nums) {
        int a=nums.length;
        for(int i=0;i<a;i++){
            int count=0;
            for(int j=0;j<a;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
            
            if(count>a/2){
                return nums[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Majority element is: " + majorityElement(arr));
        sc.close();
    }
}