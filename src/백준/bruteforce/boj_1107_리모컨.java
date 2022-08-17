package 백준.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_1107_리모컨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashSet<Integer> hashSet = new HashSet<Integer>();
        int goal = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int max = -1, min = 10;

        if (n == 0) {
            for (int i = 0; i <= 9; i++) hashSet.add(i);
            min = 0;
            max = 9;
        } else {
            int narr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
            Arrays.sort(narr);

            int p = 0;
            for (int i = 0; i <= 9; i++) {
                if (p < n && narr[p] == i) {
                    if (p + 1 < n) p++;
                    continue;
                } else hashSet.add(i);

                max = Math.max(i, max);
                min = Math.min(i, min);
            }
        }


        int now = 100;
        int cnt = 0;
        String tempMax = "";
        String tempMin = "";
        String tempSave = "";
        int tempNow = Math.abs(goal - now);
        String s = String.valueOf(goal);

        if (now != goal)
            for (int i = 0; i < s.length(); i++) {
                int temp = Integer.parseInt(s.substring(i, i + 1));
                if (hashSet.contains(temp)) {
                    tempSave = tempMax = tempMin = tempSave + String.valueOf(temp);
                    //System.out.println(tempMax);
                    cnt++;
                } else {
                    int flag = 0;
                    if (min == 10 || max == -1) {
                        cnt = tempNow;
                        break;
                    }

                    if (cnt == 0) {
                        flag = 1;
                        //그것보다 큰것중에 한자릿수 크게 가는경우
                        for (int j = 1; j <= temp - 1; j++) {
                            if (hashSet.contains(j)) {
                                tempMax = tempMax + String.valueOf(j);
                                break;
                            }
                        }
                        int least = s.length() - tempMin.length();
                        if (least < 0) least = 0;
                        tempMax = tempMax + String.valueOf(min).repeat(least + 1);
//                            System.out.println(tempMax);

                        //그것보다 작은수 중에 한자릿수 작게 가는 경우
                        least = s.length() - tempMin.length();
                        if (least < 0) least = 1;
                        tempMin = String.valueOf(max).repeat(least - 1);
//                        System.out.println(tempMin);

                        int base = s.length();
                        tempMax = (tempMax.equals("")) ? "0" : tempMax;
                        tempMin = (tempMin.equals("")) ? "0" : tempMin;
                        if (base == 1)
                            cnt = Math.min(tempNow, Math.min(Math.abs(Integer.parseInt(tempMax) - goal) + base + 1, Math.abs(goal - Integer.parseInt(tempMin)) + base));
                        else
                            cnt = Math.min(tempNow, Math.min(Math.abs(Integer.parseInt(tempMax) - goal) + base + 1, Math.abs(goal - Integer.parseInt(tempMin)) + base - 1));
                    }

                    tempMax = tempMin = tempSave;
                    //그것보다 큰것중에 제일 비슷한것(같은자리수)
                    for (int j = temp + 1; j <= 9; j++) {
                        if (hashSet.contains(j)) {
                            tempMax = tempMax + String.valueOf(j);
                            break;
                        }
                    }
                    int least = s.length() - tempMax.length();
                    if (least < 0) least = 0;
                    tempMax = tempMax + String.valueOf(min).repeat(least);
//                    System.out.println("nonflag"+tempMax);

                    //그것보다 작은것중에 제일 비슷한것(같은자리수)
                    for (int j = temp - 1; 0 <= j; j--) {
                        if (hashSet.contains(j)) {
                            tempMin = tempMin + String.valueOf(j);
                            break;
                        }
                    }
                    least = s.length() - tempMin.length();
                    if (least < 0) least = 0;
                    tempMin = tempMin + String.valueOf(max).repeat(least);
//                    System.out.println("nonflag"+tempMin);

                    int base = s.length();
                    tempMax = (tempMax.equals("")) ? "0" : tempMax;
                    tempMin = (tempMin.equals("")) ? "0" : tempMin;

                    if (flag == 1)
                        cnt = Math.min(cnt, Math.min(Math.abs(Integer.parseInt(tempMax) - goal) + base, Math.abs(goal - Integer.parseInt(tempMin)) + base));
                    else
                        cnt = Math.min(tempNow, Math.min(Math.abs(Integer.parseInt(tempMax) - goal) + base, Math.abs(goal - Integer.parseInt(tempMin)) + base));

                    break;
                }
            }

        System.out.println(cnt);

    }
}


//import java.io.BufferedReader;
//        import java.io.FileInputStream;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.StringTokenizer;
//
//public class Main {
//
//    public static int result=Integer.MAX_VALUE;
//
//    public static int N,M;
//    public static int NSize;
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//
//        N = Integer.parseInt(bf.readLine());
//
//        M = Integer.parseInt(bf.readLine());
//
//        NSize = String.valueOf(N).length();
//
//        boolean numbers[] = new boolean[11];
//        if(M>0){
//            StringTokenizer st =new StringTokenizer(bf.readLine());
//            for(int i=0;i<M;i++){
//                numbers[Integer.parseInt(st.nextToken())]=true;
//            }
//        }
//
//        result = Math.abs(N-100);
//
//        StringBuilder nowNumber = new StringBuilder();
//
//        findNum(numbers,nowNumber);
//
//        System.out.println(result);
//    }
//
//    public static void findNum(boolean numbers[],StringBuilder nowNumber){
//
//        if(nowNumber.length() > 6){
//            return;
//        }
//        if(nowNumber.length()>0){
//            int nowN = Integer.parseInt(nowNumber.toString());
//            int nowSize = String.valueOf(nowN).length();
//            result = Integer.min(Math.abs(N-Integer.parseInt(nowNumber.toString()))+nowSize,result);
//        }
//
//        for(int i=0;i<=9;i++){
//            if(!numbers[i]){
//                nowNumber.append(i);
//                findNum(numbers,nowNumber);
//                nowNumber.setLength(nowNumber.length()-1);
//            }
//        }
//    }
//}