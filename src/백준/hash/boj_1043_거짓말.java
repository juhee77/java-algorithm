package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_1043_거짓말 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //진실을 아는 사람
        HashSet<Integer> hash = new HashSet<Integer>();
        st = new StringTokenizer(br.readLine());
        int liers = Integer.parseInt(st.nextToken());
        for (int i = 0; i < liers; i++) {
            int temp = Integer.parseInt(st.nextToken())-1;
            hash.add(temp);
        }

        // 각 파티의 참여 인원
        boolean arr[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            for (int j = 0; j < number; j++) {
                int temp = Integer.parseInt(st.nextToken())-1;
                arr[i][temp] = true;
            }
        }

        int cnt = 0;

        //각 파티에서 진실을 아는 사람이 한명이라도 있으면 진실을 아는 사람에 나머지 사람 추가

        while (true) {
            boolean totalf = true;
            //파티를 모두 돈다
            for (int i = 0; i < m; i++) {
                boolean f = true;

                for (int j = 0; j < n; j++) {
                    if(!arr[i][j]) continue; //참여하지 않은 인원

                    if (hash.contains(j)) { //참여한 인원중에 진실을 아는 사람이 있는경우
                        f  = false; //진실을 말한 경우가 있음
                        break; //이 파티에 참석한 사람을 모두 진실을 아는사람에 추가 해야함
                    }
                }

                boolean temp = true; //만약 이미 파티참석인원이 해쉬에 담겨있는지 확인용

                if(!f){ //진실을 말한 사람이 있는경우
                    for(int j=0;j<n;j++) {
                        if(!arr[i][j])continue; //참여 x
                        if(!hash.contains(j)){ //참여 인원중 진실을 아는 사람에 추가되어있지 않은경우
                            temp = totalf = false;
                            //totalf-->  진실을 말하는 사람이 추가되었으므로 다시 돌아야함
                            break;
                        }
                    }
                }

                if(!temp){ //파티에 참여한 모든 인원이 담기지 않은경우 추가
                    for(int j=0;j<n;j++) {
                        if(arr[i][j])hash.add(j); //참석했던 사람만 추가
                    }
                }
            }
            if(totalf) break; //모든 파티에서 더 이상 추가된 경우가 없으면 break
        }
        //System.out.println(Arrays.toString(hash.toArray()));


        for (int i = 0; i < m; i++) {
            boolean f = true;

            for (int j = 0; j < n; j++) {
                if(!arr[i][j]) continue; //파티 참석 x
                if (hash.contains(j)) {
                    f = false; //진실을 말한 사람이 있는 경우 -- >과장된 이야기 하지 못함
                    break;
                }
            }

            if(f) cnt++; //거짓된 이야기를 할 수 있음
        }

        System.out.println(cnt);
    }

}
