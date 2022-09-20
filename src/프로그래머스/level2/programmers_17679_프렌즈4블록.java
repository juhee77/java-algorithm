package 프로그래머스.level2;

import java.awt.*;
import java.util.Arrays;
import java.util.Stack;

public class programmers_17679_프렌즈4블록 {
    private static boolean[][] state;
    private static int cnt = 1;

//    private static void dfs(char arr[][], int x, int y) {
//        if (x + 1 >= arr.length || x < 0 || y < 0 || y + 1 >= arr[0].length) return;
//
//        char temp = arr[x][y];
//
//        if (temp == arr[x][y + 1] && temp == arr[x + 1][y] && temp == arr[x + 1][y + 1]) {
//            dfs(arr, x, y + 1);
//            dfs(arr, x + 1, y);
//            dfs(arr, x + 1, y + 1);
//
//            if (state[x][y] == 0) state[x][y] = cnt++;
//            if (state[x][y + 1] == 0) state[x][y + 1] = cnt++;
//            if (state[x + 1][y] == 0) state[x + 1][y] = cnt++;
//            if (state[x + 1][y + 1] == 0) state[x + 1][y + 1] = cnt++;
//        }
//
//        return;
//    }
//
//    private static void move(char arr[][]) {
//        Stack<Character> s = new Stack<>();
//        Stack<Integer> s2 =new Stack<>();
//
//        for (int j = 0; j < state[0].length; j++) {
//            for (int i = 0; i< state.length; i++) {
//                if (state[i][j] == 0) {
//                    s2.push(state[i][j]);
//                    s.push(arr[i][j]);
//                }
//                arr[i][j] ='.';
//                state[i][j] = 100000;
//
//            }
//
//            int size = s2.size();
//            for(int i=0;i<size;i++){
//                state[state.length-i-1][j] = s2.pop();
//                arr[state.length-i-1][j]=s.pop();
//            }
//        }
//    }

    private static void dfs(char arr[][], int x, int y) {
        if (x + 1 >= arr.length || x < 0 || y < 0 || y + 1 >= arr[0].length) return;

        char temp = arr[x][y];

        if (temp == arr[x][y + 1] && temp == arr[x + 1][y] && temp == arr[x + 1][y + 1]) {
            dfs(arr, x, y + 1);
            dfs(arr, x + 1, y);
            dfs(arr, x + 1, y + 1);

            int[] tempx = {0,0,1,1};
            int[] tempy ={1,0,1,0};
            for(int i=0;i<4;i++){
                if(!state[x+tempx[i]][y+tempy[i]]){
                    cnt++;
                    state[x+tempx[i]][y+tempy[i]] = true;
                }
            }

        }

        return;
    }

    private static void move(char arr[][]) {
        Stack<Character> s = new Stack<>();

        for (int j = 0; j < arr[0].length; j++) {
            for (int i = 0; i< arr.length; i++) {
                if (!state[i][j]) {
                    s.push(arr[i][j]);
                }
                arr[i][j] ='.';
                state[i][j] = false;
            }

            int size = s.size();
            for(int i=0;i<size;i++){
                arr[arr.length-i-1][j]=s.pop();
            }
        }
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] arr = new char[m][n];

        cnt = 0;
        for (int i = 0; i < m; i++) arr[i] = board[i].toCharArray();

        state = new boolean[m][n];
        while (true) {
            answer = cnt;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (arr[i][j]=='.') continue;
                    dfs(arr, i, j);
                }
            }

//            for (int i = 0; i < m; i++) {
//                System.out.println(Arrays.toString(state[i]));
//            }
            for (int i = 0; i < m; i++) {
                System.out.println(Arrays.toString(arr[i]));
            }

            move(arr);

            System.out.println();
            System.out.println();
//            for (int i = 0; i < m; i++) {
//                System.out.println(Arrays.toString(state[i]));
//            }
            for (int i = 0; i < m; i++) {
                System.out.println(Arrays.toString(arr[i]));
            }
            System.out.println(cnt);

            if (answer == cnt) break;
        }


        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new programmers_17679_프렌즈4블록().solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(new programmers_17679_프렌즈4블록().solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
        System.out.println(new programmers_17679_프렌즈4블록().solution(4, 5, new String[]{"AAABB", "AAAAB", "BBAAA", "CCBAA"}));
        System.out.println(new programmers_17679_프렌즈4블록().solution(6, 6, new String[]{"IIIIOO", "IIIOOO", "IIIOOI", "IOOIII", "OOOIII", "OOIIII"}));
    }
}
