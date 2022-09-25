package 프로그래머스.level3;


import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class 코딩테스트공부3 {
    public int solution(int alp, int cop, int[][] problems) {

        int alpmax = 0, copmax = 0;
        for (int i = 0; i < problems.length; i++) {
            alpmax = Math.max(alpmax, problems[i][0]);
            copmax = Math.max(copmax, problems[i][1]);
        }

        alp = Math.min(alp,alpmax);
        cop = Math.min(cop,copmax);
        if(alpmax<=alp && copmax<=cop) return 0;
        int arr[][] = new int[alpmax+2][copmax+2];
        arr[alp][cop]=0;

        for(int a=alp;a<alpmax+1;a++){
            for(int c=cop;c<copmax+1;c++){
                arr[a+1][c] = (arr[a+1][c]==0)?arr[a][c]+1:Math.min(arr[a+1][c],arr[a][c]+1);
                arr[a][c+1] = (arr[a][c+1]==0)?arr[a][c]+1:Math.min(arr[a][c+1],arr[a][c]+1);


                for(int i=0;i<problems.length;i++){
                    int reqalp = problems[i][0];
                    int reqcop = problems[i][1];
                    int getalp = problems[i][2];
                    int getcop = problems[i][3];
                    int wtime = problems[i][4];

                    if(a<reqalp || c < reqcop) continue; // 현재는 해당문제를 풀지 못함
                    //if(reqalp==alp&&reqcop==cop)arr[a][c] = Math.min(arr[a][c],)

                    //해당문제 풀기 가능
                    int plusalp = a+getalp;
                    int pluscop = c+getcop;
                    int plustime = wtime+arr[a][c];

                    if(alpmax <= plusalp && copmax<= pluscop){
                        arr[alpmax][copmax] = (arr[alpmax][copmax]==0)?plustime:Math.min(plustime,arr[alpmax][copmax]);
                    }
                    else if(alpmax <= plusalp && copmax > pluscop){
                        arr[alpmax][pluscop] = (arr[alpmax][pluscop]==0)?plustime:Math.min(plustime,arr[alpmax][pluscop]);
                    }
                    else if(alpmax > plusalp && copmax<= pluscop){
                        arr[plusalp][copmax] = (arr[plusalp][copmax] ==0)?plustime:Math.min(plustime,arr[plusalp][copmax]);
                    }
                    else{
                        arr[plusalp][pluscop] = (arr[plusalp][pluscop]==0)?plustime:Math.min(plustime,arr[plusalp][pluscop]);
                    }
                }
            }
        }
        return arr[alpmax][copmax];
    }

    public static void printArr(int[][] arr) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 50; j++) System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(new 코딩테스트공부3().solution(10, 10, new int[][]{{10, 15, 2, 1, 2}, {20, 20, 2, 1, 2}}));
        System.out.println(new 코딩테스트공부3().solution(0, 0, new int[][]{{0, 0, 2, 1, 2}, {4, 5, 3, 1, 2}, {4, 11, 4, 0, 2}, {10, 4, 0, 4, 2}}));
    }
}
