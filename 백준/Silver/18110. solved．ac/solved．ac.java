import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int inputNum = Integer.parseInt(br.readLine());
            
        int[] arr = new int[inputNum];
        for(int i = 0; i < inputNum; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        
        int n = (int)Math.round(inputNum * 0.15);
        double sum = 0;
        for(int i = n; i < inputNum - n; i++) {
            sum += arr[i];
        }
        bw.append((int)Math.round(sum / (inputNum - (n * 2))) + "");
        bw.close();
    }
}