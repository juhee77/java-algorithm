package 프로그래머스.level1;
//https://programmers.co.kr/learn/courses/30/lessons/67256
public class keyPad {

    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left=10,right=12;
        for(int ele : numbers){
            System.out.println("left"+left+" right"+right+" ele"+ele);
            System.out.println("left"+left+" right"+right+" ele"+ele);
            int temp=(ele==0)? 11: ele;

            if(temp %3 ==1) {
                answer+="L";
                left=temp;
            }
            else if(temp%3==0) {
                answer+="R";
                right=temp;
            }
            else{
                int rightD=0,leftD=0;

                if(left%3==1 )leftD=Math.abs(left/3-temp/3)+1;
                else leftD=Math.abs(temp/3-left/3);

                // (/3을 아래처럼 나누지 않고 -1을 하여 갈라지게 하면 더 간단해짐
                if(right%3==0 && right<temp)rightD=temp/3-right/3+1+1;
                else if(right%3==0&& right>=temp) rightD=right/3-temp/3;
                else rightD=Math.abs(temp/3-right/3);

                System.out.println(leftD + " " +rightD);

                if(leftD==rightD){
                    if(hand.equals("right")){
                        answer+="R";
                        right=temp;
                    }
                    else{
                        answer+="L";
                        left=temp;
                    }
                }
                else if(leftD<rightD){
                    answer+="L";
                    left=temp;
                }
                else{
                    answer+="R";
                    right=temp;
                }
            }
        }
        return answer;
    }

    public static void main(String args[]){
        int[] a={1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        keyPad ex=new keyPad();
        System.out.println(ex.solution(a,"right"));
    }

}

