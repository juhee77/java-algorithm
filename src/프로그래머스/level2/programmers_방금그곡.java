package 프로그래머스.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class programmers_방금그곡 {
    /*
    방금그곡 서비스에서는 음악 제목, 재생이 시작되고 끝난 시각, 악보를 제공한다.
    네오가 기억한 멜로디와 악보에 사용되는 음은 C, C#, D, D#, E, F, F#, G, G#, A, A#, B 12개이다.
    각 음은 1분에 1개씩 재생된다. 음악은 반드시 처음부터 재생되며 음악 길이보다 재생된 시간이 길 때는 음악이 끊김 없이 처음부터 반복해서 재생된다. 음악 길이보다 재생된 시간이 짧을 때는 처음부터 재생 시간만큼만 재생된다.
    음악이 00:00를 넘겨서까지 재생되는 일은 없다.
    조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다. 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
    조건이 일치하는 음악이 없을 때에는 “(None)”을 반환한다.
     */
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int ansTime = 0;
        ArrayList<String> memory = check(m);

        for(int i=0;i<musicinfos.length;i++){
            String[] temp = musicinfos[i].split(",");
            int startTime = Integer.parseInt(temp[0].substring(0,2))*60+ Integer.parseInt(temp[0].substring(3));
            int endTime =Integer.parseInt(temp[1].substring(0,2))*60+ Integer.parseInt(temp[1].substring(3));
            if(endTime-startTime<0) endTime = 24*60; // 자정 까지만 실행
            int learningTime = endTime-startTime+1;
            ArrayList<String> melody = check(temp[3]);
            int msize = melody.size();
//            System.out.println(memory);
//            System.out.println(melody);


            for(int j =0;j<learningTime;j++){
                boolean flag = true;
                int k=0;
                 for(;k<memory.size();k++){
                     //if(j+k>=learningTime)break;
                     if(memory.get(k).equals(melody.get((j+k)%msize))) continue;
                     else {
                         flag = false;
                         break;
                     }
                 }
                 if(flag){
                     System.out.println(j+" "+k);
                     if(ansTime<learningTime) {
                         ansTime= learningTime;
                         answer = temp[2];
                     }
                     break;
                 }
            }
        }
        return (answer.equals(""))?"(None)":answer;
    }

    private static ArrayList check(String s){
        ArrayList<String> temp = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            String now = s.substring(i,i+1);
            if(i+1<s.length() && s.substring(i+1,i+2).equals("#")) {
                now =s.substring(i,i+2);
                i++;
            }
            temp.add(now);
        }
        return temp;
    }
    public static void main(String[] args) {
        System.out.println(new programmers_방금그곡().solution("ABCDEFG",new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(new programmers_방금그곡().solution("ABCDEFG",new String[]{"11:50,12:04,HELLO,CDEFGAB", "12:57,13:11,BYE,CDEFGAB"}));
        System.out.println(new programmers_방금그곡().solution("ABC",new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEFGHI"}));
    }
}
