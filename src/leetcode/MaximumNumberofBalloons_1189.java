package leetcode;

public class MaximumNumberofBalloons_1189 {
    public int maxNumberOfBalloons(String text) {
        int[] ans = new int[5];
        char[] ansC = {'b', 'a', 'n', 'l', 'o'};
        for(char c : text.toCharArray()){
            for(int j=0;j<ansC.length;j++){
                if(ansC[j]==c){
                    ans[j]++;
                    break;
                }
            }
        }

        int able = 10000;
        for(int i=0;i<ans.length;i++){
            // l o
            if(2<i){
                able = Math.min(able,ans[i]/2);
            }else{
                able = Math.min(able,ans[i]);
            }
        }
        return able;
    }
}
