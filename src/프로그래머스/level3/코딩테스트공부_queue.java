package 프로그래머스.level3;


import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class 코딩테스트공부_queue {
    class pro {
        int alp, cop, time;

        public pro(int alp, int cop, int time) {
            this.alp = alp;
            this.cop = cop;
            this.time = time;
        }


        @Override
        public String toString() {
            return "pro{" +
                    "alp=" + alp +
                    ", cop=" + cop +
                    ", time=" + time +
                    '}';
        }

    }

    public int solution(int alp, int cop, int[][] problems) {
        Queue<pro> queue = new LinkedList<>();
        int arr[][] = new int[151][151];
        queue.add(new pro(alp, cop, 0));
        arr[alp][cop] = 0;
        int answer =Integer.MAX_VALUE;
        int maxalp=0,maxcop=0;
        for(int i=0;i<problems.length;i++){
            maxalp= Math.max(maxalp,problems[i][0]);
            maxcop= Math.max(maxcop,problems[i][1]);
        }
        System.out.println(maxalp+"  "+maxcop);

        while (!queue.isEmpty()) {
            pro temp = queue.poll();
            int tempalp = temp.alp;
            int temptime= temp.time;
            int tempcop = temp.cop;

            if(tempalp>=maxalp && tempcop>=maxcop){
                answer = Math.min(answer, temptime);
                continue;
            }

            if(tempalp>maxalp || tempcop>maxcop)continue;


            for(int j=0;j< problems.length;j++){
                //해당 문제를 풀기에 필요한 점수가 부족한 경우
                if(tempalp<problems[j][0]|| tempcop<problems[j][1])continue;

                int tempalp2 = tempalp+problems[j][2];
                int tempcop2 = tempcop+problems[j][3];
                int temptime2 =temptime+problems[j][4];

                if(tempalp2>150 ||tempcop2>150) continue;

                if(arr[tempalp2][tempcop2] ==0){
                    arr[tempalp2][tempcop2] = temptime2;
                    queue.add(new pro(tempalp2,tempcop2,temptime2));
                }
                else if(arr[tempalp2][tempcop2]>temptime2){
                    arr[tempalp2][tempcop2] = temptime2;
                    queue.add(new pro(tempalp2,tempcop2,temptime2));
                }

            }

            int[] x ={0,1};
            int[] y= {1,0};
            for(int j=0;j<2;j++){
                int tempalp2 = tempalp+x[j];
                int tempcop2 = tempcop+y[j];
                int temptime2 =temptime+1;
                //목표값보다 더 크면
                if(tempalp2>150 ||tempcop2>150) continue;

                // 방문하지 않았으면
                if(arr[tempalp2][tempcop2] ==0){
                    arr[tempalp2][tempcop2] = temptime2;
                    queue.add(new pro(tempalp2,tempcop2,temptime2));
                }

            }

        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new 코딩테스트공부_queue().solution(10, 10, new int[][]{{10, 15, 2, 1, 2}, {20,20, 2, 1, 2}}));
        System.out.println(new 코딩테스트공부_queue().solution(0, 0, new int[][]{{0, 0, 2, 1, 2}, {4, 5, 3, 1, 2}, {4, 11, 4, 0, 2}, {10, 4, 0, 4, 2}}));
    }
}
