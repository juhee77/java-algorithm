package 리트코드;

import java.util.*;

class RobotCollisions_2751 {
    private static class Robot implements Comparable<Robot> {
        int position;
        int health;
        int index;
        char dir;

        public Robot(int position, int health, int index, char dir) {
            this.position = position;
            this.health = health;
            this.index = index;
            this.dir = dir;
        }

        @Override
        public int compareTo(Robot other) {
            return this.position - other.position;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Robot> robots = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            robots.add(new Robot(positions[i], healths[i], i, directions.charAt(i)));
        }

        Collections.sort(robots);
        Deque<Robot> stack = new LinkedList<>();

        for (Robot robot : robots) {
            if (robot.dir == 'R') {
                stack.push(robot);
            } else {
                while (!stack.isEmpty() && stack.peek().dir == 'R' && stack.peek().health < robot.health) {
                    stack.pop();
                    robot.health--;
                }
                if (!stack.isEmpty() && stack.peek().dir == 'R') {
                    if (stack.peek().health == robot.health) {
                        stack.pop();
                    } else {
                        stack.peek().health--;
                    }
                } else {
                    stack.push(robot);
                }
            }
        }

        List<Robot> remainingRobots = new ArrayList<>(stack);
        remainingRobots.sort(Comparator.comparingInt(a -> a.index));

        List<Integer> result = new ArrayList<>();
        for (Robot robot : remainingRobots) {
            result.add(robot.health);
        }

        return result;
    }

//    HashMap<Integer, Robot> set = new HashMap<Integer, Solution.Robot>();
//    static List<Robot> robots = new ArrayList<>();
//
//    private static class Robot implements Comparable<Robot> {
//        int position;
//        int health;
//        int index;
//        int dir;
//
//        public Robot(int position, int health, int index, char isRight) {
//            this.position = position;
//            this.health = health;
//            this.index = index;
//            this.dir = (isRight == 'R') ? 1 : 0;
//        }
//
//        @Override
//        public int compareTo(Robot o) {
//            return position - o.position;
//        }
//
//        @Override
//        public String toString() {
//            return "Robot{" +
//                    "position=" + position +
//                    ", health=" + health +
//                    ", index=" + index +
//                    ", dir=" + dir +
//                    '}';
//        }
//    }
//
//    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
//        // 원래 그 자리에 있던 로봇, 이동해서 있는 로봇이 있는 경우
//        set.clear();
//        robots.clear();
//
//        for (int i = 0; i < positions.length; i++) {
//            Robot robot = new Robot(positions[i], healths[i], i, directions.charAt(i));
//            robots.add(robot);
//            set.put(i, robot);
//        }
//        // System.out.println(robots.size());
//        Collections.sort(robots);
//
//        // move
//        boolean flag = true;
//        int j = 0;
//        int min = robots.get(0).position;
//        int max = robots.get(robots.size()-1).position;
//
//        while (j<max-min+1 && flag) {
//            // System.out.println(robots.size());
//            flag = false;
//            for (Robot robot : robots) {
//                if (robot.dir == 1) { // 오른쪽
//                    isChanged(robot, robot.position + 1);
//                } else {
//                    isChanged(robot, robot.position - 1);
//                }
//            }
//            j++;
//
//            min = Integer.MAX_VALUE;
//            max = 0;
//            int dir = -1;
//            for (int i = robots.size() - 1; 0 <= i; i--) {
//                Robot robot = robots.get(i);
//                if (robot.health > 0) {
//                    if (dir == -1) {
//                        dir = robot.dir;
//                    }
//                    else {
//                        if (dir != robot.dir) {
//                            flag = true;
//                            break;
//                        }
//                    }
//
//                    min = Math.min(robot.position, min);
//                    max = Math.max(robot.position, max);
//                } else {
//                    robots.remove(i);
//                }
//            }
//            //System.out.println(robots.size() + " " + robots);
//            // System.out.println(flag);
//        }
//
//        List<Integer> ans = new ArrayList<>();
//        for (int i = 0; i < positions.length; i++) {
//            if (set.get(i).health > 0) {
//                ans.add(set.get(i).health);
//            }
//        }
//        return ans;
//    }
//
//    public static Robot findRobotInThere(int points) {
//        for (Robot robot : robots) {
//            if (robot.position == points) {
//                return robot;
//            }
//        }
//        return null;
//    }
//
//    private static void isChanged(Robot nowRobot, int moved) {
//        if (nowRobot.health <= 0)
//            return;
//
//        Robot beforeRobot = findRobotInThere(moved);
//        if (beforeRobot != null) {
//            if (beforeRobot.health > 0 && beforeRobot.dir + nowRobot.dir == 1) {
//
//                // 그 전에 해당 자리에 있던 사람과 겹치는 경우 둘이 싸운결과
//                if (beforeRobot.health > nowRobot.health) {
//                    beforeRobot.health -= 1;
//                    beforeRobot.position = moved;
//
//                    nowRobot.health = 0;
//                    nowRobot.position = -1;
//                } else if (beforeRobot.health == nowRobot.health) {
//                    beforeRobot.health = nowRobot.health = 0;
//                    beforeRobot.position = nowRobot.position = -1;
//                } else {
//                    nowRobot.health -= 1;
//                    nowRobot.position = moved;
//
//                    beforeRobot.health = 0;
//                    beforeRobot.position = -1;
//                }
//            }
//        } else {
//            nowRobot.position = moved;
//        }
//    }

}