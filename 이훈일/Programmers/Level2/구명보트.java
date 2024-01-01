import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int result = 0;
        int start = 0;
        int end = people.length - 1;
        
        Arrays.sort(people);
        while(start <= end) {
            if(people[start] + people[end] > limit) {
                result++;
                end--;
            } else {
                result++;
                start++;
                end--;
            }
        }
        
        return result;
    }
}
