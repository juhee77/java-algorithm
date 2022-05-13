package 프로그래머스.level2;
//https://programmers.co.kr/learn/courses/30/lessons/42885?language=java -- 구명보트
//해당 코드는 한번에 최대한 많은 인원을 태워 나오면 몇명까지 가능한지 코드
public class greedyBoat {
    public int maxCnt(int []people,int remain,int cnt){
        if(people.length==0)return cnt; //종료 포인트

        int max=0; // 카운트 비교용
        int remainPeople[] = new int[people.length-1]; //남은 사람들
        for(int i=0;i<remainPeople.length;i++)remainPeople[i] = people[i+1];

        if(remain>=people[0])
            max = Math.max(maxCnt(remainPeople,remain,cnt),maxCnt(remainPeople,remain-people[0],cnt+1));
        else
            max = maxCnt(remainPeople,remain,cnt);

        //System.out.println(max);
        return max;
    }

    public int solution(int[] people, int limit) {
        return maxCnt(people,limit,0);
    }
    public static void main(String[] args) {
        System.out.println(new greedyBoat().solution(new int[] {70,50,80,50},100));
    }

}
