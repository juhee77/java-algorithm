package 프로그래머스.level2;

import java.util.Arrays;

/*
자물쇠 영역을 벗어난 부분에 있는 열쇠의 홈과 돌기는 자물쇠를 여는 데 영향을 주지 않지만,
자물쇠 영역 내에서는 열쇠의 돌기 부분과 자물쇠의 홈 부분이 정확히 일치해야 하며
열쇠의 돌기와 자물쇠의 돌기가 만나서는 안됩니다.
또한 자물쇠의 모든 홈을 채워 비어있는 곳이 없어야 자물쇠를 열 수 있습니다.
열쇠로 자물쇠를 열수 있으면 true를, 열 수 없으면 false를 return 하도록 solution 함수를 완성해주세요.

 */
public class programmers_자물쇠와열쇠 {
    public boolean solution(int[][] key, int[][] lock) {

        int len = key.length;
        int[][] di1= new int [len][len]; //90
        int [][] di2 = new int [len][len]; //180
        int [][] di3 = new int [len][len]; // 270


        for(int i=0;i<key.length;i++){
            for(int j=0;j< key.length;j++){
                if(key[i][j]!=1)continue;
                //90
                di1[j][len-1-i]=1;
                di2[len-1-i][len-1-j]=1;
                di3[len-1-j][i]=1;

            }
        }

        int lxs=21,lys=21;
        int lxe = -1, lye=-1;
        for(int i=0;i<lock.length;i++){
            for(int j=0;j<lock.length;j++){
                if(lock[i][j]==0) {
                    lxs = Math.min(lxs,i);
                    lys = Math.min(lys,j);
                    lxe= Math.max(lxe,i);
                    lye = Math.max(lye,j);
                }
            }
        }

        int lxlen = lxe-lxs+1;
        int lylen = lye-lys+1;

//        printArr(key);
//        printArr(di1);
//        printArr(di2);
//        printArr(di3);
        if(len<lxlen|| len<lylen) return false;

        for(int i=0;i< len; i++){
            for(int j=0;j<len;j++){ //i,j만큼 이동한 경우의 키
                boolean f=true,f1=true,f2=true,f3=true;
                /*check*/
                for(int p=lxs;p<=lxe;p++){
                    for(int q=lys;q<=lye;q++){
                        if(len<=i+p-lxs||len<=j+q-lys||j+q-lys<0||i+p-lxs<0) {
                            f=f1=f2=f3=false;
                            continue;
                        }
                        if(lock[p][q]+key[i+p-lxs][j+q-lys]!=1)  f= false;
                        if(lock[p][q]+di1[i+p-lxs][j+q-lys]!=1)  f1= false;
                        if(lock[p][q]+di2[i+p-lxs][j+q-lys]!=1)  f2= false;
                        if(lock[p][q]+di3[i+p-lxs][j+q-lys]!=1)  f3= false;

                    }
                }
                if(f||f1||f2||f3)return true;
            }
        }
     return false;
    }

    public static void printArr(int[][] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.println(new programmers_자물쇠와열쇠().solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}},new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
        System.out.println(new programmers_자물쇠와열쇠().solution(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 1, 0}},new int[][]{{1, 1, 1}, {1, 0, 0}, {0, 0, 0}}));
    }
}
