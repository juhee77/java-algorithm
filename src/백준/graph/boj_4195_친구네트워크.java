package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_4195_친구네트워크 {
    private static final HashMap<String, Integer> names = new HashMap<>(); //이름과 index를 저장한다.
    private static int[] friendsCnt; //조상 노드에 딸린 친구 수를 저장한다.
    private static int[] parents; //부모를 저장한다

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            //input setting
            int n = Integer.parseInt(br.readLine());
            names.clear();
            parents = new int[n * 2]; //n개의 줄에 들어오는 친구들이 모두 다를수 있다고 생각해서 크게 잡았다.
            friendsCnt = new int[n * 2];

            Arrays.fill(friendsCnt, 1); // 초기화, 처음 자신의 친구수는 자기자신 1명
            for (int i = 0; i < n * 2; i++) {
                parents[i] = i; //자신의 부모를 자신으로 설정(초기화)
            }

            int nowIdx = 0;//들어오는 친구의 저장 인덱스를 체크하기 위해서
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String friend1 = st.nextToken();
                String friend2 = st.nextToken();
                //두 친구의 이름이 없다면 새로 넣고, 있다면 저장 하지 않는다
                if (!names.containsKey(friend1)) {
                    names.put(friend1, nowIdx++);
                }
                if (!names.containsKey(friend2)) {
                    names.put(friend2, nowIdx++);
                }

                //두 친구의 인덱스
                int idx1 = names.get(friend1);
                int idx2 = names.get(friend2);

                //두 친구의 부모
                int parentsA = findParents(idx1);
                int parentsB = findParents(idx2);
                if (parentsA == parentsB) { // 이미 친구인 경우는 하지 않는다(이미 구해져 있음)
                    sb.append(friendsCnt[parentsA]).append("\n");
                } else {
                    int ans = unionParents(idx1, idx2);//더 작은 값의 값(조상)을 리턴하게 한다
                    sb.append(friendsCnt[ans]).append("\n"); //반환된 조상의 친구수를 출력
                }
            }
        }
        System.out.println(sb);
    }

    private static int unionParents(int a, int b) {
        a = findParents(a);
        b = findParents(b);
        if (a < b) {
            friendsCnt[a] += friendsCnt[b]; //친구의 합
            return parents[b] = a;
        }
        friendsCnt[b] += friendsCnt[a];
        return parents[a] = b;
    }

    private static int findParents(int x) {
        if (parents[x] == x) return x;
        return parents[x] = findParents(parents[x]);
    }
}
