import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        double sum = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            sum += arr[i];
        }
        
        int max = 0;
        for(int i : map.keySet()) {
            max = Math.max(max, map.get(i));
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i : map.keySet()) {
            if(map.get(i) == max) {
                list.add(i);
            }
        }
        
        Collections.sort(list);
        int n;
        if(list.size() != 1) {
            n = list.get(1);
        } else {
            n = list.get(0);
        }
            
        Arrays.sort(arr);
        
        
        bw.append((int)Math.round(sum / arr.length) + "\n");
        bw.append(arr[arr.length / 2] + "\n");
        bw.append(n + "\n");
        bw.append((arr[arr.length - 1] - arr[0]) + "");
        bw.close();
    }
}