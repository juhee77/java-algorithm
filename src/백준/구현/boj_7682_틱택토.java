package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_7682_틱택토 {
    private static int Xs = 0, Os = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        StringBuilder sb = new StringBuilder();

        while (!temp.equals("end")) {
            Xs = Os = 0;
            char[] arr = temp.toCharArray();

            for (int i = 0; i < 9; i++) {
                if (arr[i] == 'X') Xs++;
                else if (arr[i] == 'O') Os++;
            }

            boolean tag;
            if (Xs == Os || Os + 1 == Xs) tag = extracted(sb, arr);
            else tag = false;

            sb.append(tag ? "valid" : "invalid").append("\n");
            temp = br.readLine();
        }
        System.out.println(sb);
    }

    private static boolean extracted(StringBuilder sb, char[] arr) {

        int oflag = getflag(arr, 'O'); //row,col, cross
        int xflag = getflag(arr, 'X');

        if (Xs + Os == 9 && oflag + xflag == 0) return true;
        if (Xs == Os + 1 && oflag == 0 && xflag > 0) return true; //만약 x가 빙고가 있는 경우(x가 마지막에 두어야 한다)그리고 종료
        if (Xs == Os && oflag > 0 && xflag == 0) return true; //만약 o에 빙고가 있는경우 o를 두고 종료가 되어야 한다.

        return false;
    }

    private static int getflag(char[] arr, char x) {
        int flag = 0;
        if (arr[0] == x && arr[0] == arr[4] && arr[4] == arr[8]) flag++; //가로
        if (arr[2] == x && arr[2] == arr[4] && arr[4] == arr[6]) flag++;
        if (arr[0] == x && arr[0] == arr[3] && arr[3] == arr[6]) flag++;
        if (arr[1] == x && arr[1] == arr[4] && arr[4] == arr[7]) flag++; //세로
        if (arr[2] == x && arr[2] == arr[5] && arr[5] == arr[8]) flag++;
        if (arr[0] == x && arr[0] == arr[1] && arr[1] == arr[2]) flag++;
        if (arr[3] == x && arr[3] == arr[4] && arr[4] == arr[5]) flag++; //대각선
        if (arr[6] == x && arr[6] == arr[7] && arr[7] == arr[8]) flag++;
        return flag;
    }
}
