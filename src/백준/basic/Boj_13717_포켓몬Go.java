package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_13717_포켓몬Go {
    public static class PocketMon implements Comparable<PocketMon> {
        String name;
        int index;
        int increaseLevel;

        public PocketMon(int index,String name, int increaseLevel) {
            this.index = index;
            this.name = name;
            this.increaseLevel = increaseLevel;
        }

        @Override
        public int compareTo(PocketMon o) {
            if (o.increaseLevel == increaseLevel) {
                return index-o.index;
            }
            return o.increaseLevel - increaseLevel;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<PocketMon> pocketMonList = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        int totalLevelUp = 0;
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            st = new StringTokenizer(br.readLine());
            int levelUpCandies = Integer.parseInt(st.nextToken());
            int nowCandies = Integer.parseInt(st.nextToken());

            int increaseLevel = nowCandies / levelUpCandies;
            nowCandies = nowCandies - increaseLevel * levelUpCandies + 2 * increaseLevel;
            while (nowCandies >= levelUpCandies) {
                nowCandies-=levelUpCandies;
                nowCandies+=2;
                increaseLevel++;
            }
            totalLevelUp += increaseLevel;
            pocketMonList.add(new PocketMon(i,name, increaseLevel));
        }
        Collections.sort(pocketMonList);
        PocketMon pocketMon = pocketMonList.get(0);
        System.out.println(totalLevelUp + "\n" + pocketMon.name);


//        for (PocketMon mon : pocketMonList) {
//            System.out.println(mon.name + " " + mon.increaseLevel);
//        }
    }
}
