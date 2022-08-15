package 백준.Que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1966_프틴터큐2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());

        for (int i = 0; i < a; i++) {
            LinkedList<int[]> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int loc = Integer.parseInt(st.nextToken());
            int goal = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                int[] temp = new int[]{Integer.parseInt(st.nextToken()), j};
                queue.add(temp);
                if (j == loc) goal = temp[0];
            }

            int now = 0;
            while (now < num) {
                now++;
                int tmp[] = queue.peek();

                int flag = 0;

                int max = 0;
                for (int j = 0; j < queue.size(); j++) {
                    int[] nowTmp = queue.get(j);
                    if (nowTmp[0] > tmp[0]) {
                        if (max < nowTmp[0]) {
                            max = nowTmp[0];
                            flag = j;
                        }
                    }
                }

                //자신보다 큰게 있음
                if (flag != 0) {
//                    System.out.println("*1");
                    for (int j = 0; j < flag; j++)
                        queue.add(queue.poll());
                    if(max == goal && queue.peek()[1]==loc){
                        sb.append(now).append('\n');
                        break;
                    }
                    queue.poll(); //큰숫자 제거
                    //System.out.println(queue.peek()[0]);
                }
                else if (flag == 0 && goal != tmp[0]) {// 자기보다 큰숫자가 없음, 우선순위가 원하는것과 다름
//                    System.out.println("*2");
                    queue.poll();
                } else if (flag == 0 && goal == tmp[0]) { //자기보다 큰 숫자 없음, 원하는 우선순위임
//                    System.out.println("*3");
                    do {
                        tmp = queue.poll();
                        if(tmp[0]==goal)now++;
                    } while(loc != tmp[1]);
                    sb.append(now-1).append('\n');
                    break;
                }
            }
        }

        System.out.println(sb);

    }
}
