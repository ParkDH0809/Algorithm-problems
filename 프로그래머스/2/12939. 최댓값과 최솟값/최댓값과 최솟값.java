class Solution {
    public String solution(String s) {
        String[] sArr = s.split(" ");
        int max = Integer.parseInt(sArr[0]);
        int min = max;
        
        for(String str : sArr) {
            int n = Integer.parseInt(str);
            if(n > max)
                max = n;
            else if(n < min)
                min = n;
        }
        
        return min + " " + max;
    }
}