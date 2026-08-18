class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2,int bx1, int by1, int bx2, int by2) {
        int rect1Bre = ax2 - ax1;
        int rect1Len = ay2 - ay1;
        int rect2Bre = bx2 - bx1;
        int rect2Len = by2 - by1;
        int rect1Area = rect1Bre * rect1Len;
        int rect2Area = rect2Bre * rect2Len;
        int overlapBre = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int overlapLen = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        int overlapArea = overlapBre * overlapLen;
        return rect1Area + rect2Area - overlapArea;
    }
}