import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sortArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i< N; i++)
            sortArr[i] = arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(sortArr);
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < N; i++) {
            if(!map.containsKey(sortArr[i]))
                map.put(sortArr[i], count++);
        }

        for(int i = 0; i < N; i++)
            bw.append(map.get(arr[i]) + " ");
        bw.flush();
    }
}