class Solution {
    int[] board;
    int answer;
    public int solution(int n) {
        board = new int[n];
        answer = 0;
        nQueen(0);
        return answer;
    }
    
    void nQueen(int current) {
        if(current == board.length) {
            answer++;
            return;
        }
        
        out: for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < current; j++) 
                if(i == board[j] || i == board[j] + current - j || i == board[j] - current + j) 
                    continue out;
                    
            board[current] = i;
            nQueen(current + 1);
            board[current] = 0;
        }
    }
}