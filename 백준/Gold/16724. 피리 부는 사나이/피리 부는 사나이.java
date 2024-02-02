import java.util.*;
import java.io.*;

public class Main {
	
	static boolean[][] visited;
	static boolean[][] finished;
    static char[][] board;
    static int N;
    static int M;
    static int answer;
    
    public static void main(String[] args) throws IOException {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	visited = new boolean[N][M];
    	finished = new boolean[N][M];
    	board = new char[N][M];
    	
    	for(int r = 0; r < N; r++) {
    		String input = br.readLine();
    		for(int c = 0; c < M; c++) {
    			board[r][c] = input.charAt(c);
    		}
    	}
    	
    	answer = 0;
    	for(int r = 0; r < N; r++) {
    		for(int c = 0; c < M; c++) {
    			if(!visited[r][c])
    				checkBoard(r, c);
    		}
    	}
    	
    	System.out.println(answer);
    }
    
    static void checkBoard(int r, int c) {
    	if(finished[r][c]) {
    		return;
    	} else if(visited[r][c]) {
    		finished[r][c] = true;
    		answer++;
    		return;
    	}
    	
    	visited[r][c] = true;
    	if(board[r][c] == 'U') {
    		checkBoard(r-1, c);
    	} else if(board[r][c] == 'D') {
    		checkBoard(r+1, c);
    	} else if(board[r][c] == 'L') {
    		checkBoard(r, c-1);
    	} else {
    		checkBoard(r, c+1);
    	}
    	
    	finished[r][c] = true;
    }
}