package 백준.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_21944_문제추천시스템2 {

    public static final int MAX = 100_002;

    private static class Problem implements Comparable<Problem> {
        int num;
        int level;
        int subject;

        public Problem(int num, int level, int subject) {
            this.num = num;
            this.level = level;
            this.subject = subject;
        }

        @Override
        public int compareTo(Problem o) {
            if (o.level == this.level) {
                return num - o.num;
            }
            return level - o.level;
        }
    }

    private static final HashMap<Integer, Problem> problemSet = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, PriorityQueue<Problem>> downMap = new HashMap<>();
        HashMap<Integer, PriorityQueue<Problem>> upMap = new HashMap<>();
        PriorityQueue<Problem> allDown = new PriorityQueue<>();
        PriorityQueue<Problem> allUp = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Problem>[] levelList = new ArrayList[100_001];

        for (int i = 0; i < 100_001; i++) {
            levelList[i] = new ArrayList<>();
        }

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            int sub = Integer.parseInt(st.nextToken());

            Problem problem = new Problem(num, level, sub);
            downMap.computeIfAbsent(sub, key -> new PriorityQueue<>()).add(problem);
            upMap.computeIfAbsent(sub, key -> new PriorityQueue<>(Collections.reverseOrder())).add(problem);
            allDown.add(problem);
            allUp.add(problem);

            problemSet.put(num, problem);
            levelList[level].add(problem);
        }

        int cmd = Integer.parseInt(br.readLine());

        while (cmd-- > 0) {

            st = new StringTokenizer(br.readLine());
            String nowCmd = st.nextToken();
            if (nowCmd.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                int sub = Integer.parseInt(st.nextToken());

                Problem problem = new Problem(num, level, sub);
                downMap.computeIfAbsent(sub, key -> new PriorityQueue<>()).add(problem);
                upMap.computeIfAbsent(sub, key -> new PriorityQueue<>(Collections.reverseOrder())).add(problem);
                allDown.add(problem);
                allUp.add(problem);

                problemSet.put(num, problem);
                levelList[level].add(problem);

            } else if (nowCmd.equals("recommend")) {
                int sub = Integer.parseInt(st.nextToken());
                if (st.nextToken().equals("1")) {
                    //가장 어려운것(upperbound)
                    PriorityQueue<Problem> problems = upMap.get(sub);

                    while (!isSameProblem(problems.peek())) {
                        problems.poll();
                    }
                    sb.append(problems.peek().num).append("\n");

                } else {
                    //가장 쉬운것(lowerBound)
                    PriorityQueue<Problem> problems = downMap.get(sub);

                    while (!isSameProblem(problems.peek())) {
                        problems.poll();
                    }
                    sb.append(problems.peek().num).append("\n");
                }

            } else if (nowCmd.equals("recommend2")) {
                if (st.nextToken().equals("1")) {
                    //가장 어려운것(upperbound)
                    while (!isSameProblem(allUp.peek())) {
                        allUp.poll();
                    }
                    sb.append(allUp.peek().num).append("\n");

                } else {
                    //가장 쉬운것(lowerBound)
                    while (!isSameProblem(allDown.peek())) {
                        allDown.poll();
                    }
                    sb.append(allDown.peek().num).append("\n");
                }

            } else if (nowCmd.equals("recommend3")) {

                String subCmd = st.nextToken();
                int level = Integer.parseInt(st.nextToken());

                if (subCmd.equals("1")) {
                    //가장 어려운것(upperbound)
                    int ans = MAX;

                    for (int i = level; i < 100_001; i++) {
                        for (Problem problem : levelList[i]) {
                            if (isSameProblem(problem)) {
                                ans = Math.min(problem.num, ans);
                            }
                        }
                        if (ans != MAX) {
                            break;
                        }
                    }

                    if (ans == MAX) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(ans).append("\n");
                    }

                } else {
                    //가장 쉬운것(lowerBound)
                    int ans = -1;

                    for (int i = level - 1; 0 <= i; i--) {
                        for (Problem problem : levelList[i]) {
                            if (isSameProblem(problem)) {
                                ans = Math.max(problem.num, ans);
                            }
                        }
                        if (ans != -1) break;
                    }

                    sb.append(ans).append("\n");
                }

            } else { //solved
                int findNum = Integer.parseInt(st.nextToken());
                problemSet.put(findNum, new Problem(-1, -1, -1));
            }
        }
        System.out.println(sb);
    }

    private static boolean isSameProblem(Problem problem) {
        if (problemSet.containsKey(problem.num)) {
            Problem nowNum = problemSet.get(problem.num);
            return nowNum.level == problem.level && nowNum.subject == problem.subject;
        }
        return false;
    }
}