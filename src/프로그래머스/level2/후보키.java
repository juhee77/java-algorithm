package 프로그래머스.level2;

import org.apache.groovy.contracts.common.impl.lc.PreconditionLifecycle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class 후보키 {
    static int[] arr;
    static boolean[] visit;
    static String[][] Arelation;
    static boolean flag;
    int cnt =0;
    private static void dfs(int n, int m, int d,int f) {
        if(d == m) {
//            String temp="";
//            for(int a : arr) temp += a+" ";
//            System.out.println(temp);
//            //고유키 분류가 가능한지 체크
            if(check()) flag = true;
            else flag = false;
            return;
        }

        for(int i = f; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[d] = i;
                dfs(n, m, d+1,i);
                visit[i] = false;
            }
        }
        return;
    }


    public static boolean check(){
        int d= arr.length;
//        HashSet<String[]> hash = new HashSet<>();
//
//        for(int i=0;i< Arelation.length;i++){
//            String reltemp[] = Arelation[i];
//            String temp[] = new String[d];
//            for(int j=0;j<arr.length;j++) temp[j] = reltemp[arr[j]];
//            System.out.print("hash   ");
//            for (Iterator<String[]> it = hash.iterator(); it.hasNext(); ) {
//                String[] e = it.next();
//                System.out.print(Arrays.toString(e)+"   ");
//            }
//            System.out.println();
//            System.out.println("Temp "+Arrays.toString(temp));
//            if(!hash.contains(temp)) {
//                hash.add(temp);
//            }
//            System.out.println("hash contains");
//            return false;
//        }
//        return true;
        HashSet<String> hash = new HashSet<>();

        for(int i=0;i< Arelation.length;i++){
            String reltemp[] = Arelation[i];
            String temp[] = new String[d];
            for(int j=0;j<arr.length;j++) temp[j] = reltemp[arr[j]];
            String temparr="";
            for(int j=0;j<temp.length;j++){
                temparr += temp[j]+" ";
//                if(j<temp.length) {
//                    if(hash.contains(temparr)
//                }
                if(hash.contains(temparr)) return false;
                hash.add(temparr);
            }


            //고유키 분류가 가능한지 체크
            //System.out.println("Temp "+temparr);


        }
        return true;
    }

    public int solution(String[][] relation) {
        Arelation= relation;
        int max = relation[0].length;
        for(int i=1;i<=max;i++){
            //i개를 뽑는 경우의 수
            arr = new int[i]; visit = new boolean[max];
            dfs(max,i, 0,0);

            if(flag) continue;
            else return (i==max)?0:i;
        }
        //흐보키 없는 경우
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new 후보키().solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}}));
        System.out.println(new 후보키().solution(new String[][]{{"100","ryan","music","2"},{"100","ryan","music","2"}}));
    }

}
