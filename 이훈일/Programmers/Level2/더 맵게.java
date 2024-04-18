import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }
        
        int count = 0;
        while(queue.size() > 1 && queue.peek() < K) {
            int first = queue.poll();
            int second = queue.poll();
            
            queue.add(second * 2 + first);
            count++;
        }
        
        return queue.poll() >= K ? count : -1;
    }
}
