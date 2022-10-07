package 백준.hash;

import java.util.HashSet;

public class programmers_영어끝말잇기 {

    public int[] solution(int n, String[] words) {
        HashSet<String> hash = new HashSet<>();
        int nowturn = 0;
        int name=0;
        for(int i=1;i<=words.length;i++){
            if(2<=i && words[i-1].charAt(0) != words[i-2].charAt(words[i-2].length()-1)||
                    hash.contains(words[i-1])){
                nowturn=(i%n==0)?i/n:i/n+1;
                name= (i%n==0)?n:i%n;
                break;
            }
            hash.add(words[i-1]);
        }

        return new int[]{name,nowturn};
    }

    public static void main(String[] args) {
        System.out.println(new programmers_영어끝말잇기().solution(3,new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}));
    }
}

/*

0부터 시작하게 하고
answer[0] = (i % n)+1;
answer[1] = (i / n) + 1;
하는 방법도 있음

 */
