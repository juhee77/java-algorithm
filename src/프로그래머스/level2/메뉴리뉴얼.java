package 프로그래머스.level2;

import java.util.*;

public class 메뉴리뉴얼 {
    class menu implements Comparable<menu> {
        String name;
        int num;

        public menu(String name, int num) {
            this.name = name;
            this.num = num;
        }

        @Override
        public int compareTo(menu o) {
            if (this.name.length() < o.name.length()) return -1;
            else if (this.name.length() == o.name.length()){
                if(this.num < o.num)return 1;
                else if(this.num > o.num)return -1;
                else return this.name.compareTo(o.name); //사전식
            }
            else return 1;
        }

        @Override
        public String toString() {
            return "menu{" +
                    "name='" + name + '\'' +
                    ", num=" + num +
                    '}';
        }
    }

    private static HashMap<String, Integer> hash = new HashMap<>();
    static char[] arr;
    static boolean[] visit;
    static char[] temp;

    private static void dfs(int n, int m, int d) {
        if (d == m) {
            String s= "";
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]>arr[i+1]) return ;
            }
            for (char a : arr) s += a;
            hash.put(s,hash.getOrDefault(s,0)+1);

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[d] =temp[i];
                dfs(n, m, d + 1);
                visit[i] = false;
            }
        }
        return;
    }

    public String[] solution(String[] orders, int[] course) {
        Arrays.sort(course);

        for (String str : orders) {
            temp = str.toCharArray();
            Arrays.sort(temp);
            for (int i = 0; i < course.length; i++) {
                if (temp.length < course[i]) break;
                arr = new char[course[i]]; visit = new boolean[temp.length];
                dfs(temp.length, course[i], 0);
            }
        }

        ArrayList<menu> menuList = new ArrayList<>();

        for(String key : hash.keySet()) {
            if(hash.get(key)==1) continue;
            menuList.add(new menu(key, hash.get(key)));
        }

        menuList.sort(menu::compareTo);
        int p =0;
        int max[] = new int[course.length];
        ArrayList<String> ans = new ArrayList<>();

        for(int i=0;i<menuList.size();i++){
            menu now = menuList.get(i);
            if(course[p]!=now.name.length()){
                p++;
                if(course.length<=p) break;
            }

            if(max[p]==0 && course[p]==now.name.length()){
                max[p] = now.num;
                ans.add(now.name);
            }
            else if(max[p]!=0 && max[p]==now.num){
                ans.add(now.name);
            }
        }
        System.out.println(Arrays.toString(max));


        Collections.sort(ans);
        String[] answer = ans.toArray(new String[ans.size()]);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 메뉴리뉴얼().solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4})));
    }
}
