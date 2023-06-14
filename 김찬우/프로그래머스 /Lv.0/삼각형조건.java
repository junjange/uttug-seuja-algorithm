import java.util.Arrays;

class Solution {
    public int solution(int[] sides) {
        
        int count = 0;
        
        Arrays.sort(sides);
        
        count += sides[1]-(sides[1]-sides[0]);
        
        System.out.println(count);
        
        if((sides[1]+sides[0])-sides[1]>1){
            count+= ((sides[1]+sides[0])-sides[1])-1;
        }
        
        System.out.println(count);
        
        return count;
        
    }
}
