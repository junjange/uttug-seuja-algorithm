import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = new ArrayList<Integer>();
        List<Integer> reserveList = new ArrayList<Integer>();
        for(int l : lost) {
            lostList.add(l);
        }
        for(int r : reserve) {
            if(lostList.contains(r)){
                lostList.remove(Integer.valueOf(r));
            }else {
                reserveList.add(r);
            }

        }

        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(lostList.contains(i)) {
                if(reserveList.contains(i-1)) {
                    reserveList.remove(Integer.valueOf(i-1));
                    count++;
                    continue;
                }
                if(reserveList.contains(i+1)) {
                    reserveList.remove(Integer.valueOf(i+1));
                    count++;
                }
            }else {
                count++;
            }
        }
        return count;
    }
}
