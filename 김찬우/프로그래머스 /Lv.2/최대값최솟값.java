import java.util.Arrays;

class Solution {
    public String solution(String s) {
        
        String[] str = s.split(" ");
        
        int[] nums = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        
        Arrays.sort(nums);
        
        
        int min = nums[0];
        int max = nums[str.length-1];
        
        
        
        return min+" "+max;
    }
}
