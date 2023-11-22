import java.util.*;
class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        
        int x = 5;
        int y = 5;
        for(char dir : dirs.toCharArray()) {
            StringBuilder sb = new StringBuilder();
            switch(dir) {
                case 'U':
                    if(y != 10) {
                        int yy = y + 1;
                        set.add(sb.append(x).append(x).append(y).append(yy).toString());
                        y = yy;
                    }
                    break;
                case 'D':
                    if(y != 0) {
                        int yy = y - 1;
                        set.add(sb.append(x).append(x).append(yy).append(y).toString());
                        y = yy;
                    }
                    break;
                case 'R':
                    if(x != 10) {
                        int xx = x + 1;
                        set.add(sb.append(x).append(xx).append(y).append(y).toString());
                        x = xx;
                    }
                    break;
                case 'L':
                    if(x != 0) {
                        int xx = x - 1;
                        set.add(sb.append(xx).append(x).append(y).append(y).toString());
                        x = xx;
                    }
                    break;
            }
        }
        
        return set.size();
    }
}