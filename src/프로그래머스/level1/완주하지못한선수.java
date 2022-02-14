package 프로그래머스.level1;
import java.util.Iterator;

public class 완주하지못한선수 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        for(int i=0;i<participant.length;i++){
            String partS=participant[i];
            int flag=1;
            int which=-1;
            for(int j=0;j<completion.length;j++){
                String comS=completion[j];
                if(comS.contentEquals(partS)){
                    flag=0;
                    which=j;
                    break;
                }
            }
            if(flag==1){
                answer=partS;
            }
            else if(flag==0){
                completion[which]="";
            }
        }

        return answer;
    }

    public static void main(String args[]){
        String[] s={"leo", "kiki", "eden"};
        String[] a={"eden", "kiki"};
        System.out.print(solution(s,a));
    }
}
