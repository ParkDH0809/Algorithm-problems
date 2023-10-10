import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[3];
            for(int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            if(arr[0] == 0) {
                break;
            }
            
            Arrays.sort(arr);
            if(Math.pow(arr[0], 2) + Math.pow(arr[1], 2) == Math.pow(arr[2], 2)) {
                bw.append("right\n");
            } else {
                bw.append("wrong\n");
            }
        }
        bw.close();
    }
}