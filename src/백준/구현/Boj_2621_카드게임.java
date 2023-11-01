package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2621_카드게임 {

    private static final int[] cardNum = new int[5];
    private static final int[] cardColorCnt = new int[4];
    private static final int[] cardNumberCount = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int maxCardNum = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            char tempColor = st.nextToken().charAt(0);
            cardNum[i] = Integer.parseInt(st.nextToken());

            maxCardNum = Math.max(maxCardNum, cardNum[i]);
            cardNumberCount[cardNum[i]]++;
            switch (tempColor) {
                case 'R':
                    cardColorCnt[0]++;
                    break;
                case 'B':
                    cardColorCnt[1]++;
                    break;
                case 'Y':
                    cardColorCnt[2]++;
                    break;
                case 'G':
                    cardColorCnt[3]++;
                    break;

            }
        }

        int maxColorCnt = maxColorCnt();

        int a1;
        int a2;

        if (maxColorCnt == 5) {
            if (isAscending()) {
                sb.append(maxCardNum + 900);
            } else {
                sb.append(maxCardNum + 600);
            }
        } else if ((a1 = getNum(4)) != -1) {
            sb.append(a1 + 800);
        } else if ((a1 = getNum(3)) != -1 && (a2 = getNum(2)) != -1) {
            sb.append(a1 * 10 + a2 + 700);
        } else if (isAscending()) {
            sb.append(maxCardNum + 500);
        } else if ((a1 = getNum(3)) != -1) {
            sb.append(a1 + 400);
        } else if ((a1 = getNum(2)) != -1) {
            a2 = -1;
            for (int i = a1 + 1; i < 10; i++) {
                if (cardNumberCount[i] == 2) {
                    a2 = i;
                }
            }

            if (a2 != -1) {
                sb.append(Math.max(a1, a2) * 10 + Math.min(a1, a2) + 300);
            } else {
                sb.append(a1 + 200);
            }
        } else {
            sb.append(maxCardNum + 100);
        }
        System.out.println(sb);


    }

    private static int getNum(int goal) {
        for (int i = 0; i < 10; i++) {
            if (cardNumberCount[i] == goal) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isAscending() {
        int[] array = Arrays.stream(cardNum).sorted().toArray();
        for (int i = 1; i < 5; i++) {
            if (array[0] + i != array[i]) return false;
        }
        return true;
    }

    private static int maxColorCnt() {
        int max = 0;
        for (int i : cardColorCnt) {
            max = Math.max(max, i);
        }
        return max;
    }
}
