class Solution {
    public int solution(int[] citations) {
        int[] arr = new int[1001];
        
        for(int i : citations) {
            int n = i;
            
            if(n > 1001)
                n = 1000;
            
            for(int j = 1; j <= n; j++) 
                arr[j]++;
        }
        
        int answer = 0;
        for(int i = 0; i < arr.length; i++)
            if(arr[i] >= i)
                answer = i;
        
        return answer;
    }
}