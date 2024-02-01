import java.util.*;
import java.io.*;

public class Main {
	
	static String DNA;
	static int[] ACGT;
	static int S;
	static int P;
	static int answer;
    
    public static void main(String[] args) throws IOException {
        initVariable();
        initACGT();
        getAnswer();
        
        StringBuilder sb = new StringBuilder();
        sb.append(answer);
        System.out.println(sb);
    }
    
    static void initVariable() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        DNA = br.readLine();
        ACGT = new int[4];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 4; i++) {
            ACGT[i] = Integer.parseInt(st.nextToken());
        }
    }
    
    static void initACGT() {
    	for(int i = 0; i < P; i++) {
            char c = DNA.charAt(i);
            if(c == 'A') ACGT[0]--;
            else if(c == 'C') ACGT[1]--;
            else if(c == 'G') ACGT[2]--;
            else ACGT[3]--;
        }
    }
    
    static void getAnswer() {
    	int f = 0, t = P;
        char c;
        while(true) {
            if(ACGT[0] <= 0 && ACGT[1] <= 0 && ACGT[2] <= 0 && ACGT[3] <= 0) {
                answer++;
            }
            
            if(t >= S) {
                break;
            }
            
            c = DNA.charAt(f);
            if(c == 'A') ACGT[0]++;
            else if(c == 'C') ACGT[1]++;
            else if(c == 'G') ACGT[2]++;
            else ACGT[3]++;
                
            c = DNA.charAt(t);
            if(c == 'A') ACGT[0]--;
            else if(c == 'C') ACGT[1]--;
            else if(c == 'G') ACGT[2]--;
            else ACGT[3]--;
            
            f++;
            t++;
        }
    }
}