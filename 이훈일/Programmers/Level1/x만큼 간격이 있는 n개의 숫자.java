import java.util.List;
import java.util.ArrayList;

class Solution {
    public long[] solution(int x, int n) {
        long[] result = new long[n];
        int count = 0;
        long num = x;
        while(count < n) {
            result[count] = num;
            num = num + x;
            count++;
        }
        return result;
    }
}
