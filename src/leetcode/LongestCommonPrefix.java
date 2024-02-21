package leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++){

            int minLen = Math.min(prefix.length(), strs[i].length());

            for(int j=0;j<minLen;j++){
                if(prefix.charAt(j) != strs[i].charAt(j)){
                    prefix = prefix.substring(0,j);
                    break;
                }
            }

            if(prefix.length() > strs[i].length()){
                prefix = strs[i];
            }


        }
        return prefix;
    }
    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}
