import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i = 0; i < queue1.length; i++) {
            que1.add(queue1[i]);
            sum1 += queue1[i];
        }
        
        for(int i = 0; i < queue2.length; i++) {
            que2.add(queue2[i]);
            sum2 += queue2[i];
        }
        
        int count = 0;
        while(sum1 != sum2) {
            if(que1.isEmpty() || que2.isEmpty()) {
                count = -1;
                break;
            } else {
                if(sum1 > sum2) {
                    int out = que1.poll();
                    sum1 -= out;
                    que2.add(out);
                    sum2 += out;
                } else {
                    int out = que2.poll();
                    sum2 -= out;
                    que1.add(out);
                    sum1 += out;
                }
            }
            count++;
            
            if(count == queue1.length*3) {
                count = -1;
                break;
            }
        }
        
        return count;
    }
}
