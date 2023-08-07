import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = 0;
        int total = 0;
        for(int num : d){
            if(total + num <= budget){
                total += num;
                count++;
            }else {
                break;
            }
        }
        
        return count;
    }
}
