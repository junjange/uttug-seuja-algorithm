import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        Arrays.sort(works);
        for(int i = 0; i < n; i++) {
            int maxIndex = works.length - 1;
            while(maxIndex > 0 && works[maxIndex] <= works[maxIndex-1]) {
                maxIndex--;
            }
            if(works[maxIndex] != 0) {
                works[maxIndex]--;
            }else {
                return 0;
            }
        }
        
        for(int i = 0; i < works.length; i++) {
            answer += (long)Math.pow(works[i],2);
        }
        
        return answer;
    }
}
