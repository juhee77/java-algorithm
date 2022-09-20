package 프로그래머스.level2;

import java.util.Arrays;
import java.util.Stack;

/*
처음 시도는 dfs 를 찾는것  --> 시간초과
정답은 dfs로 모든 경우 도는게 아닌 메인에서 돌리기
 */
public class programmers_17679_프렌즈4블록_re {
    private static boolean[][] state;
    private static int cnt = 0;
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
//            int[] tempx = {0,0,1,1};
//            int[] tempy ={1,0,1,0};
//            for(int i=0;i<4;i++){
//                if(!state[x+tempx[i]][y+tempy[i]]){
//                    cnt++;
//                    state[x+tempx[i]][y+tempy[i]] = true;
//                }
//            }
//
//        }
//
//        return;
//    }

    private static void move(char arr[][]) {
        Stack<Character> s = new Stack<>();

        for (int j = 0; j < arr[0].length; j++) {
            for (int i = 0; i< arr.length; i++) {
                if (!state[i][j]) {
                    s.push(arr[i][j]);
                }
                arr[i][j] ='.';
            }

            int size = s.size();
            for(int i=0;i<size;i++){
                arr[arr.length-i-1][j]=s.pop();
            }
        }
    }


    public int solution(int m, int n, String[] board) {
       cnt =0;
        int answer = 0;
        char[][] arr = new char[m][n];
        for (int i = 0; i < m; i++) arr[i] = board[i].toCharArray();

        while (true) {
            answer = cnt;
            state = new boolean[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (arr[i][j]=='.') continue;
                    if (arr[i][j] == arr[i][j + 1] && arr[i][j] == arr[i + 1][j] && arr[i][j] == arr[i + 1][j + 1]) {
                        int[] tempx = {0,0,1,1};
                        int[] tempy ={1,0,1,0};
                        for(int k=0;k<4;k++){
                            if(!state[i+tempx[k]][j+tempy[k]]){
                                cnt++;
                                state[i+tempx[k]][j+tempy[k]] = true;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                System.out.println(Arrays.toString(arr[i]));
            }
            System.out.println(cnt);
            for (int i = 0; i < m; i++) {
                System.out.println(Arrays.toString(state[i]));
            }
            if (answer == cnt) break;
            move(arr);

        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new programmers_17679_프렌즈4블록_re().solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(new programmers_17679_프렌즈4블록_re().solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
        System.out.println(new programmers_17679_프렌즈4블록_re().solution(3, 3, new String[]{"ABC", "AVX", "QWE"}));
        System.out.println(new programmers_17679_프렌즈4블록_re().solution(6, 6, new String[]{"IIIIOO", "IIIOOO", "IIIOOI", "IOOIII", "OOOIII", "OOIIII"}));
    }
}
