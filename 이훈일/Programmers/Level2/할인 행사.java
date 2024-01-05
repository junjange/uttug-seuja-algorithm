import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> wants = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wants.put(want[i], number[i]);
        }
        
        int result = 0;
        for (int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> discounts = new HashMap<>();
            for (int j = 0; j < 10; j++) {
                String goods = discount[i + j];
                if (discounts.containsKey(goods)) {
                    discounts.put(goods, discounts.get(goods) + 1);
                } else {
                    discounts.put(goods, 1);
                }
                    
            }
            
            boolean isPossible = true;
            for (String goods : wants.keySet()) {
                if (wants.get(goods) != discounts.get(goods)) {
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) {
               result++; 
            }
        }
        
        return result;
    }
}
