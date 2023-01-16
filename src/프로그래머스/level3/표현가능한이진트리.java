package 프로그래머스.level3;

import java.util.Arrays;

public class 표현가능한이진트리 {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long nowNum = numbers[i];
            char[] binaryNums = makeBinaryNums(nowNum);
            boolean checked = checking(0, binaryNums.length - 1, binaryNums, '1'); //중앙 반드시 처음은 1

            if(checked) answer[i] = 1;
            else answer[i] = 0;
        }
        return answer;
    }

    private char[] makeBinaryNums(long nowNum) {
        String binaryNum = Long.toString(nowNum, 2);
        int line = binaryNum.length();
        int now = 1;
        String temp;

        while (true) {
            if (line / now >= 1) now *= 2;
            else {
                //line/now<1
                int refill = (now - 1) - line;
                temp = "0".repeat(refill);
                break;
            }
        }
        return (temp + binaryNum).toCharArray();
    }

    private boolean checking(int start, int end, char[] binaryNum, char targetWantedNum) {
        if (start > end) return true;
        //System.out.println("start+\" \"+end+\" \"+targetWantedNum = " + start + " " + end + " " + targetWantedNum);

        int mid = (start + end) >> 1;
        if (binaryNum[mid] == targetWantedNum) {
            return checking(start, mid - 1, binaryNum, targetWantedNum) && checking(mid + 1, end, binaryNum, targetWantedNum);
        }

        //0이어야 하는데 아닌경우는 fail
        if (targetWantedNum == '0') {
            return false;
        }
        //1이어야 하는데 0인경우는 앞으로 나오는 수 0
        if (targetWantedNum == '1') {
            return checking(start, mid - 1, binaryNum, '0') && checking(mid + 1, end, binaryNum, '0');
        }
        return true;
    }

    public static void main(String[] args) {
        표현가능한이진트리 T = new 표현가능한이진트리();
        System.out.println(Arrays.toString(T.solution(new long[]{7, 42, 5, 63, 111, 95})));
    }
}
