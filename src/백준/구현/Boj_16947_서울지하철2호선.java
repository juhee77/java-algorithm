package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_16947_서울지하철2호선 {
    private static Node[] nodes;
    private static boolean[] visited;
    private static int cycleMin = Integer.MAX_VALUE;
    private static int cycleMax = Integer.MIN_VALUE;



    public static class Node {
        int index;
        List<Node> childs = new ArrayList<>();
        boolean isCycle = false;
        int depth = 0;

        public Node(int index, List<Node> childs) {
            this.index = index;
            this.childs = childs;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", childs=" + childs.stream().map(o -> o.index) +
                    ", isCycle=" + isCycle +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        /** init **/
        int n = Integer.parseInt(br.readLine());
        boolean[][] edges = new boolean[n][n];
        nodes = new Node[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++)
            nodes[i] = new Node(i, new ArrayList<>());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int min = Math.min(a, b);
            int max = Math.max(a, b);
            nodes[min].childs.add(nodes[max]);
            nodes[max].childs.add(nodes[min]);
            edges[a][b] = true;
            edges[b][a] = true;
        }

        findCycle(0,0);
        for (Node node : nodes) {
            System.out.println(node.index + " " + node.isCycle+" "+node.depth);
        }
        System.out.println(Arrays.toString(visited));

        System.out.println("[[[[[[[[");
        System.out.println(cycleMax+" "+cycleMin);
        for (int i = 0; i < n; i++) {
            if(nodes[i].depth>cycleMax)
                sb.append(cycleMax-nodes[i].depth+" ");
            else if(nodes[i].depth<cycleMin)
                sb.append(nodes[i].depth-cycleMin+" ");
            else
                sb.append("0 ");
        }
        System.out.println(sb);
    }

    private static int find(int i,int depth) {
        for (Node child : nodes[i].childs) {
            if (child.isCycle) {
                return depth+1;
            }else{
                visited[child.index] = true;
                findCycle(child.index,depth+1);
            }
        }
        return -1;
    }

    private static void findCycle(int nodeIndex,int depth) {
        System.out.println(nodeIndex+" "+depth);
        visited[nodeIndex] = true;
        nodes[nodeIndex].depth = depth;
        for (Node child : nodes[nodeIndex].childs) {
            if (!visited[child.index]) {
                findCycle(child.index,depth+1);
            }else{
                if(depth > nodes[child.index].depth){
                    cycleMax = Math.max(cycleMax,depth);
                    cycleMin = Math.min(cycleMin,nodes[child.index].depth);
                }
            }

        }
    }
}
