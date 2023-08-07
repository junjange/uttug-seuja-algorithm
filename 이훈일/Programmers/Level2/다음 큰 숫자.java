class Solution {
    public int solution(int n) {
        int nCount = Integer.bitCount(n);
        int count = 0;
        while(nCount != count) {
            n++;
            count = Integer.bitCount(n);
        }

        return n;
    }
}
