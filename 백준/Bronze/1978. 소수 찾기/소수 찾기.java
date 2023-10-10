import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            int current = Integer.parseInt(st.nextToken());
            if(isPrime(current)) {
                answer++;
            }
        }
        
        bw.append(answer + "");
        bw.close();
    }
    
    public static boolean isPrime(int input) {
        if(input == 0 || input == 1) {
            return false;
        }
        
        int n = input / 2 + 1;
        
        for(int i = 2; i < n; i++) {
            if(input % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}