package inflearn.stackque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class C_크레인인형뽑기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        char[][] map = new char[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        //크레임 움직이는 숫자
        int movingCnt = Integer.parseInt(br.readLine());
        int[] moving = new int[movingCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < movingCnt; i++) {
            moving[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        System.out.println(solution(map, moving));
    }

    public int solution2(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int pos : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][pos - 1] != 0) {
                    int tmp = board[i][pos - 1];
                    board[i][pos - 1] = 0;
                    if (!stack.isEmpty() && tmp == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    } else stack.push(tmp);
                    break;
                }
            }
        }
        return answer;
    }

    private static int solution(char[][] map, int[] moving) {
        Stack<Character> s = new Stack<>();
        int cnt = 0;
        for (int moved : moving) {
            char doll = 0;

            for (int i = 0; i < map.length; i++) {
                if (map[i][moved] != '0') {
                    doll = map[i][moved];
                    map[i][moved] = '0';
                    break;
                }
            }

            if (doll == 0) continue;//인형이 없는 경우
            if (!s.isEmpty() && s.peek() == doll) {
                cnt += 2; //인형이 같다면 개수 증가
                s.pop();
            } else s.push(doll);
        }
        return cnt;
    }
}
