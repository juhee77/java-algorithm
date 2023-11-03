package 백준.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_21939_문제추천시스템1 {
    private static class Problem implements Comparable<Problem> {
        int level;
        int num;

        public Problem(int level, int num) {
            this.level = level;
            this.num = num;
        }

        @Override
        public int compareTo(Problem o) {
            if (o.level == this.level) {
                return num - o.num;
            }
            return level - o.level;
        }

        @Override
        public String toString() {
            return "Problem{" +
                    "level=" + level +
                    ", num=" + num +
                    '}';
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Problem> down = new PriorityQueue<>();
        PriorityQueue<Problem> up = new PriorityQueue<>(Collections.reverseOrder());

        HashMap<Integer, Integer> set = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());

            Problem problem = new Problem(level, num);
            down.add(problem);
            up.add(problem);
            set.put(num, level);
        }

        int cmd = Integer.parseInt(br.readLine());

        while (cmd-- > 0) {
            st = new StringTokenizer(br.readLine());
            String nowCmd = st.nextToken();
            if (nowCmd.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());

                Problem problem = new Problem(level, num);
                down.add(problem);
                up.add(problem);
                set.put(num, level);

            } else if (nowCmd.equals("recommend")) {
                if (st.nextToken().equals("1")) {
                    //가장 어려운것(upperbound)
                    while (set.get(up.peek().num) != up.peek().level) {
                        up.poll();
                    }
                    sb.append(up.peek().num).append("\n");

                } else {
                    //가장 쉬운것(lowerBound)
                    while (set.get(down.peek().num) != down.peek().level) {
                        down.poll();
                    }
                    sb.append(down.peek().num).append("\n");
                }


            } else { //solved
                int findNum = Integer.parseInt(st.nextToken());
                set.put(findNum, -1);
            }
        }
        System.out.println(sb);
    }
}