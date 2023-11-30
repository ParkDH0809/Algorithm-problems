class Solution {
    public String solution(String s) {
        char[] c = s.toCharArray();
        
        boolean isFirst = true;
        for(int i = 0; i < c.length; i++) {
            if(isFirst) {
                if('a' <= c[i] && c[i] <= 'z')
                    c[i] = (char)(c[i] - 32);
                isFirst = false;
            } else {
                if('A' <= c[i] && c[i] <= 'Z')
                    c[i] = (char)(c[i] + 32);
            }
            
            if(c[i] == ' ')
                isFirst = true;
        }
        
        return new String(c);
    }
}