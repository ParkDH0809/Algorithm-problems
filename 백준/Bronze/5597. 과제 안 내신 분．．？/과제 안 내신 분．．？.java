import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        boolean[] arr = new boolean[31];
        for(int i = 0; i < 28; i++)
            arr[Integer.parseInt(br.readLine())] = true;
        
        for(int i = 1; i <= 30; i++)
            if(!arr[i])
                bw.append(i + "\n");
        bw.flush();
    }
}