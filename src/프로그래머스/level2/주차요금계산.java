//https://programmers.co.kr/learn/courses/30/lessons/92341
package 프로그래머스.level2;


/* 시간 사용시에 00:00과 같은 0으로 사용되는 값으로 비교시 주의하기*/
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class 주차요금계산 {
    public static int trans(String time)  {
        //SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        //Date date=formatter.parse(time);
        //int times= (int)date.getTime();
        //return times/60000; //분으로 변환
        String[] times=time.split(":");
        return Integer.parseInt(times[0])*60+Integer.parseInt(times[1]);
    }

    public static int[] solution(int[] fees, String[] records)  {
        //feeds 기본시간, 기본요금,단위시간(분),단위요금(원)
        HashMap<Integer,int[]> hash = new HashMap<>();
        for(String elements:records){
            String temp[]=elements.split(" ");
            int key=Integer.parseInt(temp[1]);
            int time=trans(temp[0]);

            if(temp[2].equals("IN")){
                //새로 입차한경우
                if(!hash.containsKey(key)) hash.put(key,new int[]{0,time});
                //이전에 왔는데 새로 입차한경우
                else {
                    int[] difftime=hash.get(key);
                    hash.replace(key, new int[]{difftime[0], time});
                }
            }
            else{//out인 경우
                int[] difftime=hash.get(key);
                hash.replace(key, new int[]{difftime[0]+(time-difftime[1]), -1});
            }
        }
        int endTime=1439;
        int[] answer=new int[hash.size()];
        Object[] keys=hash.keySet().toArray();
        Arrays.sort(keys);

        for(int i=0;i< keys.length;i++){
            int[] difftime=hash.get(keys[i]);
            if(difftime[1]!=-1)//출차가 되지 않은 상태 0초에 입차한 경우 고려해야함
                difftime[0]=difftime[0]+endTime-difftime[1];

            /////System.out.println(endTime);
            /////System.out.println(difftime[0]);

            //가격계산
            if(difftime[0]> fees[0])
                answer[i]= fees[1]+(int)Math.ceil((double) (difftime[0]-fees[0])/fees[2])*fees[3];
            else answer[i]= fees[1];
        }

        return answer;
    }
    public static void main(String args[]){
        int[] fess={180, 5000, 10, 600};
        String[] records={"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] ans=solution(fess,records);
        System.out.println(Arrays.toString(ans));

        int[] fess2={1, 10, 1, 11};
        String[] records2={"00:00 1234 IN", "00:02 1234 OUT"};
        int[] ans2=solution(fess2,records2);
        System.out.println(Arrays.toString(ans2));

        int[] fess3={1, 461, 1, 10};
        String[] records3={"00:00 1234 IN"};
        int[] ans3=solution(fess3,records3);
        System.out.println(Arrays.toString(ans3));
    }
}
