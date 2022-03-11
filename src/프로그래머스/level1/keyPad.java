package 프로그래머스.level1;
//https://programmers.co.kr/learn/courses/30/lessons/67256
public class keyPad {

    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left=0,right=0;
        for(int ele : numbers){
            System.out.println("left"+left+" right"+right+" ele"+ele);
            if(ele %3 ==1) {
                answer+="L";
                left=ele;
            }
            else if(ele%3==0) {
                answer+="R";
                right=ele;
            }
            else{
                int rightD=0,leftD=0;
                if(left%3==1 )leftD=Math.abs(leftD/3-ele/3)+1;
                else leftD=Math.abs(ele/3-left/3);

                if(right%3==0&& ele !=0)rightD=Math.abs(ele/3-right/3)+1+1;
                else rightD=Math.abs(ele/3-right/3);

                System.out.println(leftD + " " +rightD);

                if(leftD==rightD){
                    if(hand.equals("right")){
                        answer+="R";
                        right=ele;
                    }
                    else{
                        answer+="L";
                        left=ele;
                    }
                }
                else if(leftD<rightD){
                    answer+="L";
                    left=ele;
                }
                else{
                    answer+="R";
                    right=ele;
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

