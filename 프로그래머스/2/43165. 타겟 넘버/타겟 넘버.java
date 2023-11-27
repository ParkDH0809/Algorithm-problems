class Solution {
    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        method(numbers, target, 0, 0);
        return answer;
    }
    
    void method(int[] numbers, int target, int sum, int count) {
        if(count == numbers.length) {
            if(target == sum)
                answer++;
            return;
        }
        
        method(numbers, target, sum + numbers[count], count + 1);
        method(numbers, target, sum - numbers[count], count + 1);
    }
}