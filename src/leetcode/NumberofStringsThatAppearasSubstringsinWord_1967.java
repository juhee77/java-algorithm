package leetcode;

public class NumberofStringsThatAppearasSubstringsinWord_1967 {
    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for(String pattern : patterns){
            int index = word.indexOf(pattern);
            if(0<=index) ans ++;
        }
        return ans;
    }
}
