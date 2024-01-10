import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int result = 0;
        ArrayList<String> cache = new ArrayList<>();

        if(cacheSize == 0) {
            return cities.length * 5;
        }

        for(int i = 0;i < cities.length;i++) {
            String city = cities[i].toUpperCase();

            if(cache.contains(city)) {
                cache.remove(city); 
                cache.add(city); 
                result += 1;
            } else { 
                if(cache.size() == cacheSize) {
                    cache.remove(0); 
                }
                
                cache.add(city); 
                result += 5;
            }
        }

        return result;
    }
}
