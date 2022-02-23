package 프로그래머스.level2;

import java.util.Arrays;
/*이렇게 말고 DFS로 구현해야 한다*/


public class 양궁대회_모든경우 {
    public static int[] solution(int n, int[] info) {
        int[] answer = new int[info.length];
        int[] copyinfo = info.clone();//깊은복사 값이 저장된다
        Arrays.sort(copyinfo);
        int max = copyinfo[info.length - 1];
        //System.out.println(max);
        int appeachScore = 0, ryanScore = 0;
        int copyn = n;

        for (int i = 10; 0 <= i; i--) {
            if (info[10 - i] == max) {
                appeachScore += i;
                System.out.println(i + " " + appeachScore);
            } else {
                if (n <= info[10 - i] && 1 <= info[10 - i]) {
                    appeachScore += i;
                } else if (n > 0) {
                    answer[10 - i] = info[10 - i] + 1;
                    n -= info[10 - i] + 1;
                    ryanScore += i;
                }
            }
        }

       if (0 < n)
            answer[10] += n;

        //for (Integer ele : answer)
        //    System.out.print(ele + " ");

        int diff = ryanScore - appeachScore;
        ryanScore = appeachScore = 0;
        //System.out.println("diff" + diff);

        int[] answer2 = new int[info.length];
        for (int i = 10; 0 <= i; i--) {
            if (copyn > info[10 - i]) {
                ryanScore += i;
                answer2[10 - i] = info[10 - i] + 1;
                copyn -= info[10 - i] + 1;
            }
            else if (copyn <= info[10 - i])
                appeachScore += i;
        }
        if (0 < copyn)
            answer2[10] += copyn;

        if (ryanScore - appeachScore >= diff){
            if (ryanScore <= appeachScore) {
                int[] ad = new int[]{-1};
                return ad;
            }
            System.out.println(Integer.toString(diff)+"  "+Integer.toString(ryanScore-appeachScore));
            return answer2;
        }
        else {
            if (diff <= 0) {
                int[] ad = new int[]{-1};
                return ad;
            }
            System.out.println(Integer.toString(diff)+"  "+Integer.toString(ryanScore-appeachScore));
            return answer;
        }
    }

    public static void main(String args[]){
        int []a={2,1,1,1,0,0,0,0,0,0,0};
        int[] ans=solution(5,a);
        for(Integer ele: ans)
            System.out.print(ele+" ");
        System.out.println();

        int []b={2,2,2,2,2,0,0,0,0,0,0};
        int[] ans2=solution(10,b);
        for(Integer ele: ans2)
            System.out.print(ele+" ");
    }
}
