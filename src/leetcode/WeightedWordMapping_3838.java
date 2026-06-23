package leetcode;

public class WeightedWordMapping_3838 {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            int ans = 0;
            for(char c : word.toCharArray()){
                ans += weights[c-'a'];
            }

            sb.append((char)('z'- (ans%26)));
        }
        return sb.toString();
    }
}
