import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        
        int start = routes[0][0];
        int end = routes[0][1];
        int count = 1;
        for(int i = 1; i < routes.length; i++) {
            int carStart = routes[i][0];
            int carEnd = routes[i][1];
            
            if(carStart <= end) {
                start = carStart;
                end = Math.min(carEnd, end);
            } else {
                count++;
                start = carStart;
                end = carEnd;
            }
        }
        
        return count;
    }
}
