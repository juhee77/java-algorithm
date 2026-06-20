package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumBuildingHeight_1840 {
    public int maxBuilding(int n, int[][] restrictions) {
        // 제약 없으면 가장 높게 올라감
        if (restrictions.length == 0) return n - 1;

        int m = restrictions.length;
        int[][] res = new int[m + 1][2];
        res[0] = new int[]{1, 0}; //가장 처음은 0이다
        for (int i = 0; i < m; i++) {
            res[i + 1] = restrictions[i];
        }

        // 건문 번호 대로 정렬
//        Arrays.sort(res, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(res, Comparator.comparingInt(a -> a[0]));

        //왼쪽
        for (int i = 1; i <= m; i++) {
            int dist = res[i][0] - res[i - 1][0]; // 두 건물의 인덱스 차이
            res[i][1] = Math.min(res[i][1], res[i - 1][1] + dist); // 두 건물의 인덱스 차이 만큼 커질 수 있음
        }

        //오른쪽
        for (int i = m - 1; i >= 0; i--) {
            int dist = res[i + 1][0] - res[i][0]; // 두 건물의 인덱스 차이
            res[i][1] = Math.min(res[i][1], res[i + 1][1] + dist); // 두 건물의 인덱스 차이 만큼 커질 수 있음
        }

        int maxAns = 0;

        for (int i = 1; i <= m; i++) {
            int id1 = res[i - 1][0], h1 = res[i - 1][1];
            int id2 = res[i][0], h2 = res[i][1];

            // 두 제한점 사이에서 도달할 수 있는 가장 높은 꼭대기
            int localMax = (id2 - id1 + h1 + h2) / 2;
            maxAns = Math.max(maxAns, localMax);
        }

        // 마지막 제한 구역 이후부터 마지막까지 올라가는 경우 고려
        int lastId = res[m][0];
        int lastHeight = res[m][1];
        maxAns = Math.max(maxAns, lastHeight + (n - lastId));

        return maxAns;
    }

    public static void main(String[] args) {
        MaximumBuildingHeight_1840 solution = new MaximumBuildingHeight_1840();

        // TC 1: 제한 구역 사이에서 솟아오르는 기본 케이스
        int n1 = 5;
        int[][] restrictions1 = {{2, 1}, {4, 1}};
        int expected1 = 2;
        int result1 = solution.maxBuilding(n1, restrictions1);
        printResult(1, expected1, result1);

        // TC 2: 제한이 아예 없는 경우 (마지막 건물이 제일 높음)
        int n2 = 6;
        int[][] restrictions2 = {};
        int expected2 = 5;
        int result2 = solution.maxBuilding(n2, restrictions2);
        printResult(2, expected2, result2);

        // TC 3: 입력값 정렬이 안 되어 있고 제한이 많은 복잡한 케이스
        int n3 = 10;
        int[][] restrictions3 = {{5, 3}, {2, 5}, {7, 4}, {10, 3}};
        int expected3 = 5;
        int result3 = solution.maxBuilding(n3, restrictions3);
        printResult(3, expected3, result3);

        // TC 4: 마지막 제한 구역 이후로 끝까지 쭉 올라가는 케이스
        int n4 = 10;
        int[][] restrictions4 = {{2, 1}};
        int expected4 = 9; // 2번 건물이 1이고, 10번 건물까지 8칸 쭉 올라감 (1 + 8)
        int result4 = solution.maxBuilding(n4, restrictions4);
        printResult(4, expected4, result4);
    }

    // 결과 출력을 도와주는 헬퍼 메서드
    private static void printResult(int tcNum, int expected, int result) {
        System.out.println("=== Test Case " + tcNum + " ===");
        System.out.println("기대값: " + expected);
        System.out.println("실제값: " + result);
        if (expected == result) {
            System.out.println("결과: [PASS] ✅\n");
        } else {
            System.out.println("결과: [FAIL] ❌\n");
        }
    }
}
