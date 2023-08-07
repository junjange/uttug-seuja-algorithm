class Solution {
    public int solution(int n, int m, int[] sections) {
        int count = 1;
        int start = sections[0];
        for(int i = 1; i < sections.length; i++) {
            if(sections[i] > start + m - 1) {
                if(sections[i] + m - 1 > n) {
                    count += 1;
                    break;
                }else {
                    count += 1;
                    start = sections[i];
                }
            }
        }

        return count;
    }
}
