package leetcode;

import java.io.IOException;
import java.util.Arrays;

public class ExpressiveWords {
    public int expressiveWords(String s, String[] words) {
        if (s.equals(""))
            return 0;

        char[][] sArray = getAns(s);

        int ans = 0;
        for (String temp : words) {
            char[][] tempArray = getAns(temp);
            if (isFlag(sArray, tempArray))
                ans++;
        }
        return ans;
    }

    private static boolean isFlag(char[][] sArray, char[][] tempArray) {
        // for (char[] x : tempArray) {
        //     System.out.println(Arrays.toString(x));
        // }

        if (tempArray.length != sArray.length) {
            return false;
        }
        for (int i = 0; i < tempArray.length; i++) {
            if (sArray[i][0] != tempArray[i][0]) {
                return false;
            } else if (sArray[i][1] < tempArray[i][1]) {
                return false;
            } else if (sArray[i][1] > tempArray[i][1] && sArray[i][1] <= '2') {
                return false;
            }
        }
        return true;
    }

    private static char[][] getAns(String s) {
        char[][] tempArray = new char[s.length()][2];
        tempArray[0][0] = s.charAt(0);
        tempArray[0][1] = '1';
        int hold = 1;
        int sameIndex = 1;

        for (int i = 1; i < s.length(); i++) {
            if (tempArray[hold - 1][0] != s.charAt(i)) {

                sameIndex = 1;
                tempArray[hold][0] = s.charAt(i);
                tempArray[hold][1] = (char) ('0' + sameIndex);
                hold++;
            } else {
                sameIndex++;
                tempArray[hold - 1][1] = (char) ('0' + sameIndex);
            }
        }
        return Arrays.copyOfRange(tempArray, 0, hold);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new ExpressiveWords().expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
    }
}
