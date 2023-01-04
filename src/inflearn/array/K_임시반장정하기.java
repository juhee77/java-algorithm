package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class K_임시반장정하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        int arr[][] = new int[5][num ];
        HashSet<Integer>[] student = new HashSet[num];

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken()); //가로 세로 바꿔서 배열에 저장(학년별로--가로줄)
            }
        }

        //학생 어레이 리스트
        for(int k=0;k<num;k++){
            student[k] = new HashSet<>();
        }

        for (int i = 0; i < 5; i++) {
            ArrayList<Integer>[] clas = new ArrayList[10];
            for(int k=0;k<10;k++){
                clas[k] = new ArrayList<>();
            }

            //int clas[] = new int[10];
            for (int j = 0; j < num; j++) {
                clas[arr[i][j]].add(j);
            }

            for(int j=0;j<10;j++){
                for(int e: clas[j]){
                    student[e].addAll(clas[j]);
                    //student[e]= student[e].stream().distinct();
                }
            }
            //System.out.println(i+ "   "+ Arrays.toString(student));
        }



        int max = 0;
        int studentAns =0;
        for(int j=0;j<num;j++){
            if(student[j].size()>max) {
                studentAns = j+1;
                max= student[j].size();
            }
        }


        System.out.println(studentAns);

    }
}


