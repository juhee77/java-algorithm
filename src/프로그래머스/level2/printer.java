package 프로그래머스.level2;
//https://programmers.co.kr/learn/courses/30/lessons/42587 -- 프린터
import java.util.*;
//수정중..


public class printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> q=new LinkedList<>();

        for(int i=priorities.length-1;0<=i;i--){
            priorityQueue.add(priorities[i]);
            q.add(priorities[i]);
        }
        System.out.println(priorityQueue.peek());

        int i=0;
        int indexValue=priorities[location];
        while(i<=priorities.length-1){

            if(i>=priorities.length-location-1&&priorities[location]==q.peek()&&priorities[location]==priorityQueue.peek()) break;
            i++;
            if(priorityQueue.peek()>q.peek()){
                //System.out.println(priorityQueue.peek()+" "+q.peek());
                answer++;
                if(indexValue==priorityQueue.peek()) break;

                q.remove(priorityQueue.peek());
                priorityQueue.remove();
                q.add(q.peek());
                q.remove();
            }
            else {
                answer++;
                q.remove();
                priorityQueue.remove();
            }
        }

        return answer;
    }
    public static void main(String args[]){
        int a[] = new int[] {1, 1, 9, 1, 1, 1};
        System.out.println(new printer().solution(a,0));
    }
}

