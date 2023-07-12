class Solution {
    public int solution(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i+1; j < nums.length - 1; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int a = 0;
                    for(int num = 2; num <= sum/2; num++) {
                        if(sum % num == 0) {
                            a += 1;
                            break;
                        }
                    }
                    if(a == 0) {
                        count += 1;
                    }
                }
            }
        }

        return count;
    }
}
