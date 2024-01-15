import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length + 1];
        for(int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            if(remain % speeds[i] == 0) {
                days[i] = remain / speeds[i];
            } else {
                days[i] = remain / speeds[i] + 1;
            }
        }
        
        days[progresses.length] = 101;
        int count = 1;
        int max = days[0];
        List<Integer> counts = new ArrayList<>();
        for(int i = 1; i < days.length; i++) {
            if(max < days[i]) {
                counts.add(count);
                count = 1;
                max = days[i];
            } else {
                count++;
            }
        }
        
        int[] result = new int[counts.size()];
        for(int i = 0; i < counts.size(); i++) {
            result[i] = counts.get(i);
        }
        
        return result;
    }
}
