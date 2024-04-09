package leetcode;

class TimeNeededtoBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int[] hold = new int[101];
        int max = 0, min = Integer.MAX_VALUE;
        for (int ticket : tickets) {
            hold[ticket]++;
            max = Math.max(max, ticket);
            min = Math.min(min, ticket);
        }

        int finishPeople = 0;
        int sum = 0;
        int before = 0;
        for (int i = min; i <= max; i++) {
            if (hold[i] != 0) {
                //System.out.println(i + " " + hold[i] + " " + ((tickets.length - finishPeople) * (i - before)) + " " + sum);

                sum += (tickets.length - finishPeople) * (i - before);
                if (i == tickets[k]) {
                    for (int j = k + 1; j < tickets.length; j++) {
                        if (tickets[j] >= i)
                            sum--;
                    }
                    return sum;
                }

                before = i;
                finishPeople += hold[i];
            }
        }
        return sum;

    }
}