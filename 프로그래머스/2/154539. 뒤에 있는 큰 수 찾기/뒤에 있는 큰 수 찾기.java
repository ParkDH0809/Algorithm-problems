import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        List<Integer> list = new ArrayList<>();
        list.add(numbers[numbers.length - 1]);
        answer[numbers.length - 1] = -1;
        
        for(int i = numbers.length - 2; i >= 0; i--) {
            int size = list.size();
        
            for(int j = size - 1; j >= 0; j--) {
                int currentNumber = list.get(j);
                if(numbers[i] < currentNumber) {
                    answer[i] = currentNumber;
                    list.add(numbers[i]);
                    break;
                } else {
                    list.remove(j);
                }
                
                if(j == 0)  {
                    answer[i] = -1;
                    list.add(numbers[i]);
                }
            }
        }
        return answer;
    }
}