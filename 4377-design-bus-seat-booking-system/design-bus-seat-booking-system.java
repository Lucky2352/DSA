class BusBooking {
    Map<Integer, List<Integer>> map;
    Map<String, Integer> cost;
    int totalTime = 0;
    int bookedCount = 0;

    public BusBooking(int n) {
        map = new HashMap<>();
        cost = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>(Arrays.asList(0, 0, 0, 0)));
        }
    }

    public void toggle(String seat) {
        char ch = seat.charAt(0);
        int row = Integer.parseInt(seat.substring(1));
        int index = ch - 'A';

        List<Integer> seats = map.get(row);

        if (seats.get(index) == 1) {
            totalTime -= cost.get(seat);
            bookedCount--;

            seats.set(index, 0);
            cost.remove(seat);
        } else {
            int time = 1;

            if (ch == 'A' && seats.get(1) == 1) {
                time = 3;
            } else if (ch == 'D' && seats.get(2) == 1) {
                time = 3;
            }

            seats.set(index, 1);
            cost.put(seat, time);

            totalTime += time;
            bookedCount++;
        }
    }

    public int getTotalTime() {
        return totalTime;
    }

    public int getMinTime() {
        return bookedCount;
    }
}