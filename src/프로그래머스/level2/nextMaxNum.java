package 프로그래머스.level2;

public class nextMaxNum {

    public int solution(int n) {
        String b1 = Integer.toBinaryString(n);
        String b2 = ""+b1.charAt(0);
        int oneCnt =0;
        for(int i=0;i<b1.length();i++) if(b1.charAt(i)=='1')oneCnt++;
        if(oneCnt == b1.length()) return Integer.parseInt(b2 = "10"+"1".repeat(oneCnt-1),2);

        oneCnt--; // 한자리 이동후 부터 생각
        for(int i=1;i<b1.length();i++){
            if(b1.charAt(i)=='0'&& b1.charAt(i+1)=='1') {
                b2= b2+ '1' + "0".repeat(b1.length()-b2.length()-oneCnt)+"1".repeat(oneCnt-1);
                break;
            }
            else if( b1.charAt(i)=='1') {b2+= '1'; oneCnt--;}
            else b2+='0';
        }
        System.out.println(b2+"   "+b1);
        return Integer.parseInt(b2,2);
    }
    public int solution2(int n) {
        String b1 = Integer.toBinaryString(n);
        String b2 = ""+b1.charAt(0);
        int oneCnt =1;
        int oneCntB2 =1;
        boolean flag = true;
        for(int i=1;i<b1.length();i++){
            if(b1.charAt(i)=='1')oneCnt++;
            if(flag) {
                if (b1.charAt(i + 1) == '1') {
                    b2 = b2 + '1';
                    oneCntB2++;
                    flag = false;
                } else b2 = b2 + '0';
            }
        }
        if(oneCnt == b1.length()) b2 = "10"+"1".repeat(oneCnt-1);
        else b2 = b2 + "0".repeat(b1.length()-b2.length()-(oneCnt-oneCntB2))+"1".repeat(oneCnt-oneCntB2);
        System.out.println(b2+"   "+b1);
        int answer = Integer.parseInt(b2,2);
        return answer;
    }
    public static void main(String args[]){
        System.out.println(new nextMaxNum().solution(15));
    }

}
