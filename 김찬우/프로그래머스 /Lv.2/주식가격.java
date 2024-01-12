
import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        int[] answer =new int[prices.length];
        
        stack.add(0);
        
        for(int i=1; i<prices.length; i++){
            
            while(!stack.isEmpty() && prices[stack.peekLast()] > prices[i]){
                int a = stack.pollLast();
                
                answer[a] = i-a;
                
            }
            
            stack.add(i);
            
            
        }
        
        int len = stack.size();
        
        if(!stack.isEmpty()){
            
            int start = stack.peek();
            int end = stack.peekLast();
            
            for(int i=0; i<len; i++){
                
                int j = stack.poll();
                
                answer[j] = end -j;
                

                
                
            }
            
            
            
        }
        
        return answer;
    }
}
