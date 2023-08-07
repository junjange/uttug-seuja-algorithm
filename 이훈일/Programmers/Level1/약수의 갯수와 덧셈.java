import java.util.stream.IntStream;

class Solution {
    public int solution(int left, int right) {
        int result = 0;
        for(int i = left; i <= right; i++) {
            int num = i;
            if(IntStream.rangeClosed(1,i).filter(a -> num % a == 0).count() % 2 == 0) {
                result += i;
            } else {
                result -= i;
            }
        }

        return result;
    }
}
