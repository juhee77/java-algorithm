package 프로그래머스.level2;
//https://programmers.co.kr/learn/courses/30/lessons/42587 -- 프린터
import java.util.*;
//수정중..

class num{
    int x;
    boolean y;

    public num (int priority, boolean b) {
        this.x=priority;
        this.y=b;
    }

}

public class printermodi {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<num> q=new ArrayList<>();

        for(int i=priorities.length-1;0<=i;i--){
            if(i==location){
                priorityQueue.add(priorities[i]);
                q.add(new num(priorities[i], true));
            }else {
                priorityQueue.add(priorities[i]);
                q.add(new num(priorities[i], false));
            }
        }
        //System.out.println(priorityQueue.peek());

        while(true){
            if(priorityQueue.peek()>q.get(0).x){
                //System.out.println(priorityQueue.peek()+" "+q.get(0).x);
                if(q.contains(new num(priorityQueue.peek(),true))) break;
                answer++;
                q.remove(new num(priorityQueue.peek(),false));

                priorityQueue.remove();
                q.add(q.get(0));
                //location++;
                q.remove(0);

            }
            else {
                //System.out.println(priorityQueue.peek()+" "+q.get(0).y);
                if(q.get(0).y==true) break;
                answer++;
                q.remove(0);
                priorityQueue.remove();
            }
        }

        return answer;
    }
    public static void main(String args[]){
        int a[] = new int[] {1, 1, 9, 1, 1, 1};
        int b[]= new int[]{2,1,3,2};
        System.out.println(new printer().solution(a,0));
    }
}

