package 프로그래머스.level2;

import groovy.console.ui.text.MatchingHighlighter;

//https://programmers.co.kr/learn/courses/30/lessons/12905 -- 가장 큰 정사각형 찾기 <0329> __다시풀기, dp
public class maxSquare {
    public int solution(int [][]board)
    {
        int[][] cpyb = new int[board.length+1][board[0].length+1];
        int max=0;
        for(int i=0;i<board.length;i++) {
            for (int j = 0; j < board[i].length; j++) {
                cpyb[i + 1][j + 1] = board[i][j];
            }
        }

        for(int i=1;i<cpyb.length;i++){
            for(int j=1;j<cpyb[i].length;j++){
                if(cpyb[i][j]==1){
                    cpyb[i][j]= Math.min(cpyb[i-1][j-1],Math.min(cpyb[i][j-1],cpyb[i-1][j]))+1;
                    if(max<=cpyb[i][j]) max = cpyb[i][j];
                }
            }
        }
        return max*max;
    }

    public static void main(String args[]){
        System.out.println(new maxSquare().solution(new int[][] {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}));
        System.out.println(new maxSquare().solution(new int[][] {{1,1,1},{1,0,1},{1,1,1}}));
    }
}
