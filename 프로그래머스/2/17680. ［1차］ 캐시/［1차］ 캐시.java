import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        if(cacheSize == 0)
            return cities.length * 5;
        
        ArrayList<String> cache = new ArrayList<>();
        int answer = 0;
        
        for(int i = 0; i < cities.length; i++) {
            String currentCity = cities[i].toUpperCase();
            
            if(cache.contains(currentCity)) {
                cache.remove(cache.indexOf(currentCity));
                cache.add(currentCity);
                answer += 1;
            } else {
                if(cache.size() == cacheSize)
                    cache.remove(0);
                cache.add(currentCity);
                answer += 5;
            }
        }
        return answer;
    }
}