import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        List<Integer> list = new ArrayList<>();
        list.add(numbers[numbers.length - 1]);
        
        for(int i = numbers.length - 2; i >= 0; i--) 
            getAnswer(answer, numbers, list, i);
        
        return answer;
    }
    
    void getAnswer(int[] answer, int[] numbers, List<Integer> list, int i) {
        for(int j = list.size() - 1; j >= 0; j--) {
            if(numbers[i] < list.get(j)) {
                answer[i] = list.get(j);
                list.add(numbers[i]);
                return;
            } else {
                list.remove(j);
            }
        }
        list.add(numbers[i]);
    }
}