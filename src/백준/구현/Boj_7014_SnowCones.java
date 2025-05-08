package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_7014_SnowCones {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int TC = 1; TC <= n; TC++) {
            char[] curr = br.readLine().toCharArray();
            char[] goal = br.readLine().toCharArray();

            ArrayList<Integer> currXPos = new ArrayList<Integer>();
            ArrayList<Integer> goalXPos = new ArrayList<Integer>();
            for (int i = 0; i < curr.length; i++) {
                if (curr[i] == 'X')
                    currXPos.add(i);
                if (goal[i] == 'X')
                    goalXPos.add(i);
            }

            int numX = currXPos.size();
            int numSwaps = 0;
            boolean same = false;
            while (!same) {
                same = true;
                //왼쪽부터 스캔
                for (int i = 0; i < numX; i++) {
                    int currXInd = currXPos.get(i);
                    if (currXInd < goalXPos.get(i)) // need to move right
                    {
                        if (!currXPos.contains(currXInd + 1)) {
                            currXPos.set(i, currXInd + 1);
                        }
                        same = false;
                    }
                }
                //오른쪽 부터 스캔
                for (int i = numX - 1; i >= 0; i--) {
                    int currXInd = currXPos.get(i);
                    if (currXPos.get(i) > goalXPos.get(i)) {
                        if (!currXPos.contains(currXInd - 1)) {
                            currXPos.set(i, currXInd - 1);
                        }
                        same = false;
                    }
                }
                if (!same)
                    numSwaps++;
            }
            sb.append("Data Set " + TC + ":\n" + numSwaps + "\n\n");
            //System.out.println("" + maxBound); // debugging only
        }
        System.out.println(sb);
    }
}
