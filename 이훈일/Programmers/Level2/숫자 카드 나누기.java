import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int numA = arrayA[0];
        List<Integer> numsA = new ArrayList<>();
        for(int i = numA; i >= 1; i--) {
            if(numA % i == 0) {
                numsA.add(i);
            }
        }
        
        int numB = arrayB[0];
        List<Integer> numsB = new ArrayList<>();
        for(int i = numB; i >= 1; i--) {
            if(numB % i == 0) {
                numsB.add(i);
            }
        }
        
        int answerA = 0;
        for(int i = 0; i < numsA.size(); i++) {
            boolean isPossible = true;
            int comp = numsA.get(i);
            
            for(int j = 0; j < arrayA.length; j++) {    
                if(arrayA[j] % comp != 0) {
                    isPossible = false;
                    break;
                }
                
                if(arrayB[j] % comp == 0) {
                    isPossible = false;
                    break;
                }
            }
            
            if(isPossible) {
                answerA = comp;
                break;
            }
        }
        
        int answerB = 0;
        for(int i = 0; i < numsB.size(); i++) {
            boolean isPossible = true;
            int comp = numsB.get(i);
            
            for(int j = 0; j < arrayB.length; j++) { 
                if(arrayB[j] % comp != 0) {
                    isPossible = false;
                    break;
                }
                
                if(arrayA[j] % comp == 0) {
                    isPossible = false;
                    break;
                }
            }
            
            if(isPossible) {
                answerB = comp;
                break;
            }
        }
        
        return Math.max(answerA, answerB);
    }
}
