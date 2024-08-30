import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> playCounts = new HashMap<>();
        HashMap<Integer, Integer> indexes = new HashMap<>();
        HashMap<String, List<Integer>> numbers = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            playCounts.put(genre, playCounts.getOrDefault(genre, 0) + play);
            indexes.put(i, play);
            
            if(numbers.containsKey(genre)) {
                List<Integer> maxPlays = numbers.get(genre);
                maxPlays.add(i);
                
                Collections.sort(maxPlays, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer i1, Integer i2) {
                        if(indexes.get(i1) == indexes.get(i2)) {
                            return i1 - i2;
                        }
                        return indexes.get(i2) - indexes.get(i1);
                    }
                });
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                numbers.put(genre, list);
            }
        }
        
        List<String> keys = new ArrayList<>(playCounts.keySet());
        Collections.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return playCounts.get(s2) - playCounts.get(s1);
            }
        });
        
        List<Integer> result = new ArrayList<>();
        int index = -1;
        for(String key : keys) {
            List<Integer> maxPlays = numbers.get(key);
            for(int i = 0; i < maxPlays.size(); i++) {
                if(i == 2) {
                    break;
                }
                result.add(maxPlays.get(i));
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
