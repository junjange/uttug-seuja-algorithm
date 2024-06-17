class Solution {
    public int solution(int storey) {
        String str = String.valueOf(storey);
        String[] strs = str.split("");
        
        int length = strs.length;
        int[] nums = new int[length];
        for(int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        
        int count = 0;
        for(int i = length-1; i >= 0; i--) {
            int num = nums[i];
            
            if(num < 5) {
                count += num;
            } else if(num == 5) {
                if(i != 0) {
                    if(nums[i-1] >= 5) {
                        nums[i-1] += 1;
                    }
                } 
                
                count += 5;
            } else {
                if(i == 0) {
                    count += 1;
                } else {
                    nums[i-1] += 1;
                }
                
                count += 10 - num;
            }
        }
        
        return count;
    }
}
