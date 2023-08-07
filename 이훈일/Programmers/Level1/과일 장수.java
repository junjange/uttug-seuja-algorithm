import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int sum = 0;
        for(int i = score.length % m; i < score.length; i += m) {
            sum += score[i];
        }
        return sum * m;
    }
}
