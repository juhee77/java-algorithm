package 프로그래머스.level3;

import java.util.*;

class FindPath43164Retry {
    public static final String ICN = "ICN";
    private String[][] tickets;
    private boolean[] visited;
    private String[] ans ;
    private boolean flag = false;

    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        visited = new boolean[tickets.length];
        ans = new String[tickets.length + 1];
        ans[0] = ICN;
        dfs(ICN, 0);

        return ans;
    }

    public void dfs(String now, int depth) {
        if (depth == tickets.length) {
            flag = true;
        }else{
            List<Integer> able = new ArrayList<>();
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i][0].equals(now) && !visited[i]) {
                    able.add(i);
                }
            }

            able.sort((o1, o2) -> tickets[o1][1].compareTo(tickets[o2][1]));

            for (int ableIndex : able) {
                String next = tickets[ableIndex][1];
                ans[depth + 1] = next;
                visited[ableIndex] = true;

                dfs(next, depth + 1);
                if (flag) return; //이미 찾음
                visited[ableIndex] = false;
            }
        }
    }

    public static void main(String[] args) {
        FindPath43164Retry solution = new FindPath43164Retry();
        System.out.println(Arrays.toString(solution.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
//        System.out.println(Arrays.toString(solution.solution(new String[][]{{"A", "B"},{"A", "D"},{"B", "C"},{"D", "C"},{"C", "B"},{"C", "A"}})));
//        System.out.println(Arrays.toString(solution.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}})));
//        System.out.println(Arrays.toString(solution.solution(new String[][]{{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}}
//        )));
    }
}