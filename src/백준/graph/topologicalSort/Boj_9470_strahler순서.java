package 백준.graph.topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_9470_strahler순서 {
    private static List<List<Integer>> outEdges;
    private static List<HashMap<Integer,Integer>> savedValues;
    private static int[] inDegrees;

    public static int calculateStrahlerOrder() {
        Queue<Integer> queue = new LinkedList<>();
        int[] strahlers = new int[inDegrees.length];

        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                strahlers[i] = 1;
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int parent = queue.poll();
            for (int child : outEdges.get(parent)) {
                inDegrees[child]--;
                HashMap<Integer, Integer> nowHash = savedValues.get(child);
                nowHash.put(strahlers[parent],nowHash.getOrDefault(strahlers[parent],0)+1);

                if (inDegrees[child] == 0) {
                    for (Integer key : nowHash.keySet()) {
                        Integer cnt = nowHash.get(key);
                        if (cnt >= 2) {
                            strahlers[child] = key + 1;
                        }

                        strahlers[child] = Math.max(strahlers[child], key);
                    }
                    queue.add(child);
                }
            }
        }

        return strahlers[inDegrees.length - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= tc; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tcNum = Integer.parseInt(st.nextToken());
            int nodes = Integer.parseInt(st.nextToken());
            int edges = Integer.parseInt(st.nextToken());

            outEdges = new ArrayList<>();
            savedValues = new ArrayList<>();
            inDegrees = new int[nodes];

            for (int j = 0; j < nodes; j++) {
                outEdges.add(new ArrayList<>());
                savedValues.add(new HashMap<>());
            }

            for (int j = 0; j < edges; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                outEdges.get(a).add(b);
                inDegrees[b]++;
            }

            sb.append(tcNum).append(" ").append(calculateStrahlerOrder()).append("\n");
        }
        System.out.println(sb);
    }
}
