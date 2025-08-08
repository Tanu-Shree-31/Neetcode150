import java.util.ArrayList;
import java.util.Scanner;

import java.util.List;

public class EncodeAndDecode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String arr[] = new String[n];
        for (int i =0; i<n; i++){
            arr[i] = sc.next();
        }
        String encodedStr = encode(arr);
        System.out.println(encodedStr);
        String decodedStr = decode(encodedStr);
        System.out.println(decodedStr);
    }

    private static String encode(String[] arr) {
        String finalStr = "";
        for(int i=0; i<arr.length; i++){
            String str = arr[i];
            int len = str.length();
            finalStr = finalStr+len+"#"+str;
        }
        return finalStr;
    }

    // 4#neet4#code
    private static String decode(String encodedStr) {
        List<String> res = new ArrayList<>();
        int i=0;
        while(i<encodedStr.length()){
            int j=i;
            while (encodedStr.charAt(j)!='#'){
                j++;
            }
            int len = Integer.parseInt(encodedStr.substring(i,j));
            i = j+1;
            j=len+i;
            res.add(encodedStr.substring(i,j));
            i=j;
        }
        return res.toString();
    }

}
