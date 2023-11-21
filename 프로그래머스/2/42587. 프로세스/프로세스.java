import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int size = priorities.length;
        int[] sort = Arrays.copyOf(priorities, size);
        boolean[] visited = new boolean[size];
        Arrays.sort(sort);
        
        int answer = 0;
        int current = 0;
        int sortCur = size - 1;
        while(true) {
            //1. 현재 프로세스가 이미 실행된 것인 경우: 넘김
            if(visited[current]) {
                current = (current + 1) % size;
                continue;
            }
            
            //2. 현재 프로세스가 우선순위가 낮은 경우: 넘김
            if(priorities[current] != sort[sortCur]) {
                current = (current + 1) % size;
                continue;
            }
            
            //3. 현재 프로셋가 우선순위가 가장 높은 경우: 실행
            if(priorities[current] == sort[sortCur]) {
                //3.1 현재 프로세스가 정답인 경우: 종료
                if(current == location) {
                    answer++;
                    break;
                }
                 
                //3.2 현재 프로세스가 정답이 아닌 경우: 실행
                visited[current] = true;
                current = (current + 1) % size;
                sortCur--;
                answer++;
            }
        }
        return answer;
    }
}