package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1038_감소하는수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int goal = Integer.parseInt(br.readLine());
        int cnt = -1;
        long i=0;
        if(1021==goal) System.out.println("9876543210");
        else if (1021<goal) System.out.println("-1");
        else {
            while (true) {
                String temp = String.valueOf(i);
                if (temp.length() == 1) cnt++;
                else {
                    int hold = Integer.parseInt(temp.substring(0, 1));
                    boolean f = true;
                    for (int j = 1; j < temp.length(); j++) {
                        int temphold = Integer.parseInt(temp.substring(j, j + 1));
                        if (hold <= temphold) {
                            f = false;
                            break;
                        }
                        hold = temphold;
                    }
                    if (f) {
                        //System.out.println(temp + " " + cnt);
                        cnt++;
                    }
                }
                if (cnt == goal) {
                    System.out.println(i);
                    break;
                }
                i++;
                if (temp.equals("9876543210")) break;
            }
        }

    }
}
