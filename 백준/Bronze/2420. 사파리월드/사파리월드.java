import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long result = Long.parseLong(st.nextToken()) - Long.parseLong(st.nextToken());
        if(result < 0) result = -result;
        System.out.print(result);
    }
}