package 프로그래머스;
import java.util.*;

public class scovileQue {
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int answer = 0;

        for(int i=0;i<scoville.length;i++){
            priorityQueue.offer(scoville[i]);
        }
        while(true){
            if(priorityQueue.peek()>=K){
                return answer;
            }
            else if(priorityQueue.peek()==null){
                    return -1;
            }
            else{
                int min = priorityQueue.poll();
                int nextmin = priorityQueue.poll();
                priorityQueue.offer(min+nextmin*2);
                answer++;
            }
        }
    }
    public static void main(String args[]){
        int[] numbers= {1,2,3,9,10,12};
        System.out.println(solution(numbers,7));
        //int[] numbers1= {5,8,4,0,6,7,9};
        //System.out.println(solution(numbers1));
    }
}
