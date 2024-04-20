import java.util.*;

class Solution {
    public int solution(int[] topping) {
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> second = new HashMap<>();
        
        for(int t : topping) {
            first.put(t, first.getOrDefault(t, 0) + 1);
        }
        
        int count = 0;
        for(int t : topping) {
            second.put(t, second.getOrDefault(t, 0) + 1);
            
            if(first.get(t) == 1) {
                first.remove(t);
            } else {
                first.put(t, first.get(t) - 1);
            }
            
            if(first.size() == second.size()) {
                count++;
            }
        }
        
        return count;
    }
}
