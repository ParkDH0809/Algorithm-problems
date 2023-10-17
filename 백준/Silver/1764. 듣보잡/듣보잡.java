import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        HashSet<String> set = new HashSet<>();
        while(N > 0) {
            String input = br.readLine();
            set.add(input);
            N--;
        }
        
        List<String> answerList = new ArrayList<>();
        while(M > 0) {
            String input = br.readLine();
            if(set.contains(input)) {
                answerList.add(input);
            }
            M--;
        }
        
        Collections.sort(answerList);
        bw.append(answerList.size() + "\n");
        for(String s : answerList) {
            bw.append(s + "\n");
        }
        bw.close();
    }
}