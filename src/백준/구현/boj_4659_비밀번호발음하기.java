package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_4659_비밀번호발음하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String temp;
        while (!(temp = br.readLine()).equals("end")) {
            sb.append("<").append(temp).append("> ");

            char[] chars = temp.toCharArray();
            int aeiou = 0;
            char before = ' ';
            int beforeCnt = 0;
            boolean flag = false;
            boolean aeiouFlag = false;
            int aeiouFCnt=0;

            for (char aChar : chars) {
                if (aChar == 'a' || aChar == 'e' || aChar == 'i' || aChar == 'o' || aChar == 'u') {
                    aeiou++; //1. 하나 이상 있어야 한다.
                    if(aeiouFlag) aeiouFCnt++;
                    else {
                        aeiouFlag=true;
                        aeiouFCnt=1;
                    }
                }
                else{
                    if(!aeiouFlag) aeiouFCnt++;
                    else{
                        aeiouFlag=false;
                        aeiouFCnt=1;
                    }
                }

                if(aeiouFCnt==3) { //자음이나 모음의 연속되는것이 3개가 넘었다.
                    flag=true;
                    break;
                }

                //같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
                if (before == aChar) {
                    if (before == 'e' || before == 'o') {
                        beforeCnt++; //e,o 떄문에
                        if (beforeCnt == 3) {
                            flag = true;
                            break;
                        }
                    } else {
                        flag = true;
                        break;
                    }
                } else {
                    beforeCnt = 0;
                    before = aChar;
                }
            }
            if(aeiou==0) flag = true; //1

            if (flag) sb.append("is not acceptable.").append("\n");
            else sb.append("is acceptable.").append("\n");
        }
        System.out.println(sb);

    }
}
