import java.util.HashMap;
import java.util.Scanner;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
Example 1:

Input: s = "anagram", t = "nagaram"

Output: true
 */

public class ValidAnagrams {
    /*
     HashMap - use getOrDefault for each character and at last compare both hashmaps
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(validAnagram(s1,s2));
    }

    private static boolean validAnagram(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        HashMap<Character,Integer> counts1 = new HashMap<>();
        HashMap<Character,Integer> counts2 = new HashMap<>();
        for(int i=0; i<s1.length(); i++){
            counts1.put(s1.charAt(i), counts1.getOrDefault(s1.charAt(i),0)+1);
            counts2.put(s2.charAt(i), counts2.getOrDefault(s2.charAt(i),0)+1);
        }
        return counts1.equals(counts2);
    }
}
