package leetcode;

public class RansomNote_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int a[] = new int[26];
        int b[] = new int[26];

        for(char c : ransomNote.toCharArray()){
            a[c-'a'] ++;
        }
        for(char c : magazine.toCharArray()){
            b[c-'a'] ++;
        }

        for(int i=0;i<26;i++){
            if(a[i]>b[i]) return false;
        }
        return true;

    }
}
