import java.util.Arrays;

class Solution {
    public boolean solution(int x) {
        String strX = x + "";
        int sum = Arrays.stream(strX.split("")).mapToInt(Integer::parseInt).sum();
        return x % sum == 0 ? true : false;
    }
}
