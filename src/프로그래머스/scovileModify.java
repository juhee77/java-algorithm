package 프로그래머스;
import java.util.*;

public class scovileModify {
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int answer = 0;

        for(int i : scoville){
            priorityQueue.offer(i);
        }
        while(priorityQueue.peek()<K){
            if(priorityQueue.size()==1){ //peek에서 나온 null값을 비교하는것보다는 size로 계산하는게 효율성이 더 올라감
                return -1;
            }

            priorityQueue.offer(priorityQueue.poll()+priorityQueue.poll()*2);
            answer++;
        }
        return answer;
    }
    public static void main(String args[]){
        int[] numbers= {1,2,3,9,10,12};
        System.out.println(solution(numbers,7));
        //int[] numbers1= {5,8,4,0,6,7,9};
        //System.out.println(solution(numbers1));
    }
}

