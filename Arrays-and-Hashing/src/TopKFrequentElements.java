import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(topKFrequentElements(arr, k));
    }

    private static int[] topKFrequentElements(int[] arr, int k) {
        // Brute force
//        HashMap<Integer, Integer> mpp = new HashMap<>();
//        for(int i=0; i<arr.length; i++){
//            mpp.put(arr[i],mpp.getOrDefault(arr[i],0)+1);
//        }
//
//        //sort the hashmap
//        List<int[]> list = new ArrayList<>();
//        for(Map.Entry<Integer, Integer> entry: mpp.entrySet()){
//            list.add(new int[] {entry.getValue(), entry.getKey()});
//        }
//        list.sort((a,b)->b[0]-a[0]); //descending order where b[0] is freq
//
//        int res[] = new int[k];
//        for(int i=0; i<k; i++){
//            res[i]=list.get(i)[0];
//        }
//        return res;

        // Optimal approach - O(N), SC: O(N)
        // 1. create the hashmap and for each number and its frequency
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            mpp.put(arr[i],mpp.getOrDefault(arr[i],0)+1);
        }

        //2. create the list of array
        // key - number of  times its occuring
        // value - array because its the numbers in array
        // create empty one
        List<Integer>[] list = new List[arr.length+1];
        for(int i=0; i< list.length; i++){
            list[i] = new ArrayList<>();
        }

        // Step 3: Place each number into the correct frequency bucket
        for(Map.Entry<Integer,Integer> entry: mpp.entrySet()){
            int number = entry.getKey();
            int freq = entry.getValue();
            list[freq].add(number);
        }

        // Step 4: Collect the top K frequent elements from the buckets
        int index=0;
        int res[] = new int[k];
        // Start from the highest frequency bucket and move downward
        for(int i=list.length-1 ; i>0; i--){
            for(int n: list[i]){
                res[index] = n;
                index++;
                if(index==k){
                    return res;
                }
            }
        }
        return res;
    }
}
