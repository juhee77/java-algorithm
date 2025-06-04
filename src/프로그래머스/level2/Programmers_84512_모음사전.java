package 프로그래머스.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Programmers_84512_모음사전 {
        private static String[] dic = {"A","E","I","O","U"};
        public int solution(String word) {
            HashSet<String> set = new HashSet<>();
            dfs(set,0,"");
            List<String> dicList = new ArrayList<>(set);
            Collections.sort(dicList);

            //System.out.println(dicList);
            return dicList.indexOf(word)+1;
        }

        public void dfs(HashSet<String> set, int depth, String s){
            if(depth==5) return;

            for(String di : dic){
                String temp = s+di;
                //System.out.println(temp);

                if(!set.contains(temp)){
                    set.add(temp);
                    dfs(set,depth+1,temp);
                }
            }
            if(depth>=1) dfs(set,depth+1,s);
        }

    public static void main(String[] args) {
        Programmers_84512_모음사전 solution = new Programmers_84512_모음사전();
        System.out.println(solution.solution("AAAAE"));
        System.out.println(solution.solution("AAAE"));
        System.out.println(solution.solution("I"));
    }
}
