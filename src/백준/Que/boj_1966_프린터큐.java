package 백준.Que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class ele implements Comparable<ele> {
    int priority;
    int loc;

    ele(int priority, int loc) {
        this.priority = priority;
        this.loc = loc;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getLoc() {
        return loc;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }

    @Override
    public int compareTo(ele ele) {
        if (this.priority > ele.getPriority())
            return 1;
        else if (this.priority < ele.getPriority())
            return -1;
        return 0;
    }

    public String toString(){

        return this.getPriority()+" "+this.getLoc()+" ";
    }
}

public class boj_1966_프린터큐 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());

        for (int i = 0; i < a; i++) {
            PriorityQueue<ele> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            Queue<ele> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int loc = Integer.parseInt(st.nextToken());
            int goal = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                ele temp = new ele(Integer.parseInt(st.nextToken()), j);
                priorityQueue.add(temp);
                queue.add(temp);
                if(j==loc) goal = temp.getPriority();
            }

            int now = 0;
            while (now < num) {
                now++;
                ele pmax = priorityQueue.peek();
                ele qmax = queue.peek();
                //System.out.println("prio"+pmax.toString()+"queue"+qmax.toString());

                if(goal == pmax.getPriority()){
                    while (true) {
                        qmax = queue.poll();
                        if(qmax.getLoc()==loc) break;
                        else if(qmax.getPriority() ==goal) now++;
                    }
                    if (qmax.getLoc()==loc) {
                        sb.append(now).append('\n');
                        break;
                    }

                }
                //우선순위에 맞춰서 회전
                else if (qmax.getPriority() < pmax.getPriority()) {
                    while (true) {
                        ele temp = queue.poll();
                        queue.add(temp);
                        qmax = queue.peek();
                        if (pmax.equals(qmax)) break;
                    }
                    priorityQueue.poll();
                    queue.poll();
                }


                //우선순위와 동일하면 위치 확인
                else if (qmax.getPriority() == pmax.getPriority()) {
                    if(loc == qmax.getLoc()) {
                        sb.append(now).append('\n');
                        break;
                    }
                    //위치가 다른거면 그냥 지나감
                    priorityQueue.poll();
                    queue.poll();
                }

            }

        }

        System.out.println(sb);

    }
}
