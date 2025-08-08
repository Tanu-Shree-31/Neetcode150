import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Result is: "+longestConsecutiveSequence(arr));
    }

    private static boolean linearSearch(int[] arr, int num) {
        for(int i=0; i<arr.length; i++){
            if(num==arr[i]){
                return true;
            }
        }
        return false;
    }

    private static int longestConsecutiveSequence(int[] arr) {
//        // Brute force approach - O(N2)
//        int n = arr.length, longest=1;
//        for(int i=0; i<n; i++){
//            int num = arr[i];
//            int counter = 1;
//            while(linearSearch(arr,num+1)==true){
//                num++;
//                counter++;
//            }
//            longest = Math.max(longest,counter);
//        }
//        return longest;

        // Better Approach - sorting and checking
//        Arrays.sort(arr);
//        int lastSmaller = Integer.MIN_VALUE, counter = 0, longest=1;
//        for(int i=0; i<arr.length; i++) {
//            if(arr[i]-1 == lastSmaller){
//                lastSmaller = arr[i];
//                counter++;
//            } else if(arr[i]!=lastSmaller){
//                lastSmaller = arr[i];
//                counter=1;
//            }
//            longest = Math.max(counter,longest);
//
//        }
//        return longest;


        // Optimal approach
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0; i< arr.length; i++){ //O(N)
            hashSet.add(arr[i]);
        }
        int longest=1;
        for(int i: hashSet){
            if(!hashSet.contains(i-1)){
                int counter = 1;
                int num = i;
                while(hashSet.contains(num+1)){
                    num++;
                    counter++;
                }
                longest = Math.max(counter,longest);
            }
        }
        return longest;
    }
}
