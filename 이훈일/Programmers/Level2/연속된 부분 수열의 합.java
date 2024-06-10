class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0, sequence.length-1};
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        while(true) {
            if(sum < k && right < sequence.length-1) {
                right++;
                sum += sequence[right];
            } else if(sum > k) {
                sum -= sequence[left];
                left++;
            }
            
            if(sum == k){
                if(right-left < answer[1]-answer[0]) {
                    answer[0] = left;
                    answer[1] = right;
                } else if(right-left == answer[1]-answer[0]) {
                    if(left < answer[0]) {
                        answer[0] = left;
                        answer[1] = right;
                    }
                }
                
                if(right < sequence.length-1) {
                    right++;
                    sum += sequence[right];
                }
            }
            
            if(right == sequence.length-1) {
                if(sum <= k) {
                    break;
                }
            }
        }
        
        return answer;
    }
}
