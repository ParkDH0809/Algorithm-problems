import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[201];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(; N > 0; N--)
            arr[Integer.parseInt(st.nextToken()) + 100]++;
        bw.append(arr[Integer.parseInt(br.readLine()) + 100] + "");
        bw.flush();
    }
}