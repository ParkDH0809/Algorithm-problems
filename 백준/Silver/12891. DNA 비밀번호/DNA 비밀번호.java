import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        String DNA = br.readLine();
        
        int[] ACGT = new int[4];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 4; i++) {
            ACGT[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < P; i++) {
            char c = DNA.charAt(i);
            if(c == 'A') ACGT[0]--;
            else if(c == 'C') ACGT[1]--;
            else if(c == 'G') ACGT[2]--;
            else ACGT[3]--;
        }
        int f = 0, t = P, answer = 0;
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
        
        bw.append(answer + "");
        bw.close();
    }
}