package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_5021_왕위계승 {
    private static class Human {
        String name;
        List<Human> childs = new ArrayList<>();
        int parentsCnt = 0;
        double score = 0;

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, double score) {
            this.name = name;
            this.score = score;
        }

//        @Override
//        public String toString() {
//            return "Human{" +
//                    "name='" + name + '\'' +
//                    ", parentsCnt=" + parentsCnt +
//                    ", score=" + score +
//                    '}';
//        }
    }

    private static final HashMap<String, Human> hashMap = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int familyLine = Integer.parseInt(st.nextToken());
        int preKingLine = Integer.parseInt(st.nextToken());

        String kingNmae = br.readLine();
        hashMap.put(kingNmae, new Human(kingNmae, 1));
        //자식이름 , 부모1, 부모2
        for (int i = 0; i < familyLine; i++) {
            String[] s = br.readLine().split(" ");
            for (String name : s) {
                if (!hashMap.containsKey(name)) {
                    hashMap.put(name, new Human(name));
                }
            }

            Human child = hashMap.get(s[0]);
            Human parent1 = hashMap.get(s[1]);
            Human parent2 = hashMap.get(s[2]);

            child.parentsCnt += 2;
            parent2.childs.add(child);
            parent1.childs.add(child);
        }

//        for (String s : hashMap.keySet()) {
//            Human human = hashMap.get(s);
//            System.out.println(human.name + " 의 자식 ");
//            for (Human child : human.childs) {
//                System.out.print(child.name + " ");
//            }
//            System.out.println();
//        }

        Queue<Human> q = new LinkedList<>();
        for (String s : hashMap.keySet()) {
            if (hashMap.get(s).parentsCnt == 0) q.add(hashMap.get(s));
        }

        while (!q.isEmpty()) {
            Human now = q.poll();
            for (Human child : now.childs) {
                child.parentsCnt--;
                child.score += now.score * 0.5;

                if (child.parentsCnt == 0) {
                    q.add(child);
                }
            }
        }

//        for (String s : hashMap.keySet()) {
//            Human human = hashMap.get(s);
//            System.out.println(human.name + " " + human.parentsCnt + " " + human.score);
//        }

        String nextKing = null;
        double score = -1;
        while (preKingLine-- > 0) {
            String name = br.readLine();
            Human preKing = hashMap.getOrDefault(name, new Human(name)); //완전 관련없는 사람이 해야하는경우
            if (score < preKing.score) {
                nextKing = preKing.name;
                score = preKing.score;
            }
        }
        System.out.println(nextKing);
    }
}
