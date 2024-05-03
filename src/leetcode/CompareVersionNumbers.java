package leetcode;

class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        int hold1_1 = Integer.parseInt(split1[0]);
        int hold1_2 = Integer.parseInt(split1[0]);
        int hold2_1 = Integer.parseInt(split2[0]);
        int hold2_2 = Integer.parseInt(split2[0]);

        if (hold1_1 > hold2_1) {
            return 1;
        } else if (hold1_1 < hold2_1) {
            return -1;
        }else{
            if (hold1_2 > hold2_2) {
                return 1;
            } else if (hold1_2 < hold2_2) {
                return -1;
            }
            return 0;
        }
    }
}