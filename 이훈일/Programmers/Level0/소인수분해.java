import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        int share = n;
        List<Integer> intList = new ArrayList<>();
        for(int num = 2; num <= share; num++) {
            while(share % num == 0) {
                intList.add(num);
                share = share / num;
            }
        }
        return intList.stream().mapToInt(Integer::intValue).distinct().toArray();
    }
}
