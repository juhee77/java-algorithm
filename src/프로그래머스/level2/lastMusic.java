package 프로그래머스.level2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//https://programmers.co.kr/learn/courses/30/lessons/17683 방금그곡<0428>
public class lastMusic {
    public String solution(String m, String[] musicinfos) throws ParseException {

        SimpleDateFormat hhmm=new SimpleDateFormat("HH:mm");

        m = m.replaceAll("A#", "a");
        m = m.replaceAll("C#", "c");
        m = m.replaceAll("D#", "d");
        m = m.replaceAll("F#", "f");
        m = m.replaceAll("G#", "g");
        char[] mArr = m.toCharArray();

        int repeatCnt[] = new int[musicinfos.length];
        //String big[] = new String[musicinfos.length];
        String max ="0";

        for(int i=0;i<musicinfos.length;i++){

            String[] musinArr = musicinfos[i].split(",");


            int diffMin =0;
            String beforeTime[] = musinArr[0].split(":");
            String endTime[] = musinArr[1].split(":");
            int before = Integer.parseInt(beforeTime[0])*60 + Integer.parseInt(beforeTime[1]);
            int end = Integer.parseInt(endTime[0])*60 + Integer.parseInt(endTime[1]);
            diffMin=(end<before)?1440-before:end-before;

            musinArr[3]=musinArr[3].replaceAll("A#", "a");
            musinArr[3]=musinArr[3].replaceAll("C#", "c");
            musinArr[3]=musinArr[3].replaceAll("D#", "d");
            musinArr[3]=musinArr[3].replaceAll("F#", "f");
            musinArr[3]=musinArr[3].replaceAll("G#", "g");

            char[] temp = musinArr[3].toCharArray();

            int  q =0; //M의 위치
            int flag = 0;
            for(int c=0;c<diffMin;c++){
                if(q>= mArr.length) {
                    break;
                }

                else if(mArr[q] == temp[c%temp.length]){
                    if(flag == 1 && repeatCnt[i]>0){
                        repeatCnt[i]++;
                        q++;
                    }
                    else if( flag == 0 && repeatCnt[i]==0){
                        flag =1;
                        repeatCnt[i]++;
                        q++;
                    }
                    else if(flag == 0 && repeatCnt[i]>0)
                        break;
                }

                else flag =0;
            }
            String big=Integer.toString(repeatCnt[i])+"-"+diffMin+"-"+i+"-"+musinArr[2];
            String arrMax[] = max.split("-");

            if(repeatCnt[i]>Integer.parseInt(arrMax[0]))
                max=big;
            else if(repeatCnt[i]==Integer.parseInt(arrMax[0])){
                if(diffMin>Integer.parseInt(arrMax[1]))
                    max = big;
                else if(diffMin==Integer.parseInt(arrMax[1])){
                    if(i>Integer.parseInt((arrMax[2])))
                        max = big;
                }
            }
        }

        String arr[] = max.split("-");

        return (arr[0].equals("0"))?"(None)":arr[3];
    }
    public static void main(String args[]) throws ParseException {
        String arr[] = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(new lastMusic().solution("ABC",arr));
    }
}
