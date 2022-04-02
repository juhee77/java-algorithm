package 프로그래머스.level2;
//https://programmers.co.kr/learn/courses/30/lessons/12913 -- 땅따먹기(dp이용) <0403>

public class eatLand_dp {
    public int solution(int[][] land) {
        int answer = 0;
        for(int i=1;i<land.length;i++){
            for(int j=0;j<4;j++){

                land[i][j] += Math.max(land[i-1][(j+3)%4],Math.max(land[i-1][(j+1)%4],land[i-1][(j+2)%4]));
                if(i==land.length-1 && answer<=land[i][j]) answer=land[i][j];
            }
        }

        return answer;
    }
    public static void main(String args[]){
        System.out.println(new eatLand_Queue().solution(new int[][] {{1,2,3,5},{5,6,7,8},{4,3,2,1}}));
    }
}
