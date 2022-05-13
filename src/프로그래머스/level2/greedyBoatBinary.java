package 프로그래머스.level2;

public class greedyBoatBinary {

    public int zeroCnt(int []arr){ // 배에 탄 인원수
        int zero=0;
        for(int i : arr){
            if(i==0) zero++;
        }
        return zero;
    }

    public int solution(int[] people, int limit) {
        int cnt=0;
        while(true){

            cnt ++;
        }
        return cnt;
    }
    public static void main(String[] args) {
        System.out.println(new greedyBoatAll().solution(new int[] {70,50,80,50},100));
    }

}
