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
            Xs = Os =0;
            char[] arr = temp.toCharArray();

            for (int i = 0; i < 9; i++) {
                if (arr[i] == 'X') Xs++;
                else if (arr[i] == 'O') Os++;
            }

            if (Xs == Os )extracted(sb, arr,0);
            else if(Os+1 ==Xs) extracted(sb, arr,1);
            else sb.append("invalid\n");

            temp = br.readLine();
        }
        System.out.println(sb);
    }

    private static void extracted(StringBuilder sb, char[] arr,int now) {

        int rflag = getRflag(arr, 'O');
        int lflag = getLflag(arr, 'O');
        int cflag = getCflag(arr, 'O');
        int rXflag = getRflag(arr, 'X');
        int lXflag = getLflag(arr, 'X');
        int cXflag = getCflag(arr, 'X');

        if (rflag + rXflag>= 2 || lflag+lXflag >= 2) sb.append("invalid\n");
        else {
            if(now == 0){
                if(rXflag+lXflag+cXflag==0&&lflag+rflag+cflag>0)sb.append("valid\n");
                else sb.append("invalid\n");
            }
            else if(now==1){
                if(Xs+Os == 9 && rXflag+lXflag+cXflag+rflag+lflag+cflag==0) sb.append("valid\n");
                else if(lflag+rflag+cflag==0&&rXflag+lXflag+cXflag>0)sb.append("valid\n");
                else sb.append("invalid\n");
            }

        }
    }

    private static int getCflag(char[] arr, char x) {
        int cflag=0;
        if (arr[0] == x && arr[0] == arr[4] && arr[4] == arr[8]) cflag++;
        if (arr[2] == x && arr[2] == arr[4] && arr[4] == arr[6]) cflag++;
        return cflag;
    }

    private static int getLflag(char[] arr, char x) {
        int lflag =0;
        if (arr[0] == x && arr[0] == arr[3] && arr[3] == arr[6]) lflag++;
        if (arr[1] == x && arr[1] == arr[4] && arr[4] == arr[7]) lflag++;
        if (arr[2] == x && arr[2] == arr[5] && arr[5] == arr[8]) lflag++;
        return lflag;
    }

    private static int getRflag(char[] arr, char x) {
        int rflag=0;
        if (arr[0] == x && arr[0] == arr[1] && arr[1] == arr[2]) rflag++;
        if (arr[3] == x && arr[3] == arr[4] && arr[4] == arr[5]) rflag++;
        if (arr[6] == x && arr[6] == arr[7] && arr[7] == arr[8]) rflag++;
        return rflag;
    }
}
