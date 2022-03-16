package 프로그래머스.level1;


import java.util.Stack;

public class puppetDraw_stack {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack= new Stack<>();
        stack.push(0);
        int ans=0;
        for(int ele: moves){
            for(int i=0;i<board[ele-1].length;i++)
                if(board[i][ele-1]!=0) {
                    if(board[i][ele-1]==stack.peek()){
                        stack.pop();
                        ans+=2;
                    }
                    else stack.push(board[i][ele-1]);

                    board[i][ele-1]=0;
                    break;
                }

            System.out.println(stack+"   count: "+ans);
        }

        return ans;
    }

    public static void main(String args[]){
        puppetDraw_stack ex= new puppetDraw_stack();
        int[][] a={{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] b={1,4,3,5,1,2,1,4};
        System.out.println(ex.solution(a,b));
    }
}
