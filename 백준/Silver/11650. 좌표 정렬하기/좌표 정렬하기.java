import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        Coordinate[] arr = new Coordinate[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i] = new Coordinate(Integer.parseInt(st.nextToken()), 
                                    Integer.parseInt(st.nextToken()));
        }
        
        Arrays.sort(arr, new Comparator<>() {
            @Override
            public int compare(Coordinate c1, Coordinate c2) {
                if(c1.x == c2.x) {
                    return c1.y - c2.y;
                }
                return c1.x - c2.x;
            }
        });
        
        for(Coordinate c : arr) {
            bw.append(c.toString() + "\n");
        }
        bw.close();
    }
}

class Coordinate {
    int x;
    int y;
    
    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public String toString() {
        return x + " " + y;
    }
}