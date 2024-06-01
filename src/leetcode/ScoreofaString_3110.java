package leetcode;

class ScoreofaString_3110 {
    public int scoreOfString(String s) {
        int sum=0;
        char[] array = s.toCharArray();
        char before =array[0];
        for(int i=1;i<array.length;i++){
            sum += Math.abs(array[i]-before);
            before = array[i];
        }
        return sum;
    }
}