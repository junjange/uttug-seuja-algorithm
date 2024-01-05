import java.util.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int count = 1; count < elements.length; count++) {
            for(int start = 0; start < elements.length; start++) {
                int sum = 0;
                for(int i = start; i < start + count; i++) {
                    sum += elements[i % elements.length];     
                }
                set.add(sum);
            }
        }
        
        return set.size() + 1;
    }
}
