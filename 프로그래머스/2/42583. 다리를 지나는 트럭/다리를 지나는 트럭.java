import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1;
        int totalWeight = 0;
        int truckCount = 0;
        int finished = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(finished < truck_weights.length) {
            if(truckCount < truck_weights.length && totalWeight + truck_weights[truckCount] <= weight) {
                totalWeight += truck_weights[truckCount];
                list.add(0);
                truckCount++;
            }
            
            for(int i = 0; i < list.size(); i++)
                list.set(i, list.get(i) + 1);
            
            if(list.get(0) == bridge_length) {
                list.remove(0);
                totalWeight -= truck_weights[finished++];
            }
            
            time++;
        }
        
        return time;
    }
}