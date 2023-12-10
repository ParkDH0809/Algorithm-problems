import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        Integer[] arr1 = new Integer[N];
        Integer[] arr2 = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr1[i] = Integer.valueOf(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr2[i] = Integer.valueOf(st.nextToken());
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        
        int answer = 0;
        for(int i = 0; i < N; i++)
            answer += arr1[i] * arr2[i];
        bw.append(answer + "");
        bw.flush();
    }
}