package 리트코드;

import java.util.*;

class Solution {
    private static class Robot implements Comparable<Robot> {
        int position;
        int health;
        int index;
        int dir;

        public Robot(int position, int health, int index, char isRight) {
            this.position = position;
            this.health = health;
            this.index = index;
            this.dir = (isRight == 'R') ? 1 : 0;
        }

        @Override
        public int compareTo(Robot o) {
            return position - o.position;
        }

        @Override
        public String toString() {
            return "Robot{" +
                    "position=" + position +
                    ", health=" + health +
                    ", index=" + index +
                    ", dir=" + dir +
                    '}';
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int len = positions.length;
        List<Robot> robots = new ArrayList<>();
        HashMap<Integer, Robot> set = new HashMap<Integer, Solution.Robot>();

        // 원래 그 자리에 있던 로봇, 이동해서 있는 로봇이 있는 경우

        int maxPosition = 0;
        for (int i = 0; i < positions.length; i++) {
            Robot robot = new Robot(positions[i], healths[i], i, directions.charAt(i));
            robots.add(robot);
            maxPosition = Math.max(maxPosition, positions[i]);

            set.put(i, robot);
        }

        Collections.sort(robots);

        int[] before = new int[maxPosition + 1];
        int[] after = new int[maxPosition + 1];
        Arrays.fill(before, -1);
        Arrays.fill(after, -1);

        for (Robot robot : robots) {
            before[robot.position] = robot.index; // 인덱스 표시
        }

        // move
        boolean flag = true;
        int j = 0;
        while (j < 5 && flag) {
            flag = false;
            System.out.println(robots);
            for (Robot robot : robots) {
                if (robot.dir == 1) { // 오른쪽
                    isChanged(set, before, after, robot, robot.position + 1);
                } else {
                    isChanged(set, before, after, robot, robot.position - 1);
                }
                // if (robot.health <= 0) {
                // robots.remove(robot);
                // }
            }
            j++;

            int dir = -1;
            for (int i=robots.size()-1;0<=i;i--){
                Robot robot = robots.get(i);
                if (robot.health > 0) {
                    if(dir==-1) dir = robot.dir;
                    else{
                        if (dir != robot.dir) {
                            flag = true;
                            break;
                        }
                    }
                }else{
                    robots.remove(i);
                }
            }

            System.out.println(flag);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < robots.size(); i++) {
            if (set.get(i).health > 0) {
                ans.add(set.get(i).health);
            }
        }
        return ans;
    }

    private static void isChanged(HashMap<Integer, Robot> set, int[] before, int[] after, Robot nowRobot,
                                  int moved) {
        if (moved < 0 || before.length <= moved)
            return ;
        if (nowRobot.health <= 0)
            return ;

        if (before[moved] != -1 && set.get(before[moved]).dir + nowRobot.dir == 1) {
            Robot beforeRobot = set.get(before[moved]);
            if (beforeRobot.health > 0) {

                // 그 전에 해당 자리에 있던 사람과 겹치는 경우 둘이 싸운결과
                if (beforeRobot.health < nowRobot.health) {
                    nowRobot.health -= 1;
                    beforeRobot.health = 0;
                    beforeRobot.position = -1;
                    nowRobot.position = moved;
                    before[moved] = nowRobot.index;
                } else if (beforeRobot.health == nowRobot.health) {
                    beforeRobot.health = nowRobot.health = 0;
                    beforeRobot.position = nowRobot.position = -1;
                    before[moved] = -1;
                } else {
                    beforeRobot.health -= 1;
                    nowRobot.health = 0;
                    nowRobot.position = -1;
                    before[moved] = beforeRobot.index;
                }
            }
        }

        if(nowRobot.health<=0) return ;

        if (after[moved] != -1) {
            // 이동한 곳에 이미 있는 경우
            Robot afterRobot = set.get(after[moved]);
            if (afterRobot.health > 0) {
                // 그 전에 해당 자리에 있던 사람과 겹치는 경우 둘이 싸운결과
                if (afterRobot.health < nowRobot.health) {
                    nowRobot.health -= 1;
                    afterRobot.health = 0;
                    afterRobot.position = -1;
                    nowRobot.position = moved;
                    after[moved] = nowRobot.index;
                } else if (afterRobot.health == nowRobot.health) {
                    afterRobot.position = nowRobot.position = -1;
                    afterRobot.health = nowRobot.health = 0;
                } else {
                    afterRobot.health -= 1;
                    nowRobot.position = -1;
                    nowRobot.health = 0;
                }
            }
        } else {
            // 이동한 곳에 표시
            after[moved] = nowRobot.index;
            nowRobot.position = moved;
        }
    }
}