import java.util.*;
import java.lang.Math;
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        
        List<Integer> result = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList();
        
        for(int i = 0; i<progresses.length; i++){
             queue.offer((int)Math.ceil((100.0-progresses[i])/speeds[i]));
        }

        
        while(!queue.isEmpty()){
            
            int minDays = queue.poll();
            
            int count = 1;
            
            while(!queue.isEmpty() && queue.peek() <= minDays){
                queue.poll();
                count++;
            }
            
            result.add(count);
            
            
        }

        return result;
    }
}
