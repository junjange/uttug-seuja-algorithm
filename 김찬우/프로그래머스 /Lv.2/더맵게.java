import java.util.*;


class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = 0; 
        
        for(int i = 0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }
        
        
        while(pq.peek() < K){
            
            int first = pq.poll();
            
            if(pq.isEmpty()){
                result = -1;
                break;
            }
            
            int second = pq.poll();
            
            pq.offer(first + second * 2);
            
            result++;

            
        }

    
        return result;
    }
}
