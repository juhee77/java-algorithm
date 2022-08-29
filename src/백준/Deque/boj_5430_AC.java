package 백준.Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class boj_5430_AC {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            char[] str = br.readLine().toCharArray();
            int num = Integer.parseInt(br.readLine());

            String input = br.readLine().replaceAll("[\\[\\]]", "");
            String[] temp = input.split(",");

            Deque<Integer> deque = new LinkedList<Integer>();
            for (int i = 0; i < num; i++) {
                deque.add(Integer.parseInt(temp[i]));
            }

            int cmdLine = str.length;
            boolean front = true;
            boolean flag = true;
            for (int i = 0; i < cmdLine && flag; i++) {
                switch (str[i]) {
                    case 'R'://앞이 바뀌는 경우
                        front = !front;
                        break;
                    case 'D':
                        //덱이 빈경우
                        if (deque.isEmpty()) {
                            sb.append("error\n");
                            flag = false;
                        } else if (front) deque.pollFirst();
                        else deque.pollLast();
                        break;

                    default:
                        break;
                }
            }

            if (flag) {
                String tmp ="";
                if (deque.isEmpty()) sb.append("[]\n");
                else if (front) {
                    tmp += deque.pollFirst();
                    while (!deque.isEmpty())
                        tmp = tmp + "," + deque.pollFirst();
                    sb.append( "[" + tmp + "]" + '\n');
                } else {
                    tmp += deque.pollLast();
                    while (!deque.isEmpty())
                        tmp = tmp + "," + deque.pollLast();
                    sb.append( "[" + tmp + "]" + '\n');
                }

            }
        }
        System.out.println(sb);
    }
}
