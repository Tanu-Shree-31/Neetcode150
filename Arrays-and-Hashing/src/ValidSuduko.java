import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ValidSuduko {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums[][] = new int[9][9];
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                nums[i][j] = sc.nextInt();
            }
        }
        System.out.println(validSuduko(nums, 9, 9));
    }

    private static boolean validSuduko(int[][] nums, int rows, int col) {
//        // single sub-grid Brainstorming
//        HashSet<Integer> set = new HashSet<>();
//        for(int i=0; i<rows; i++){
//            for(int j=0; j<col; j++){
//                if(nums[i][j]>0 && nums[i][j]<=9) {
//                    if (!set.contains(nums[i][j])) {
//                        set.add(nums[i][j]);
//                    } else {
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;

        // TC: O(N2)
        // SC: O(N2)
        // rows
//        for(int i=0; i<9; i++){
//            HashSet<Integer> set = new HashSet<>();
//            for(int j=0; j<9; j++) {
//                if (nums[i][j]>0 && nums[i][j]<=9){
//                    if (!set.contains(nums[i][j])) {
//                        set.add(nums[i][j]);
//                    } else {
//                        return false;
//                    }
//                }
//            }
//        }
//
//        // columns
//        for(int i=0; i<9; i++) { //rows
//            HashSet<Integer> set = new HashSet<>();
//            for(int j=0; j<9; j++) { //col
//                if (nums[j][i]>0 && nums[j][i]<=9) {
//                    if (!set.contains(nums[j][i])) {
//                        set.add(nums[j][i]);
//                    } else {
//                        return false;
//                    }
//                }
//            }
//        }
//
//        // sub-boxes
//        for(int row=0; row<9; row=row+3) {
//            for(int colu=0; colu<9; colu=colu+3) {
//                HashSet<Integer> set = new HashSet<>();
//                for (int i = row; i < row+3; i++) {
//                    for (int j = colu; j < colu+3; j++) {
//                        if (nums[i][j]>0 && nums[i][j]<=9){
//                            if (!set.contains(nums[i][j])) {
//                                set.add(nums[i][j]);
//                            } else {
//                                return false;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return true;


        /*
        in order to optimise the space complexity, as we are creating many hashsets for
        each row or column or sub square
        we will now traverse the single element only once and then we will check for all 3
         */

        HashMap<Integer,HashSet<Integer>> rowmpp = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> colmpp = new HashMap<>();
        HashMap<String, HashSet<Integer>> square = new HashMap<>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                String sqareKey = (i/3) + "," + (j/3);
                if(rowmpp.computeIfAbsent(i,k->new HashSet<>()).contains(nums[i][j]) ||
                        colmpp.computeIfAbsent(j,k->new HashSet<>()).contains(nums[i][j]) ||
                        square.computeIfAbsent(sqareKey,k->new HashSet<>()).contains(nums[i][j])) {
                    return false;
                }
                rowmpp.get(i).add(nums[i][j]);
                colmpp.get(j).add(nums[i][j]);
                square.get(sqareKey).add(nums[i][j]);

            }
        }
        return true;
    }
}
