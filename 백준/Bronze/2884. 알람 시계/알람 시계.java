import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        
        if(minute >= 45) {
            bw.append(hour + " " + (minute - 45));
        }
        
        if(minute < 45) {
            minute = 60 - (45 - minute);
            if(hour == 0) {
                bw.append("23 " + minute);
            } else {
                bw.append(hour - 1 + " " + minute);
            }
        }
        bw.close();
    }
}
