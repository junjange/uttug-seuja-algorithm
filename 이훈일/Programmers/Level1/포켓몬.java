import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        int[] disArr = Arrays.stream(nums).distinct().toArray();
        return n / 2 > disArr.length ? disArr.length : n/2;
    }
}
