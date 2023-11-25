import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int count = 0;
        int weight = 0;
        int front = 0;
        int back = people.length - 1;
        while (front <= back) {
            weight += people[back--];
            
            if(people[front] + weight <= limit)
                front++;
            
            weight = 0;
            count++;
        }
        return count;
    }
}