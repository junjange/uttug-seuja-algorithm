import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] times = new int[book_time.length][2];
        for(int i = 0; i < book_time.length; i++) {
            String[] start = book_time[i][0].split(":");
            String[] end = book_time[i][1].split(":");
            
            times[i][0] = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            times[i][1] = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) + 10;
        }
        
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return a1[0] - a2[0];
            }
        });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]> () {
            @Override
            public int compare(int[] a1, int[] a2) {
                return a1[1] - a2[1];
            }
        });
        for(int i = 0; i < times.length; i++) {
            int[] time = times[i];
            
            if(pq.isEmpty()) {
                pq.add(time);
            } else {
                int[] comp = pq.peek();
                    
                if(time[0] >= comp[1]) {
                    pq.poll();
                } 
                
                pq.add(time);
            }
        }
        
        return pq.size();
    }
}
