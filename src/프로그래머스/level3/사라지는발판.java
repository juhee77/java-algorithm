package 프로그래머스.level3;



public class 사라지는발판 {
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        int answer = -1;
//        printArr2d p = new printArr2d(board);
//        p.printarr(board);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new 사라지는발판().solution(new int[][]{{1,1,1},{1,1,1},{1,1,1}},new int[]{1,0},new int[]{1,2}));
        System.out.println(new 사라지는발판().solution(new int[][]{{1}},new int[]{0,0},new int[]{0,0}));
    }
}
