import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int max = 0;
        int r = 0;
        int c = 0;
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if(max < cur) {
                    max = cur;
                    r = i;
                    c = j;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(r+1).append(" ").append(c+1);
        System.out.print(sb);
	}
}