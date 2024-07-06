import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                if(!list.contains(numbers[i] + numbers[j])) {
                    list.add(numbers[i] + numbers[j]);
                }
            }
        }
        
        int[] intArr = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(intArr);
        return intArr;
    }
}
