import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        
        int sum = 0;
        int answer = 0;
        for(int i = 0; i < enemy.length; i++) {
            int num = enemy[i];
            pq.add(num);
            sum += num;
            
            if(sum > n) {
                if(k > 0) {
                    int max = pq.poll();
                    sum -= max;
                    k--;
                } else {
                    answer = i;
                    break;
                }
            }
        }
        
        return answer == 0 ? enemy.length : answer;
    }
}
