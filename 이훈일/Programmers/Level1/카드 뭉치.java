import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        List<String> cards1List = new ArrayList<>(Arrays.asList(cards1));
        List<String> cards2List = new ArrayList<>(Arrays.asList(cards2));
        List<String> goalList = new ArrayList<>(Arrays.asList(goal));
        
        for(String s : goal) {
            if(!(cards1List.size() == 0)) {
                if(cards1List.get(0).equals(s)){
                    cards1List.remove(0);
                    goalList.remove(s);
                } 
            } 
            if (!(cards2List.size() == 0)) {
                if(cards2List.get(0).equals(s)){
                    cards2List.remove(0);
                    goalList.remove(s);
                }
            }
        }
        return goalList.size() == 0 ? "Yes":"No";
    }
}
