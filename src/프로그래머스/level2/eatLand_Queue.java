package 프로그래머스.level2;
//https://programmers.co.kr/learn/courses/30/lessons/12913 -- 땅따먹기 <0402>
import java.util.LinkedList;
import java.util.Queue;

public class eatLand_Queue {
    public int solution(int[][] land) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(land[0][0]);
        queue.add(land[0][1]);
        queue.add(land[0][2]);
        queue.add(land[0][3]);

        for(int i=1;i<land.length;i++){
            for(int j=0;j<Math.pow(4,i);j++){
                int lastStage=j;
                while(lastStage>=4)lastStage %= 4;

                int temp = queue.poll();
                for(int k=0;k<4;k++){
                    if(k!=lastStage)queue.add(temp+land[i][k]);
                    else queue.add(temp);
                }
                //System.out.println(queue);
            }
        }
        for(int i=0;i<queue.size();){
            int temp = queue.poll();
            //System.out.println(i+" "+temp);
            if(answer<=temp) answer = temp;
        }
        return answer;
    }
    public static void main(String args[]){
        System.out.println(new eatLand_Queue().solution(new int[][] {{1,2,3,5},{5,6,7,8},{4,3,2,1}}));
    }
}
