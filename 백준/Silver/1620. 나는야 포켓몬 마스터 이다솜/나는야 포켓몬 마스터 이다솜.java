import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        HashMap<Integer, String> searchName = new HashMap<>();
        HashMap<String, Integer> searchNumber = new HashMap<>();
        
        for(int i = 1; i <= N; i++) {
            String input = br.readLine();
            searchName.put(i, input);
            searchNumber.put(input, i);
        }
        
        for(int i = 0; i < M; i++) {
            String inputName = br.readLine();
            int inputNumber = 0;
            boolean isNumber = true;
            try {
                inputNumber = Integer.parseInt(inputName);
            } catch(NumberFormatException e) {
                isNumber = false;
            }
            
            if(isNumber) {
                bw.append(searchName.get(inputNumber) + "\n");
            } else {
                bw.append(searchNumber.get(inputName) + "\n");
            }
        }
        bw.close();
    }
}