import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
    /*
    O(N) - using Hashmap (create array of size 2 to return the indices)
run the loop over all array element, pick the first array ele, and then check if target - num[i] is present in a hashmap or not, if it is present then return num[i] and mpp.get(target-num[i]), else add to hashmap.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int arr[] = new int[n];
        for (int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int res[] = twoSum(arr, target);
        for(int i=0; i< res.length; i++){
            System.out.println(res[i]);
        }
    }

    /*
    hashmap approach
     */
    private static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int res[] = new int[2];
        for(int i=0; i<arr.length; i++){
            int n = target-arr[i];
            if(mpp.containsKey(n)){
                return new int[]{mpp.get(n),i};
            }
            mpp.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }

    // using two pointer solution
    /*
    . O(NlogN) - Two pointer solution
Sort the array and keep a left pointer at 1st index and right pointer at last index. Do the sum of both and
(a) sum < target -> increment the left pointer
(b) sum > target -> incremement the right pointer
(c) sum == target -> return yes or no / return the left and right value and return the value of that postiion from the array.
     */
    private static int[] twoSumTwoPointerApproach (int[] arr, int target){
        Arrays.sort(arr);
        int left = 0, right = arr.length-1;
        for(int i=0; i<arr.length; i++){
            int sum = arr[left]+arr[right];
            if(sum<target){
                left ++;
            } else if(sum>target){
                right++;
            } else {
                return new int[]{left,right};
            }
        }
        return new int[]{-1,-1};
    }
}
