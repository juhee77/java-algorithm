package 백준.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1065_가르치기 {
    private static final List<String> dictionary = new ArrayList<>();
    private static final boolean[] visited = new boolean[26];
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int wordNum = Integer.parseInt(st.nextToken());
        int knowAlphabet = Integer.parseInt(st.nextToken());

        for (int i = 0; i < wordNum; i++) {
            String temp = br.readLine();
            temp = temp.substring(4, temp.length() - 4);
            dictionary.add(temp);
        }

        char[] mustKnown = new char[]{'a','c','i','n','t'};
        for(char alphabet :mustKnown){
            visited[alphabet - 'a'] = true;
        }

        if (knowAlphabet < 5) {
            System.out.println(0);
        } else if (26 <= knowAlphabet) {
            System.out.println(wordNum);
        } else {
            dfs(knowAlphabet - 5, 0, wordNum,0);
            System.out.println(max);
        }
    }

    private static void dfs(int n, int depth, int maxNum, int start) {
        if (maxNum == max) return;

        if (n == depth) {
            //System.out.println(Arrays.toString(visited));
            int canRead = checkingKnown();
            max = Math.max(max, canRead);
            return;
        }
        for (int i = start; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(n, depth + 1, maxNum,i+1);
                visited[i] = false;
            }
        }
    }

    private static int checkingKnown() {
        int canRead = 0;
        for (String tempWord : dictionary) {
            boolean flag = true;
            for (int j = 0; j < tempWord.length(); j++) {
                if (!visited[tempWord.charAt(j)-'a']) {
                    flag=false;
                    break;
                }
            }
            if(flag)canRead++;
        }
        return canRead;
    }
}

