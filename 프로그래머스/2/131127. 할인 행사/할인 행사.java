class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int size = 0;
        for(int i : number)
            size += i;
        
        for(int i = 0; i < size; i++)
            for(int j = 0; j < want.length; j++) 
                if(want[j].equals(discount[i]))
                    number[j]--;
        
        int answer = 0;
        if(isAnswer(number))
                answer++;
        
        int n = size;
        while(n < discount.length) {
            for(int i = 0; i < want.length; i++) 
                if(want[i].equals(discount[n - size]))
                    number[i]++;
            
            for(int i = 0; i < want.length; i++) 
                if(want[i].equals(discount[n]))
                    number[i]--;
            
            if(isAnswer(number))
                answer++;
            
            n++;
        }
        return answer;
    }
    
    boolean isAnswer(int[] number) {
        for(int i : number)
            if(i != 0)
                return false;
        return true;
    }
}