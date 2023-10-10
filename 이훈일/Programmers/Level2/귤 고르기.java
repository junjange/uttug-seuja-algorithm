import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Arrays.sort(tangerine);
        int pre = tangerine[0];
        map.put(tangerine[0], 1);
        int count = 1;
        int sum = 0;
        for(int i = 1; i < tangerine.length; i++) {
            if(pre == tangerine[i]) {
                count++;
            }else {
                pre = tangerine[i];
                count = 1;
            }
            map.put(tangerine[i], count);
        }
        
        ArrayList<Integer> keySet = new ArrayList<Integer>(map.keySet());
        
        keySet.sort((o1,o2) -> map.get(o2).compareTo(map.get(o1)));
        
        int answer = 0;
        for(int i = 0; i < keySet.size(); i++) {
            sum += map.get(keySet.get(i));
            answer++;
            if(sum >= k) {
                break;
            }
        }
        
        return answer;
    }
}
