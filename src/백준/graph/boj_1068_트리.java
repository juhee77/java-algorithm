package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1068_트리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, List<Integer>> tree = new HashMap<>();

        int[] parents = new int[size];

        for (int index = 0; index < size; index++) {
            int parent = Integer.parseInt(st.nextToken());

            //부모가 없는 경우
            if (parent == -1) {
                //만약 그 전에 루트노드가 들어왔다면
                if (tree.containsKey(index)) continue;
                else tree.put(index, new ArrayList<>());
            }
            else {
                //부모가 없다면 생성
                if (!tree.containsKey(index))tree.put(index, new ArrayList<>());
                if (!tree.containsKey(parent)) tree.put(parent, new ArrayList<>());

                //부모의 자식노드에 자신을 넣는다.
                List<Integer> temp = tree.get(parent);
                temp.add(index);
                tree.put(parent, temp);
                parents[index] = parent;
            }

        }

        //삭제노드
        int remove = Integer.parseInt(br.readLine());
        //System.out.println(Arrays.toString(tree.get(remove).toArray()));

        //지워야 할 노드와, 지우는 노드에 딸린 자식들도 모두 지운다.
        Queue<Integer> q = new LinkedList<>();
        q.addAll((tree.get(remove)));
        tree.remove(remove);

        while (!q.isEmpty()) {
            int temp = q.poll();
            q.addAll(tree.get(temp));
            tree.remove(temp);
        }

        //child가 0인것을 출력한다. 만약 지워야할 노드의 부모라면 1이면 증가시킨다.
        int cnt = 0;
        for (int key : tree.keySet()) {
            if (key == parents[remove] && tree.get(key).size() == 1) cnt++;
            if (tree.get(key).size() == 0) cnt++;
        }


        System.out.println(cnt);

    }
}
