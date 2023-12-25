import java.util.*;
import java.io.*;

public class Main {

    static int white;
    static int blue;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++)
                paper[i][j] = Integer.parseInt(st.nextToken());
        }   

        white = 0;
        blue = 0;
        cutPaper(N, paper);

        bw.append(white + "\n" + blue);
        bw.flush();
    }

    static void cutPaper(int N, int[][] paper) {
        if(check(paper)) {
            if(paper[0][0] == 0)
                white++;
            else
                blue++;

            return;
        }
        
        int[][] newPaper = new int[N/2][N/2];
        for(int i = 0; i < N/2; i++)
            System.arraycopy(paper[i], 0, newPaper[i], 0, N/2);
        cutPaper(N/2, newPaper);

        for(int i = 0; i < N/2; i++)
            System.arraycopy(paper[i], N/2, newPaper[i], 0, N/2);
        cutPaper(N/2, newPaper);

        for(int i = 0; i < N/2; i++)
            System.arraycopy(paper[i + N/2], 0, newPaper[i], 0, N/2);
        cutPaper(N/2, newPaper);

        for(int i = 0; i < N/2; i++)
            System.arraycopy(paper[i + N/2], N/2, newPaper[i], 0, N/2);
        cutPaper(N/2, newPaper);
    }

    static boolean check(int[][] paper) {
        int current = paper[0][0];
        for(int i = 0; i < paper.length; i++) 
            for(int j = 0; j < paper[0].length; j++) 
                if(current != paper[i][j])
                    return false;

        return true;
    }
}