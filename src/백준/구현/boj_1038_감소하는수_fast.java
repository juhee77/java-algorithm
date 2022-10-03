package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class boj_1038_감소하는수_fast {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int goal = Integer.parseInt(br.readLine());
        HashSet<String> arr= new HashSet<>();

        if(1022==goal) System.out.println("9876543210");
        else if (1022<goal) System.out.println("-1");
        else if(goal<=10) System.out.println(goal);
        else {
            long i = 0;
            while (true) {
//                System.out.println(i +" "+ arr.size());
//                System.out.println(Arrays.toString(arr.toArray()));

                String temp = String.valueOf(i);
                if (temp.length() == 1) {
                    arr.add(temp);
                    i++;
                }
                else{
                    int hold1 = Integer.parseInt(temp.substring(0,1));
                    int hold2 = Integer.parseInt(temp.substring(1,2));

                    if(hold1<=hold2) i=Long.parseLong(String.valueOf(hold1+1)+"0".repeat(temp.length()-1));

                    else{
                        String remain = temp.substring(1);
                        if(arr.contains(remain)){
                            arr.add(temp);
                            if(arr.size()-1==goal) {
                                System.out.println(i);
                                break;
                            }
                            i++;
                        }
                        else{
                            for(int j=2;j<temp.length();j++){
                                hold1 = hold2;//1,2
                                hold2 = Integer.parseInt(temp.substring(j,j+1));//2,3
                                if(hold1<=hold2){
                                    i=Long.parseLong(temp.substring(0,j-1)+String.valueOf(hold1+1)+"0".repeat(temp.length()-j));
                                    break;
                                }
                            }
                        }
                    }
                }

            }
        }
    }
}
