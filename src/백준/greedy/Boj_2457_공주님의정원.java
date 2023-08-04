package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_2457_공주님의정원 {
    private static class Flower implements Comparable<Flower> {
        int startM, startD, endM, endD;

        public Flower(int startM, int startD, int endM, int endD) {
            this.startM = startM;
            this.startD = startD;
            this.endM = endM;
            this.endD = endD;
        }

        @Override
        public int compareTo(Flower other) {
            if (startM == other.startM) {
                if (startD == other.startD) {
                    if (endM == other.endM) {
                        if (endD == other.endD) {
                            return 0;
                        }
                        return other.endD - endD;
                    }
                    return other.endM - endM;
                }
                return startD - other.startD;
            }
            return startM - other.startM;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        PriorityQueue<Flower> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int startM = Integer.parseInt(st.nextToken());
            int startD = Integer.parseInt(st.nextToken());
            int endM = Integer.parseInt(st.nextToken());
            int endD = Integer.parseInt(st.nextToken());
            pq.add(new Flower(startM, startD, endM, endD));
        }

        int cnt = 0;
        int nowM = 3, nowD = 1;

        while (!pq.isEmpty()) {
            Flower flower = pq.poll();
            //채택하는 기준은 현재 날짜가 시작일과 끝날의 사이에 있어야 한다.
            if (flower.startM == nowM && flower.startD == nowD) {
                cnt++;
                nowM = flower.endM;
                nowD = flower.endD;
            } else if (flower.startM < nowM && nowM < flower.endM) { //완전 중앙
                pq.add(new Flower(nowM, nowD, flower.endM, flower.endD));
            } else if (flower.startM == nowM && flower.startD <= nowD) { //시작일 기준
                pq.add(new Flower(nowM, nowD, flower.endM, flower.endD));
            } else if(flower.endM == nowM && nowD < flower.endD ){ //마감일 기준
                pq.add(new Flower(nowM, nowD, flower.endM, flower.endD));
            }

            if (11 < nowM) {
                break;
            }
        }

        if (11 < nowM) System.out.println(cnt);
        else System.out.println(0);
    }
}
