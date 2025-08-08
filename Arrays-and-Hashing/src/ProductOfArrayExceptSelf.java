import java.util.Scanner;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        productOfArrayExceptSelf(arr);
    }

    private static String productOfArrayExceptSelf(int[] arr) {
//        int preSum[] = new int[arr.length];
//        int suffSum[] = new int[arr.length];
        int res[] = new int[arr.length];
//
//        // calculating the prefix sum
//        preSum[0] = 1;
//        for(int i=1; i<arr.length; i++){
//            preSum[i] = preSum[i-1] * arr[i-1];
//        }
//        System.out.println("prefix sum: ");
//        for(int i=0; i<preSum.length; i++){
//            System.out.print(preSum[i]+" ");
//        }
//
//        // calculating the suffix sum
//        suffSum[arr.length-1] = 1;
//        for(int i=arr.length-2;i>=0; i--){
//            suffSum[i] = suffSum[i+1]*arr[i+1];
//        }
//        System.out.println("suffix sum: ");
//        for(int i=0; i<suffSum.length; i++){
//            System.out.print(suffSum[i]+" ");
//        }
//
//        // prefixSum * suffixSum
//        for(int i=0; i<arr.length; i++){
//            res[i] = preSum[i]*suffSum[i];
//        }
//        System.out.println("res: ");
//        for(int i=0; i<res.length; i++){
//            System.out.print(res[i]+" ");
//        }

        // TC: O(N+N) = O(N)
        //SC: O(3N) = O(N)

        int n = arr.length;
        res[0] = 1;
        for(int i=1; i<n; i++){
            res[i] = res[i-1] * arr[i-1]; // calculating the prefix in the res array only
        }

        // we dont want the last pos bcz already it would be same as prefixsum value
        int suffix = 1;
        for(int i=n-2; i>=0; i--){
            suffix = suffix * arr[i+1];
            res[i] = suffix * res[i];
        }

        return res.toString();
    }

}
