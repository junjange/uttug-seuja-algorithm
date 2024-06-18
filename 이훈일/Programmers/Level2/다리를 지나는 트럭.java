import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> trucks = new LinkedList<>();
        int sum = 0;
        int time = 0;
        for(int tw : truck_weights) {
            while(true) {
                if(trucks.size() == 0) {
                    trucks.add(tw);
                    sum += tw;
                    time += 1;
                    break;
                } else if(trucks.size() == bridge_length) { 
                    sum -= trucks.poll();
                } else {
                    if(sum+tw <= weight) {
                        trucks.add(tw);
                        sum += tw;
                        time++;
                        break;
                    } else {
                        trucks.add(0);
                        time++;
                    }
                }
            }
        }
        
        return time + bridge_length;
    }
}
