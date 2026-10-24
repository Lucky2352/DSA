class Solution {
    int toDayOfYear(String date, int[] ttl) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        return (month == 1 ? 0 : ttl[month - 2]) + day;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] ttl = {31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        int alcAr = toDayOfYear(arriveAlice, ttl);
        int alcLv = toDayOfYear(leaveAlice, ttl);
        int bobAr = toDayOfYear(arriveBob, ttl);
        int bobLv = toDayOfYear(leaveBob, ttl);
        int start = Math.max(alcAr, bobAr);
        int end = Math.min(alcLv, bobLv);
        return Math.max(0, end - start + 1);
    }
}