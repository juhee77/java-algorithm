package 프로그래머스.level1;

public class 최소직사각형 {
    public int solution(int[][] sizes) {

        int maxl=Math.max(sizes[0][0],sizes[0][1]);
        int minl=Math.min(sizes[0][0],sizes[0][1]);

        for(int i=1;i<sizes.length;i++){
            int tempminl = Math.min(sizes[i][0],sizes[i][1]);
            int tempmaxl = Math.max(sizes[i][0],sizes[i][1]);

            if(maxl>=tempmaxl && minl>=tempminl)continue;
            else if(maxl>=tempmaxl) minl=tempminl;
            else if(minl>=tempminl) maxl=tempmaxl;
            else {
                minl=tempminl;
                maxl=tempmaxl;
            }

            //maxl=Math.max(maxl,tempmaxl);
           // minl=Math.min(minl,tempminl);
        }

        return maxl*minl;
    }

    public static void main(String args[]){
        최소직사각형 ex = new 최소직사각형();
        int[][] a={{60,50},{30,70},{60,30},{80,40}};
        System.out.println(ex.solution(a));
    }
}
