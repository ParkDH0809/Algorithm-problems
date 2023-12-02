class Solution {
    public int[] solution(String s) {
        int zeroTotal = 0;
        int n = 0;
        while(!s.equals("1")) {
            int zero = 0;
            for(int i = 0; i < s.length(); i++) 
                if(s.charAt(i) == '0')
                    zero++;
            
            zeroTotal += zero;
            n++;
            s = Integer.toBinaryString(s.length() - zero);
        }
        
        return new int[]{n, zeroTotal};
    }
}