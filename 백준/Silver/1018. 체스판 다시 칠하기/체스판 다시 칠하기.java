import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String[] arr = new String[N];
        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        
        int min = Integer.MAX_VALUE;
        for(int x = 0; x < N - 7; x++) {
            for(int y = 0; y < M - 7; y++) {
                
                boolean check;
                if(arr[x].charAt(y) == 'B') {
                    check = true;
                } else {
                    check = false;
                }
                
                int num = 0;
                for(int i = x; i < x + 8; i++) {
                    check = !check;
                    for(int j = y; j < y + 8; j++) {
                        char c;
                        if(check) {
                            c = 'B';
                        } else {
                            c = 'W';
                        }
                        
                        if(arr[i].charAt(j) != c) {
                            num++;
                        }
                        
                        check = !check;
                    }
                }
                min = Math.min(min, Math.min(num, 64 - num));
            }
        }
        
        System.out.println(min);
    }
}