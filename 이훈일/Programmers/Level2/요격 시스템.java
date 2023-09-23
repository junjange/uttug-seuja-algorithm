import java.util.Comparator;
import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int count = 1;
        Arrays.sort(targets, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] value = targets[0];
        for(int i = 1; i < targets.length; i++) {
            int[] target = targets[i];
            if(target[0] < value[1]) {
                value[0] = target[0];
                value[1] = Math.min(target[1], value[1]);
            }else {
                value = targets[i];
                count++;
            }
        }
        
        return count;
    }
}
