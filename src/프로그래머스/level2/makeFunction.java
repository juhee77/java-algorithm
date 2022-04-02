package 프로그래머스.level2;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
//https://programmers.co.kr/learn/courses/30/lessons/42586 -- 기능개발<0401>
public class makeFunction {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> que = new LinkedList<>();

        for(int i=0;i<progresses.length;i++){
            int temp= (int)Math.ceil((100-progresses[i])/(float)speeds[i]);
            que.add(temp);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0;
        while(que.size()>=1){
            int temp=0;
            while( que.size()>=1&& que.peek()<=i ){
                temp++;
                que.poll();
            }
            if(temp!=0)ans.add(temp);
            i++;
        }
        return ans.stream().mapToInt(o -> o).toArray();
    }
    public static void main(String args[]){
        //System.out.println(Arrays.toString(new makeFunction().solution(new int[] {93, 30, 55},new int[] {1, 30, 5})));
    }
}
