package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_28702_FizzBuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int index = 0;
        int number = 0;
        for (int i = 1; i <= 3; i++) {
            String input = br.readLine();
            if (isNumeric(input)) {
                index = i;
                number = Integer.parseInt(input);
            }
        }

        int findNumber = (4 - index) + number;
        if (findNumber % 3 == 0 && findNumber % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (findNumber % 3 == 0) {
            System.out.println("Fizz");
        } else if (findNumber % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(findNumber);
        }
    }

    public static boolean isNumeric(String str) {
        return str != null && str.matches("-?\\d+");
    }
}
