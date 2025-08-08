import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for(int i=0; i<strs.length; i++){
            strs[i] = sc.next();
        }
        System.out.println(groupAnagrams(strs));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        // Brute force
        /*
        1. 0(n*mlogm) - sorting and hashmap
        for each string, we convert it to a character array, sort it, and use the sorted string as the key in a HashMap
        to group all anagrams together.
         */
//        HashMap<String, List<String>> mpp = new HashMap<>();
//        for(String s: strs){
//            char[] charArr = s.toCharArray();
//            Arrays.sort(charArr);
//            String sortedString = Arrays.toString(charArr);
//            mpp.putIfAbsent(sortedString, new ArrayList<>());
//            mpp.get(sortedString).add(s);
//        }
//        return new ArrayList<>(mpp.values());

        // Optimal approach
        // to optimise this - we will have to reduce the sorting TC which is mlogm to somethng which is m. Hence using the hash array approach.
        /*
        2. O(n*m) - hash array and hashmap
        For each string, we build a 26-length array to count how many times each letter (a–z) appears, and then convert that array into
        a string to use as the key. This avoids sorting and reduces the overall time complexity to O(n·k)
         */
        HashMap<String, List<String>> mpp = new HashMap<>();
        for(String s: strs) {
            int[] count = new int[26];
            for(char c: s.toCharArray()){
                count[c-'a']++;
            }
            String charString = Arrays.toString(count);
            mpp.putIfAbsent(charString, new ArrayList<>());
            mpp.get(charString).add(s);

        }
        return new ArrayList<>(mpp.values());
    }
}
