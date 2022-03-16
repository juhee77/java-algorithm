package 프로그래머스.level1;

import java.util.ArrayList;

public class puppetDraw {
    public int solution(int[][] board, int[] moves) {
        ArrayList<Integer> answer= new ArrayList<>();
        int ans=0;
        for(int ele: moves){
            for(int i=0;i<board[ele-1].length;i++)
                if(board[i][ele-1]!=0){
                    //answer=answer+board[i][ele-1];
                    answer.add(board[i][ele-1]);
                    board[i][ele-1]=0;
                    break;
                }

            if(answer.size()>=2 && answer.get(answer.size()-2)==answer.get(answer.size()-1)){
                ans+=2;
                answer.remove(answer.size()-1);
                answer.remove(answer.size()-1);
            }
            System.out.println(answer+"   count: "+ans);
        }

        return ans;
    }

    public static void main(String args[]){
        puppetDraw ex= new puppetDraw();
        int[][] a={{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] b={1,4,3,5,1,2,1,4};
        System.out.println(ex.solution(a,b));
    }
}
