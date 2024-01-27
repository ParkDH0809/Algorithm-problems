import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            String[] MBTI = new String[N];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) {
                MBTI[i] = st.nextToken();
            }
            
            if(N > 32) {
                bw.append("0\n");
                continue;
            }

            int min = Integer.MAX_VALUE;

            out: for(int i = 0; i < N; i++) {
                for(int j = i+1; j < N; j++) {
                    for(int k = j+1; k < N; k++) {
                        min = Math.min(min, method(MBTI[i], MBTI[j], MBTI[k]));
                        if(min == 0) {
                            break out;
                        }
                    }
                }
            }

            bw.append(min + "\n");
        }
        bw.close();
    }

    static int method(String str1, String str2, String str3) {
        int count = 0;
        for(int i = 0; i < 4; i++) {
            count += str1.charAt(i) != str2.charAt(i) ? 1 : 0;
            count += str2.charAt(i) != str3.charAt(i) ? 1 : 0;
            count += str1.charAt(i) != str3.charAt(i) ? 1 : 0;
        }
        return count;
    }
}