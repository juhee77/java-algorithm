package leetcode;

class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        int[] num1 = new int[split1.length];
        int[] num2 = new int[split2.length];

        for (int i = 0; i < num1.length; i++) {
            num1[i] = Integer.parseInt(split1[i]);
        }
        for (int i = 0; i < num2.length; i++) {
            num2[i] = Integer.parseInt(split2[i]);
        }

        for (int i = 0; i < Math.max(num1.length, num2.length); i++) {

            int left = (num1.length > i) ? num1[i] : 0;
            int right = (num2.length > i) ? num2[i] : 0;

            if (left > right) {
                return 1;
            } else if (left < right) {
                return -1;
            }
        }
        return 0;
    }
}