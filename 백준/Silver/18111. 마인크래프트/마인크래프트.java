import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N * M];
        int max = -1;
        int min = 501;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                arr[M * i + j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[M * i + j]);
                min = Math.min(min, arr[M * i + j]);
            }
        }
        
        int[] answer = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        for(int t = min; t <= max; t++) {
            int[] numArr = checkNeedBlock(arr, t);
            int addNum = numArr[0];
            int digNum = numArr[1];
            
            if((digNum + B) >= addNum) {
                answer[0] = Math.min(answer[0], (addNum + digNum * 2));
                if(answer[0] == (addNum + digNum * 2)) {
                    answer[1] = t;
                }
            }
        }
        bw.append(answer[0] + " " + answer[1]);
        bw.close();
    }
    
    public static int[] checkNeedBlock(int[] arr, int max) {
        int[] returnArr = new int[2];
        
        for(int i : arr) {
            if( i < max)
                returnArr[0] += max - i;
            if(i > max)
                returnArr[1] += i - max;
        }
        
        return returnArr;
    }
}