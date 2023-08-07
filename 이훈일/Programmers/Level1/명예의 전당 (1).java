import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> best = new ArrayList<>();
        int[] result = new int[score.length];
        for(int i = 0; i < score.length; i++) {
            best.add(score[i]);
            Collections.sort(best);
            if(best.size() == k+1) {
                best.remove(0);
            }
            result[i] = best.get(0);
        }

        return result;
    }
}
