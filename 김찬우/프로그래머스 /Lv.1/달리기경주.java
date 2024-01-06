import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String,Integer> map = new HashMap<>();
        Map<Integer,String> playerMap = new HashMap<>();
        
        for(int i=0; i<players.length; i++){
            
            map.put(players[i],i);
            playerMap.put(i,players[i]);
        
        }
        
        for(int i=0; i<callings.length; i++){
            
            int currentRank = map.get(callings[i]);
            
            String nowPlayer = playerMap.get(currentRank);
            String frontPlayer = playerMap.get(currentRank-1);
            
            map.put(nowPlayer,currentRank-1);
            map.put(frontPlayer,currentRank);
            
            playerMap.put(currentRank-1,nowPlayer);
            playerMap.put(currentRank,frontPlayer);
            
            
        }
        
        for(int i=0; i<players.length; i++){
            
            answer[i] = playerMap.get(i);
            
        }
        
        
      
        return answer;
    }
}
