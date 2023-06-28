package 프로그래머스.level3;

import java.util.*;

class FindPath43164 {
    public static final String ICN = "ICN";
    HashMap<String, Integer> hash = new HashMap<>();
    List<List<String>> graph = new LinkedList<>();
    List<String> ans = new ArrayList<>();
    boolean flag = false;

    public String[] solution(String[][] tickets) {
        graph.add(new ArrayList<>());
        for (String[] ticket : tickets) {

            for (int j = 0; j < 2; j++) {
                if (!hash.containsKey(ticket[j])) {
                    hash.put(ticket[j], hash.size());
                    graph.add(new ArrayList<>());
                }
            }
            int start = hash.get(ticket[0]);
            graph.get(start).add(ticket[1]);
        }



        ans.add(ICN); //시작
        dfs(hash.get(ICN),1,tickets.length+1);


        return ans.toArray(String[]::new);
    }


    public void dfs(int now, int depth, int goalDepth) {
        if (depth == goalDepth) {
            flag = true;
            return;
        }
        if (checkVisited()) return;

        if (graph.get(now).size() == 0) return;
        Collections.sort(graph.get(now));

        int size = graph.get(now).size();
        for (int i = 0; i < size; i++) {
            String nextCity = graph.get(now).remove(i);
            ans.add(nextCity);

            dfs(hash.get(nextCity),depth+1,goalDepth);
            if (flag) return;

            ans.remove(ans.lastIndexOf(nextCity));
            graph.get(now).add(i, nextCity);
        }


    }

    private boolean checkVisited() {
        for (List<String> strings : graph) {
            if (strings.size() != 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        FindPath43164 solution = new FindPath43164();
//        System.out.println(Arrays.toString(solution.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
//        System.out.println(Arrays.toString(solution.solution(new String[][]{{"A", "B"},{"A", "D"},{"B", "C"},{"D", "C"},{"C", "B"},{"C", "A"}})));
//        System.out.println(Arrays.toString(solution.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}})));
//        System.out.println(Arrays.toString(solution.solution(new String[][]{{"ICN", "ABC"},{"ICN","ABC"},{"ABC","CDB"}})));
        System.out.println(Arrays.toString(solution.solution(new String[][]{{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}}
        )));
    }
}