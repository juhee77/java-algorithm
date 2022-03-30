package 프로그래머스.level2;
//https://programmers.co.kr/learn/courses/30/lessons/81302 -- 거리두기 확인하기 <0330>
import java.util.Arrays;
public class makeDistance {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i=0;i<places.length;i++){
            char[][] temp = new char[5][5];
            for(int j=0;j<places[i].length;j++){ //이중배열로 만들기
                temp[j]= places[i][j].toCharArray();
            }

            /*
            for(int z=0;z<5;z++){
                for(int x=0;x<5;x++){
                    System.out.print(temp[z][x]+" ");
                }
                System.out.println();
            }

            System.out.println();System.out.println();
             */
            int flag=0;
            for(int p=0;p<5;p++){
                if(flag==1) break;
                for(int q=0;q<5;q++){
                    if(temp[p][q]=='P'){
                    //cross
                    if(p!=0 && q!= 0 && temp[p-1][q-1]=='P'&& (temp[p][q-1]=='O'||temp[p-1][q]=='O') ) flag=1;
                    if(p!=0 && q<4 && temp[p-1][q+1]=='P'&& (temp[p][q+1]=='O'||temp[p-1][q]=='O') ) flag=1;
                    //up
                    if(p!=0 &&temp[p-1][q]=='P') flag=1;

                    //second up
                    if(p>1 &&temp[p-2][q]=='P'&&temp[p-1][q]=='O') flag=1;

                    //side
                    if(q!=0 &&temp[p][q-1]=='P') flag=1;

                    //secont side
                    if(q>1 &&temp[p][q-2]=='P'&&temp[p][q-1]=='O') flag=1;

                    }
                }
            }
            answer[i] = 1-flag;
            //System.out.println(flag);
            //System.out.println();
        }
        return answer;
    }
    public static void main(String args[]){
        System.out.println(Arrays.toString(new makeDistance().solution(
                new String[][] {{"OOPOO", "OPOOO", "OOOOO", "OOOOO", "OOOOO"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}}
        )));
    }
}
